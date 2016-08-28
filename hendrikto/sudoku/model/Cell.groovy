package hendrikto.sudoku.model

import groovy.transform.TypeChecked
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Cell implements Comparable<Cell> {
    final Sudoku sudoku
    final Set<Integer> row
    final Set<Integer> column
    final Set<Integer> block
    int value

    Cell(Sudoku sudoku, Set<Integer> row, Set<Integer> column, Set<Integer> block) {
        this.sudoku = sudoku
        this.row = row
        this.column = column
        this.block = block
        sudoku.empty << this
    }

    void setValue(int newValue) {
        assert newValue in 1..9
        clear()
        value = newValue
        forAllAreas { it.remove value }
        sudoku.empty.remove this
    }

    void clear() {
        if (value) {
            forAllAreas { it << value }
            value = 0
            sudoku.empty << this
        }
    }

    Set<Integer> getCandidates() {
        Set<Integer> candidates = []
        for (i in 1..9) {
            if (isAllowed(i)) {
                candidates << i
            }
        }
        candidates
    }

    @Override
    String toString() {
        value ?: "."
    }

    @Override
    int compareTo(Cell other) {
         candidates.size() - other.candidates.size()
    }

    private boolean isAllowed(int candidate) {
        candidate in row && candidate in column && candidate in block
    }

    private void forAllAreas(
            @ClosureParams(value = SimpleType, options = "java.util.Set") Closure closure
    ) {
        closure row
        closure column
        closure block
    }
}

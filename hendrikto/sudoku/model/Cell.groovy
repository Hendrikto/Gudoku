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
    final Row row
    final Column column
    final Block block
    int value

    Cell(Sudoku sudoku, Row row, Column column, Block block) {
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
        forAllAreas { it.removeCandidate value }
        sudoku.empty.remove this
    }

    void clear() {
        if (value) {
            forAllAreas { it.addCandidate value }
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
        candidate in row.candidates && candidate in column.candidates && candidate in block.candidates
    }

    private void forAllAreas(
            @ClosureParams(value = SimpleType, options = "hendrikto.sudoku.model.Area") Closure closure
    ) {
        closure row
        closure column
        closure block
    }
}

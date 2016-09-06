package hendrikto.sudoku.model

import groovy.transform.TypeChecked
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Cell {
    static final ALLOWED_VALUES = 1..9

    final Sudoku sudoku
    final Area row
    final Area column
    final Area block
    int value

    Cell(Sudoku sudoku, Area row, Area column, Area block) {
        this.sudoku = sudoku
        this.row = row
        this.column = column
        this.block = block
        sudoku.empty << this
    }

    void setValue(int newValue) {
        assert newValue in ALLOWED_VALUES
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
        row.intersect column intersect block
    }

    @Override
    String toString() {
        value ?: "."
    }

    private void forAllAreas(
            @ClosureParams(value = SimpleType, options = "hendrikto.sudoku.model.Area") Closure closure
    ) {
        closure row
        closure column
        closure block
    }
}

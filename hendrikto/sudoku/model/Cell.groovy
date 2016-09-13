package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
class Cell {
    static final IntRange ALLOWED_VALUES = 1..9

    final Sudoku sudoku
    final Area[] areas = new Area[3]
    int value

    Cell(final Sudoku sudoku, final Area row, final Area column, final Area block) {
        this.sudoku = sudoku
        this.areas[0] = row
        this.areas[1] = column
        this.areas[2] = block
        sudoku.empty << this
    }

    void setValue(final int newValue) {
        assert newValue in ALLOWED_VALUES
        clear()
        value = newValue
        areas*.remove value
        sudoku.empty.remove this
    }

    void clear() {
        if (value) {
            areas*.add value
            value = 0
            sudoku.empty.add 0, this
        }
    }

    Set<Integer> getCandidates() {
        areas[0].intersect areas[1] intersect areas[2]
    }
}

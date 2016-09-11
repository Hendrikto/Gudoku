package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
class SimpleStringifier implements SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        sudoku.cells.join("")
    }
}

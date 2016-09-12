package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
abstract class SudokuStringifier {
    char empty = "."

    abstract String stringify(Sudoku sudoku)
}

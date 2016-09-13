package hendrikto.sudoku.model.stringifier

import groovy.transform.CompileStatic
import hendrikto.sudoku.model.Sudoku

/**
 * @author Hendrik Werner
 */
@CompileStatic
abstract class SudokuStringifier {
    char empty = "."

    abstract String stringify(Sudoku sudoku)
}

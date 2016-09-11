package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
interface SudokuStringifier {
    String stringify(Sudoku sudoku)
}

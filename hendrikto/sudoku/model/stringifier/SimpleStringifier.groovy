package hendrikto.sudoku.model.stringifier

import groovy.transform.CompileStatic
import hendrikto.sudoku.model.Cell
import hendrikto.sudoku.model.Sudoku
import hendrikto.sudoku.model.stringifier.SudokuStringifier

/**
 * @author Hendrik Werner
 */
@CompileStatic
class SimpleStringifier extends SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        sudoku.cells.collect { Cell c -> c.value ?: empty } join ""
    }
}

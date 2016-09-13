package hendrikto.sudoku.model.stringifier

import groovy.transform.CompileStatic
import hendrikto.sudoku.model.Sudoku
import hendrikto.sudoku.model.stringifier.SudokuStringifier

/**
 * @author Hendrik Werner
 */
@CompileStatic
class SimpleStringifier extends SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        Arrays.stream(sudoku.cells)
                .map { it.value ?: empty }
                .collect()
                .join("")
    }
}

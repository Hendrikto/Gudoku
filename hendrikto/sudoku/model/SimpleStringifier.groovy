package hendrikto.sudoku.model

import groovy.transform.CompileStatic

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

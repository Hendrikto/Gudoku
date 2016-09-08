package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class SimpleStringifier implements SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        sudoku.cells.join("")
    }
}

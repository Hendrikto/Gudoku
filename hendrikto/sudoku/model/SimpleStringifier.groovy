package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class SimpleStringifier implements SudokuStringifier {
    @Override
    String stringify(Sudoku sudoku) {
        sudoku.cells.join("")
    }
}

package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class PrettyStringifier implements SudokuStringifier {
    @Override
    String stringify(Sudoku sudoku) {
        StringBuilder sb = new StringBuilder()
        sudoku.cells.eachWithIndex { Cell cell, int i ->
            sb.with {
                append cell
                append(++i % 9 == 0 ? "\n" : " ")
            }
        }
        sb
    }
}

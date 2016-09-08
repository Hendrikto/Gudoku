package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class PrettyStringifier implements SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        StringBuilder sb = new StringBuilder()
        sudoku.cells.eachWithIndex { Cell cell, int i ->
            int cellID = ++i
            if (cellID != 1 && cellID % 27 == 1) {
                sb.append "------+-------+------\n"
            }
            sb.append cell
            if (cellID % 9 == 0) {
                sb.append "\n"
            } else if (cellID % 3 == 0) {
                sb.append " | "
            } else {
                sb.append " "
            }
        }
        sb
    }
}

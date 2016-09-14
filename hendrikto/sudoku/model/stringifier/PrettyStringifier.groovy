package hendrikto.sudoku.model.stringifier

import groovy.transform.CompileStatic
import hendrikto.sudoku.model.Sudoku

/**
 * @author Hendrik Werner
 */
@CompileStatic
class PrettyStringifier extends SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        StringBuilder sb = new StringBuilder()
        for (int i in 0..<81) {
            int cellID = i + 1
            if (i && i % 27 == 0) {
                sb.append "------+-------+------\n"
            }
            sb.append sudoku.cells[i].value ?: empty
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

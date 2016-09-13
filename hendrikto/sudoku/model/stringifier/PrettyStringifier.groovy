package hendrikto.sudoku.model.stringifier

import groovy.transform.CompileStatic
import hendrikto.sudoku.model.Cell
import hendrikto.sudoku.model.Sudoku
import hendrikto.sudoku.model.stringifier.SudokuStringifier

/**
 * @author Hendrik Werner
 */
@CompileStatic
class PrettyStringifier extends SudokuStringifier {
    @Override
    String stringify(final Sudoku sudoku) {
        StringBuilder sb = new StringBuilder()
        sudoku.cells.eachWithIndex { Cell cell, int i ->
            int cellID = ++i
            if (cellID != 1 && cellID % 27 == 1) {
                sb.append "------+-------+------\n"
            }
            sb.append cell.value ?: empty
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

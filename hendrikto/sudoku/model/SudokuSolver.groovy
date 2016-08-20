package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class SudokuSolver {
    Sudoku sudoku

    void solve() {
        boolean progress = true
        while (progress) {
            progress = false
            for (cell in sudoku.cells) {
                if (cell.isEmpty() && cell.candidates.size() == 1) {
                    cell.setValue cell.candidates.head()
                    progress = true
                }
            }
        }
        backtrack()
    }

    private boolean backtrack() {
        if (sudoku.cells.count { it.isEmpty() } == 0) {
            return true
        }
        Cell cell = sudoku.cells.find { it.isEmpty() }
        for (candidate in cell.candidates) {
            cell.setValue candidate
            if (backtrack()) {
                return true
            }
        }
        cell.clear()
        return false
    }
}

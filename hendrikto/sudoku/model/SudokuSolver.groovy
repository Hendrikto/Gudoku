package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class SudokuSolver {
    Sudoku sudoku

    void solve() {
        pickSingleCandidates()
        backtrack()
    }

    private void pickSingleCandidates() {
        boolean progress = true
        while (progress) {
            progress = false
            for (cell in sudoku.cells) {
                if (cell.empty && cell.candidates.size() == 1) {
                    cell.setValue cell.candidates.head()
                    progress = true
                }
            }
        }
    }

    private boolean backtrack() {
        if (sudoku.emptyCells == 0) {
            return true
        }
        Cell cell = sudoku.cells.find { it.empty }
        for (candidate in cell.candidates) {
            cell.setValue candidate
            if (backtrack()) {
                return true
            }
        }
        cell.clear()
        false
    }
}

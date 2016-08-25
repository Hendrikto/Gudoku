package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class SudokuSolver {
    Sudoku sudoku

    void solve() {
        backtrack()
    }

    private Set<Cell> pickSingleCandidates() {
        Set<Cell> changed = []
        boolean progress = true
        while (progress) {
            progress = false
            for (cell in sudoku.cells) {
                if (!cell.value && cell.candidates.size() == 1) {
                    cell.setValue cell.candidates.head()
                    changed << cell
                    progress = true
                }
            }
        }
        changed
    }

    private boolean backtrack() {
        if (sudoku.empty.size() == 0) {
            return true
        }
        Cell cell = sudoku.empty.head()
        for (candidate in cell.candidates) {
            cell.setValue candidate
            Set<Cell> changed = pickSingleCandidates()
            if (backtrack()) {
                return true
            }
            changed*.clear()
        }
        cell.clear()
        false
    }
}

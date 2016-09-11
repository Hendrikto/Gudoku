package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
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
            for (Cell cell in sudoku.cells) {
                if (!cell.value && cell.candidates.size() == 1) {
                    cell.value = cell.candidates.head()
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
        for (int candidate in cell.candidates) {
            cell.value = candidate
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

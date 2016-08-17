package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
abstract class Area {
    protected final Set<Integer> candidates = 1..9

    void addCandidate(int c) {
        candidates.add c
    }

    void removeCandidate(int c) {
        candidates.remove c
    }

    boolean isCandidate(int c) {
        candidates.contains c
    }
}

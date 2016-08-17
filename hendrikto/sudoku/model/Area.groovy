package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
abstract class Area {
    protected final Set<Integer> candidates = 1..9 as Set

    void addCandidate(int c) {
        candidates.add c
    }

    void removeCandidate(int c) {
        candidates.remove c
    }

    boolean isCandidate(int c) {
        c in candidates
    }
}

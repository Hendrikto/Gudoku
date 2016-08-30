package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Area {
    @Delegate Set<Integer> candidates = 1..9 as Set
}

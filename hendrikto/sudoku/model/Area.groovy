package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
class Area {
    @Delegate Set<Integer> candidates = 1..9 as Set
}

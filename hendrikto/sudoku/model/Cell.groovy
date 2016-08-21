package hendrikto.sudoku.model

import groovy.transform.TypeChecked
import groovy.transform.stc.ClosureParams
import groovy.transform.stc.SimpleType

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Cell {
    final Row row
    final Column column
    final Block block
    int value

    Cell(Row row, Column column, Block block) {
        this.row = row
        this.column = column
        this.block = block
    }

    void setValue(int newValue) {
        assert newValue in 1..9
        clear()
        value = newValue
        forAllAreas { it.removeCandidate value }
    }

    void clear() {
        if (value) {
            forAllAreas { it.addCandidate value }
            value = 0
        }
    }

    Set<Integer> getCandidates() {
        Set<Integer> candidates = []
        for (i in 1..9) {
            if (isAllowed(i)) {
                candidates << i
            }
        }
        candidates
    }

    boolean isEmpty() {
        !value
    }

    @Override
    String toString() {
        value ?: "."
    }

    private boolean isAllowed(int candidate) {
        candidate in row.candidates && candidate in column.candidates && candidate in block.candidates
    }

    private void forAllAreas(
            @ClosureParams(value = SimpleType, options = "hendrikto.sudoku.model.Area") Closure closure
    ) {
        closure row
        closure column
        closure block
    }
}

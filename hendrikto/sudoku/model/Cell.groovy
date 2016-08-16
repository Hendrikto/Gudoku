package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
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
        row.removeCandidate value
        column.removeCandidate value
        block.removeCandidate value
    }

    void clear() {
        if (value) {
            row.addCandidate value
            column.addCandidate value
            block.addCandidate value
            value = 0
        }
    }

    @Override
    String toString() {
        value
    }
}

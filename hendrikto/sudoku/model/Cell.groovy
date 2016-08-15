package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Cell {
    final Row row
    final Column column
    final Block block
    int value

    Cell(Row r, Column c, Block b) {
        row = r
        column = c
        block = b
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

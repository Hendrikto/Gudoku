package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Cell {
    int value = 0
    private final Row row
    private final Column column
    private final Block block

    Cell(Row r, Column c, Block b) {
        row = r
        column = c
        block = b
    }
}

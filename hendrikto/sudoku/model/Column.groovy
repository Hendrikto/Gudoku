package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Column {
    private final Cell[] cells = new Cell[9]

    public Column(Cell... cs) {
        for (i in 0..<9) {
            cells[i] = cs[i]
        }
    }
}

package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Row {
    private Cell[] cells = new Cell[9]

    public Row(Cell... cs) {
        for (i in 0..<9) {
            cells[i] = cs[i]
        }
    }
}

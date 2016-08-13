package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Row extends CellContainer {
    public Row(Cell... cs) {
        for (i in 0..<9) {
            cells[i] = cs[i]
        }
    }
}

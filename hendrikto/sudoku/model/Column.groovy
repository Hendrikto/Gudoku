package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
class Column extends CellContainer {
    public Column(Cell... cs) {
        for (i in 0..<9) {
            cells[i] = cs[i]
        }
    }
}

package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
abstract class CellContainer {
    protected final Cell[] cells = new Cell[9]

    Cell getAt(int i) {
        cells[i]
    }

    void putAt(int i, Cell c) {
        cells[i] = c
    }
}

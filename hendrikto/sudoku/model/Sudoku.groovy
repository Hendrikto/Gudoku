package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Sudoku {
    private final Cell[] cells = new Cell[81]

    Sudoku() {
        Row[] rows = new Row[9]
        Column[] columns = new Column[9]
        Block[][] blocks = new Block[3][3]
        for (i in 0..<9) {
            rows[i] = new Row()
            columns[i] = new Column()
        }
        for (x in 0..<3) {
            for (y in 0..<3) {
                blocks[x][y] = new Block()
            }
        }
        int i = 0;
        for (x in 0..<9) {
            for (y in 0..<9) {
                cells[i++] = new Cell(
                        rows[y],
                        columns[x],
                        blocks[(int) (x / 3)][(int) (y / 3)]
                )
            }
        }
    }
}
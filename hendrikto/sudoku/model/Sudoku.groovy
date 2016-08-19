package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Sudoku {
    final Cell[] cells = new Cell[81]

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
                        blocks[x.intdiv(3) as int][y.intdiv(3) as int]
                )
            }
        }
    }

    Sudoku(String seed) {
        this()
        cells.eachWithIndex { Cell cell, int i ->
            if (seed[i].isInteger()) {
                cell.setValue seed[i] as Integer
            }
        }
    }

    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()
        cells.eachWithIndex { Cell cell, int i ->
            sb.append "$cell "
            if ((i + 1) % 9 == 0) {
                sb.setCharAt sb.length() - 1, "\n" as char
            }
        }
        sb
    }
}

package hendrikto.sudoku.model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner
 */
@CompileStatic
class Sudoku {
    final Cell[] cells = new Cell[81]
    final List<Cell> empty = []

    SudokuStringifier stringifier = new SimpleStringifier()

    Sudoku() {
        Area[] rows = new Area[9]
        Area[] columns = new Area[9]
        Area[][] blocks = new Area[3][3]
        for (int i in 0..<9) {
            rows[i] = new Area()
            columns[i] = new Area()
        }
        for (int x in 0..<3) {
            for (int y in 0..<3) {
                blocks[x][y] = new Area()
            }
        }
        int i = 0;
        for (int x in 0..<9) {
            for (int y in 0..<9) {
                cells[i++] = new Cell(
                        this,
                        rows[y],
                        columns[x],
                        blocks[x.intdiv(3) as int][y.intdiv(3) as int]
                )
            }
        }
    }

    Sudoku(final String seed) {
        this()
        for (int i = 0; i < 81 && i < seed?.length(); i++) {
            if (seed[i].isInteger()) {
                int value = seed[i] as int
                if (value) {
                    if (value in cells[i].candidates) {
                        cells[i].value = value
                    } else {
                        throw new IllegalArgumentException("Specified seed contains a collision at position ${i + 1}.")
                    }
                }
            }
        }
    }

    @Override
    String toString() {
        stringifier.stringify this
    }
}

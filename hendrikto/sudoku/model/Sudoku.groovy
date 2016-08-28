package hendrikto.sudoku.model

import groovy.transform.TypeChecked

/**
 * @author Hendrik Werner
 */
@TypeChecked
class Sudoku {
    final Cell[] cells = new Cell[81]
    final List<Cell> empty = []

    Sudoku() {
        Set<Integer>[] rows = new Set<Integer>[9]
        Set<Integer>[] columns = new Set<Integer>[9]
        Set<Integer>[][] blocks = new Set<Integer>[3][3]
        for (int i in 0..<9) {
            rows[i] = 1..9 as Set
            columns[i] = 1..9 as Set
        }
        for (int x in 0..<3) {
            for (int y in 0..<3) {
                blocks[x][y] = 1..9 as Set
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

    Sudoku(String seed) {
        this()
        for (int i = 0; i < 81 && i < seed.length(); i++) {
            if (seed[i].isInteger()) {
                cells[i].setValue seed[i] as Integer
            }
        }
    }

    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()
        cells.eachWithIndex { Cell cell, int i ->
            sb.with {
                append cell
                append(++i % 9 == 0 ? "\n" : " ")
            }
        }
        sb
    }
}

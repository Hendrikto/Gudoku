package hendrikto.sudoku.model

/**
 * @author Hendrik Werner
 */
abstract class CellContainer {
    protected final Cell[] cells = new Cell[9]
    protected final Set<Integer> candidates = new HashSet<>(1..9)

    Cell getAt(int i) {
        cells[i]
    }

    void putAt(int i, Cell c) {
        cells[i] = c
    }

    void addCandidate(int c) {
        candidates.add(c)
    }

    void removeCandidate(int c) {
        candidates.remove(c)
    }

    boolean isCandidate(int c) {
        candidates.contains(c)
    }
}

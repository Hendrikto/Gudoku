package hendrikto.test.model

import hendrikto.sudoku.model.Area
import hendrikto.sudoku.model.Cell
import hendrikto.sudoku.model.Sudoku

/**
 * @author Hendrik Werner
 */
class CellTest extends GroovyTestCase {
    private Area row;
    private Area column;
    private Area block;
    private Cell cell;

    @Override
    void setUp() {
        super.setUp()
        makeCell()
    }

    void testValidValueIsAccepted() {
        cell.value = 4
        assert cell.value == 4
        cell.value = 1
        assert cell.value == 1
    }


    void testInvalidValueIsRejected() {
        shouldFail {
            cell.value = 0
        }
        shouldFail {
            cell.value = 10
        }
    }

    void testCellIsCleared() {
        cell.value = 1
        cell.clear()
        assert !cell.value
    }

    void testGetCandidatesWorks() {
        assert cell.candidates == 1..9 as Set
        row.remove 9
        assert cell.candidates == 1..8 as Set
        column.remove 8
        assert cell.candidates == 1..7 as Set
        block.remove 7
        assert cell.candidates == 1..6 as Set
    }

    void testToStringWorks() {
        assert cell.toString() == Cell.empty as String
        cell.value = 5
        assert cell.toString() == "5"
    }

    private Cell makeCell() {
        row = new Area()
        column = new Area()
        block = new Area()
        cell = new Cell(new Sudoku(), row, column, block)
    }
}

package hendrikto.sudoku.cli

import hendrikto.sudoku.model.Cell
import hendrikto.sudoku.model.PrettyStringifier
import hendrikto.sudoku.model.Sudoku
import hendrikto.sudoku.model.SudokuSolver

/**
 * @author Hendrik Werner
 */
class Main {
    static void main(final String[] args) {
        ArgsParser parser = new ArgsParser()
        OptionAccessor options = parser.parse args
        if (options.arguments().empty || options.help) {
            parser.usage()
            return
        }
        if (options.empty) {
            Cell.empty = options.empty as char
        }
        try {
            Sudoku sudoku = new Sudoku(options.arguments().head())
            if (options."pretty-print") {
                sudoku.stringifier = new PrettyStringifier()
                println "Read Sudoku:\n\n$sudoku\n\nSolving...\n\n"
            }
            new SudokuSolver(sudoku: sudoku).solve()
            println sudoku
        } catch (IllegalArgumentException ex) {
            println "Error: $ex.message"
        }
    }
}

package hendrikto.sudoku.cli

import hendrikto.sudoku.model.Cell
import hendrikto.sudoku.model.PrettyStringifier
import hendrikto.sudoku.model.SimpleStringifier
import hendrikto.sudoku.model.Sudoku
import hendrikto.sudoku.model.SudokuSolver
import hendrikto.sudoku.model.SudokuStringifier

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
        SudokuStringifier stringifier = options."pretty-print" ? new PrettyStringifier() : new SimpleStringifier()
        if (options.empty) {
            stringifier.empty = options.empty as char
        }
        try {
            Sudoku sudoku = new Sudoku(options.arguments().head())
            sudoku.stringifier = stringifier
            if (options."pretty-print") {
                println "Read Sudoku:\n\n$sudoku\n\nSolving...\n\n"
            }
            new SudokuSolver(sudoku: sudoku).solve()
            println sudoku
        } catch (IllegalArgumentException ex) {
            println "Error: $ex.message"
        }
    }
}

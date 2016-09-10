package hendrikto.sudoku.cli
/**
 * @author Hendrik Werner
 */
class ArgsParser {
    @Delegate final CliBuilder builder = new CliBuilder()

    ArgsParser() {
        builder.with {
            usage = "gudoku [options] <Sudoku>"
            footer = "For more information visit: github.com/Hendrikto/Gudoku/"
            h longOpt: "help", "Print this help message."
            p longOpt: "pretty-print", "Print output in a human readable form."
            _ longOpt: "empty", "Set the char that represents an empty cell.", args: 1, argName: "char"
        }
    }
}

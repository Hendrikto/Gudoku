package hendrikto.sudoku.cli
/**
 * @author Hendrik Werner
 */
class ArgsParser {
    @Delegate final CliBuilder builder = new CliBuilder()

    ArgsParser() {
        builder.with {
            usage = "gudoku [options] [Sudoku]"
            h longOpt: "help", "Print this message."
            p longOpt: "pretty-print", "Print output in a human readable form."
        }
    }
}

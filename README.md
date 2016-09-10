# Gudoku
A Sudoku solver in written in Groovy.

## About
This solver employs a pretty naive solving algorithm but should be able to solve
all valid Sudokus. It uses a backtracking strategy coupled with picking cells
that only have one candidate value in between backtracking calls.

If you find any Sudoku that cannot be solved by this program please open an
issue on Github.

## Command Line Interface

### Usage
    gudoku [options] <Sudoku>

#### Sudoku
A string containing the values of the cells from top left to bottom right.
Anything other than 1..9 is interpreted as empty. Gudoku uses the convention of
representing empty cells as "." but you can use any character you want. You can
even mix and match different characters.

Gudoku will reject Sudokus containing collisions with an error message stating
where the collsion occurred.

    gudoku 11

will result in

    Error: Specified seed contains a collision at position 2.

#### Examples
    gudoku ""
    gudoku .
    gudoku 800000000003600000070090200050007000000045700000100030001000068008500010090000400
    gudoku 8..........36......7..9.2...5...7.......457.....1...3...1....68..85...1..9....4..
    gudoku 8..........36......7..9.2...5...7.......457.....1...3...1....68..85...1..9....4
    gudoku 8----------36------7--9-2---5---7-------457-----1---3---1----68--85---1--9----4
    gudoku 8__.....((-36._.((-7(-9-2((-5((-7_._.((-457..((-1((-3((-1.((-68(-85((-1(-9.((-4

The last 5 examples all represent the same Sudoku while the first 2 are empty.
Notice:
* you need to use `""` or at least one character to represent an empty Sudoku
* you can leave out empty cells at the end of the Sudoku

### Options

#### -h, --help
    gudoku -h
    gudoku --help
Print a help message explaining how to use Gudoku.

#### -p, --pretty-print
    gudoku -p ""
    gudoku --pretty-print ""
Print the output in a human readable form.

### File Expansion
This program supports argument file expansion via `@`:

    gudoku @options.txt @sudoku.txt

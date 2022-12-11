import puzzles.puzzle1
import puzzles.puzzle10
import puzzles.puzzle10dot1
import puzzles.puzzle11
import puzzles.puzzle1dot1
import puzzles.puzzle2
import puzzles.puzzle2dot1
import puzzles.puzzle3
import puzzles.puzzle3dot1
import puzzles.puzzle4
import puzzles.puzzle4alt
import puzzles.puzzle4dot1
import puzzles.puzzle5
import puzzles.puzzle5dot1
import puzzles.puzzle6
import puzzles.puzzle6dot1
import puzzles.puzzle7
import puzzles.puzzle7ButLegible
import puzzles.puzzle8
import puzzles.puzzle8alt
import puzzles.puzzle8dot1
import puzzles.puzzle9
import puzzles.puzzle9dot1

fun main() {
    println("""1: ${puzzle1()}""")
    println("""1.1: ${puzzle1dot1()}""")
    println("""2: ${puzzle2()}""")
    println("""2.1: ${puzzle2dot1()}""")
    println("""3: ${puzzle3()}""")
    println("""3.1: ${puzzle3dot1()}""")
    println("""4: ${puzzle4()}""")
    println("""4 alt: ${puzzle4alt()}""")
    println("""4.1: ${puzzle4dot1()}""")
    println("""5: ${puzzle5()}""")
    println("""5.1: ${puzzle5dot1()}""")
    println("""6: ${puzzle6()}""")
    println("""6.1: ${puzzle6dot1()}""")
    println("""7: ${puzzle7()}""")
    println("""7.1: ${puzzle7ButLegible()}""")
    println("""8: ${puzzle8()}""")
    println("""8 alt: ${puzzle8alt()}""")
    println("""8.1: ${puzzle8dot1()}""")
    println("""9: ${puzzle9()}""")
    println("""9.1: ${puzzle9dot1()}""")
    println("""10: ${puzzle10()}""")
    println("""10.1: ${puzzle10dot1()}""")
    println("""11: ${puzzle11(true)}""")
    println("""11.1: ${puzzle11(false)}""")
}
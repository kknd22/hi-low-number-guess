package g

/**
 * use machine to guess a number that the user secretly picked
 */
class NumberGuess {

    /**
     *
     * @param args
     */
    static void main(String[] args) {
        def max = Integer.MAX_VALUE
        def min = Integer.MIN_VALUE

        def Pair p = new Pair (min: min, max: max)
        println "Pick any secret number which is between ${Integer.MIN_VALUE} and ${Integer.MAX_VALUE}: "
        while (!p.isDone()) {
            p = zoomIn(p)
        }
    }

    /**
     * recursion to zoom in the answer fast
     *
     * @param p
     * @return
     */
    static Pair zoomIn(Pair p) {
        def keyboard = new Scanner(System.in)
        println "Is number ${p.mid()} ?"
        def answer = keyboard.nextLine()
        if (answer == 'higher')
            new Pair(min: p.mid(), max: p.max)
        else if (answer == 'lower')
            new Pair(min: p.min, max: p.mid())
        else if (answer ==~ /yes|end/)
            new Pair(min: p.mid(), max: p.mid())
        else {
            println "bad input, try it again"
            p
        }
    }
}

/**
 * simple data structure to capture
 */
class Pair {
    int min
    int max

    /**
     * the mid point
     *
     * @return
     */
    def int mid() {
        min/2 + max/2
    }

    /**
     * use simple logic that if the lower and upper is the same then the number guessing is done and mid is the answe
     * @return
     */
    def isDone() {
        min == max
    }
}

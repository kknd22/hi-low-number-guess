package g

class TicTacToe{
    final int dimension = 3
    List<Point> moves = new ArrayList<Point>()



    public boolean hasWon(Player p, int row, int col){
        moves << new Point(x:row, y:col, p:p)
        def ms = moves.findAll{it.p.black == p.black}

        def xs = ms.findAll{it.x == row}
        if ( xs.size() == dimension )
            return true

        def ys = ms.findAll{it.y == col}
        if ( ys.size() == dimension )
            return true

        def xys = ms.findAll{it.y == it.x}
        if ( xys.size() == dimension )
            return true

        return false
    }
}

class Point {
    int x
    int y
    Player p
}

class Player {
    boolean black

    @Override
    String toString() {
        if (black)
            "black"
        else
            "white"
    }

    static void main(String[] args) {
        def b = new Player(black:true)
        def w = new Player(black:false)

        def won = false
        def p = b
        def keyboard = new Scanner(System.in)
        def g = new TicTacToe()

        while (!won) {
           p = p == b ? w:b
           def ins = keyboard.nextLine()
           def s = ins.split()
           println "$p [${s[0]}, ${s[1]}]"
           won = g.hasWon(p, s[0].toInteger(), s[1].toInteger())
           if (won)
               println "$p has won"
        }
    }
}
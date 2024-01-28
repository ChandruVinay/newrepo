package tictactoe;
public class Main {
    public static void main(String[] args) {
        Player A = new Player();//Player 1 object
        A.setname("Player 1");
        A.setsymbol('0');
        Player B = new Player();
        B.setname("Player 2");//player 2 object
        B.setsymbol('X');
        Player [] players={A,B};//array of object
        Board board = new Board(3);
        Game obj= new Game(players, board);
        obj.play();
    }
}
//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
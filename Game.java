package tictactoe;

import java.util.Scanner;

public class Game {
    Player [] players;// we are getting object of 2 player from main class(objecy have  name and symbol)
    Board board;  //we are getting object from main class(2d  matrix)
    int turn;    //0-p1 && x-p2
    int moves;   //current movies
    boolean gameover;// true or false

    String zeros;
    String ones;

    Game(Player [] players,Board board){
        this.players=players;
        this.board=board;
        turn=0;
        moves=0;
        gameover=false;
        zeros="000";
        ones="XXX";
    }
    private void printboard(){
        for(int i=0;i<board.size;i++){
            for(int j=0;j<board.size;j++){
                System.out.print(board.matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    void play(){
         printboard();
         int size=board.size;

         while(gameover==false){
             moves++;
             int [] idx= getIndex();
             int x=idx[0];
             int y=idx[1];

             board.matrix[x][y]=players[turn].getsymbol();

             //winner
             if(checkcombination()==true){
                 gameover=true;
                 printboard();
                 System.out.println("winner is"+players[turn].getname());
             }
             //draw
             if(moves>=size*size){
                System.out.println("draw Match");
                printboard();
                return;
            }
             turn=1-turn;
             printboard();
         }
    }
    private int [] getIndex(){
        while(true){
            System.out.println("Player :"+ players[turn].getname() +"which position do you want to insert?");
            Scanner scan = new Scanner(System.in);
            int x=scan.nextInt();
            int y=scan.nextInt();
            int size=board.size;

            if(x<0 || y<0 || x>=size ||y>=size){
                System.out.println("Invalid Index");
                continue;
            }

            if(board.matrix[x][y]!='-'){
                System.out.println("cell is occupied");
                continue;
            }
            
            return new int[]{x,y};
            
        }
        
    }
    
    private boolean checkcombination(){
        int size=board.size;
        
        //row wise direction 
        for(int i=0;i<size;i++){
            String pattern="";
            for(int j=0;j<size;j++){
                pattern+=board.matrix[i][j];
            }
            if(pattern.equals(zeros) || pattern.equals(ones)){
                return true;
            }
        }
        //col wise
        for(int j=0;j<size;j++){
            String pattern="";
            for(int i=0;i<size;i++){
                pattern+=board.matrix[i][j];
            }
            if(pattern.equals(zeros) || pattern.equals(ones)){
                return true;
            }
        }

        //diagonal check

        String pattern="";
        int i=0;
        int j=0;
        while(i<size){
            pattern+=board.matrix[i][j];
            i++;
            j++;
        }
        if(pattern.equals(zeros) || pattern.equals(ones)){
            return true;
        }

        //antidiagonal
         pattern="";
         i=0;
         j=size-1;
        while(i<size){
            pattern+=board.matrix[i][j];
            i++;
            j--;
        }
        if(pattern.equals(zeros) || pattern.equals(ones)){
            return true;
        }

        return false;
    }
}


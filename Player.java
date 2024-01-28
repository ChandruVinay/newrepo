package tictactoe;

public class Player {
    private String name;
    private char symbol;

    public String getname(){
       return this.name;
    }
    public char getsymbol(){
        return this.symbol;
    }
    public void setname(String name){
        this.name=name;
    }
     public void setsymbol(char symbol){
        this.symbol=symbol;
     }



}
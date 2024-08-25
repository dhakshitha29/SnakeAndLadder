package game;
import board.*;
import player.*;
import coordinates.*;
import dice.*;
import jumper.*;

public class Game {
    Board b;
    Player[] players;
    boolean[] isAllowed;
    Coordinate[] places;
    Dice dice;
    int turn;

    public Game(Board b,Player[] players,Dice dice){
        this.b=b;
        this.players=players;
        this.dice=dice;
        turn=0;
        isAllowed=new boolean[players.length];
        places=new Coordinate[players.length];

        for(int i=0;i<players.length;i++){
            places[i]=new Coordinate(9, 0);
        }
    }

    public void play(){
        while (true) {
            int num=dice.diceroll();
            System.out.println(players[turn].getPlayerName() + " rolled -> "+num+" ["+places[turn].getRow()+", "+places[turn].getCol()+"]");

            if(!isAllowed[turn]){
                if(num!=1){
                    //to change the turn
                    turn=1-turn;
                    //turn=1 turn=1-1=0
                    //turn=0 turn=1-0=1
                    continue;
                }else{
                    isAllowed[turn]=true;
                }
            }

            Coordinate newCoordinate=getnewCoordinate(places[turn],num);
            if (newCoordinate.getRow() < 0) {
                System.out.println(players[turn].getPlayerName()+" has won");
                return;
            }
            places[turn]=newCoordinate;
            turn=1-turn;
        }
    }

    //to decide the direction of player to move
    private Coordinate getnewCoordinate(Coordinate oldCoordinates,int num){
        int row=oldCoordinates.getRow();
        int col=oldCoordinates.getCol();

        while(num > 0){
            if((row&1)==1){
                if(col == 9) row--;
                else col++;
            }else{
                if(col == 0) row--;
                else col--;
            }
            num--;
        }
        
        if(row <0) return new Coordinate(row, col);
        if(checkIfJumperExists(row,col)){
            Jumper j=b.jumper.get(b.b[row][col]);
            return j.end;
        }
        return new Coordinate(row, col);
    }

    private boolean checkIfJumperExists(int row,int col){
        return b.jumper.containsKey(b.b[row][col]);
    }
}

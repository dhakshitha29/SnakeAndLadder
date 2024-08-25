package board;
import java.util.*;
import jumper.*;

public class Board {

    public String b[][];
    public HashMap<String,Jumper> jumper;

    public Board(HashMap<String,Jumper> jumper){
        this.jumper=jumper;
        int cnt=1;
        b=new String[10][10];
        for(int i=9;i>=0;i--){
            if((i&1)==0){
                for(int j=9;j>=0;j--){
                    b[i][j]=cnt+"";
                    cnt++;
                }
            }else{
                for(int j=0;j<10;j++){
                    b[i][j]=cnt+"";
                    cnt++;
                }
            }
        }
    }
    public void printBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}

package coordinates;

public class Coordinate {
    public int row;
    public int col;
    public Coordinate(int row,int col){
        this.row=row;
        this.col=col;
    }
    public String printCoordinates(){
        StringBuilder sb=new StringBuilder();
        sb.append("[").append(this.row).append(",").append(this.col).append("]");
        return sb.toString();
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
}

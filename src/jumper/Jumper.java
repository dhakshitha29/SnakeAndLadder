package jumper;
import coordinates.Coordinate;

public class Jumper {
    public Coordinate start,end;
    public String name;

    public Jumper(Coordinate start,Coordinate end){
        this.start=start;
        this.end=end;

        if (start.row > end.row) {
            this.name="Ladder";
        }else{
            this.name="Snake";
        }
    }

    public String getJumperName(){
        return this.name;
    }

}

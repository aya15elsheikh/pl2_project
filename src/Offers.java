import java.util.*;

public class Offers {
    private String type;
    private double  timePerdays;
    private double percentage;


    public Offers (String type ,double time , double percentage ){
        this.type = type;
        this.timePerdays=time;
        this.percentage=percentage;

    }
    public String get_type(){
        return type;
    }
    public double get_time(){
        return timePerdays;
    }
    public double get_percentage(){
        return percentage;
    }




    }




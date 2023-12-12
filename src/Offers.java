import java.util.*;

public class Offers {
    private String type;
    private double  time;
    private double percentage;


    public Offers (String type ,double time , double percentage ){
        this.type = type;
        this.time=time;
        this.percentage=percentage;

    }
    public String get_type(){
        return type;
    }
    public double get_time(){
        return time;
    }
    public double get_percentage(){
        return percentage;
    }




    }




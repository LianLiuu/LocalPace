import java.util.Scanner;
import java.io. * ;
/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant
{
   protected String name;
   protected double lati,longi,miles,runtime,jogtime,biketime;
   protected static String Rtname;
   final double RADIUS = 6371.01;
   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public Restaurant (String name,double lati,double longi)
   {    
      this.name = name;
      this.lati=lati;
      this.longi=longi;
   }
   
   public Restaurant (String name,double miles,double runtime,double jogtime,double biketime)
   {    
      this.name = name;
      this.miles=miles;
      this.runtime=runtime;
      this.jogtime=jogtime;
      this.biketime=biketime;
   }
   
    public String toString(){
        String result=name+","+String.valueOf(miles)+","+String.valueOf(runtime)+","+String.valueOf(jogtime)+","+String.valueOf(biketime)+".";
        return result;
    }
    
    public static void main(String[]args){
        
    }
}



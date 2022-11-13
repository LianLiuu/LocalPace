import java.util.Scanner;
import java.io. * ;
import java.util.Arrays;
/**
 * Write a description of class LocalPace here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LocalPace
{
    private static Restaurant[] collection;
    private static double[] distances;
    private String Rtname;
    private double lati,longi;
    private double runspeed=6; //6 mile per hour
    private double jogspeed=3;//
    private double bikespeed=10;
    private static int count=0;
    private static double lat1,lon1;
    
    public LocalPace(){ 
        collection = new Restaurant[10];
        distances=new double[10];
    }
    
        
    public static void displayFile(String inFileName){
        try{
            Scanner sc = new Scanner(new File(inFileName));
        //parsing a CSV file into the constructor of Scanner class 
        //sc.useDelimiter(",");
        //setting comma as delimiter pattern
            while (sc.hasNext()) {
                String name=sc.next();
                double lat0=sc.nextDouble();
                double long0=sc.nextDouble();
                Restaurant r1=new Restaurant(name,lat0,long0);
                System.out.println(r1);
                collection[count]=r1;
                count++;
                }
            }
        catch(IOException ex){
            System.out.println(ex);}      
    }   
    
    public static void getLocation(){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter location");
        lat1=s.nextDouble();
        lon1=s.nextDouble();
    }
    
    public static double calculateDistanceBetweenPointsinmeters(double lat2, double lon2) {
        final int R = 6371; // Radius of the earth
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters
        double miles = distance * 0.00062137119;
        return miles;
    }   
    
    public double runningTime(double dis){
        double hour=(double)dis/runspeed;
        double time=hour * 60;
        return time;
    }
    
    public double joggingTime(double dis){
        double hour=(double)dis/jogspeed;
        double time=hour * 60;
        return time;
    }
    
    public double bikingTime(double dis){
        double hour=(double)dis/bikespeed;
        double time=hour * 60;
        return time;
    }
    
    public String toString()
    {
        String report = "Nearby Resturant Collection\n";
        report += "Number of Restaurant: " + count + "\n";
        report += "\n\nRestaurantList:\n\n";
        for (int i = 0; i < count; i++)
            report += collection[i].toString() + "\n";
        return report;
    }
    
    public static void main(String[]args){
        LocalPace tester = new LocalPace();
        tester.displayFile("Restaurant.txt");
        System.out.println(tester.toString());
        tester.getLocation();
        for(int i=0;i<count;i++){
            distances[i]=tester.calculateDistanceBetweenPointsinmeters(collection[i].lati,collection[i].longi);
            System.out.println(distances[i]);
            collection[i].miles=distances[i];
            double runtime=tester.runningTime(distances[i]);
            System.out.println(runtime);
            collection[i].runtime=runtime;
            double jogtime=tester.joggingTime(distances[i]);
            System.out.println(jogtime);
            collection[i].jogtime=jogtime;
            double biketime=tester.bikingTime(distances[i]);
            System.out.println(biketime);
            collection[i].biketime=biketime;
        
        }
        System.out.println("all the distances");
        System.out.println(Arrays.toString(distances));
        System.out.println("all the resturnats");
        System.out.println(tester.toString());
        }
        
    }


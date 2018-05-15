/*
*Johnny Polimeni 
 *jpolimen 
 *Project 3 
 *lab section T/R 6:15 - 7:30
 *I did not collaborate with anyone on this assignment
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class points {
	public static Point[]points;
	public static  Line[]lines;
	public static Point[]testPoints;
	public static int countGlobal=0;
	public static int a;

	public static Point intersection(Line a, Line b){

		double m1=(a.b.y-a.a.y)/(a.b.x-a.a.x);
		double b1=a.a.y-m1*a.a.x;
		double m2=(b.b.y-b.a.y)/(b.b.x-b.a.x);
		double b2=b.a.y-m2*b.a.x;

		double x0=-(b1-b2)/(m1-m2);
		double y0=(m1*x0)+b1; 

		Point p1=new Point(x0,y0);
		if(0<x0&&x0<1&&0<y0&&y0<1){
		return(p1);
		}
		else{
			return null;
		}
		
	}

	//inputs the points
	public static Point[] inputPoints() throws IOException{
		BufferedReader reader= new BufferedReader(new FileReader("C:/Users/johnn/eclipse-workspace/CSC 172 Proj-3/inputFile"));
		String str;
		String a = reader.readLine();
		int length=Integer.parseInt(a);
		int count=0;
		Point[]points=new Point[length*2];

		
		for(int i=0;i<length;i++){
			str = reader.readLine();

            String[] strspl = str.split(" ");

            Point p1 = new Point(Double.parseDouble(strspl[0]), Double.parseDouble(strspl[1]));
			points[count]=p1;
			count++;
            Point p2 = new Point(Double.parseDouble(strspl[2]), Double.parseDouble(strspl[3]));
			points[count]=p2;
			count++;

		}
	
		return(points);
	}
	public static Point getPoints() throws IOException{
		BufferedReader reader= new BufferedReader(new FileReader("C:/Users/johnn/eclipse-workspace/CSC 172 Proj-3/inputFile"));
		String str;
		String a = reader.readLine();
		int length=Integer.parseInt(a);
		Point p1=new Point(9999,99);

		for(int i=0;i<length;i++){
			str = reader.readLine();

		}
		for(int x=0;x<=countGlobal;x++)	{
		str = reader.readLine();

            String[] strspl = str.split(" ");
             p1 = new Point(Double.parseDouble(strspl[0]), Double.parseDouble(strspl[1]));
		}
		countGlobal++;

		
		return(p1);
	}
	//inputs the points into an array and puts the points into lines into an array
	public static Line[] lineSegments() throws IOException{
		BufferedReader reader= new BufferedReader(new FileReader("C:/Users/johnn/eclipse-workspace/CSC 172 Proj-3/inputFile"));
		String str;
		String a = reader.readLine();
		int length=Integer.parseInt(a);
		int count=0;
		int count2=0;
		Point[]points=new Point[length*2];
		Line[]lines=new Line[length];

		for(int i=0;i<length;i++){
			str = reader.readLine();

            String[] strspl = str.split(" ");

            Point p1 = new Point(Double.parseDouble(strspl[0]), Double.parseDouble(strspl[1]));
			points[count]=p1;
			count++;
            Point p2 = new Point(Double.parseDouble(strspl[2]), Double.parseDouble(strspl[3]));
			points[count]=p2;
            			Line line1=new Line(p1,p2,""+count2);
			lines[count2]=line1;
			count2++;
			count++;

		}
		return(lines);
	}

	public static void main(String args[]) throws IOException{

		lines=lineSegments();
		points=inputPoints();
		System.out.println(getPoints().y);
		

	}
	
}

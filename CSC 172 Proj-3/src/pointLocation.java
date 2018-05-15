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
import java.util.Scanner;

public class pointLocation extends points {
	public static int COUNTERCLOCKWISE=1;
	public static int CLOCKWISE=-1;
	public static int COLINEAR=0;
	
	
	public static void main(String[] args) throws IOException {
		lines=lineSegments();
		points=inputPoints();
		
			
	}
	//input a point and a line and tests what side of the line the poitn is on
	static int ccw(Point p0, Point p1,Point p2) {
		double dx1 = p1.x - p0.x;
		double dy1 = p1.y - p0.y;
		double dx2 = p2.x - p0.x;
		double dy2 = p2.y - p0.y;
		if (dx1*dy2 > dy1*dx2) return COUNTERCLOCKWISE;
		else if (dx1*dy2 < dy1*dx2) return CLOCKWISE;
		else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return CLOCKWISE;
		else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return COUNTERCLOCKWISE;   
		else return COLINEAR; 
		}
	
	
}

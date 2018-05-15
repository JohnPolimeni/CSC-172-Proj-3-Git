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

public class BSTClass extends MyTreeNode  implements BST {

public static	MyTreeNode root= new MyTreeNode();
public static String  result="";

public pointLocation pointLocaion= new pointLocation();
	public BSTClass(){
		root=null;
	}
	
	public static void main(String[] args) throws IOException {
		BSTClass bst=new BSTClass();
		BufferedReader reader= new BufferedReader(new FileReader("C:/Users/johnn/eclipse-workspace/CSC 172 Proj-3/inputFile"));
		String str;
		String a = reader.readLine();
		int length=Integer.parseInt(a);
		Line[] lines=pointLocation.lineSegments();
		MyTreeNode temp=new MyTreeNode();
		temp=root;
		System.out.println(length);
		for(int x=0;x<length;x++){
			bst.insert(lines[x], root);
		}
	//	bst.insert(lines[0], root);
	//	bst.insert(lines[1],root);


	//	bst.insert(lines[2],root);
		
		
		bst.insert(lines[3], root);
	/*	System.out.println(root.line.name);
		System.out.println(root.rightChild.line.name);
		System.out.println(root.leftChild.line.name);
		System.out.println(root.rightChild.rightChild.line.name);
		System.out.println(root.rightChild.leftChild.line.name);
		System.out.println(root.leftChild.leftChild.line.name);
		System.out.println(root.rightChild.leftChild.leftChild.line.name);
*/

		//bst.insert(lines[4], root);
		for(int x=0;x<2;x++){
		bst.searchPoint(points.getPoints(), bst.root);
		String result1=result;
		result="";
		bst.searchPoint(points.getPoints(), bst.root);
		String result2=result;
		sameRegion(result1,result2);
		result="";
		}
		double xnodes=bst.externalNodes(root);
		System.out.println(xnodes);
		int count=0;
		double xpath=bst.externalPathLength(count,root);
		System.out.println(xpath);
		System.out.println("the average path length is "+xpath/xnodes);
		
	}

	public String searchPoint(Point point, MyTreeNode temp){
		if(pointLocation.ccw(point,temp.line.a,temp.line.b)==1){
			if(temp.leftChild==null||temp.rightChild==null){
				System.out.println("found it");
				result+=temp.line.name;	
				return result;
			}
			else{
				result+=(" left ");
					result+=temp.line.name;
				temp.parent=temp;
			temp=temp.leftChild;
			searchPoint(point,temp);
			}
			}
		else if(pointLocation.ccw(point,temp.line.a,temp.line.b)==-1){
			
			if(temp.rightChild==null||temp.leftChild==null){
				System.out.println(temp.rightChild);
				result+=temp.line.name;
				System.out.println("found it");
				return result;
			}
			else{
			result+=" right ";
			result+=temp.line.name;	
			temp.parent=temp;
				temp=temp.rightChild;
			searchPoint(point,temp);
			}
		}
		System.out.println(temp.line.name);

		return "not found";

	}public static boolean sameRegion(String result1,String result2){
		if(result1.equals(result2)){
			System.out.println(result1+" & "+result2+ " are in the same region");
			return true;
			
		}
		System.out.println(result1+" & "+result2+ " are not in the same region");
		return false;
	}
	
	@Override
	public void insert(Line line,MyTreeNode temp) {
		boolean result=true;
	

		
		if(root==null){
		//	
			root=new MyTreeNode();
			root.line=line;

		}
		
		else if(pointLocaion.intersection(temp.line,line)==null){
	
			//if they dont intersect

				if(pointLocation.ccw(line.a,temp.line.a,temp.line.b)==1){
					if(temp.leftChild==null){
						 MyTreeNode replacement=new MyTreeNode();
						 replacement.line=line;
						temp.leftChild=replacement;
					}
					else{
						temp=temp.leftChild;
						insert(line,temp);
					}
					}

				//right direction
				else if(pointLocation.ccw(line.a,temp.line.a,temp.line.b)==-1){
					if(temp.rightChild==null){
						 MyTreeNode replacement=new MyTreeNode();
						 replacement.line=line;
						 temp.rightChild=replacement;
					}
					else{
					temp=temp.rightChild;
					insert(line,temp);
					}
				}
			
				
			}
		//if they intersect	
		else{	
				

			
			if(temp.rightChild!=null&&temp.leftChild!=null){
				MyTreeNode rightTree=new MyTreeNode();
				rightTree=temp.rightChild;
				insert(line,rightTree);
				
				MyTreeNode leftTree=new MyTreeNode();
				leftTree=temp.leftChild;
				insert(line,leftTree);
			}
			 if(temp.rightChild!=null){
				temp=temp.rightChild;
				insert(line,temp);
			}
			 else if(temp.leftChild!=null){
				temp=temp.leftChild;
				insert(line,temp);    
			}
			 if(temp.rightChild==null){
				 MyTreeNode replacement=new MyTreeNode();
				 replacement.line=line;
				 temp.rightChild=replacement;	//next right element
			}
			  if(temp.leftChild==null){
				 MyTreeNode replacement=new MyTreeNode();
				 replacement.line=line;
				 temp.leftChild=replacement;			//next left element in the tree
			 }
			 
			
			
		}
			



		}
	public double externalNodes(MyTreeNode temp){
		
		if(temp.leftChild==null||temp.rightChild==null){
			return 1;
		}
		
		else{
			return externalNodes(temp.leftChild)+externalNodes(temp.rightChild);
					
		}
		
	}
	//adapted from exam 2 question 4

	public double externalPathLength(int count,MyTreeNode temp){
		if(temp==null){
			return 0;
		}
		if(temp.leftChild==null||temp.rightChild==null){
			return count++;
		}
		
		else{
			return externalPathLength(count+1,temp.leftChild)+externalPathLength(count+1,temp.rightChild);
		}
	}

	


}

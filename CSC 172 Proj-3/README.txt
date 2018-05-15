/*
*Johnny Polimeni 
 *jpolimen 
 *Project 3 
 *lab section T/R 6:15 - 7:30
 *I did not collaborate with anyone on this assignment
*/

This project conains multiple different classes, the points class reads in data from the
file.  The first number read in is the number of lines and the following lines contain 
the end points of the lines.  I have 3 methods that read in values, one reads in points
and creates an array of points.  One makes an array of lines, which is a combinaition of 
two points.  The last method reads in the points that will be tested.  Also in this class
is the intersectoin method, which uses equations to determine if two lines intersect.  
I cited in the comments where i got the equations from.  If the points do not intersect 
then null is returned, otherwise the intersection point is returned.

There is also a point class which stores two doubles togeather.

Similar to the point class, there is a line class whic stores two points and a name for a
line.

The point location method is the given method and it tells you what side of the line the
inputed point lies on.

The BSTClass is a binary search tree that contains lines, and is used to determine 
where the inputed point lies.  The insert class is used to insert a line into the tree
is split into 3 main if statements.  The first initializes the root.  The next if 
statement exicutes if the given line doesn't intersect with any other lines in the tree.
This method uses recurion frequetly to easily run through the tree.  The last if
statement exicutes if the inputed line does intersect with a line in the tree.  There
are several cases that exicute if this if statement is run.  Additionally in this class,
there are methods that calculate the externalPathLength and external nodes.  Some of this
code was adapted from one of the questions in exam 2.  Lastly, there is the search point
method which finds the value and saves the path it takes as a string and compares the
path to the other point to see if they are in the same region.

As the number of lines grows, so will the runtime of the program.  For this lab we aimed 
to build a structure that will grow at a rate of log(n).  The average path length of the 
first set of 4 lines is 2, which is proportional to the average path length of the 
dataStructure I made, which is 2.666.  As we increase the line size to 6 the average
path length increases to 3.857.  This is a bit high but still proportional to log(n).
 
There is another input file included to display how the runtime grows as the data size
grows.
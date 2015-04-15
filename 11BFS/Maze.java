import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    private char[][] maze;
    private int[] solutions;
    private int startx, starty, maxx, maxy;
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    /** Same constructor as before...*/
    public Maze(String filename){
	maxx = 0;
	maxy = 0;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxx == 0) maxx = line.length();
		maxy ++;
	    }
	}catch(Exception e){
	    throw new FileNotFoundException(filename);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i< ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx] = c;
	    if(c == 'S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }

    public String toString();//do not do the funky character codes

    public String toString(boolean animate); //do the funky character codes when animate is true

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){
	
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){

    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    /**return an array [x1,y1,x2,y2,x3,y3...]
     *that contains the coordinates of the solution from start to end.
     *Precondition :  solveBFS() OR solveDFS() has already been called (otherwise an empty array is returned)
     *Postcondition:  the correct solution is in the returned array
     */
    public int[] solutionCoordinates(){
	return solutions;
    }
}

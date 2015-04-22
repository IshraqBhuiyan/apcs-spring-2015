import java.util.*;
import java.io.*;

public class Maze{
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    private char[][] maze;
    private int[] solutions;
    private int startx, starty, maxx, maxy, endx, endy;
    
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    /** Same constructor as before...*/
    public Maze(String filename) throws FileNotFoundException{
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
	    if(c == 'E'){
		endx = i%maxx;
		endy = i/maxx;
	    }
	}
    }

    public String toString(){//do not do the funky character codes
	String ans = "";
	for(int i = 0; i<maze[0].length; i++){
	    for(int z = 0; z<maze.length;z++){
		ans+=maze[z][i];
	    }
	    ans+="\n";
	}
	return ans;
    }

    public String toString(boolean animate){//do the funky character codes when animate is true
	if(animate){
	    return hide + go(0, 0) + toString() + "\n" + show;
	}
	return toString();
    }

    /**Solve the maze using a frontier in a BFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveBFS(boolean animate){
	return solve(0, animate);
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	return solve(1, animate);
    }

    public boolean solveBest(boolean animate){
	return solve(2, animate);
    }

    public boolean solveAStar(boolean animate){
	return solve(3, animate);
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveBest(){
	return solveBest(false);
    }

    public boolean solveAStar(){
	return solveAStar(false);
    }

    public boolean solve(int mode, boolean animate){
	Frontier front = new Frontier(mode);
	Point start = new Point(startx, starty);
	start.setDist(Math.abs(endx -startx) + Math.abs(endy - starty));
	start.setTotalDist(Math.abs(endx - startx) + Math.abs(endy - starty));
	front.add(start);
	
	boolean solved = false;

	while(!solved && front.hasNext()){
	    if(animate && !solved){
		System.out.println(toString(animate));
	    }

	    Point next = front.remove();
	    if(maze[next.getX()][next.getY()] == 'E'){
		solved = true;
		addCoordinatesToSolutionsArray(next);
	    }else{
		maze[next.getX()][next.getY()] = 'x';
		Point[] neighbors = getNeighbors(next);
		for(int i=0;i<neighbors.length;i++){
		    front.add(neighbors[i]);
		}
	    }
	}
	return solved;
    }

    public Point[] getNeighbors(Point next){
	ArrayList<Point> neighbors = new ArrayList<Point>();
	Point[] ans = new Point[0];
	char[] block = {'x', '#'};
	if(!Arrays.asList(block).contains(maze[next.getX()-1][next.getY()])){
	    Point p = new Point(next.getX() - 1, next.getY());
	    p.setParent(next);
	    p.setDist(Math.abs(endx - next.getX() - 1) + Math.abs(endy - next.getY()));
	    p.setTotalDist(p.getDist() + p.getPoints().length + 1);
	    neighbors.add(p);
	}
	if(!Arrays.asList(block).contains(maze[next.getX()+1][next.getY()])){
	    Point p = new Point(next.getX() + 1, next.getY());
	    p.setParent(next);
	    p.setDist(Math.abs(endx - next.getX() + 1) + Math.abs(endy - next.getY()));
	    p.setTotalDist(p.getDist() + p.getPoints().length + 1);
	    neighbors.add(p);
	}
	if(!Arrays.asList(block).contains(maze[next.getX()][next.getY()+1])){
	    Point p = new Point(next.getX(), next.getY() + 1);
	    p.setParent(next);
	    p.setDist(Math.abs(endx - next.getX()) + Math.abs(endy - next.getY() + 1));
	    p.setTotalDist(p.getDist() + p.getPoints().length + 1);
	    neighbors.add(p);
	}
	if(!Arrays.asList(block).contains(maze[next.getX()][next.getY() - 1])){
	    Point p = new Point(next.getX(), next.getY() - 1);
	    p.setParent(next);
	    p.setDist(Math.abs(endx - next.getX()) + Math.abs(endy- next.getY() - 1));
	    p.setTotalDist(p.getDist() + p.getPoints().length + 1);
	    neighbors.add(p);
	}
	neighbors.toArray(ans);
	return ans;
    }

    public void addCoordinatesToSolutionsArray(Point p){
	int[] s = new int[p.getPoints().length * 2 + 2];
	Point[] points = p.getPoints();
	for(int i = 0; i<points.length;i++){
	    s[i*2] = points[i].getX();
	    s[i*2+1] = points[i].getY();
	}
	s[s.length - 2] = p.getX();
	s[s.length - 1] = p.getY();
	solutions = s;
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

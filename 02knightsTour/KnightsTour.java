import java.util.*;
import java.io.*;



public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    private int startx,starty;
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	for(int i=0;i<board.length;i++){
	    for(int z=0;z<board.length;z++){
		ans+="" + board[z][i]+"\t";
	    }
	    ans+="\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(int size){
	this(size, 0, 0);
    }

    public KnightsTour(int size, int startx, int starty){
	if(size < 1) throw new IllegalArgumentException("The board size must be larger than 0");
	board = new int[size][size];
	for(int i=0;i<size;i++){
	    for(int z=0;z<size;z++){
		board[i][z] = 0;
	    }
	}
	this.startx = startx;
	this.starty = starty;
    }


    public boolean solve(){
	//maze[0][0] = 0;
	return solve(startx,starty,1);
    }


    public boolean solve(int startx, int starty){
	//maze[startx][starty] = 0;
	return solve(startx, starty, 1);
    }


    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//wait(20);
	if(x>=board.length || y>=board.length || x<0 || y<0)
	    return false;
	if(board[x][y] == board.length * board.length-1)
	    return true;
	if(board[x][y] > 0)
	    return false;
	if(board[x][y] < 1)
	    board[x][y] = currentMoveNumber;
	if(solve(x+2,y+1,currentMoveNumber+1) || solve(x+2,y-1,currentMoveNumber+1) || solve(x+1,y+2,currentMoveNumber+1) ||
	   solve(x-1,y+2,currentMoveNumber+1) || solve(x-2,y+1,currentMoveNumber+1) || solve(x-2,y-1,currentMoveNumber+1) ||
	   solve(x+1,y-2,currentMoveNumber+1) || solve(x-1,y-2,currentMoveNumber+1))
	    return true;
	board[x][y] = 0;
	return false;
    }


}

import java.util.*;
import java.io.*;

public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;
    private int startx,starty;
    private int numQueens;

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
	//build your nqueens tour here...
	for(int i=0;i<board.length;i++){
	    for(int z=0;z<board.length;z++){
		ans+="" + board[z][i]+"\t";
	    }
	    ans+="\n";
	}
	return hide + clear + go(0,0) + ans + "\n" + show;
    }

    public NQueens(int size){
	if(size < 1) throw new IllegalArgumentException("The board size must be larger than 0");
	board = new char[size][size];
	for(int i=0;i<size;i++){
	    for(int z=0;z<size;z++){
		board[i][z] = 'X';
	    }
	}
	numQueens = 0;
    }

    public boolean checkDir(int x, int y, int xdir, int ydir){ //xdir and ydir are either 1, 0, or -1 to determine increments
	try{
	    int i=1;
	    while(true){
		if(board[x + i*xdir][y + i*ydir] == 'Q') return false;
		i++;
	    }
	}catch(Exception e){
	    return true;
	}
    }


    public boolean checkPos(int x, int y){
	if(!checkDir(x, y, 1, 0) || !checkDir(x, y, 0, 1) || !checkDir(x, y, -1, 0) || !checkDir(x, y, 0, -1) || !checkDir(x, y, 1, 1) ||
	   !checkDir(x, y, -1, -1) || !checkDir(x, y, -1, 1) || !checkDir(x, y, 1, -1)){
	    return false;
	}
	return true;
    }


    public boolean solve(){
	return this.solve(0, 0);
    }

    public boolean solve(int x){
	board[0][x] = 'Q';
	numQueens++;
	return this.solve(1, 0);
    }

    public boolean solve(int x, int y){
	//System.out.println(this);
	//wait(20);
	if(numQueens == board.length) return true;
	if(y >= board.length) return false;
	board[x][y] = 'Q';
	numQueens++;
	//System.out.println(this);
	//System.out.println("checking pos of current queen: " + checkPos(x, y));
	//wait(20);
	if(checkPos(x, y)){
	    if(solve(x+1, 0)) return true;
	}
	board[x][y] = 'X';
	numQueens--;
	if(solve(x, y+1)){
	    return true;
	}else{
	    return false;
	}
    }

    public String name(){
	return "bhuiyan.ishraq";
    }

}

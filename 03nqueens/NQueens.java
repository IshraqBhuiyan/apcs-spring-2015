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

    public boolean solve(){
	this.solve(0);
    }

    public boolean solve(int x){
	if(x < 0 || x >=board.size) throw new IllegalArgumentException("You must start inside of the board.");
	if(numQueens == board.size) return true;

    }

}

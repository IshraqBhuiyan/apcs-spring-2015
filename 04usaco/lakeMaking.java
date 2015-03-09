import java.util.*;
import java.io.*;

public class lakeMaking{
    public static void main(String[]args){
	int[][]lake;
	int initvolume;
	int endvolume;
	int lakevolume;
	int[][] instructions;
	//file reading stuff
	//initial calculation of volume stuff
	solve(lake, startx, starty);
	//calculate end volume
	lakevolume = initvolume - endvolume;
	//output lakevolume to text file
    }

    public static boolean isSolved(int x, int y){
	if(x+1 > lake.length || y+1 > lake.length || x-1 < 1 || y-1 < 1){
	    return true;
	}
    }

    public static boolean check(int x, int y, boolean isStart){
	if(isStart){
	    if(lake[x][y]<=lake[x+1][y]) return true;
	    if(lake[x][y]<=lake[x][y-1]) return true;
	}
	if(compare(x, y, x+1, y) && compare(x, y, x-1, y) && compare(x, y, x, y+1) && compare(x,y,x,y-1))
    public static boolean solveSquare(int startx, int starty){
	
    }

    public static boolean compare(int x, int y, int a, int b){
	try{
	    if(lake[x][y]<lake[a][b]) return true;
	}catch(Exception e){
	    return false;
	}
	return false;
    }

}

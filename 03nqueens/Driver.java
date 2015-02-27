import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]arrr){
	int cse = 0;
	if(arrr.length >0) cse=Integer.parseInt(arrr[0]);
	NQueens t = new NQueens(20);
	if(t.solve()){
	    System.out.println(t);
	}else{
	    System.out.println("Cannot solve");
	}
    }
}

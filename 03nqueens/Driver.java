import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]arrr){
	NQueens t = new NQueens(8);
	if(t.solve()){
	    System.out.println(t);
	}else{
	    System.out.println("Cannot solve");
	}
    }
}

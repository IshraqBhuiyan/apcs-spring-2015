import java.util.*;
import java.io.*;

public class driver{
    public static void main(String[]args){
	/*
	KnightsTour board;
	if(args.length < 1){
	    System.out.println("Usage:\n\tint boardSize [int startPosx, intstartPosy]");
	}
	else{
	    if(args.length == 1){
	    board = new KnightsTour(Integer.parseInt(args[0]));
	    board.solve();
	    System.out.println(board);
	    }
	    else if(args.length == 3){
	    board = new KnightsTour(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
				    Integer.parseInt(args[2]));
	    board.solve();
	    System.out.println(board);
	    }

	}
	*/
	KnightsTour t = new KnightsTour(5);
	System.out.println(t.name());
	System.out.println("Knights Tour:");
	//t.solve();
	//System.out.println(t);
	t.solve(3,3);
	System.out.println(t);

    }

}

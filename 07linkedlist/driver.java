import java.util.*;
import java.io.*;

public class driver{

    public static void main(String[]args){
	linkedList<Integer> l = new linkedList<Integer>(new LNode<Integer>(0));
	for(int i = 0; i< 40; i++){
	    l.add(i);
	}
	System.out.println(l);
	l.set(15, 4);
	System.out.println(l + " Set 15 to 4");
	l.add(5, 6);
	System.out.println(l + " add to 5 6");
	l.remove(16);
	System.out.println(l + " remove 16");
    }

}

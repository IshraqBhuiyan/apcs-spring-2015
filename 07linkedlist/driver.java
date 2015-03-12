import java.util.*;
import java.io.*;

public class driver{

    public static void main(String[]args){
	linkedList l = new linkedList(new LNode(0));
	for(int i = 0; i< 40; i++){
	    l.add(i);
	}
	System.out.println(l);
    }

}

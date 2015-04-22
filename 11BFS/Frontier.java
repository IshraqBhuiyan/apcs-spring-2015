import java.util.*;
import java.io.*;
public class Frontier{
    private int mode;
    private MyDeque<Point> Front;
    
    public Frontier(){
	Front = new MyDeque<Point>();
    }

    public Frontier(int m){
	Front = new MyDeque<Point>();
	mode = m;
    }

    public void setMode(int m){
	mode = m;
    }

    public Point remove(){
	switch(mode){
	case 0:
	    return Front.removeLast();
	case 1:
	    return Front.removeFirst();
	case 2:
	    return Front.removeSmallest();
	case 3:
	    return Front.removeSmallest();
	default:
	    throw new IllegalArgumentException();
	}
    }

    public void add(Point p){
	if(mode == 3){
	    Front.addFirst(p, p.getTotalDist());
	}else{
	    Front.addFirst(p, p.getDist());
	}
    }

    public boolean hasNext(){
	try{
	    Front.getFirst();
	    return true;
	}catch(Exception e){
	    return false;
	}
    }
}

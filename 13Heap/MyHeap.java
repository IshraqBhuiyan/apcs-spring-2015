import java.util.*;
import java.io.*;

public class MyHeap{
    private int[] heap;
    boolean type; //true is maxheap, false is minheap

    public MyHeap(){
	this(true);
    }

    public MyHeap(boolean isMax){
	type = ismax;
	heap = new int[15];
	heap[0] = 0;
    }

    public String toString(){
    }

    public int remove(){
    }

    public void add(int x){
	if(heap[0] == 0){
	    heap[1] = x;
	}else{
	    if(heap[0] == heap.length-1){
		resize();
	    }
	    if(type){
		int curr = heap[1];
		while(true){}
	    }
	}
    }

    public int peek(){
	try{
	    return int[1];
	}catch(Exception e){
	    throw new NoSuchElementException("This tree does not have a root.");
	}
    }

}

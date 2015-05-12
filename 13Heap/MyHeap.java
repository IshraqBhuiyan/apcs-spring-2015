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
	try{
	    int temp = 1;
	    
    }

    public void add(int x){
	if(heap[0] == 0){
	    heap[1] = x;
	}else{
	    if(heap[0] == heap.length-1){
		resize();
	    }
	    int curr = heap[0] + 1;
	    heap[curr] = x;
	    if(type){
		while(curr/2 != 0 && heap[curr/2] >= x){
		    int temp = heap[curr];
		    heap[curr] = heap[curr/2];
		    heap[curr/2] = temp;
		}
	    }else{
		while(curr/2 != 0 && heap[curr/2] <= x){
		    int temp = heap[curr];
		    heap[curr] = heap[curr/2];
		    heap[curr/2] = temp;
		}
	    }
	    heap[0] += 1;
	}
    }

    public void resize(){
	int[] temp = new int[heap.length * 4];
	for(int i=0;i<heap.length;i++){
	    temp[i] = heap[i];
	}
	heap = temp;
    }

    public int peek(){
	try{
	    return int[1];
	}catch(Exception e){
	    throw new NoSuchElementException("This tree does not have a root.");
	}
    }

}

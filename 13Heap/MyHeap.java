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
	return Arrays.toString(heap);
    }

    public int remove(){
	try{
	    int ind = heap[0];
	    int temp = heap[ind];
	    while(ind > 0){
		temp = heap[ind/2];
		heap[ind/2] = heap[ind];
		ind = ind/2;
	    }
	    heap[0] = heap[0] - 1;
	    return temp;
	}catch(Exception e){
	    throw NoSuchElementException("This Heap is empty.");
	}
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

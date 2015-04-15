import java.util.*;
import java.io.*;

public class MyDeque<T>{
    private Object[] deque;
    private int[] priority;
    private int start = -1;
    private int end = -1;

    public MyDeque(){
	deque = new Object[15];
	priority = new int[15];
    }

    public MyDeque(T item){
	this(item, 0);
    }
    public MyDeque(T item, int p){
	deque = new Object[15];
	priority = new int[15];
	deque[7] = item;
	priority[7] = p;
	start = 7;
    }

    public void addFirst(T item){
	addFirst(item, 0);
    }

    public void addFirst(T item, int priority){
	if((start - 1 < 0 && deque[deque.length - 1] != null) || deque[start - 1] != null){
	    resize();
	}
	if(start - 1 < 0){
	    deque[deque.length - 1] = item;
	    priority[deque.length - 1] = priority;
	    start = deque.length - 1;
	}else{
	    deque[start - 1] = item;
	    priority[start - 1] = priority;
	    start--;
	}
    }

    public void addLast(T item){
	addLast(item, 0);
    }

    public void addLast(T item, int priority){
	if((end + 1 >= deque.length && deque[0] != null) || deque[end + 1] != null){
	    resize();
	}
	if(end + 1 >= deque.length){
	    deque[0] = item;
	    priority[0] = priority;
	    end = 0;
	}else{
	    deque[end + 1] = item;
	    priority[end + 1] = priority;
	    end++;
	}
    }

    public T removeFirst(){
	if(start == -1 || deque[start] == null)
	    throw new NoSuchElementException();
	T item = (T) deque[start];
	deque[start] = null;
	priority[start] = null;
	if(start + 1 >= deque.length && deque[0] != null){
	    start = 0;
	}else if(deque[start + 1] != null){
	    start++;
	}else{
	    start = -1;
	}
	return item;
    }

    public T removeLast(){
	if(end == -1 || deque[start] == null){
	    throw new NoSuchElementException();
	}
	T item = (T) deque[end];
	deque[end] = null;
	priority[end] = null;
	if(end - 1 < 0 && deque[deque.length - 1] != null){
	    end = deque.length - 1;
	}else if(deque[end - 1] != null){
	    end--;
	}else{
	    end = -1;
	}
	return item;
    }

    public void resize(){
	Object[] temp = new Object[deque.length * 4];
	int[] ptemp = new int[deque.length * 4];
	for(int i = 0; i<deque.length; i++){
	    temp[deque.length + (deque.length/2) + i] = deque[i];
	    ptemp[dque.length + (deque.length/2) + i] = priority[i];
	}
	start = deque.length + (deque.length/2);
	end = deque.length+ (deque.length/2) + deque.length - 1;
	deque = temp;
	priority = ptemp;
    }

    public T getFirst(){
	if(deque[start] == null){
	    throw new NoSuchElementException();
	}
	return (T)deque[start];
    }

    public T getLast(){
	if(deque[end] == null){
	    throw new NoSuchElementException();
	}
	return (T)deque[end];
    }

}

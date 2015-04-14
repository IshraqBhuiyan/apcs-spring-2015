import java.util.*;
import java.io.*;

public class MyDeque<T>{
    private Object[] deque;
    private int start, end;

    public MyDeque(){
	deque = new Object[15];
    }

    public MyDeque(T item){
	deque = new Object[15];
	deque[7] = item;
	start = 7;
    }

    public void addFirst(T item){
	if((start - 1 < 0 && deque[deque.length - 1] != null) || deque[start - 1] != null){
	    resize();
	}
	if(start - 1 < 0){
	    deque[deque.length - 1] = item;
	    start = deque.length - 1;
	}else{
	    deque[start - 1] = item;
	    start--;
	}
    }

    public void addLast(T item){
	if((end + 1 >= deque.length && deque[0] != null) || deque[end + 1] != null){
	    resize();
	}
	if(end + 1 >= deque.length){
	    deque[0] = item;
	    end = 0;
	}else{
	    deque[end + 1] = item;
	    end++;
	}
    }

    public T removeFirst(){
	if(deque[start] == null)
	    throw new NoSuchElementException();
	T item = (T) deque[start];
	deque[start] = null;
	if(start + 1 >= deque.length && deque[0] != null){
	    start++;
	}else if(deque[start + 1] != null){
	    start++;
	}else{
	    start = null;
	}
    }

    public void resize(){
	Object[] temp = new Object[deque.length * 4];
	for(int i = 0; i<deque.length; i++){
	    temp[deque.length + (deque.length/2) + i] = deque[i];
	}
	start = deque.length + (deque.length/2);
	end = deque.length+ (deque.length/2) + deque.length - 1;
	deque = temp;
    }

    public T getFirst(){
	return (T)deque[start];
    }

    public T getLast(){
	return (T)deque[end];
    }

}

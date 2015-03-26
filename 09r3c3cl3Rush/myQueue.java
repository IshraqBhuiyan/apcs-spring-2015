import java.util.*;
import java.io.*;

public class myQueue<T> extends myStack<T>{

    public myQueue(){
	super();
    }

    public myQueue(T x){
	super(x);
    }

    public T add(T x){
	super.add(x);
	return x;
    }

    public T peek(){
	return super.get(0).getData();
    }

    public T pop(){
	T item = super.get(0).getData();
	super.remove(0);
	return item;
    }

}

import java.util.*;
import java.io.*;

public class myStack<T> extends MyLinkedList<T>{

    public myStack(){
	super();
    }

    public myStack(LNode<T> x){
	super(x);
    }

    public T peek(){
	return super.getHead().getData();
    }

    public T pop(){
	return super.remove(0);
    }

    public T push(T item){
	super.add(0, item);
	return item;
    }

}

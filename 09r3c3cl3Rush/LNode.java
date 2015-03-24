import java.util.*;
import java.io.*;

public class LNode<T>{
    private T value;
    private LNode<T> next;

    public LNode(){
    }

    public LNode(T value){
	setData(value);
    }
    
    public LNode(T value, LNode<T> next){
	setData(value);
	setNext(next);
    }

    public void setData(T x){
	value = x;
    }

    public void setNext(LNode<T> x){
	next = x;
    }

    public T getData(){
	return value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "" + getData();
    }

}

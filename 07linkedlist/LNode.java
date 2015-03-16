import java.util.*;
import java.io.*;

public class LNode<T extends Comparable<T>>{
    private T value;
    private LNode<T> next;

    public LNode(){
    }

    public LNode(T value){
	setValue(value);
    }
    
    public LNode(T value, LNode<T> next){
	setValue(value);
	setNext(next);
    }

    public void setValue(T x){
	value = x;
    }

    public void setNext(LNode<T> x){
	next = x;
    }

    public T getValue(){
	return value;
    }

    public LNode<T> getNext(){
	return next;
    }

    public String toString(){
	return "" + getValue();
    }

}

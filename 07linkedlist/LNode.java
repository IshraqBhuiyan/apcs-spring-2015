import java.util.*;
import java.io.*;

public class LNode{
    private int value;
    private LNode next;

    public LNode(){
    }

    public LNode(int value){
	setValue(value);
    }
    
    public LNode(int value, LNode next){
	setValue(value);
	setNext(next);
    }

    public void setValue(int x){
	value = x;
    }

    public void setNext(LNode x){
	next = x;
    }

    public int getValue(){
	return value;
    }

    public LNode getNext(){
	return next;
    }

    public String toString(){
	return "" + getValue();
    }

}

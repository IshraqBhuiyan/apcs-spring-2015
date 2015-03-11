import java.util.*;
import java.io.*;

public class linkedList{
    private LNode head;
    private int size;

    public linkedList(){
    }

    public linkedList(LNode x){
	setHead(x);
	LNode x = head;
	while(x.getValue != null){
	    size++;
	    x = head.getNext();
	}
    }

    public get(int index){
	LNode point;
	for(int i=0; i<index; i++){
	    point = 

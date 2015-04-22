import java.util.*;
import java.io.*;
public class Point{
    private int totalDist;
    private int Dist;
    private Point Parent;
    private int Xcor, Ycor;
    
    public Point(){
    }

    public Point(int x, int y){
	Xcor = x;
	Ycor = y;
    }

    public void setParent(Point P){
	Parent = P;
    }

    public void setDist(int dist){
	Dist = dist;
    }

    public void setTotalDist(int dist){
	totalDist = dist;
    }

    public Point[] getPoints(){
	if(Parent == null){
	    return new Point[0];
	}
	Point[] parent = new Point[Parent.getPoints().length + 1];
	parent[Parent.getPoints().length] = Parent;
	System.arraycopy(Parent.getPoints(),0,parent,0,Parent.getPoints().length);
	return parent;
    }

    public int getTotalDist(){
	return totalDist;
    }

    public int getDist(){
	return Dist;
    }

    public int getX(){
	return Xcor;
    }

    public int getY(){
	return Ycor;
    }

}

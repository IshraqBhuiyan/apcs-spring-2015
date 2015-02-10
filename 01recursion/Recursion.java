public class Recursion{
    public String name() {
	return "Bhuiyan,Ishraq";
    }

    public int fact(int n){
	if(n<0) throw new IllegalArgumentException("n must be greater than or equal to 0");
	return factorial(n, 1);
    }

    public int factorial(int n, int ans){
	if(n<=1) return ans;
	return factorial(n-1, ans * n);
    }

    public int fib(int n){
	if(n<0) throw new IllegalArgumentException("n must be greater than or equal to 0");
	return fib(n, 1, 0);
    }

    public int fib(int n,int l, int m){
	if(n == 0) return 0;
	if(n == 1) return l;
	return fib(n - 1, l + m, l);
    }

    public double sqrt(double n){
	if(n<0) throw new IllegalArgumentException("n must be greater than or equal to 0");
	if(n==1||n==0) return n;
	return sqrt(n, 1);
    }

    public double sqrt(double n, double guess){
	if(Math.abs(1 - (guess*guess)/n) < 0.0005){
	    return guess;
	}
	return sqrt(n, (n/guess + guess)/2);
    }

}

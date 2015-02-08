public class main{
    public static void main(String[] args){
	Recursion test = new Recursion();
	System.out.println(test);
	System.out.println("" + test.fact(Integer.parseInt(args[0])));
	System.out.println("" + test.fib(Integer.parseInt(args[1])));
	System.out.println("" + test.sqrt(Double.parseDouble(args[2])));
    }
}

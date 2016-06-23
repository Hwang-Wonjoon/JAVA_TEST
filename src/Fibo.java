
public class Fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fibo fibo = new Fibo();
		fibo.run();
	}
	
	private void run(){
		int num = 3;
		
		int result = fibo(num);
		
		System.out.println("Result: " + result);;
	}
	
	private int fibo(int num){
		
		int sum;
		
		if(num > 0){
			return num * fibo(num-1);
		}
		else{
			return 1;
		}
	}

}

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	int test_case;
	int num_explosive;
	ArrayList<Integer>[] list = new ArrayList[num_explosive];
	
	int[] a;
	int[] b;
	int[] c;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		s.run();
	}
	
	public void run() throws Exception{
		
		System.setIn(new FileInputStream("./sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		test_case = sc.nextInt();
		num_explosive = sc.nextInt();
		// 1 <= num_fire <= 10,000
		
		
		a = new int[2*num_explosive - 1];
		b = new int[2*num_explosive - 1];
		c = new int[2*num_explosive - 1];
		
		// 1 <= c <=1,000,000,000
		// if a <= num_explosive                                =>     Explosive a is connected to Line
		// if num_explosive < a < 2* num_explosive     =>     Bungy a-n is connected to Line
		// if a == 2*num_explosive                             =>     'a' is switch
		
		int start = 0;
		for(int i = 0; i < 2*num_explosive -1; i++){
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			if( a[i] == 2*num_explosive || b[i] == 2*num_explosive)
				start = i;			
			System.out.println("Line " + (i +1) + "#:  "  + a[i] + " " + b[i] + " " + c[i]);
		}
		System.out.println("Start Location: " + (start + 1));
		
		for(int i = 0; i < num_explosive; i++){
			list[i] = new ArrayList<Integer>();
		}
		
		make_tree(start);
		check_tree();
	}

	public void make_tree(int pos){
		
		if( a[pos] <= num_explosive ){
			list[pos].add(c[pos]);
			return;
		}else{
			list[pos].add(c[pos]);
			make_tree(a[pos]);
		}
		
		if(b[pos <= num_explosive]){
			
		}
		
	}
	
	public void check_tree(){
		
	}
}

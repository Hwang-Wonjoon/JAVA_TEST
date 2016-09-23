import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Solution s = new Solution();
		s.run();
	}
	
	public void run() throws Exception{
		
		System.setIn(new FileInputStream("./sample_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		int num_explosive = sc.nextInt();
		// 1 <= num_fire <= 10,000
		
		
		int[] a = new int[2*num_explosive - 1];
		int[] b = new int[2*num_explosive - 1];
		int[] c = new int[2*num_explosive - 1];
		
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
		
		ArrayList<Integer>[] list = new ArrayList[num_explosive];
		for(int i = 0; i < num_explosive; i++){
			list[i] = new ArrayList<Integer>();
		}
		if(a[i] == 2*num_explosive){
		}
		
		
	}

}

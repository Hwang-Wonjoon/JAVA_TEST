import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("res/sample_input.txt");
		System.setIn(fis);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input your favorite color: ");
		
		System.out.println("Your color is  " + sc.next() + ".");
		
		fis.close();
		
		FileReader fr = new FileReader("res/sample_input.txt");
		BufferedReader br = new BufferedReader(fr);
		System.out.print("Input your favorite number: ");
		
		System.out.println("Your number is " + br.readLine());
		br.close();
	}

}

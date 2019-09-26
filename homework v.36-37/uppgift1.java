import java.util.Scanner;
public class uppgift1 {
	
	
	public static void main (String[] args) {
		
		int[] list = {1, 2, 5, 4};
		int sum = 0;
		
		for (int i = 0; i < list.length; i++) {
			sum += list[i];
		}
		
		System.out.println(sum);
	}

}

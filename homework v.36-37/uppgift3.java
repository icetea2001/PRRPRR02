import java.util.Arrays;

public class uppgift3 {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(array("hej", 5, 'c', "gay")));
		Object[] hej = {};
		uppgift4 box = new uppgift4(hej);
	}
	
	public static <T> T[] array(T... t) {
		return t;
	}

}

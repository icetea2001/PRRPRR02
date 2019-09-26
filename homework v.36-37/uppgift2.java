
public class uppgift2 {

	static int co = 0;
	static String rev = "";
	
	public static void main(String[] args) {
		System.out.println(reverse("Mikael är gay"));
	}
	
	public static String reverse(String p) {
		rev += p.charAt(p.length() - co - 1);
		
		co++;
		
		if(co >= p.length()) {
			return rev;
		}
		
		reverse(p);
		return rev;
	}
	
}
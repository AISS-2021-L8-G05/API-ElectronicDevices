import java.util.ArrayList;
import java.util.List;

public class Prueba2 {
	
	public static void main(String[] args) {
		List<String> test = new ArrayList<String>();
		
		test.add("A");
		test.add("B");
		test.add("C");
		test.add("A");
		test.add("D");
		test.add("E");
		test.add("F");
		test.add("G");
		
		test.add("AA");
		test.add("BB");
		
		System.out.println(test);
		
//		for(String t : test) {
//			if(!(t.contains("A"))) {
//				test.remove(t);
//			}
////			if(!(t.equals("A"))) {
////				test.remove(t);
////			}
//		}
		
		for(int i = 0; i<test.size(); i++) {
			String t = test.get(i);
			
			if(!(t.contains("A"))) {
				test.remove(t);
				i--;
			}
			if(!(t.equals("A"))) {
				test.remove(t);
				i--;
			}
			
		}
		
		System.out.println(test);
	}

}

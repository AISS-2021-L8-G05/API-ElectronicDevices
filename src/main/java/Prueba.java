import java.util.ArrayList;
import java.util.List;

public class Prueba {
	
	public static void main(String[] args) {
		List<Integer> num = new ArrayList<Integer>();
		
		num.add(2);
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		num.add(5);
		num.add(6);
		num.add(7);
		num.add(8);
		num.add(9);
		num.add(10);
		num.add(11);
		num.add(12);
		num.add(13);
		
//		for(Integer i : num) {
//			if(i%2==0 ) {
//				num.remove(i);
//			}
//			
////			if(num.contains(i) && i%2==0) {
////				num.remove(i);
////			}
//			System.out.println(num.contains(i));
//			
//			System.out.println(i);			
//		}
		
		int j = 0;
		while(j<num.size()) {
			Integer i = num.get(j);
			if(i%2==0 ) {
				num.remove(i);
				j--;
			}
			
//			if(num.contains(i) && i%2==0) {
//				num.remove(i);
//			}
			System.out.println(num.contains(i));
			
			System.out.println(i);
			j++;
		}
	}

}

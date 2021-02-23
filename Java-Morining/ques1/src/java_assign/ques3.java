package java_assign;

public class ques3 {
	
	public static void main(String args[]) {
		Singleton obj1 = Singleton.get();
				
		Singleton obj2 = Singleton.get();
		
		String s_obj1 = obj1.s.toLowerCase();
		String s_obj2 = obj2.s.toUpperCase();
		
		System.out.println(s_obj1);
		System.out.println(s_obj2);
		
	}

}


class Singleton 
{
private static Singleton obj = null;
	
	public String s;
	private Singleton() {
		s = "This is implementation of Stringleton class";
	}
	
	public static Singleton get(){
		if (obj == null) {
			obj = new Singleton();
		}
		return obj;
	}
}
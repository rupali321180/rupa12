package excepti;

public class NULLpointeerexcepotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	 String s = null;
	 System.out.println(s.hashCode());
}
catch(NullPointerException e) {
	System.out.println("done");
}
	}
}


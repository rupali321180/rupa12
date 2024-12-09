package excepti;

public class c_exception {
	
	static void Submit() {
	int age=18;
	if(age>=21)
		System.out.println("happylife");
	else {
		throw new Sadhiexception("LOSTLIFE");
	}
	public static void main(String[]args) {
		try {
			Submit();
		}
		catch(Sadhiexception e) {
			
		System.out.println(e.getmessage());
		}
	}
	class Sadhiexception extends Exception{
		String msg;
		Sadhiexception(String msg)
		{
			this.msg=msg;
		}
		public String getmessage() {
			return msg;
		}
	}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	}

}

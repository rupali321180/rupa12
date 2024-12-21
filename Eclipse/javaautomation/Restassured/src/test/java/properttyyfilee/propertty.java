package properttyyfilee;

import java.io.IOException;

import org.testng.annotations.Test;

public class propertty {

	@Test
	public void gett() throws IOException {
		Propertycs p=new Propertycs();
		String url =p.gett("baseurl");
		String endpoint= p.gett("loginEP");
		
		
		System.out.println(url);
		System.out.println(endpoint);
	}
	
	
	
	
	
	
	
	
	
	
}

package shopperpojo;

import org.testng.annotations.Test;

public class Runnermerchant {

	@Test
	public void create() {
	
		Createmerchant merchant=new Createmerchant();
		merchant.setCity("Bengaluru");
		merchant.setCommission(30);
		
		
		Adressmerchant adress=new Adressmerchant();
		adress.setBuildingInfo("IshrilediesPG");
		adress.setCity("Bengaluru");
		adress.setCountry("India");
		adress.setLandmark("Rajajinagar");
		adress.setName("rupa");
		adress.setPhone("7654567890");
		adress.setPincode("560010");
		adress.setState("Karnataka");
		adress.setStreetInfo("Mahalaxmipuram");
		adress.setType("Office");
	
	Companymerchant company=new Companymerchant();
	company.setAddress("Marathali");
	company.setCompanyId(1080);
	company.setEmail("rupa123@gmail.com");
	company.setGstn("GST123456");
	company.setName("rupali");
	company.setPhone("7654323456");
	company.setRegisterNumber("REG12345");
	
	company.setAddress(adress);
	merchant.setCompany(company);
	
	merchant.setCountry("India");
	merchant.setCreatedDateTime("2024-11-25T16:34:48.151Z");
	merchant.setDob("2011");
	merchant.setEmail("gana@gmail.com");
	merchant.setFirstName("rupali");
	merchant.gender("")
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
	
	

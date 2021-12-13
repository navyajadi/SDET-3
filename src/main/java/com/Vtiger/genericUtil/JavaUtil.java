package com.Vtiger.genericUtil;

import java.util.Random;

import com.github.javafaker.Faker;

public class JavaUtil {
	
	public JavaUtil() {
		
	}
 
	public static JavaUtil ObjforJavaUtil() {
		
		JavaUtil jv=new JavaUtil();
		return jv;
	
	}
    /**
     * @author jagad
     * Description: Generate The Random Name
     * @return
     */
	
	public int generateRandomNumber() {
		Random r= new Random();
		return r.nextInt(1000);
	}

	
	/**
	 * @author jagad
	 * Description: Generate the FirstName
	 * @return
	 */
	
	public String getFirstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
    /**
     * @author jagad
     * Description: Generate the LastName
     * @return
     */
	public String getLastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	
	/**
	 * @author jagad
	 * Description: Generate the FullName
	 * @return
	 */
	public String getFullName() {
		Faker faker = new Faker();
		return faker.name().fullName();
	}
	
	public String getphoneNumber() {
		Faker faker = new Faker();
		return faker.phoneNumber().cellPhone();
	}
	
	
}

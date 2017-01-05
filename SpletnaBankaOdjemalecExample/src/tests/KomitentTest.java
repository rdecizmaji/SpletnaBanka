package tests;

import javax.naming.InitialContext;

import test.LocalTests;

public class KomitentTest {

	public static void main(String[] args) throws Exception{
		
		String ejb="SpletnaBankaEar/SpletnaBankaJPA/LocalTestsBean!test.LocalTests";
		
		LocalTests lt=(LocalTests)new InitialContext().lookup(ejb);
		
		lt.komitentTest();
		
		lt.trrTest();
		
	}
	


}

package calculator;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a + b ;
	}
	
	
	public int multiply(int a, int b){
		return a * b;
	}


	public void longCalculation() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}


//	public Set<Integer> digitsSet(int number) {
//		final Set<Integer> integers = new HashSet<Integer>();
//		final String numberString = String.valueOf(number);
//		
//		for (int i = 0; i < numberString.length(); i++) {
//			integers.add(Integer.parseInt(numberString, i, i + 1, 10));
//		}
//		return integers;
//	}
	
	
	public double divise(double a, double b) {
			return a / b;
	}
	
	public double addDouble(int a, int b) {
		return a + b;
	}
	
}

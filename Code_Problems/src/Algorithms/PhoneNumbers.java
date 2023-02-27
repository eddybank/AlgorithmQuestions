package Algorithms;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class PhoneNumbers {

	public static HashMap<Integer, String> findNumbers(int numDigits, int digitOne, int digitTwo, int digitThree) {
		int highestNum = (int) (Math.pow(10, numDigits) - 1);
		HashMap<Integer, String> numbers = new HashMap<Integer, String>();
		for(int i = 0; i <= highestNum; i++) {
			String num = String.format("%0"+numDigits+"d", i);
			numbers.put(i, num);
		}
			
		int hashSize = numbers.size();
		
		for(int x = 0; x < hashSize; x++) {
			String cur = numbers.get(x);
			char curDig = '\0';
			char prevDig = '\0';
			if(cur.toCharArray().length == numDigits) {
				for(int y = 0; y < cur.length() ; y++) {
					curDig = cur.charAt(y);
					if(y > 0 && curDig == '4') {
						numbers.remove(x);
					}
					if(curDig == Character.forDigit(digitOne, 10) || curDig == Character.forDigit(digitTwo, 10) || curDig == Character.forDigit(digitThree, 10)) {
						numbers.remove(x);
					} 
					if(prevDig == curDig) {
						numbers.remove(x);
					}
					prevDig = curDig;
				}
			}
		}
		
		return numbers;
	}
	
	public static HashMap<Integer, String> findNumbersT(int numDigits, int digitOne, int digitTwo, int digitThree) {
		int highestNum = (int) (Math.pow(10, numDigits) - 1);
		HashMap<Integer, String> numbers = new HashMap<Integer, String>();
		for(int i = 0; i <= highestNum; i++) {
			String num = String.format("%0"+numDigits+"d", i);
			numbers.put(i, num);
			String cur = numbers.get(i);
			char curDig = '\0';
			char prevDig = '\0';
			if(cur.toCharArray().length == numDigits) {
				for(int y = 0; y < cur.length() ; y++) {
					curDig = cur.charAt(y);
					if(y > 0 && curDig == '4') {
						numbers.remove(i);
					}
					if(curDig == Character.forDigit(digitOne, 10) || curDig == Character.forDigit(digitTwo, 10) || curDig == Character.forDigit(digitThree, 10)) {
						numbers.remove(i);
					} 
					if(prevDig == curDig) {
						numbers.remove(i);
					}
					prevDig = curDig;
				}
			}
		}	
		
		return numbers;
	}
	
	
	/*
	 * public static HashMap<Integer, String> findNumbers(int numDigits, int digitOne, int digitTwo, int digitThree) {
		int highestNum = (int) (Math.pow(10, numDigits) - 1);
		HashMap<Integer, String> numbers = new HashMap<Integer, String>();
		for(int i = 0; i <= highestNum; i++) {
			String num = String.format("%0"+numDigits+"d", i);
			numbers.put(i, num);
			String cur = numbers.get(i);
			char curDig = '\0';
			char prevDig = '\0';
			if(cur.toCharArray().length == numDigits) {
				for(int y = 0; y < cur.length() ; y++) {
					curDig = cur.charAt(y);
					if(y > 0 && curDig == '4') {
						numbers.remove(i);
					}
					if(curDig == Character.forDigit(digitOne, 10) || curDig == Character.forDigit(digitTwo, 10) || curDig == Character.forDigit(digitThree, 10)) {
						numbers.remove(i);
					} 
					if(prevDig == curDig) {
						numbers.remove(i);
					}
					prevDig = curDig;
				}
			}
		}
		
		Set<Integer> keys = numbers.keySet();
		System.out.println("num of keys: "+ keys.size());	
		
		return numbers;
	}
		int hashSize = numbers.size();
	 	for(int x = 0; x < hashSize; x++) {
			String cur = numbers.get(x);
			char curDig = '\0';
			char prevDig = '\0';
			if(cur.toCharArray().length == numDigits) {
				for(int y = 0; y < cur.length() ; y++) {
					curDig = cur.charAt(y);
					if(y > 0 && curDig == '4') {
						numbers.remove(x);
					}
					if(curDig == Character.forDigit(digitOne, 10) || curDig == Character.forDigit(digitTwo, 10) || curDig == Character.forDigit(digitThree, 10)) {
						numbers.remove(x);
					} 
					if(prevDig == curDig) {
						numbers.remove(x);
					}
					prevDig = curDig;
				}
			}
		}
	 */
	
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> hash = findNumbers(3, 9, 2, 3);
		System.out.println("size: "+hash.size());
		System.out.println(hash);
		
		HashMap<Integer, String> hash1 = findNumbersT(3, 9, 2, 3);
		System.out.println("size: "+hash1.size());
		System.out.println(hash1);
		
		System.out.println(hash.equals(hash1));
	}

}

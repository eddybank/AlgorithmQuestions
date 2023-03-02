package algorithms;

public class MRNumber {

	/*
	 * Create a function that takes a string of 10 numbers and an array of lengths to create a Medical Record Number (MRN).
	 * The format of the MRN is as follows: 684-21-5902-6
	 */
	
	public static String createMRN(String id, int[] lengths) {
		int prev = id.length();
		String mRN = "";
		
		for(int i = 0; i < lengths.length; i++) {
			if(i == lengths.length-1) {
				mRN += id.substring(prev-lengths[i], prev);
			} else {
				mRN += id.substring(prev-lengths[i], prev) + "-";
			}
			prev = prev-lengths[i];
		}
		
		return mRN;
	}
	
	public static void main(String[] args) {
		int[] array = {3, 2, 4, 1};
		String num = "6842156748";
		
		System.out.println(createMRN(num, array));
	}
}

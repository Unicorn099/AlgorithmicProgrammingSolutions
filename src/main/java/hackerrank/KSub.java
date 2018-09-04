package hackerrank;

public class KSub {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[]{1,2,3,4,1};
		int k=3;
		
		System.out.println(kSub(k, nums));

	}

	static long kSub(int k, int[] nums) {
		long result = 0;

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum % k == 0) {
					result += 1;
				} 
			}
		}
		return result;
	}

}

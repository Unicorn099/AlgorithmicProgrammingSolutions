package hackerrank;

public class MostFrequest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = new int[] { 3, 4, 5, 2, 2, 3, 2 };
		System.out.println(findMostFrequent(a));
	}

	static String findMostFrequent(int[] n) {

		String str = "";
		int length = n.length;
		int min = n[0], max = n[0];
		for(int i=0;i<length;i++){
			if(n[i]<min){
				min=n[i];
			}
			if(n[i]>max){
				max=n[i];
			}
		}
		System.out.println(min+" "+max);
		int[] x = new int[max+1];
		for(int i=0;i<n.length;i++){
			x[n[i]]+=1;
		}
		
		int m=x[0];
		for(int i=1;i<max+1;i++){
			if(m<x[i]){
				str=i+": "+x[i];
				m=x[i];
			}
		}
		return str;
	}
}

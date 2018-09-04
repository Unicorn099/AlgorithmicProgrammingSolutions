package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] str = new String[]{"aksjdhkajhdkadhaksdhttp://www.oxford.com",
				"kajshkjahfkajhf",
				"http://ww2.orgfa.com"
		};
		
		for(int i=0;i<str.length;i++){
			extractDomains(str[i]);
		}

	}

	private static List<String> extractDomains(String value) {
		List<String> result = new ArrayList<String>();
		String domainPattern = "[a-z0-9\\-\\.]+\\.(com|org|net|mil|edu|(co\\.[a-z].))";
		Pattern p = Pattern.compile(domainPattern, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(value);
		while (m.find()) {
			result.add(value.substring(m.start(0), m.end(0)));
		}
		
		for (int ii = 0; ii < result.size(); ii++) {
			System.out.print(result.get(ii) + ";");
		}
		System.out.println();
		return result;
	}

	static void printDomains(String[] arr) {

		String s = "http://ww";
		String str = "http://www.", str2 = "http://ww2.", str3 = "http://web.";
		String str1 = ".com";
		List<String> results = new ArrayList<String>();

		
		
		
		for (int i = 0; i < arr.length; i++) {
			int j = 0;
			boolean flag = true;
			if (arr[i].charAt(i) == s.charAt(j)) {

			}
		}

		// for (int i = 0; i < arr.length; i++) {
		//
		// if ((arr[i].contains(str) ||
		// arr[i].contains(str2)||arr[i].contains(str3)) &&
		// arr[i].contains(str1)) {
		// int j=0, jj=0;
		// boolean flag = true;
		// for (; j < arr[i].length() && jj<str.length(); j++) {
		// if (arr[i].charAt(j) == str.charAt(j)) {
		// jj++;
		// } if(!flag){
		// break;
		// }
		// }
		// if(j==str.length()){
		// int k=0;
		// for (; k < arr[i].length() && k<str1.length(); k++) {
		// if (arr[i].charAt(j) != str.charAt(k)) {
		//
		// } else {
		// break;
		// }
		// }
		// }
		// }
		//
		// }

		for (int ii = 0; ii < results.size() - 1; ii++) {
			System.out.print(results.get(ii) + ";");
		}
		System.out.println(results.get(results.size() - 1));
	}

}

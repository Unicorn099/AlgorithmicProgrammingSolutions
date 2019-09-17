package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateParentheses {

  static Map<Integer, List<String>> parenthesisList = createMap();
  private static Map<Integer, List<String>> createMap()
  {
    Map<Integer,List<String>> myMap = new HashMap<>();
    myMap.put(1, Arrays.asList("()"));
    myMap.put(2, Arrays.asList("()()", "(())"));
    return myMap;
  }

  public static void main(String[] args) {
    int n = 10;
    GenerateParentheses g = new GenerateParentheses();
    g.generateParenthesis(n).stream().forEach(System.out::println);
  }

  public List<String> generateParenthesis(int n) {
    Set<String> ans = new HashSet<>();
    if (parenthesisList.containsKey(n)) {
      return parenthesisList.get(n);
    } else {
      List<String> previousAns = generateParenthesis(n - 1);
      for (String str : previousAns) {
        //Generating for n now and putting in "ans"
        List<Integer> indexOf = new ArrayList<>();
        int l = 0;
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
          if (str.charAt(i) == ')') {
            r++;
            if ((r - l) == 0) {
              indexOf.add(i);
            }
          } else {
            l++;
          }
        }
        ans.add("()" + str);
        for (int ll = 0; ll < str.length(); ) {
          for (int kk = ll; kk < indexOf.size(); kk++) {
//            if("()()()()".equalsIgnoreCase(str.substring(0, ll) + "(" + str.substring(ll, indexOf.get(kk) + 1) + ")" + (
//                (indexOf.get(kk) + 1) >= str.length() ? ""
//                    : str.substring(indexOf.get(kk) + 1)))){
//              System.out.print("");
//            }
            ans.add(str.substring(0, ll) + "(" + str.substring(ll, indexOf.get(kk) + 1) + ")" + (
                (indexOf.get(kk) + 1) >= str.length() ? ""
                    : str.substring(indexOf.get(kk) + 1)));
//            if("()()()()".equalsIgnoreCase(str.substring(ll, indexOf.get(kk) + 1) + "()" + (
//                (indexOf.get(kk) + 1) >= str.length() ? ""
//                    : str.substring(indexOf.get(kk) + 1)))){
//              System.out.print("");
//            }
            ans.add(
                str.substring(0, indexOf.get(kk) + 1) + "()" + (
                    (indexOf.get(kk) + 1) >= str.length() ? ""
                        : str.substring(indexOf.get(kk) + 1)));
          }
          ll++;
          if (ll >= indexOf.size()) {
            break;
          } else {
            ll = indexOf.get(ll) + 1;
          }
        }
        ans.add(str + "()");
      }
      return new ArrayList<>(ans);
    }
  }


}

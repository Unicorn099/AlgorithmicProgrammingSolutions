package year2019.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

  public static void main(String[] args) {

    Triangle triangle = new Triangle();
    List<List<Integer>> triangleE =  new ArrayList<>();
    List<Integer> x1 = new ArrayList<>();
    x1.add(1);
    List<Integer> x2 = new ArrayList<>();
    x2.add(1);
    x2.add(2);
    List<Integer> x3 = new ArrayList<>();
    x3.add(1);
    x3.add(2);
    x3.add(3);
    List<Integer> x4 = new ArrayList<>();
    x4.add(1);
    x4.add(2);
    x4.add(3);
    x4.add(4);
    triangleE.add(x1);
    triangleE.add(x2);
    triangleE.add(x3);
    triangleE.add(x4);
    int i = triangle.minPath(triangleE);
    System.out.println(i);
  }

  public int minPath(List<List<Integer>> triangle) {
    List<Integer> ans = triangle.get(triangle.size() - 1);
    List<Integer> realAnswer = new ArrayList<>();

    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> tempAns = triangle.get(i);
      for(int j=0;j<tempAns.size();j++){
        realAnswer.add(Math.min(tempAns.get(j)+ans.get(j), tempAns.get(j)+ans.get(j+1)));
      }
      ans=realAnswer;
      realAnswer = new ArrayList<>();
    }
    return ans.get(0);
  }

}

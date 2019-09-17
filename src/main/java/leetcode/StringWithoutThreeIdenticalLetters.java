package year2019.practice.leetcode;

public class StringWithoutThreeIdenticalLetters {

  public static void main(String[] args) {
    test(solution("baaaaa"), 1);
    test(solution("baaabbaabbba"), 2);
    test(solution("baabab"), 0);
    test(solution("baaaaa"), 1);
    test(solution("baaaaaa"), 2);
    test(solution("baaaab"), 1);
    test(solution("baaabbaabbba"), 2);
    test(solution("baabab"), 0);
    test(solution("bbaabbaabbabab"), 0);
  }

  public static void test(int x, int y) {
    System.out.println(x==y);
    if(x!=y){
      System.out.println(x+","+y);
    }
  }

  public static int solution(String string) {

    int len = string.length();
    char c = string.charAt(0);
    int count = 1;
    int ans = 0;

    for (int i = 1; i < len; i++) {
      if (c == string.charAt(i)) {
        count++;
        if (count == 3) {
          ans++;
          c=' ';
        }
      } else {
        c = string.charAt(i);
        count=1;
      }
    }
    return ans;
  }
}

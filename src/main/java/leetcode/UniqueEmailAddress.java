package year2019.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

  public static void main(String[] args) {
    String[] emails = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
    UniqueEmailAddress u = new UniqueEmailAddress();
    System.out.println(u.numUniqueEmails(emails));
  }

  public int numUniqueEmails(String[] emails) {

    Set<String> s = new HashSet<>();

    for (int i = 0; i < emails.length; i++) {
      StringBuilder ans = new StringBuilder();
      boolean enteredDomainName = false;
      for (int j = 0; j < emails[i].length(); j++) {
        if (!enteredDomainName) {
          if (emails[i].charAt(j) != '+' && emails[i].charAt(j) != '@') {
            if (emails[i].charAt(j) != '.') {
              ans.append(emails[i].charAt(j));
            }
          } else {
            while (emails[i].charAt(j) != '@') {
              j++;
            }
            ans.append(emails[i].charAt(j));
            enteredDomainName = true;
          }
        } else {
          ans.append(emails[i].charAt(j));
        }
      }
      s.add(ans.toString());
    }

    return s.size();
  }
}

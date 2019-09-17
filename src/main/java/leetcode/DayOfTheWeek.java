package year2019.practice.leetcode;

import java.time.LocalDate;

public class DayOfTheWeek {

  public static void main(String[] args) {
    System.out.println(new DayOfTheWeek().dayOfTheWeek(12, 9, 2019));
  }

  public String dayOfTheWeek(int day, int month, int year) {

    String str = month < 10 ? "0" + month : "" + month;
    LocalDate dt = LocalDate.parse(year + "-" + str + "-" + day);

    String d = dt.getDayOfWeek().name();

    return d.substring(0,1).toUpperCase()+d.substring(1).toLowerCase();
  }
}

package google.codejam.R1B18.B;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {

  final static String WORK_DIR = "E:\\testingtestingtesting123\\R1B18\\";
  final static String fileName = "B-small";

  static class BoardDetails {
    //    int index;
    int distance;
    int A;
    int B;
    int M;
    int N;

  }

//  static Comparator<List<Integer>> MyComparator = new Comparator<List<Integer>>() {
//    public int compare(List<Integer> o1, List<Integer> o2) {
//      return o2.size() - o1.size();
//    }
//  };


  public static void main(String[] args) throws FileNotFoundException {
//    Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader(WORK_DIR
        + fileName + ".in"));
    int caseCnt = Integer.parseInt(sc.nextLine());

    for (int i = 0; i < caseCnt; i++) {
      int numberOfSignBoards = Integer.parseInt(sc.nextLine());
      List<BoardDetails> boardDetailsList = new ArrayList<>();

      Map<Integer, List<Integer>> mCount = new TreeMap<>();
      Map<Integer, List<Integer>> nCount = new LinkedHashMap<>();
      for (int j = 0; j < numberOfSignBoards; j++) {
        String[] boardDetailsLineReader = sc.nextLine().split(" ");
        BoardDetails boardDetails = new BoardDetails();
//        boardDetails.index = j + 1;
        boardDetails.distance = Integer.parseInt(boardDetailsLineReader[0]);
        boardDetails.A = Integer.parseInt(boardDetailsLineReader[1]);
        boardDetails.B = Integer.parseInt(boardDetailsLineReader[2]);
        boardDetails.M = boardDetails.distance + boardDetails.A;
        boardDetails.N = boardDetails.distance - boardDetails.B;
        boardDetailsList.add(boardDetails);

//        List<Integer> indices1 = mCount.getOrDefault(boardDetails.distance + boardDetails.A, new ArrayList<>());
//        indices1.add(boardDetails.index);
//        mCount.put(boardDetails.distance + boardDetails.A, indices1);
//
//        List<Integer> indices2 = nCount.getOrDefault(boardDetails.distance - boardDetails.B, new ArrayList<>());
//        indices2.add(boardDetails.index);
//        nCount.put(boardDetails.distance - boardDetails.B, indices2);
//
      }
      System.out.print("Case #" + (i + 1) + ": ");
//      solve(mCount, nCount);
      solveR(boardDetailsList);
    }
  }

  private static void solveR(List<BoardDetails> boardDetailsList) {
    int maxLength = 0;
    int tempMaxLength = 0;
    int count = 0;
    boolean flag1, flag2, flag3;
    int length = boardDetailsList.size();
    for (int i = 0; i < length; i++) {
      int M = boardDetailsList.get(i).M;
      int N = boardDetailsList.get(i).N;
      tempMaxLength = 1;
      flag1 = false;
      flag2 = false;
      flag3 = false;
      for (int j = i + 1; j < length; j++) {
        int anotherM = boardDetailsList.get(j).M;
        int anotherN = boardDetailsList.get(j).N;
        if (anotherM == M && anotherN == N) {
          tempMaxLength++;
        } else if (anotherM == M && anotherN != N && !flag2) {
          flag1 = true;
          tempMaxLength++;
        } else if (anotherM != M && anotherN == N && !flag1) {
          flag2 = true;
          tempMaxLength++;
        } else {
          if (!flag3) {
            flag3 = true;
            if (flag1) {
              N = boardDetailsList.get(j).N;
              flag2 = false;
              flag1 = false;
            } else {
              if (flag2) {
                M = boardDetailsList.get(j).M;
                flag1 = false;
                flag2 = false;
              } else {
                if (tempMaxLength > 1) {

                }else{

                }
//                N = boardDetailsList.get(j).N;
              }
            }
            tempMaxLength++;
          } else {
            break;
          }
        }
      }
      if (tempMaxLength > maxLength) {
        maxLength = tempMaxLength;
        count = 1;
      } else if (tempMaxLength == maxLength) {
        count++;
      }
    }

    System.out.println(maxLength + " " + count);
  }

  private static void solve(Map<Integer, List<Integer>> mCount, Map<Integer, List<Integer>> nCount) {

    Map<Integer, List<Integer>> sortedmCount = mCount.entrySet().stream()
        .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> {
              throw new AssertionError();
            },
            LinkedHashMap::new
        ));

    Map<Integer, List<Integer>> sortednCount = nCount.entrySet().stream()
        .sorted((o1, o2) -> o2.getValue().size() - o1.getValue().size())
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (a, b) -> {
              throw new AssertionError();
            },
            LinkedHashMap::new
        ));

    int maxLength = 0;
    int count = 0;

    boolean done = false;
    for (Map.Entry<Integer, List<Integer>> x : sortedmCount.entrySet()) {
      List<Integer> integerList = x.getValue();
      int tempMaxLength = 0;
      for (Map.Entry<Integer, List<Integer>> y : sortednCount.entrySet()) {
        List<Integer> anotherIntegerList = y.getValue();
        if (integerList.size() + anotherIntegerList.size() < maxLength) {
          done = true;
          break;
        }
        Collections.sort(integerList);
        Collections.sort(anotherIntegerList);
        if ((integerList.get(integerList.size() - 1) < anotherIntegerList.get(0))
            || (integerList.get(0) < anotherIntegerList.get(anotherIntegerList.size() - 1))) {
          tempMaxLength = integerList.size() + anotherIntegerList.size();
          if (tempMaxLength > maxLength) {
            maxLength = tempMaxLength;
            count = 0;
          } else if (tempMaxLength == maxLength) {
            count++;
          }
        } else {
          for (int i = 0, j = 0; i < integerList.size() && j < anotherIntegerList.size(); ) {
            if (integerList.get(i) == anotherIntegerList.get(j)) {
              tempMaxLength++;
              i++;
              j++;
            } else if (integerList.get(i) < anotherIntegerList.get(j)) {
              i++;
            } else {
              j++;
            }
          }
          if (tempMaxLength > maxLength) {
            maxLength = tempMaxLength;
            count = 0;
          } else if (tempMaxLength == maxLength) {
            count++;
          }
        }

      }
      if (done) {
        break;
      }
    }
    System.out.println(maxLength + " " + count);
  }
}

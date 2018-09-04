package google.codejam.previousyear;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by Peeyush on 1/1/2017.
 */
public class LazySpellingBee {
    static class InputData {

        String str;

        public InputData(Scanner sc) {
            str = sc.next();
        }

        public void solve(PrintWriter pw) {
            int length = str.length();
            long count = 1;
            if (length == 1) {
                pw.println(1);
            } else {
                if (str.charAt(0) == str.charAt(1)) {
                    count *= 1;
                } else {
                    count *= 2;
                }

                for (int i = 1; i <= str.length() - 2; ++i) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        if (str.charAt(i) == str.charAt(i - 1)) {
                            count *= 1;
                        } else {
                            count *= 2;
                        }
                    } else {
                        if (str.charAt(i) != str.charAt(i - 1) && str.charAt(i - 1) != str.charAt(i + 1)) {
                            count *= 3;
                        } else {
                            count *= 2;
                        }
                    }
                    count %= 1000000007;
                }
                if (str.charAt(length - 1) == str.charAt(length - 2)) {
                    count *= 1;
                } else {
                    count *= 2;
                }
                count %= 1000000007;
                pw.println(count);
            }
        }
    }

    static class Solver implements Callable<String> {

        private InputData in;

        public Solver(InputData in) {
            this.in = in;
        }

        @Override
        public String call() throws Exception {
            StringWriter out = new StringWriter();
            in.solve(new PrintWriter(out));
            return out.toString();
        }

    }

    final static String WORK_DIR = "E:\\testingtestingtesting123\\LazySpellingBee\\";

    public static void main(String[] args) throws IOException,
            InterruptedException, ExecutionException {
        Scanner sc = new Scanner(new FileReader(WORK_DIR
                + "A-large-practice.in"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + "A-large-practice.txt"));

        int caseCnt = sc.nextInt();
        sc.nextLine();

        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(10);
        List<Future<String>> results = new ArrayList<Future<String>>();

        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            System.out.println("Processing test case " + (caseNum + 1));
            Future<String> res = stpe.submit(new Solver(new InputData(sc)));
            results.add(res);
        }
        for (Future<String> result : results) {
            while (!result.isDone()) {
                Thread.sleep(1000);
            }
            pw.print("Case #" + (results.indexOf(result) + 1) + ": ");
            pw.print(result.get());

        }

        pw.flush();
        pw.close();
        sc.close();
        stpe.shutdown();

    }

}

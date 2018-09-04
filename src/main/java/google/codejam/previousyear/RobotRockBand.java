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
 * This is yet not working for large input. (Hint:Dynamic Programming)
 */
public class RobotRockBand {

    static class InputData {

        int N, K;
        long[][] ids;

        public InputData(Scanner sc) {
            N = sc.nextInt();
            K = sc.nextInt();
            ids = new long[4][N];
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < N; ++i) {
                    ids[j][i] = sc.nextLong();
                }
            }
        }

        public void solve(PrintWriter pw) {
            int count = 0;
            long[][] temp1 = new long[N][N];
            long[][] temp2 = new long[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            if ((ids[0][i] ^ ids[1][j] ^ ids[2][k] ^ ids[3][l]) == K) {
                                count++;
                            }
                        }
                    }
                }
            }
            pw.println(count);
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

    final static String WORK_DIR = "E:\\testingtestingtesting123\\RobotRockBand\\";

    public static void main(String[] args) throws IOException,
            InterruptedException, ExecutionException {
        Scanner sc = new Scanner(new FileReader(WORK_DIR
                + "B-large-practice.in"));
        PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
                + "B-large-practice.txt"));

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
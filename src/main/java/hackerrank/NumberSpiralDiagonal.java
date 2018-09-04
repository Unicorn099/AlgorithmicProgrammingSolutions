package hackerrank;

/**
 * Created by Peeyush on 5/15/2016.
 */
public class NumberSpiralDiagonal {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int T = 1;
        long n;

        for (int i = 0; i < T; i++) {
            System.out.println(findAnswer(99999999999999799l));
        }

    }

    private static long findAnswer(long k) {

        long result1, result2, result3, result4;
        long n = (k + 1) / 2;

        long temp = ((n % 1000000007) * (n % 1000000007)) % 1000000007;

        //result1 = (((1 + (n - 1) * 4) % 1000000007) * (n % 1000000007)) + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n) + 8 * n;
        result1 = 4 * temp + 5 * n + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n);

        //result2 = (((1 + (n - 1) * 3) % 1000000007) * (n % 1000000007)) + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n) + 8 * n;
        result2 = 3 * temp + 6 * n + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n);

        //result3 = (((1 + (n - 1) * 2) % 1000000007) * (n % 1000000007)) + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n) + 8 * n;
        result3 = 2 * temp + 7 * n + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n);
        //result4 = (((1 + (n - 1) * 1) % 1000000007) * (n % 1000000007)) + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n) + 8 * n;
        result4 = temp + 8 * n + 4 * sumOfNSquaredNumbers(n) - 12 * sumOfNNumbers(n);
        return (result1 + result2 + result3 + result4 - 3) % 1000000007;
    }

    private static long sumOfNNumbers(long n) {
        return (((n % 1000000007) * ((n + 1) % 1000000007)) % 1000000007) / 2;
    }

    private static long sumOfNSquaredNumbers(long n) {
        return (((n % 1000000007) * ((n + 1) % 1000000007) * ((2 * n) + 1) % 1000000007) % 1000000007) / 6;
    }
}

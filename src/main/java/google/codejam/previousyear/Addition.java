package google.codejam.previousyear;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Callable;

public class Addition {

	/**
	 * @param args
	 */

	static class InputData {

		public InputData() {

		}

		public void solve(PrintWriter pw) {

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
			return null;
		}

	}

	public static void main(String[] args) {

	}

}

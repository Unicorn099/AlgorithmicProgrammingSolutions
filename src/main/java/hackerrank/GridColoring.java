package hackerrank;

public class GridColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] str = new String[][] { { ".G.B", ".B.." , ".B.", ".B.."} };

		for (String s[] : str) {
			System.out.println(gridColouring(s));
		}

	}

	static int gridColouring(String[] grid) {
		int res = 0;
		boolean[][] flag = new boolean[grid.length][grid[0].length()];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length();) {
				if (!flag[i][j]) {
					int ii = i, jj = j;
					if (grid[i].charAt(j) == 'G') {
						flag[i][j] = true;
						res += 2;
						do {
							flag[i][j] = true;
							j++;
						} while (j < grid[i].length()
								&& grid[i].charAt(j) != '.');

						do {
							flag[ii][jj] = true;
							ii++;
						} while (ii < grid.length && grid[ii].charAt(jj) != '.');

					}
					else if (grid[i].charAt(j) == 'R') {
						flag[i][j] = true;
						res += 1;
						do {
							flag[i][j] = true;
							j++;
						} while (j < grid[i].length()
								&& grid[i].charAt(j) != '.');
					}
					else if (grid[i].charAt(j) == 'B') {
						ii = i;
						jj = j;
						res += 1;
						j++;
						do {
							flag[ii][jj] = true;
							ii++;
						} while (ii < grid.length && grid[ii].charAt(jj) != '.');
						
					}
					else if (grid[i].charAt(j) == '.') {
						j++;
					}
				} else {
					j++;
				}
			}
		}

		return res;
	}
}

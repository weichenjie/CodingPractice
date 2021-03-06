package leetcode_final;

/*
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids.
 * How many unique paths would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * 
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		if (n == 0)
			return 0;
		int[][] path = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 0)
				path[i][0] = 1;
			else {
				while (i < m)
					path[i++][0] = 0;
			}
		}
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 0)
				path[0][j] = 1;
			else {
				while (j < n)
					path[0][j++] = 0;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					path[i][j] = 0;
				else
					path[i][j] = path[i - 1][j] + path[i][j - 1];
			}
		}
		return path[m - 1][n - 1];
	}
}

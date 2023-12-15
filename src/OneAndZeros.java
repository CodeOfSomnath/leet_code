/**
 * You are given a 0-indexed m x n binary matrix grid.
 * A 0-indexed m x n difference matrix diff is created with the following procedure:
 * Let the number of ones in the ith row be onesRowi.
 * Let the number of ones in the jth column be onesColj.
 * Let the number of zeros in the ith row be zerosRowi.
 * Let the number of zeros in the jth column be zerosColj.
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * Return the difference matrix diff.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,1],[1,0,1],[0,0,1]]
 * Output: [[0,0,4],[0,0,4],[-2,-2,2]]
 * Explanation:
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 2 + 1 - 1 - 2 = 0
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 2 + 1 - 1 - 2 = 0
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 2 + 3 - 1 - 0 = 4
 * - diff[2][0] = onesRow2 + onesCol0 - zerosRow2 - zerosCol0 = 1 + 1 - 2 - 2 = -2
 * - diff[2][1] = onesRow2 + onesCol1 - zerosRow2 - zerosCol1 = 1 + 1 - 2 - 2 = -2
 * - diff[2][2] = onesRow2 + onesCol2 - zerosRow2 - zerosCol2 = 1 + 3 - 2 - 0 = 2
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1,1,1],[1,1,1]]
 * Output: [[5,5,5],[5,5,5]]
 * Explanation:
 * - diff[0][0] = onesRow0 + onesCol0 - zerosRow0 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[0][1] = onesRow0 + onesCol1 - zerosRow0 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[0][2] = onesRow0 + onesCol2 - zerosRow0 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * - diff[1][0] = onesRow1 + onesCol0 - zerosRow1 - zerosCol0 = 3 + 2 - 0 - 0 = 5
 * - diff[1][1] = onesRow1 + onesCol1 - zerosRow1 - zerosCol1 = 3 + 2 - 0 - 0 = 5
 * - diff[1][2] = onesRow1 + onesCol2 - zerosRow1 - zerosCol2 = 3 + 2 - 0 - 0 = 5
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * grid[i][j] is either 0 or 1.
 */

import java.util.Arrays;
import java.util.HashMap;

public class OneAndZeros {
    public static Integer[] readRow(int[] row) {
        int ones, zeros;
        zeros = (int) Arrays.stream(row).filter(value -> value == 0).count();
        ones = row.length - zeros;
        return new Integer[]{zeros, ones};
    }

    public static Integer[] readCol(int[] col) {
        int ones, zeros;
        zeros = (int) Arrays.stream(col).filter(value -> value == 0).count();
        ones = col.length - zeros;
        return new Integer[]{zeros, ones};
    }


    public static HashMap<String, HashMap<Integer, Integer[]>> getAllValues(int[][] grid) {
        HashMap<String, HashMap<Integer, Integer[]>> values = new HashMap<>();
        HashMap<Integer, Integer[]> rowHash = new HashMap<>();
        HashMap<Integer, Integer[]> colHash = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            int[] row = getRow(grid, i);
            var zerosAndOnes = readRow(row);
            rowHash.put(i, zerosAndOnes);
        }

        for (int i = 0; i < grid[0].length; i++) {
            int[] column = getColumn(grid, i);
            var zerosAndOnes = readCol(column);
            colHash.put(i, zerosAndOnes);
        }

        values.put("row", rowHash);
        values.put("col", colHash);
        return values;
    }

    public static int[] getColumn(int[][] matrix, int columnIndex) {
        int numRows = matrix.length;
        int[] column = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            column[i] = matrix[i][columnIndex];
        }

        return column;
    }

    public static int[] getRow(int[][] matrix, int rowIndex) {
        int numCols = matrix[0].length;
        int[] row = new int[numCols];
        System.arraycopy(matrix[rowIndex], 0, row, 0, numCols);
        return row;
    }

    public static int[][] onesMinusZeros(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        var values = getAllValues(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                var oneAndZeroRaw = values.get("row").get(i);
                var oneAndZeroCol = values.get("col").get(j);
                result[i][j] = oneAndZeroRaw[1] + oneAndZeroCol[1] - oneAndZeroRaw[0] - oneAndZeroCol[0];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        int[][] result = onesMinusZeros(grid);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

// This is enough fast for submit in leet code . Runtime - 126ms

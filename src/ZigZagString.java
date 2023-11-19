/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigZagString {
    String convert(String s, int numRows) {
        int numCol = 0;
        int skippingCol = numRows - 2, fullFiledCol = 0;
        int count = 0, fullFilledCount = 0;
        boolean foundSkip = false;

        for (int i = 0; i < s.length(); i++) {
            fullFilledCount++;
            if (foundSkip) {
                fullFilledCount = 0;
                System.out.print(s.charAt(i));
                count++;
            }

            if (count == skippingCol) {
                foundSkip = false;
                numCol =+ skippingCol;
                count = 0;
            }

            if (fullFilledCount == numRows) {
                fullFiledCol++;
                foundSkip = true;
            }

        }

        numCol = numCol + fullFiledCol;


        char[][] buffer = new char[numRows][numCol];

        System.out.println(numCol);
        System.out.println(fullFiledCol);


        return null;
    }
}

/*
    S   A
    O N T
    M   H
 */
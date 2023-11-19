/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * 0 1 2 3 4 5 6
 * 0 P   A   H   N
 * 1 A P L S I I G
 * 2 Y   I   R
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
 * <p>
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N // 4 - 1
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
        String result = "";
        int skippingCol = numRows - 2;
        boolean[] skippingColIndex = new boolean[10];
        int start = 0, end = skippingCol + start;
        boolean hasToUpdate = false;
        int colCount = skippingCol;

        for (int i = 0; i < skippingColIndex.length; i++) {

            if (start < i && i <= end) {
                // it is skipped column
                skippingColIndex[i] = true;
            }

            if (i == end) {
                hasToUpdate = true;
            }

            if (hasToUpdate) {
                start = i + 1;
                end = start + skippingCol;
                hasToUpdate = false;
            }

        }

        boolean[][] bufferIndex = new boolean[numRows][10];

        for (int col = 0; col < bufferIndex[0].length; col++) {
            if (!skippingColIndex[col]) {
                for (int row = 0; row < bufferIndex.length; row++) {
                    bufferIndex[row][col] = true;
                }
                continue;
            }
            if (colCount == 0) {
                colCount = skippingCol;
            }

            for (int row = 0; row < bufferIndex.length; row++) {
                if (row == colCount) {
                    bufferIndex[row][col] = true;
                    colCount--;
                }
            }
        }

        int charCount = 0;

        char[][] buffer = new char[numRows][10];

        for (int col = 0; col < bufferIndex[0].length; col++) {
            for (int row = 0; row < bufferIndex.length; row++) {

                if (bufferIndex[row][col] && s.length() != charCount) {
                    buffer[row][col] = s.charAt(charCount);
                    charCount++;
                } else {
                    buffer[row][col] = ' ';
                }


            }

        }

        for (int row = 0; row < buffer.length; row++) {
            for (int col = 0; col < buffer[0].length; col++) {
                if (buffer[row][col] != ' ') {
                    result += buffer[row][col];
                }
            }
        }

        return result;
    }
}

/*
    S   A
    O N T
    M   H
    SAONTMH
 */
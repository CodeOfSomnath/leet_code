import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInt {

    public int reverse(int x) {
        String s = ""+Math.abs(x);
        char[] charArray = s.toCharArray();
        char[] reversedArray = new char[s.length()];
        int count = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            reversedArray[count] = charArray[i];
            count++;
        }

        try {
            int result = Integer.parseInt(new String(reversedArray));

            if (x < 0) {
                return -result;
            } else {
                return result;
            }

        } catch (Exception e) {
           return 0;
        }


    }

}

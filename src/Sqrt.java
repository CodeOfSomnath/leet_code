/*

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 

Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

 */

import java.util.ArrayList;

class Sqrt {

    public int mySqrt(int x) {
        int number = x;
        ArrayList<Integer> pairs = new ArrayList<>();

        while (number != 0) {
            pairs.add(0, number % 100);
            number = (number - (number % 100)) / 100;
        }

        // reset values
        int remaining = 0;
        int divisor = 0;
        int result = 0;
        int i = 0;

        while (i != pairs.size()) {
            number = remaining * 100 + pairs.get(i);

            if (result * 20 > number) {
                i++;
                result *= 10;
                divisor = result;
                if (i == pairs.size()) {
                    break;
                }
                number = number * 100 + pairs.get(i);
            }

            remaining = 0;

            for (int j = 1; j <= number + 1; j++) {
                if (number - (((divisor * 20) + j) * j) < 0) {
                    int p = j - 1;
                    remaining = number - (((divisor * 20) + p) * p);
                    result = (result * 10) + (j - 1);
                    divisor = result;
                    break;
                }
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();

        int result = sqrt.mySqrt(196); // 14
        System.out.println(result);

    }
}
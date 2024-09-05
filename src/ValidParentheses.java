/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */


// I will do it later..
public class ValidParentheses {


    // "( [ ] )"
    //  0 1 2 3 len -> 4
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        boolean valid = true;
        return valid;
    }

    public static void main(String[] args) {
        String s = "()";
        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid(s));
    }
}

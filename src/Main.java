public class Main {
    public static void main(String[] args) {
//       ParseInt parseInt = new ParseInt();
////        System.out.println(parseInt.myAtoi("42"));
//        System.out.println(Integer.MIN_VALUE);
        String num = Integer.toBinaryString(45353);
        String result = new String();

        for (char c : num.toCharArray()) {
            int isOne = Integer.parseInt(""+c);
            if (isOne == 1) {
                result += String.valueOf(0);
            } else {
                result += String.valueOf(1);
            }

        }

        System.out.println(Integer.parseInt(result, 2));

    }
}
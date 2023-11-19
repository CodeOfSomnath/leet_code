public class Main {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        ZigZagString sol = new ZigZagString();
        String res = sol.convert(s, numRows);
        String result = "PAHNAPLSIIGYIR";
        System.out.println(res);
    }
}
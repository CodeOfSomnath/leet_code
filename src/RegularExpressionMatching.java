public class RegularExpressionMatching {

    public String solveStar(String s, String p) {
        StringBuilder finalString = new StringBuilder();
        int count = 1;
        for (int i = 0; i < p.length(); i++) {
            char cpi = p.charAt(i);

            if (cpi == '*') {
                cpi = p.charAt(i - 1);
                while (finalString.length() <= s.length() - 1) {
                    finalString.append(cpi);

                    if (p.length() > i + count) {
                        cpi = p.charAt(i + count);
                    }
                    count++;
                }
            } else {
                finalString.append(cpi);
            }
        }
        return finalString.toString();
    }

    public String solveDot(String s, String p) {
        StringBuilder f = new StringBuilder();

        for (int i = 0; i < p.length(); i++) {
            char cpi = p.charAt(i);

            if (cpi == '.') {
                char csi = s.charAt(i);
                f.append(csi);
            } else {
                f.append(cpi);
            }

        }

        return f.toString();
    }


    public boolean isMatch(String s, String p) {
        p = solveStar(s, p);
        System.out.println(p);
        p = solveDot(s, p);
        System.out.println(p);

        return p.contains(s);
    }

    public static void main(String[] args) {
        String s = "mississippi", p = "mis*is*p*.";
        RegularExpressionMatching matching = new RegularExpressionMatching();
        System.out.println(matching.isMatch(s, p));
    }
}

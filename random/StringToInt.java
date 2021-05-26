package random;

public class StringToInt {
    public int myAtoi(String s) {
        boolean started = false;
        boolean negative = false;
        long sum = 0;

        for (char c : s.toCharArray()) {
            if (!started) {
                if (c == ' ') {
                    continue;
                }
                if (c == '-') {
                    started = true;
                    negative = true;
                    continue;
                }
                if (c == '+') {
                    started = true;
                    continue;
                }
                if (Character.isDigit(c)) {
                    sum = (int) c - 48;
                    started = true;
                    continue;
                } else {
                    return 0;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return negative ? 0 - (int) sum : (int) sum;
                }
                sum = sum * 10 + c - 48;
                if (sum > Integer.MAX_VALUE) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

            }
        }
        return negative ? 0 - (int) sum : (int) sum;

    }

    public static void main(String[] args) {
        new StringToInt().myAtoi("  -0012a42");
    }
}

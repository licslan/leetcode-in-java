public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // 判断正负
        if ((numerator > 0) ^ (denominator > 0))
            sb.append("-");

        long num = Math.abs((long) numerator);// 这个地方一定要用long，int边界值问题
        long den = Math.abs((long) denominator);

        // 整数部分
        sb.append(num / den);

        num %= den;// 求小数部分的num
        if (num == 0)
            return sb.toString();

        // 小数部分
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}
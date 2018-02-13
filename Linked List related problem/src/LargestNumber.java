class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        if(a.length() == b.length()) {
            return b.compareTo(a);
        } else {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    }
}
public class Solution {
    public String largestNumber(int[] nums) {
        StringBuffer sbuf = new StringBuffer();
        ArrayList<String> numStrings = new ArrayList<String>(nums.length);
        for(int i : nums) numStrings.add(String.valueOf(i));
        Collections.sort(numStrings, new StringComparator());
        for(String s: numStrings) sbuf.append(s);
        String res = sbuf.toString();
        if(res.length() > 0 && res.charAt(0) == '0') return "0";//"":represents string, '':represents char;
        return res;
    }
}
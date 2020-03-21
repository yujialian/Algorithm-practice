class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < s.length()) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if(map.size() > k) {//Need to slide
                if(map.get(s.charAt(l)) == 1) {
                    map.remove(s.charAt(l));
                } else {
                    map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                }
                l++;
                r++;
            } else {
                r++;
            }
        }
        return r - l;
    }
}

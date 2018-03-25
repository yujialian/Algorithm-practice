class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, counter = 0, d = 0;
        while(end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c) > 1) counter++;
            end++;
            while(counter > 0) {
                char tempc = s.charAt(start);
                if(map.get(tempc) > 1) {
                    counter--;
                }
                map.put(tempc, map.get(tempc) - 1);
                start++;
            }
            d = Math.max(d, end - start);
        }
        return d;
        }
    }
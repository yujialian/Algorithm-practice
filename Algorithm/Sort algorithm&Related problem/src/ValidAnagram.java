class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else {
                if(map.get(c)<1) {
                    return false;
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        for(int val: map.values()) {
            if(val != 0) {
                return false;
            }
        }
        return true;
        
    }
}

//Better way, less code, less memory
public class Solution {
	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
		for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
		for(int i: alphabet) if(i!= 0) return false;
		return true;
	}
}
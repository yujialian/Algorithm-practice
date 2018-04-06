//Bloomberg
import java.util.*;
public class sortString {
  public String sortString(String str) {
    Map<Character, Integer> preMap = new HashMap<>();
    Map<Integer, List<Character>> postMap = new HashMap<>();
    for(int i = 0; i < str.length(); i++) {
      preMap.put(str.charAt(i), preMap.getOrDefault(str.charAt(i), 0) + 1);
    }
    for(Map.Entry<Character, Integer> entry: preMap.entrySet()) {
      if(!postMap.containsKey(entry.getValue())) {
        postMap.put(entry.getValue(), new ArrayList<Character>());
        postMap.get(entry.getValue()).add(entry.getKey());
      } else {
        postMap.get(entry.getValue()).add(entry.getKey());
      }
    }
    ArrayList<Integer> keyList = new ArrayList<>();
    for(int val: postMap.keySet()) {
      keyList.add(val);
    }
    Collections.sort(keyList,Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < keyList.size(); i++) {
      int cur = keyList.get(i);
      List<Character> list = postMap.get(cur);
      for(char c: list) {
        for(int j = 0; j < cur; j++) {
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }
  public static void main(String[] args) {
    String t = new String("kkqqdddtttttqwertyu");
    sortString test = new sortString();
    System.out.println(test.sortString(t));
  }
}

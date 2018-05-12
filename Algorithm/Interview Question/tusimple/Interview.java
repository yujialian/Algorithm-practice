TuSimple Online Interview
Candidate name: Yujia Lian
Scheduled time: 5/1/2018 16:00 UTC+0800
// Problem 1
// "abbcdef" => ["a" "bb" "cd" "ef"]
// "abbcda" => ["abbcda"]
// "abcdba" => ["abcdba"]
// "abcd" => ["a", "b", "c", "d"]
// "abcbetrtyrty" => ["a", "bcb"]
// "aabb"
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.StringBuilder;
public class Interview {
  public ArrayList<String> find(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++) {
          map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      }
      ArrayList<String> ans = new ArrayList<>();
      int index = 0;
      HashSet<Character> set;
      while(index < s.length()) {
          StringBuilder sb = new StringBuilder();
          int l = index;
          int count = 0;
          set = new HashSet<>();
          while(l < s.length()) {
              char c = s.charAt(l);
              map.put(c, map.get(c) - 1);
              sb.append(c);
              if(!set.contains(c)) {
                  count++;
              }
              set.add(c);
              if(map.get(c) == 0) {
                  count--;
              }
              if(count == 0) break;
              else l++;
          }
          ans.add(sb.toString());
          index = l + 1;
          sb.delete(0, sb.length());
      }
      return ans;
  }
  public List<List<Double>> mergeInterval(List<List<Double>> list) {
      PriorityQueue<List<Double>> pq = new PriorityQueue<>(new Comparator<List<Double>>() {
          public int compare(List<Double> l1, List<Double> l2) {
              return l1.get(0).compareTo(l2.get(0));
          }
      }
      List<List<Double>> ans = new List<List<Double>>();
      pq.addAll(list);
      while(!pq.isEmpty()) {
          if(ans.size() == 0) ans.add(pq.poll());
          else {
              List<Double> curr = pq.poll();
              List<Double> prev = ans.get(ans.size() - 1);
              if(curr.get(0) <= prev.get(prev.size() - 1)) {
                  if(curr.get(curr.size() - 1) > prev.get(prev.size() - 1)) {
                      prev.set(prev.size() - 1, curr.get(curr.size() - 1));
                  }
              } else {
                  ans.add(curr);
              }
          }
      }
      return ans;
  }
  public static void main(String[] args) {
    Interview test = new Interview();
    String s = "abbcdef";
    ArrayList<String> ans = test.find(s);
    for(int i = 0; i < ans.size(); i++) {
      System.out.println(ans.get(i));
    }
  }
}

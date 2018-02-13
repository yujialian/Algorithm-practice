import java.util.*;
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval> temp = new PriorityQueue<Interval>(new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        for(int i = 0; i < intervals.size(); i++) {
            temp.offer(intervals.get(i));
        }
        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        Interval current = null;
        for(int i = 0; i < intervals.size(); i++) {
            current = temp.poll();
            if(prev == null || current.start > prev.end) {
                res.add(current);
                prev= current;
            } else if(prev.end < current.end){
                prev.end = current.end;
            }
        }
        return res;
    }
}
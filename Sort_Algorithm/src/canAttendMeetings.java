class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int prev= intervals[0].end;
        for(int i = 1; i < intervals.length; i++) {
            if(prev > intervals[i].start) {
                return false;
            } else {
                prev = intervals[i].end;
            }
        }
        return true;
    }
}
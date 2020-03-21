class Solution {
    public int repeatedStringMatch(String A, String B) {
        int times = 1;
        StringBuilder sb = new StringBuilder(A);
        for(; sb.length() < B.length(); times++) {
            sb.append(A);
        }
        if(sb.indexOf(B) != -1) return times;
        sb.append(A);
        return sb.indexOf(B) == -1 ? -1 : times+1;
    }
}

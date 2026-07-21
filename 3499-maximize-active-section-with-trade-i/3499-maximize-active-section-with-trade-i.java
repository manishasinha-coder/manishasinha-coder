class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int m = t.length();
        int ans = ones;

        for (int i = 1; i < m - 1; ) {
            if (t.charAt(i) == '1') {
                int j = i;
                while (j < m && t.charAt(j) == '1') j++;
                if (i > 0 && j < m && t.charAt(i - 1) == '0' && t.charAt(j) == '0') {
                    int left = i - 1;
                    while (left >= 0 && t.charAt(left) == '0') left--;
                    int l = i - left - 1;

                    int right = j;
                    while (right < m && t.charAt(right) == '0') right++;
                    int r = right - j;

                    int gain = l + r;
                    ans = Math.max(ans, ones + gain);
                }
                i = j;
            } else {
                i++;
            }
        }

        return ans;
    }
}
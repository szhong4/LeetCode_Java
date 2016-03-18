// Ask yes/no, choose dp. If ask for all the subsets, use backtracking

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int maxWord = getMax(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i ++) {
            int start = Math.max(1, i - maxWord);
            for (int j = start; j <= i; j++) {
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[len];
    }
    
    private int getMax(Set<String> wordDict) {
        int max = 0;
        for (String str : wordDict) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
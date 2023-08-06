//GFG Practice

class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int n=s.length();
        int m=t.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] item:dp){
            Arrays.fill(item,0);
        }
        
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=0+dp[i-1][j-1];
                }
                
                else{
                    int case1=1+dp[i-1][j];
                    int case2=1+dp[i][j-1];
                    int case3=1+dp[i-1][j-1];
                    
                    dp[i][j]=Math.min(case1,Math.min(case2,case3));
                } 
            }
        }
        return dp[n][m];
    }
}

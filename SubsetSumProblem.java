//GFG Practice

class Solution{

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean dp[][] = new boolean[N+1][sum+1];
        
        for(int i = 0;i<N+1;i++){
            dp[i][0] = true;
        }
        
        for(int i = 1;i<N+1;i++){
            for(int j = 1;j<sum+1;j++){
                int v = arr[i-1];
                
                if(v <=j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        
        return dp[N][sum];
    }
}

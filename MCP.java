public class MCP {

	// Recursive - O(3^n)
	static int mcp(int cost[][],int m, int n) {
		if(m<0 || n<0)return Integer.MAX_VALUE;
		if(m==0 && n==0)return cost[m][n];
		return cost[m][n] + Math.min(Math.min(mcp(cost,m-1,n-1),mcp(cost,m-1,n)),mcp(cost,m,n-1));
	}
	
	// Tabulation - O(n^2)
	static int mcpTab(int cost[][],int m, int n) {
		if(m<0 || n<0)return Integer.MAX_VALUE;
		if(m==0 && n==0)return cost[m][n];
		int res[][] = new int[cost.length][cost.length];
		res[0][0]=cost[0][0];
		for(int i=1;i<res.length;i++) {
			res[i][0] = res[i-1][0]+cost[i][0];
		}
		for(int i=1;i<res.length;i++) {
			res[0][i] = res[0][i-1]+cost[i][0];
		}
		for(int i=1;i<res.length;i++) {
			for(int j =1;j<res.length;j++) {
				res[i][j] = Math.min(Math.min(res[i-1][j-1],res[i-1][j]),res[i][j-1])+cost[i][j];
			}
		}
		return res[res.length-1][res.length-1];
	}
	
	public static void main(String[] args) {
		int cost[][] = {{2,0,6},{3,1,7},{4,5,9}};
		System.out.println(mcp(cost,cost.length-1,cost.length-1));
		System.out.println(mcpTab(cost,cost.length-1,cost.length-1));
	}

}

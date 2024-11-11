import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void go(int node) {
		visited[node] = true;
		dp[node][0] = 1;
		
		for(int nextNode : edgeList.get(node)) {
			if(visited[nextNode]) continue;
			go(nextNode);
			dp[node][1] += dp[nextNode][0];
			dp[node][0] += Math.min(dp[nextNode][0], dp[nextNode][1]);
		}
	}
	
	static int dp[][];
	static List<List<Integer>> edgeList;
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		edgeList = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			edgeList.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edgeList.get(u).add(v);
			edgeList.get(v).add(u);
		}
		
		dp = new int[N+1][2];
		
		visited = new boolean[N+1];
		
		go(1);
		
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		
	}

}
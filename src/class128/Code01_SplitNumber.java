package class128;

// 数的划分方法
// 将整数n分成k份，且每份不能为空，任意两个方案不相同(不考虑顺序)
// 例如：n=7，下面三种分法被认为是相同的
// 1, 1, 5
// 1, 5, 1
// 5, 1, 1
// 返回有多少种不同的划分方法
// 测试链接 : https://www.luogu.com.cn/problem/P1025
// 提交以下的code，提交时请把类名改成"Main"，可以通过所有用例

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code01_SplitNumber {

	public static int MAXN = 201;

	public static int MAXK = 7;

	public static int[][] dp = new int[MAXN][MAXK];

	public static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		in.nextToken();
		k = (int) in.nval;
		out.println(compute());
		out.flush();
		out.close();
		br.close();
	}

	public static int compute() {
		if (n < k) {
			return 0;
		}
		if (n == k) {
			return 1;
		}
		n -= k;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = -1;
			}
		}
		return f(n, k);
	}

	public static int f(int apples, int plates) {
		if (dp[apples][plates] != -1) {
			return dp[apples][plates];
		}
		int ans = 0;
		if (apples == 0) {
			ans = 1;
		} else if (plates == 0) {
			ans = 0;
		} else if (plates > apples) {
			ans = f(apples, apples);
		} else {
			ans = f(apples, plates - 1) + f(apples - plates, plates);
		}
		dp[apples][plates] = ans;
		return ans;
	}

}
//백준 - 구간 합 구하기 5
package hangyu.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //각 행별로 구간합을 저장할 dp
        int[][] dp = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                //각 행별로 구간합을 구함
                dp[i][j] = dp[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        //정답을 담을 배열
        int[] answer = new int[M+1];

        for (int i = 1; i <= M; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //x1~x2 행에서 y2 ~ y1 까지의 합을 더하면 되므로..
            for (int j = x1; j <= x2; j++) {
                sum += dp[j][y2] - dp[j][y1-1];
            }
            answer[i] = sum;
        }

        for (int i = 1; i <= M ; i++) {
            System.out.println(answer[i]);
        }
    }

}

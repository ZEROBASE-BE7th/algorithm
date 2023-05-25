//백준 - 벽 부수고 이동하기 2206번
package hangyu.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class exam01 {

    static int N, M;
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //오왼상하
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String num = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = num.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited = new int[N][M][2];
        queue.add(new int[]{x, y, 0});

        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int a = ints[0], b = ints[1], cnt = ints[2];

            if (a == N - 1 && b == M - 1) {
                System.out.println(visited[a][b][cnt]);
                return;
            }

            for (int[] dir : dirs) {
                int nA = a + dir[0];
                int nB = b + dir[1];

                if (nA < 0 || nA >= N || nB < 0 || nB >= M) {
                    continue;
                }

                if (visited[nA][nB][cnt] != 0) {
                    continue;
                }

                if (map[nA][nB] == 1) {
                    if (cnt == 0) {
                        queue.offer(new int[]{nA, nB, cnt + 1});
                        visited[nA][nB][cnt + 1] = visited[a][b][cnt] + 1;
                    }
                } else {
                    visited[nA][nB][cnt] = visited[a][b][cnt] + 1;
                    queue.offer(new int[]{nA, nB, cnt});
                }
            }

        }
        System.out.println(-1);
    }

}

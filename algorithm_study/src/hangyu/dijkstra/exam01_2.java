//백준 - 미로만들기 2665번

package hangyu.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class exam01_2 {

    static int[][] room;
    static int answer;
    static int N;
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        System.out.println(Arrays.deepToString(room));
        bfs();
        System.out.println("answer = " + answer);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{0,0,0});


        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int x = ints[0] , y = ints[1] , delete = ints[2];

            if (x == N - 1 && y == N - 1) {
                answer = Math.min(answer, delete);
            }

            for (int[] dir : dirs) {
                int nX = x + dir[0];
                int nY = y + dir[1];

                if (nX < 0 || nY < 0 || nX >= N || nY >= N) {
                    continue;
                }

                if (visited[nX][nY]) {
                    continue;
                }

                if (room[nX][nY] == 0 && delete + 1 < answer) {
                    visited[nX][nY] = true;
                    queue.offer( new int[]{nX, nY, delete + 1});
                } else if (room[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    queue.offer( new int[]{nX, nY, delete});
                }
            }
        }
    }

}

//백준 - 미로만들기 2665번

package hangyu.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam01 {

    static int[][] room;
    static int answer;
    static int N;

    static boolean[][] visited;

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        visited = new boolean[N][N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        System.out.println(Arrays.deepToString(room));
        dfs(0,0,0);
        System.out.println("answer = " + answer);

    }

    private static void dfs(int x, int y, int delete) {

        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("delete = " + delete);

        if(delete > answer) {
            return;
        }

        if(x == N-1 && y == N-1){
            answer = delete;
            return;
        }

        for(int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if(nX < 0 || nY < 0 || nX >= N || nY >= N){
                continue;
            }

            if(visited[nX][nY]) {
                continue;
            }

            if(room[nX][nY] == 0 && delete+1 < answer) {

                visited[nX][nY] = true;
                dfs(nX,nY,delete+1);
                visited[nX][nY] = false;

            }else if (room[nX][nY] == 1) {

                visited[nX][nY] = true;
                dfs(nX,nY,delete);
                visited[nX][nY] = false;

            }


        }
    }

}

//백준 - 미로만들기 2665번

package hangyu.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam01_3 {

    static int[][] room;
    static int answer;
    static int N;

    static int[][] visited;

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new int[N][N];
        visited = new int[N][N];
        visited[0][0] = 0;
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                room[i][j] = Character.getNumericValue(str.charAt(j));
                visited[i][j] = Integer.MAX_VALUE;
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

        if(x == N-1 && y == N-1){
            System.out.println(Arrays.deepToString(visited));
            answer = delete;
            return;
        }

        for(int[] dir : dirs) {
            int nX = x + dir[0];
            int nY = y + dir[1];

            if(nX < 0 || nY < 0 || nX >= N || nY >= N){
                continue;
            }

            if(visited[nX][nY] < visited[x][y]) {
                continue;
            }

            if(room[nX][nY] == 0) {

                visited[nX][nY] = visited[x][y] + 1;
                dfs(nX,nY,delete+1);

            }else if (room[nX][nY] == 1) {

                visited[nX][nY] = visited[x][y];
                dfs(nX,nY,delete);
            }


        }
    }

}

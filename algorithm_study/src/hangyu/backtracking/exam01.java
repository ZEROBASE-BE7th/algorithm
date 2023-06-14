//백준 - 소문난 칠공주 https://www.acmicpc.net/problem/1941
package hangyu.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam01 {

    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int answer;
    static char[][] board;
    static int[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[5][5];
        checked = new int[7];

        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }

        combination(0, 0, 0);

        System.out.println(answer);

    }

    //25명중에 7명을 뽑는 로직
    static void combination(int idx, int start, int sCnt) {
        //만약 idx 가 sCnt보다 3 초과로 크다면.. 조건에 만족하지 않기 때문에 가지치기를 한다.
        if (idx - sCnt > 3) return;

        //만약 갯수가 7이 된다면
        //연결되어 있는지 확인한다.
        if (idx == 7) {
            //checked 의 맨 처음 값을 넣는다.
            //각 숫자를 좌표로 바꾼다.
            bfs(checked[0] / 5, checked[0] % 5);
            return;
        }
        // 0 ~ 25
        for (int i = start; i < 25; i++) {
            //각 row와 column을 숫자로 바꿈
            int row = i / 5, col = i % 5;
            checked[idx] = i;
            combination(idx + 1, i + 1, (board[row][col] == 'S') ? sCnt + 1 : sCnt);
        }

    }

    //여기서 7개가 모두 연결된다면 정답을 +1을 해주면 된다
    static void bfs(int i, int j) {
        int num = 1;
        boolean[] visited = new boolean[7];
        visited[0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {

            int[] rowCol = queue.poll();
            int r = rowCol[0], c = rowCol[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }

                //각 좌표를 숫자로 바꿈
                int next = 5 * nr + nc;

                for (int k = 0; k < 7; k++) {
                    if (!visited[k] && checked[k] == next) {
                        visited[k] = true;
                        num++;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        //num이 7이 된다는 것은 해당 값들이 모두 연결되었다는 뜻임.
        if (num == 7) answer++;
    }
}

package yehun.graph;

// 백준 5014번
// 입력 100 2 1 1 0
// 출력 use the stairs

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution1 {
    public String solution1(int f, int s, int g, int u, int d) {

        int[] visited = new int[f + 1];


        //방문 설정 하기 위해 1 더하기
        visited[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()){
            int c = q.poll();

            // 목표 층 도달
            if (c == g){
                return String.valueOf(visited[c] - 1);
            }

            // 최고층을 넘지 않고, 방문하지 않은 층이면
            // 해당층을 add
            if (c + u <= f && visited[c + u] == 0){
                visited[c + u] = visited[c] + 1;
                q.add(c + u);
            }

            // 최하층을 넘지 않고 방문하지 않은 층
            // 해당층을 add
            if (c - d > 0 && visited[c - d] == 0){
                visited[c - d] = visited[c] + 1;
                q.add(c - d);
            }
        }

        return "use the stairs";
    }
}

//class Solution2{
//    public String solution2(int f, int s, int g, int u, int d){
//        int[] visit = new int[f + 1];
//        Queue<Integer> q = new LinkedList<>();
//        q.add(s);
//
//        while (!q.isEmpty()){
//            int cur = q.poll();
//
//            if (cur == g){
//                return String.valueOf(visit[cur] - 1);
//            }
//
//            if (cur + u < f && visit[cur + u] == 0){
//                visit[cur + u] = visit[cur] + 1;
//                q.add(cur + u);
//            }
//
//            if (cur - d > 0 && visit[cur - d] == 0){
//                visit[cur - d] = visit[cur] + 1;
//                q.add(cur - d);
//            }
//        }
//
//        return "use the stairs";
//    }
//}

public class Graph1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.solution1(f, s, g, u, d));
    }
}

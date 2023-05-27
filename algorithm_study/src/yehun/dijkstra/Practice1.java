package yehun.dijkstra;

// 백준 1753 최단경로
// 책보고 연습삼아 쓴 것임니다.
// 하지만 틀렸다고 나옵니다.
// 웨....?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Practice1 {
    public static int V, E, K;
    public static int distance[];
    public static boolean visit[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int value;

        public Edge() {}
        public Edge(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.value > o.value) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 노드의 갯수
        E = Integer.parseInt(st.nextToken()); // 간선 갯수
        K = Integer.parseInt(br.readLine()); // 시작 지점

        distance = new int[V + 1];
        visit = new boolean[V + 1];
        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }
        queue.add(new Edge(K, 0));
        distance[K] = 0;

        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            int curVertex = cur.vertex;
            if (visit[curVertex]) continue;
            visit[curVertex] = true;

            for (int i = 0; i < list[curVertex].size(); i++) {
                Edge tmp = list[curVertex].get(i);
                int next = tmp.vertex;
                int value = tmp.value;

                if (distance[next] > distance[curVertex] + value) {
                    distance[next] = value + distance[curVertex];
                    queue.add(new Edge(next, distance[next]));
                }
            }
        }

        for (int i = 1; i < V; i++) {
            if (visit[i]) {
                System.out.print(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}


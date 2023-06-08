package hangyu.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class zelda {
    static class Node {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
        }
    }

    static int N;
    static int[][] board;
    final static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    static List<List<Node>> graph;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        String s = "";
        int cnt = 1;
        while ((s = br.readLine()) != null) {
            N = Integer.parseInt(s);
            if(N == 0){
                return;
            }

            board = new int[N][N];
            graph = new ArrayList<>();

            for (int i = 0; i < N*N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int idx = (i*N) + j;
                    connect(idx, i, j);
                }
            }

            System.out.printf("Problem %d: %d \n",cnt++, dijkstra());

        }
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int M = N * N;
        int[] dist = new int[M];
        Arrays.fill(dist, INF);
        dist[0] = board[0][0];
        pq.offer(new Node(0,board[0][0]));
        boolean[] visited = new boolean[M];

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]){
                continue;
            }

            visited[cur.to] = true;

            for(Node adj : graph.get(cur.to)){
                if(!visited[adj.to] && dist[adj.to] > cur.weight + adj.weight){
                    dist[adj.to] = cur.weight + adj.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }

        return dist[M-1];
    }

    private static void connect(int idx, int x , int y) {

        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N){
                continue;
            }
            int newIdx = (nx * N) + ny;
            graph.get(idx).add(new Node(newIdx, board[nx][ny]));
        }

    }
}

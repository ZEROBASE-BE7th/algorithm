package yehun.dijkstra;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Practice3 {
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int cost = sc.nextInt();
            list[s].add(new Node(e, cost));
            list[e].add(new Node(s, cost));
        }
        visit = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, 50000001);
        dijkstra();
        System.out.println(dist[n]);

    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (!visit[current.loc]) visit[current.loc] = true;
            else continue;

            for (int i = 0; i < list[current.loc].size(); i++) {
                Node next = list[current.loc].get(i);
                if (dist[next.loc] > dist[current.loc] + next.cow) {
                    dist[next.loc] = dist[current.loc] + next.cow;
                    pq.offer(new Node(next.loc, dist[next.loc]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int loc, cow;

        public Node(int loc, int cow) {
            this.loc = loc;
            this.cow = cow;
        }

        @Override
        public int compareTo(Node o) {
            return this.cow - o.cow; // 오름차순...
        }
    }
}

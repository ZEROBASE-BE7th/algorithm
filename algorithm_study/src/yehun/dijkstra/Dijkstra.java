package yehun.dijkstra;

// 백준 13549

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Dijkstra {
    static int min = Integer.MAX_VALUE;
    static int n, k;
    static int max = 100000;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visit = new boolean[max + 1];
        bfs();
        System.out.println(min);

    }
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(n, 0));


        while (!q.isEmpty()){
            Node node = q.poll();
            visit[node.loc] = true;
            if (node.loc == k) {
                min = Math.min(min, node.time);
            }

            if (node.loc * 2 <= max && visit[node.loc * 2] == false){
                q.offer(new Node(node.loc * 2, node.time));
            }
            if (node.loc + 1 <= max && visit[node.loc + 1] == false){
                q.offer(new Node(node.loc + 1, node.time + 1));
            }
            if (node.loc - 1 >= 0 && visit[node.loc - 1] == false){
                q.offer(new Node(node.loc - 1, node.time + 1));
            }
        }
    }

    static class Node{
        int loc;
        int time;

        public Node(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }
}

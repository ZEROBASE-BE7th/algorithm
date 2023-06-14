package yehun.sorting;

import java.util.*;
import java.io.*;

// 2075 N번째큰수(백준)

class Practice1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            pq.offer(temp);
            System.out.println("pq = " + pq);
        }

        for(int i=1; i<n; i++) { //n에서 하나 빼야하므로// 위에 한줄 채웠으므로
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                pq.offer(temp);
                System.out.println("6자리 pq = "+ pq);
                pq.poll();
                System.out.println("poll 후 pq = " + pq);
            }
        }

        System.out.println(pq.poll());
    }
}
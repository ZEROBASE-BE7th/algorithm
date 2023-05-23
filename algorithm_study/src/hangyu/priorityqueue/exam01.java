//백준 - 컵라면
//그리디 + PriorityQueue
package hangyu.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class exam01 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] ints = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ints[i][0] = Integer.parseInt(st.nextToken());
            ints[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬한다.
        //데드라인에 따라서 오름차순
        //데드라인이 같다면 컵라면 수로 내림차순
        //그래야 데드라인에 따라서 컵라면 수를 가장 높은 것을 얻을 수 있다.
        Arrays.sort(ints, (x,y) -> {
            if(x[0] == y[0]){
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] arr : ints){
            if(pq.size() < arr[0]){
                pq.offer(arr[1]);
            } else {
                if(!pq.isEmpty() && pq.peek() < arr[1]){
                    pq.poll();
                    pq.offer(arr[1]);
                }
            }
            System.out.println(pq);
        }

        int answer = 0;
        while (!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.println(answer);

    }
}

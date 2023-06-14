package yehun.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        // 입력값 받기 
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        System.out.println(solution(arr, m));
    }

    private static int solution(int[] arr, int m) {
        int count = 0; //경우의 수
        int start = 0; //시작 포인터
        int end = 0; //두번째 포인터
        int len = arr.length;
        int sum = 0;

        while(true){
            if (sum >= m) {
                sum -= arr[start++]; //start 인덱스 값 뺴고 한칸 이동
            } else if (end >= len) {
                break;
            } else {
                sum += arr[end++];
            }

            if (sum == m){
                count++;
            }
        }
        return count;
    }
}

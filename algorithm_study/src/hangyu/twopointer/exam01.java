//백준 소수의 연속합 - 1644번
//소수 구하기의 결정판
//하나 이상의 연속된 소수의 합으로 나타낼 수 있는 자연수 들이 있다.
//자연수가 주어졌을 때, 이 자연수를 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구하면 된다.
//자연수가 주어지고 연속된이라는 점에서 투포인터를 사용 할 수 있다.
//N이라는 자연수가 주어졌을때 N보다 작거나 같은 소수들을 리스트에 담아야 한다.
//에라토스테네스의 체 사용
//투포인터를 움직일때 리스트의 범위를 잘 지켜야 한다!

package hangyu.twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exam01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        if (num < 2) {
            System.out.println(0);
            return;
        }

        int[] nums = new int[num+1];

        for (int i = 2; i <= num ; i++) {
            nums[i] = i;
        }

        List<Integer> primeNums = new ArrayList<>();

        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if(nums[i] != 0) {
                for(int j = i+i; j <= num; j += i) {
                    nums[j] = 0;
                }
            }
        }

        for (int i = 2; i <= num ; i++) {
            if(nums[i] != 0) {
                primeNums.add(i);
            }
        }

        System.out.println((primeNums));

        int answer = 0;

        int left = 0 , right = 0;
        int sum = primeNums.get(0);

        while (left <= right) {
            if(sum == num) {
                answer++;
                sum -= primeNums.get(left);
                left++;
            }else if(sum > num) {
                sum -= primeNums.get(left);
                left++;
            }else {
                right++;
                if(right >= primeNums.size()) break;
                sum += primeNums.get(right);
            }
        }

        System.out.println(answer);

    }

}

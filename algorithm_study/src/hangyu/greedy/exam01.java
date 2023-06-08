//점프를 하여 마지막 인덱스에 도달할 수 있는 지 없는 지..
package hangyu.greedy;

public class exam01 {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));

        nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));

        nums = new int[]{2,0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int pos = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(pos < i) {
                return false;
            } else if (pos >= nums.length-1) {
                return true;
            }

            pos = Math.max(pos, i+nums[i]);
        }

        return false;
    }
}

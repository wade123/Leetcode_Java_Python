import java.util.ArrayList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int cur = k / factorial[i];
            sb.append(list.get(cur));
            list.remove(cur);
            k -= cur * factorial[i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(5, 55));
        PermutationSequence2 t2 = new PermutationSequence2();
        System.out.println(t2.getPermutation(5, 55));
    }
}

class PermutationSequence2 {
    public String getPermutation(int n, int k) {
        int[] sequence = new int[n];
        for (int i = 1; i <= n; i++) {
            sequence[i - 1] = i;
        }
        while (k > 1) {
            nextPermutation(sequence);
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (int number : sequence) {
            sb.append(number);
        }
        return sb.toString();
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i] <= nums[i - 1]) {
                i--;
            } else {
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swap(nums, i - 1, j);
        reverse(nums, i, nums.length - 1);
        return;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        PermutationSequence test = new PermutationSequence();
        System.out.println(test.getPermutation(100, 50));
    }
}
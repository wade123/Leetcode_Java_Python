public class ContainerWithMostWater {
// 2 pointers
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

// brute force: time limit exceeded
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int local = 0;
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                local = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, local);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater test = new ContainerWithMostWater();
        int[] height = {1, 2, 1};
        System.out.println(test.maxArea(height));
    }
}
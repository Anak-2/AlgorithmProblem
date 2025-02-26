public class Can_Place_Flowers {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

    static class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {

            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (isPlaceFlowerAvailable(flowerbed, i)) {
                    flowerbed[i] = 1;
                    count++;
                }
            }

            return (count >= n);
        }

        private boolean isPlaceFlowerAvailable(int[] flowerbed, int loc) {
            if (flowerbed[loc] == 1) {
                return false;
            } else if (flowerbed.length == 1) {
                return true;
            }

            if (loc == 0) {
                return flowerbed[loc] == 0 && flowerbed[loc + 1] == 0;
            }
            if (loc == flowerbed.length - 1) {
                return flowerbed[loc] == 0 && flowerbed[loc - 1] == 0;
            }

            return (flowerbed[loc - 1] == 0 && flowerbed[loc + 1] == 0);
        }
    }
}

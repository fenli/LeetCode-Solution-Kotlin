package p3869_smallest_index_with_digit_sum_equal_to_index

class Solution {
    fun smallestIndex(nums: IntArray): Int {
        for (i in 0 until nums.size) {
            var sum = 0
            var num = nums[i]

            while (num != 0) {
                sum += num % 10
                num /= 10

                if (sum > i) break
            }

            if (sum == i) return i
        }

        return -1
    }
}

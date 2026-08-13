package p3225_length_of_longest_subarray_with_at_most_k_frequency

class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()

        var i = 0
        var j = 0
        var res = 0

        while (j < nums.size) {
            map[nums[j]] = map.getOrDefault(nums[j], 0) + 1

            while (map[nums[j]]!! > k) {
                map[nums[i]] = map[nums[i]]!! - 1
                i++
            }

            res = maxOf(res, j - i + 1)
            j++
        }

        return res
    }
}


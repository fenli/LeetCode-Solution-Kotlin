package p0167_two_sum_ii__input_array_is_sorted

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var firstIndex = 0
        var lastIndex = numbers.size - 1
        while (firstIndex < lastIndex) {
            val sum = numbers[firstIndex] + numbers[lastIndex]
            if (sum == target) return intArrayOf(firstIndex + 1, lastIndex + 1)
            else if (sum < target) firstIndex++
            else if (sum > target) lastIndex--
        }
        
        return intArrayOf(0, 0)
    }
}

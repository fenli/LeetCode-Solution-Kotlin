package p0448_find_all_numbers_disappeared_in_an_array

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val answer = mutableListOf<Int>()
        for (number in nums) {
            val newIndex = Math.abs(number) - 1
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1
            }
        }
        for (index in 1 .. nums.size) {
            if (nums[index-1] > 0) {
                answer.add(index)
            }
        }
        return answer
    }
}

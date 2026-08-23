package p4383_find_all_numbers_disappeared_in_an_array_ii

class Solution {
    fun findDisappearedNumbers(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val valids = nums.filter { it in lower..upper }.distinct().sorted()
        val ans = mutableListOf<List<Int>>()
        var low = lower
        for (n in valids) {
            if (n > low) ans.add(listOf(low, n-1))
            low = n + 1
        }

        if (low <= upper) ans.add(listOf(low, upper))

        return ans
    }
}

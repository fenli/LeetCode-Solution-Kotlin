package p4107_find_missing_elements

class Solution {
    fun findMissingElements(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        val sets = mutableSetOf<Int>()
        var min = 101
        var max = 0
        for (n in nums) {
            min = minOf(min, n)
            max = maxOf(max, n)
            sets.add(n)
        }

        for (i in min..max) {
            if (!sets.contains(i)) result.add(i)
        }

        return result
    }
}

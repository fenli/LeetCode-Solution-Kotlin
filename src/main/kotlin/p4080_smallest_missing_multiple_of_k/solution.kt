package p4080_smallest_missing_multiple_of_k

class Solution {
    fun missingMultiple(nums: IntArray, k: Int): Int {
        val sets = mutableSetOf<Int>()
        for (n in nums) if (n % k == 0) sets.add(n)
        var minK = k
        while(sets.contains(minK)) minK += k
        return minK
    }
}

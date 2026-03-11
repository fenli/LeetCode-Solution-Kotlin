package p0347_top_k_frequent_elements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (n in nums) {
            map[n] = (map[n] ?: 0) + 1
        }

        return map.entries
            .sortedBy { it.value }
            .takeLast(k)
            .map { it.key }
            .toIntArray()
    }
}

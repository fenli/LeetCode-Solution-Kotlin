package p4429_rearrange_array_by_removing_distinct_values

class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        // Step 1: Count frequency of each number
        val counts = nums.asSequence().groupingBy { it }.eachCount().toMutableMap()
        
        // Step 2: Get sorted unique keys
        val uniqueSortedKeys = counts.keys.sorted()
        
        val ans = IntArray(nums.size)
        var index = 0
        
        // Step 3: Append elements round-by-round in sorted order
        var remaining = nums.size
        while (remaining > 0) {
            for (key in uniqueSortedKeys) {
                val count = counts[key] ?: 0
                if (count > 0) {
                    ans[index++] = key
                    counts[key] = count - 1
                    remaining--
                }
            }
        }
        
        return ans
    }
}

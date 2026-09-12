package p4414_count_values_with_equally_spaced_occurrences_ii

class Solution {
    fun countSpecialIntegers(nums: IntArray): Int {
        var specials = 0
        val map = mutableMapOf<Int, IntArray>()
        for ((i, n) in nums.withIndex()) {
            val arr =  if (map.contains(n)) {
                map[n]!!
            } else {
                intArrayOf(0, 0, 0).also { map[n] = it }
            }
            
            val (count, lastIndex, space) = arr
            if (count == -1) continue
            
            if (count == 0) {
                arr[1] = i
            } else if (count == 1) {
                arr[2] = i - lastIndex
                arr[1] = i
            } else if (count >= 2) {
                if (i - lastIndex != space) {
                    arr[0] = -1
                    continue
                }
                arr[1] = i
            }

            arr[0]++
        }

        for ((_, arr) in map) if (arr[0] >= 3) specials++
        
        return specials
    }
}

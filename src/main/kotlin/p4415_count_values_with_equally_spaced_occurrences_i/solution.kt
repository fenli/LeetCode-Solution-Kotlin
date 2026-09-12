package p4415_count_values_with_equally_spaced_occurrences_i

class Solution {
    fun countSpecialIntegers(nums: IntArray): Int {
        var specials = 0
        for (k in 1..100) {
            var count = 0
            var lastIndex = 0
            var space = 0
            for ((i, n) in nums.withIndex()) {
                if (n != k) continue
                
                if (count == 0) {
                    lastIndex = i
                } else if (count == 1) {
                    space = i - lastIndex
                    lastIndex = i
                } else if (count == 2) {
                    if (i - lastIndex != space) break
                }

                count++
                if (count > 3 ) break
            }
            
            if (count == 3) specials++
        }
        
        return specials
    }
}

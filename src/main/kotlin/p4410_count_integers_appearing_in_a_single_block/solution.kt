package p4410_count_integers_appearing_in_a_single_block

class Solution {
    fun countSpecialIntegers(nums: IntArray): Int {
        var apperance = mutableMapOf<Int, Int>()
        var last = 0
        for (n in nums) {
            if (n != last) apperance[n] = (apperance[n] ?: 0) + 1
            last = n
        }
        return apperance.count { it.value == 1 } 
    }
}

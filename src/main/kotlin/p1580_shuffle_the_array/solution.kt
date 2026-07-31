package p1580_shuffle_the_array

class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(n*2)
        for (i in 0 until n) {
            val i2 = i * 2
            ans[i2] = nums[i]
            ans[i2 + 1] = nums[i + n]
        }

        return ans
    }
}

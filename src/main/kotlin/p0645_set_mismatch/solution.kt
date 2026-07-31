package p0645_set_mismatch

class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val ans = IntArray(2)
        val set = mutableSetOf<Int>()
        val sumA = (nums.size * (nums.size + 1)) / 2
        var sumB = 0
        var checkSet = true
        for (n in nums) {
            if (checkSet) {
                if (set.contains(n)) {
                    ans[0] = n
                    checkSet = false
                } else set.add(n)
            }
            
            sumB += n
        }

        ans[1] = sumA - sumB + ans[0]
        return ans
    }
}

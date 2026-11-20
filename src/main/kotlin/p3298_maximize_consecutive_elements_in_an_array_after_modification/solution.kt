package p3298_maximize_consecutive_elements_in_an_array_after_modification

class Solution {
    fun maxSelectedElements(nums: IntArray): Int {
        nums.sort()
        val v = mutableListOf<Pair<Int, Int>>()
        var value = nums[0] 
        var count = 0
        for (x in nums) {
            if (x == value) {
                count++
            } else {
                v.add(Pair(value, count))
                value = x
                count = 1
            }
        }
        v.add(Pair(value, count))
        val n = v.size
        var ans = 1
        var change = v[0].first
        var j = v[0].first
        for (i in 0 until n) {
            if (i == n - 1) {
                val y = v[i].second > 1
                ans = maxOf(ans, v[i].first - j + 1 + if (y) 1 else 0)
                break
            }
            if (v[i].first + 1 == v[i + 1].first) {
                if (v[i].second > 1) {
                    v[i + 1] = Pair(v[i + 1].first, v[i + 1].second + 1)
                }
            } else if (v[i].first + 2 == v[i + 1].first) {
                if (v[i].second > 1) {
                    change = v[i + 1].first
                } else {
                    ans = maxOf(ans, v[i].first - j + 1)
                    j = change + 1
                    change = v[i + 1].first
                }
            } else {
                val y = v[i].second > 1
                ans = maxOf(ans, v[i].first - j + 1 + if (y) 1 else 0)
                change = v[i + 1].first
                j = v[i + 1].first
            }
        }
        return ans
    }
}

package p1522_stone_game_iii

class Solution {
    
    fun stoneGameIII(stoneValue: IntArray): String {
        val n = stoneValue.size
        val dp = IntArray(n + 1)
        
        for (i in n - 1 downTo 0) {
            var best = Int.MIN_VALUE
            var runningSum = 0
            for (k in 1..3) {
                if (i + k > n) break
                runningSum += stoneValue[i + k - 1]
                best = maxOf(best, runningSum - dp[i + k])
            }
            dp[i] = best
        }
        
        return when {
            dp[0] > 0 -> "Alice"
            dp[0] < 0 -> "Bob"
            else -> "Tie"
        }
    }

    fun stoneGameIII_TLE(stoneValue: IntArray): String {
        val finalPoints = points(stoneValue, true, 0, 0)
        return when {
            finalPoints == 1 -> "Alice"
            finalPoints == -1 -> "Bob"
            else -> "Tie"
        }
    }

    fun points(nums: IntArray, p1turn: Boolean, p: Int, l: Int): Int {
        if (l >= nums.size) return p

        var p1: Int? = null
        var p2: Int? = null
        var p3: Int? = null

        if (p1turn) {
            p1 = points(nums, false, p + nums[l], l+1)
            if (p1 > 0) return 1

            if (l < nums.size - 1) {
                p2 = points(nums, false, p + nums[l] + nums[l+1], l+2)
                if (p2 > 0) return 1
            }

            if (l < nums.size - 2) {
                p3 = points(nums, false, p + nums[l] + nums[l+1] + nums[l+2], l+3)
                if (p3 > 0) return 1
            }

            if (p1 == 0 || p2 == 0 || p3 == 0) return 0
            else return -1
        } else {
            p1 = points(nums, true, p - nums[l], l+1)
            if (p1 < 0) return -1

            if (l < nums.size - 1) {
                p2 = points(nums, true, p - nums[l] - nums[l+1], l+2)
                if (p2 < 0) return -1
            }

            if (l < nums.size - 2) {
                p3 = points(nums, true, p - nums[l] - nums[l+1] - nums[l+2], l+3)
                if (p3 < 0) return -1
            }

            if (p1 == 0 || p2 == 0 || p3 == 0) return 0
            else return 1
        }
    }
}

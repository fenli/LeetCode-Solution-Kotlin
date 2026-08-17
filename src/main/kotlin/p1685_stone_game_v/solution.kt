package p1685_stone_game_v

class Solution {

    private lateinit var dp: Array<IntArray>

    fun stoneGameV(stoneValue: IntArray): Int {
        val n = stoneValue.size
        dp = Array(n) { IntArray(n) }
        return dfs(stoneValue, 0, n - 1)
    }

    private fun dfs(stoneValue: IntArray, left: Int, right: Int): Int {
        if (left == right) return 0
        if (dp[left][right] != 0) return dp[left][right]

        var sum = 0
        for (i in left..right) sum += stoneValue[i]

        var suml = 0
        for (i in left until right) {
            suml += stoneValue[i]
            val sumr = sum - suml

            if (suml < sumr) {
                dp[left][right] = maxOf(
                    dp[left][right],
                    dfs(stoneValue, left, i) + suml
                )
            } else if (suml > sumr) {
                dp[left][right] = maxOf(
                    dp[left][right],
                    dfs(stoneValue, i + 1, right) + sumr
                )
            } else {
                dp[left][right] = maxOf(
                    dp[left][right],
                    maxOf(
                        dfs(stoneValue, left, i),
                        dfs(stoneValue, i + 1, right)
                    ) + suml
                )
            }
        }

        return dp[left][right]
    }
}


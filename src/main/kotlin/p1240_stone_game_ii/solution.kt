package p1240_stone_game_ii

class Solution {

    fun stoneGameII(piles: IntArray): Int {
        // Store the suffix sum of all array elements.
        val suffixSum = piles.copyOf()

        for (i in suffixSum.size - 2 downTo 0) {
            suffixSum[i] += suffixSum[i + 1]
        }

        return maxStones(
            suffixSum,
            1,
            0,
            Array(piles.size) { IntArray(piles.size) }
        )
    }

    private fun maxStones(
        suffixSum: IntArray,
        maxTillNow: Int,
        currIndex: Int,
        memo: Array<IntArray>
    ): Int {
        // If currIndex + 2 * maxTillNow lies outside the array,
        // pick all remaining stones.
        if (currIndex + 2 * maxTillNow >= suffixSum.size) {
            return suffixSum[currIndex]
        }

        if (memo[currIndex][maxTillNow] > 0) {
            return memo[currIndex][maxTillNow]
        }

        var res = Int.MAX_VALUE

        // Find the minimum value res for the next move possible.
        for (i in 1..2 * maxTillNow) {
            res = minOf(
                res,
                maxStones(
                    suffixSum,
                    maxOf(i, maxTillNow),
                    currIndex + i,
                    memo
                )
            )
        }

        // Memoize the difference of suffixSum[p] and res.
        // This denotes the maximum stones that can be picked.
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res

        return memo[currIndex][maxTillNow]
    }
}

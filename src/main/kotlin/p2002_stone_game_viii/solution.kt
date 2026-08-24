package p2002_stone_game_viii

class Solution {
    fun stoneGameVIII(stones: IntArray): Int {
        for (i in 1 until stones.size) {
            stones[i] += stones[i - 1]
        }

        var best = stones[stones.size - 1]
        for (i in stones.size - 2 downTo 1) {
            best = maxOf(best, stones[i] - best)
        }

        return best
    }
}


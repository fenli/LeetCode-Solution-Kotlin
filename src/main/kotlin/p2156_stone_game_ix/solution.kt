package p2156_stone_game_ix

class Solution {
    fun stoneGameIX(stones: IntArray): Boolean {
        val cnt = IntArray(3)
        for (stone in stones) cnt[stone % 3]++
        return if (cnt[0] % 2 == 0) {
            cnt[1] > 0 && cnt[2] > 0
        } else {
            kotlin.math.abs(cnt[1] - cnt[2]) > 2
        }
    }
}


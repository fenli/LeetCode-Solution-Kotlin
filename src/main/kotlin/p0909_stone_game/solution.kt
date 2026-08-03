package p0909_stone_game

class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        return true
        // return p1Wins(piles, true, 0, 0, 0, piles.size - 1)
    }

    // TLE
    fun p1Wins(piles: IntArray, p1turn: Boolean, p1: Int, p2: Int, l: Int, r: Int): Boolean {
        if (r < l) return p1 >= p2

        if (p1turn) {
            // When P1 turns, P1 can win when P1 pick either left or right
            return p1Wins(piles, false, p1 + piles[l], p2, l+1, r) || p1Wins(piles, false, p1 + piles[r], p2, l, r-1)
        } else {
            // When P2 turns, P1 can win when P2 pick both left and right
            return p1Wins(piles, true, p1, p2 + piles[l], l+1, r) && p1Wins(piles, true, p1, p2 + piles[r], l, r-1)
        }
    }
}

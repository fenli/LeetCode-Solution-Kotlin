package p0486_predict_the_winner

class Solution {
    fun predictTheWinner(nums: IntArray): Boolean {
        return canP1Wins(nums, true, 0, 0, 0, nums.size - 1)
    }

    tailrec fun canP1Wins(nums: IntArray, p1turn: Boolean, p1: Int, p2: Int, l: Int, r: Int): Boolean {
        if (r < l) return p1 >= p2

        if (p1turn) {
            // When P1 turns, P1 can win when P1 pick either left or right
            return canP1Wins(nums, false, p1 + nums[l], p2, l+1, r) || canP1Wins(nums, false, p1 + nums[r], p2, l, r-1)
        } else {
            // When P2 turns, P1 can win when P2 pick both left and right
            return canP1Wins(nums, true, p1, p2 + nums[l], l+1, r) && canP1Wins(nums, true, p1, p2 + nums[r], l, r-1)
        }
    }
}

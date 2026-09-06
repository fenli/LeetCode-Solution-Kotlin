package p4411_count_rotations_with_exactly_k_equal_adjacent_pairs

class Solution {
    fun countRotations(s: String, k: Int): Int {
        val n = s.length
        var cycle = 0
        for (i in 0 until n) {
            var score = 0
            for (j in i until i+n-1) {
                if (s[j%n] == s[(j+1)%n]) score++
            }

            if (score == k) cycle++
        }
        
        return cycle
    }
}


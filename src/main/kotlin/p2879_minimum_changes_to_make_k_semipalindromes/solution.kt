package p2879_minimum_changes_to_make_k_semipalindromes

class Solution {
    fun minimumChanges(s: String, k: Int): Int {
        val n = s.length

        // cost[left][right]: minimum changes to make s[left..right]
        // a semi-palindrome.
        val cost = Array(n) { IntArray(n) }

        for (length in 2..n) {
            for (left in 0..n - length) {
                val right = left + length - 1
                var best = length

                for (divisor in 1..length / 2) {
                    if (length % divisor != 0) {
                        continue
                    }

                    var changes = 0

                    for (residue in 0 until divisor) {
                        var low = left + residue
                        var high = left + residue + ((length - 1 - residue) / divisor) * divisor

                        while (low < high) {
                            if (s[low] != s[high]) {
                                changes++
                            }
                            low += divisor
                            high -= divisor
                        }

                        if (changes >= best) {
                            break
                        }
                    }

                    best = minOf(best, changes)

                    if (best == 0) {
                        break
                    }
                }

                cost[left][right] = best
            }
        }

        // dp[parts][end]: minimum changes to split s[0..end)
        // into `parts` semi-palindromes.
        val INF = 1000000000
        val dp = Array(k + 1) { IntArray(n + 1) { INF } }
        dp[0][0] = 0

        for (parts in 1..k) {
            for (end in 2 * parts..n - 2 * (k - parts)) {
                var best = INF

                for (start in 2 * (parts - 1)..end - 2) {
                    if (dp[parts - 1][start] == INF) {
                        continue
                    }
                    best = minOf(best, dp[parts - 1][start] + cost[start][end - 1])
                }

                dp[parts][end] = best
            }
        }

        return dp[k][n]
    }
}

package p4037_lexicographically_smallest_palindromic_permutation_greater_than_target

class Solution {

    fun lexPalindromicPermutation(s: String, target: String): String {
        val n = s.length

        // Special case: length of 1
        if (n == 1) {
            return if (s > target) s else ""
        }

        // Count the frequency of each character
        val cnt = IntArray(26)

        for (c in s) {
            cnt[c - 'a']++
        }

        // Check if it can form a palindrome and record
        // the character with odd occurrences
        var oddChar = ""

        for (i in 0 until 26) {
            if (cnt[i] % 2 == 1) {
                // More than one character appears an odd number of times
                if (oddChar.isNotEmpty()) {
                    return ""
                }

                oddChar = ('a'.code + i).toChar().toString()
            }

            // Only half the characters are needed to construct
            // the left half of the palindrome
            cnt[i] /= 2
        }

        val prefix = StringBuilder()

        // Construct the left part greedily
        for (i in 0 until n / 2) {
            var found = false

            // Try to place the smallest character
            for (j in 0 until 26) {
                if (cnt[j] == 0) {
                    continue
                }

                cnt[j]--

                if (
                    check(
                        prefix.toString(),
                        ('a'.code + j).toChar(),
                        cnt,
                        oddChar,
                        target
                    )
                ) {
                    prefix.append(('a'.code + j).toChar())
                    found = true
                    break
                } else {
                    // Not meeting the conditions, reset the counter
                    cnt[j]++
                }
            }

            if (!found) {
                return ""
            }

            // prefix is already greater than target
            if (prefix[i] > target[i]) {
                val left = StringBuilder(prefix)

                for (j in 0 until 26) {
                    repeat(cnt[j]) {
                        left.append(('a'.code + j).toChar())
                    }
                }

                val palindrome =
                    left.toString() +
                    oddChar +
                    left.reversed()

                return palindrome
            }
        }

        // Construct the final palindrome
        return prefix.toString() +
            oddChar +
            prefix.reversed()
    }

    private fun check(
        prefix: String,
        c: Char,
        cnt: IntArray,
        oddChar: String,
        target: String
    ): Boolean {
        val left = StringBuilder(prefix)
        left.append(c)

        // Fill remaining characters in descending order
        for (i in 25 downTo 0) {
            repeat(cnt[i]) {
                left.append(('a'.code + i).toChar())
            }
        }

        val palindrome =
            left.toString() +
            oddChar +
            left.reversed()

        return palindrome > target
    }
}


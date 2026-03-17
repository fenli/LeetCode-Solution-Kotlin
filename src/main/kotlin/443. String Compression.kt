/**
 * Problem : https://leetcode.com/problems/string-compression/description/
 * Submission : https://leetcode.com/problems/string-compression/submissions/1950926464
 */

class Solution443 {
    fun compress(chars: CharArray): Int {
        if (chars.size == 1) return 1

        var pointer = 0
        var tempCount = 0
        var prevC: Char? = null

        for (c in chars) {
            if (c != prevC) {
                if (tempCount >= 1) {
                    chars[pointer++] = prevC!!

                    if (tempCount > 1) {
                        val countArr = tempCount.toString().toCharArray()
                        for (n in countArr) {
                            chars[pointer++] = n
                        }
                    }
                }

                tempCount = 1
                prevC = c
            } else {
                tempCount++
            }
        }

        chars[pointer++] = prevC!!
        if (tempCount > 1) {
            val countArr = tempCount.toString().toCharArray()
            for (n in countArr) {
                chars[pointer++] = n
            }
        }

        return pointer
    }
}

fun main() {
    val solution = Solution443()
    check(solution.compress("aabbccc".toCharArray()) == 6)
    check(solution.compress("a".toCharArray()) == 1)
    check(solution.compress("abbbbbbbbbbbb".toCharArray()) == 4)
}

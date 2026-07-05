/**
 * Problem : https://leetcode.com/problems/roman-to-integer/description/
 * Submission : https://leetcode.com/problems/roman-to-integer/submissions/2056679997
 */

class Solution13 {
    fun romanToInt(s: String): Int {
        var num = 0
        val romans = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var last: Char? = null
        for (c in s) {
            if (
                (last == 'I' && (c == 'V' || c == 'X')) ||
                (last == 'X' && (c == 'L' || c == 'C')) ||
                (last == 'C' && (c == 'D' || c == 'M'))
            ) num -= romans[last]!! * 2

            num += romans[c] ?: 0
            last = c
        }

        return num
    }
}

fun main() {
    val solution = Solution13()
    check(solution.romanToInt("III") == 3)
    check(solution.romanToInt("LVIII") == 58)
    check(solution.romanToInt("MCMXCIV") == 1994)
}

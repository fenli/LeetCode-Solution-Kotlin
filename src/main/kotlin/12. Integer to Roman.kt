/**
 * Problem : https://leetcode.com/problems/integer-to-roman/description/
 * Submission : https://leetcode.com/problems/integer-to-roman/submissions/2056737416
 */

class Solution12 {
    fun intToRoman(num: Int): String {
        var numTemp = num
        return buildString {
            while (numTemp > 0) {
                if (numTemp >= 1000) {
                    val thousands = numTemp / 1000
                    append("M".repeat(thousands))
                    numTemp -= 1000 * thousands
                    continue
                }

                if (numTemp >= 100) {
                    val hundreds = numTemp / 100
                    if (hundreds < 4) {
                        append("C".repeat(hundreds))
                    } else if (hundreds == 4) {
                        append('C')
                        append('D')
                    } else if (hundreds == 9) {
                        append('C')
                        append('M')
                    } else {
                        append('D')
                        append("C".repeat(hundreds - 5))
                    }

                    numTemp -= 100 * hundreds
                    continue
                }

                if (numTemp >= 10) {
                    val tens = numTemp / 10
                    if (tens < 4) {
                        append("X".repeat(tens))
                    } else if (tens == 4) {
                        append('X')
                        append('L')
                    } else if (tens == 9) {
                        append('X')
                        append('C')
                    } else {
                        append('L')
                        append("X".repeat(tens - 5))
                    }

                    numTemp -= 10 * tens
                    continue
                }

                val ones = numTemp
                if (ones < 4) {
                    append("I".repeat(ones))
                } else if (ones == 4) {
                    append('I')
                    append('V')
                } else if (ones == 9) {
                    append('I')
                    append('X')
                } else {
                    append('V')
                    append("I".repeat(ones - 5))
                }
                numTemp = 0
            }
        }
    }
}

fun main() {
    val solution = Solution12()
    check(solution.intToRoman(3749) == "MMMDCCXLIX")
    check(solution.intToRoman(58) == "LVIII")
    check(solution.intToRoman(1994) == "MCMXCIV")
}

package p0008_string_to_integer_atoi

import java.lang.Math.*

class Solution {
    fun myAtoi(s: String): Int {
        var positive = true
        var scanning = false
        var number = 0
        for (c in s) {
            when(c) {
                ' ' -> if (scanning) break else continue
                '+' -> if (scanning) break else {
                    positive = true
                    scanning = true
                }
                '-' -> if (scanning) break else {
                    positive = false
                    scanning = true
                }
                '0','1','2','3','4','5','6','7','8','9' -> {
                    scanning = true
                    val n = c.digitToInt()
                    try {
                        number = multiplyExact(number, 10)
                        number = if (positive) addExact(number, n) else subtractExact(number, n)
                    } catch (e: ArithmeticException) {
                        return if (positive) Int.MAX_VALUE else Int.MIN_VALUE
                    }
                }
                else -> break
            }
        }

        return number
    }
}

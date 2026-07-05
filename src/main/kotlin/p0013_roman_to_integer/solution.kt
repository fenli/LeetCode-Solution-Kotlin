package p0013_roman_to_integer

class Solution {
    fun romanToInt(s: String): Int {
        var num = 0
        val romans = mapOf<Char, Int>(
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
            ) num -= romans[last!!]!! * 2

            num += romans[c]!!

            last = c
        }

        return num
    }
}


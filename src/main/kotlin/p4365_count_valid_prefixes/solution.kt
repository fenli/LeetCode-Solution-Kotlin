package p4365_count_valid_prefixes

class Solution {
    fun countValidPrefixes(s: String): Int {
        var ans = 0
        var sumZero = 0
        var sumOne = 0
        for (i in 0 until s.length) {
            if (s[i] == '0') sumZero++
            else sumOne++

            if (i % 2 == 0) {
                if (Math.abs(sumZero - sumOne) == 1) ans++
            } else {
                if (sumZero == sumOne) ans++
            }
        }

        return ans
    }
}

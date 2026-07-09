package p0459_repeated_substring_pattern

class Solution {
    // Repeat substring approach
    fun repeatedSubstringPattern(s: String): Boolean {
        if (s.length == 1) return false
        if (s[0].toString().repeat(s.length) == s) return true
        
        for (i in 2..s.length / 2) {
            if (s.length % i == 0) {
                if (s.substring(0, i).repeat(s.length / i) == s) return true
            }
        }

        return false
    }

    // String rotation approach
    fun repeatedSubstringPattern2(s: String): Boolean {
        if (s.length == 1) return false
        var temp = s
        for (i in 0 until s.length / 2) {
            temp = temp.substring(1) + temp[0]
            if (temp == s) return true
        }
        return false
    }
}

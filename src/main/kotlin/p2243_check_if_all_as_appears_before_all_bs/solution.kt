package p2243_check_if_all_as_appears_before_all_bs

class Solution {
    fun checkString(s: String): Boolean {
        for (i in 0 until s.length - 1) {
            if (s[i] == 'b' && s[i + 1] == 'a') {
                return false
            }
        }
        return true
    }
}

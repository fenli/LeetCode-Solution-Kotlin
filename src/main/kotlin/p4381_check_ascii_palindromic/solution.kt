package p4381_check_ascii_palindromic

class Solution {
    fun isPalindromic(s: String): Boolean {
        if (s.length % 2 != 0 && s[s.length / 2] != 'f') return false
        
        for (i in 0 until s.length / 2) {
            if (s[i] == 'v' && s[s.length - 1 - i] == 'n') continue
            if (s[i] == 'n' && s[s.length - 1 - i] == 'v') continue
            if (s[i] == 'f' && s[s.length - 1 - i] == 'f') continue
            return false
        }
        return true
    }
}

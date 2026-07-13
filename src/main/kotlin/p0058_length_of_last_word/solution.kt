package p0058_length_of_last_word

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var lengthOfLastWord = 0
        for (i in (s.length - 1) downTo 0) {
            if (s[i] == ' ') {
                if (lengthOfLastWord != 0) return lengthOfLastWord
                lengthOfLastWord = 0
            } else {
                if (lengthOfLastWord == 0) lengthOfLastWord = 1
                else lengthOfLastWord++
            }
        }

        return lengthOfLastWord
    }
}

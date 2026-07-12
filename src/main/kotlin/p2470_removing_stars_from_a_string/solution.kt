package p2470_removing_stars_from_a_string

import java.util.Stack

class Solution {
    fun removeStars(s: String): String {
        val chars = Stack<Char>()
        for (c in s) {
            if (c == '*') chars.pop()
            else chars.push(c)
        }
        return chars.joinToString("")
    }
}

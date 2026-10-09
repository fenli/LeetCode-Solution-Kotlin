package p1648_minimum_insertions_to_balance_a_parentheses_string

class Solution {
    fun minInsertions(s: String): Int {
        var added = 0
        var netOpen = 0
        var count = 0
        for (c in s) {
            val v = c.code and 1 xor count
            added += count and v
            count = c.code and v
            netOpen += 1 - count - (c.code and 1)
            added += netOpen ushr 31
            netOpen += netOpen ushr 31
        }
        added += netOpen * 2 + count
        return added
    }
}

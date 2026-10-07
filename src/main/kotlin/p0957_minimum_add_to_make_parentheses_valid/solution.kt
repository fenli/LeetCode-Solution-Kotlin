package p0957_minimum_add_to_make_parentheses_valid

class Solution {
    fun minAddToMakeValid(s: String): Int {
        var add = 0
        var bal = 0
        for (c in s) {
            bal += 1 - (c.code and 1 shl 1)
            add += bal ushr 31
            bal += bal ushr 31
        }
        return add + bal
    }
}

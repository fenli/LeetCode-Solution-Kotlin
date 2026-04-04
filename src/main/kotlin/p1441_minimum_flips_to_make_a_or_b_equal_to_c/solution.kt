package p1441_minimum_flips_to_make_a_or_b_equal_to_c

class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var count = 0
        var aa = a
        var bb = b
        var cc = c
        while(!(aa == 0 && bb == 0 && cc == 0)) {
            val lastA = aa and 1
            val lastB = bb and 1
            val lastC = cc and 1
            if (lastA or lastB != lastC) {
                if (lastA == 1 && lastB == 1 && lastC == 0) count += 2
                else count++
            }

            aa = aa shr 1
            bb = bb shr 1
            cc = cc shr 1
        }

        return count
    }
}

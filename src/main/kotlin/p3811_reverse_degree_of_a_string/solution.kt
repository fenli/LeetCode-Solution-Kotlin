package p3811_reverse_degree_of_a_string

class Solution {
    fun reverseDegree(s: String): Int {
        var p = 0
        var i = 1
        for (c in s) {
            val ir = 'z' - c + 1
            p += i * ir
            i++
        }
        return p
    }
}

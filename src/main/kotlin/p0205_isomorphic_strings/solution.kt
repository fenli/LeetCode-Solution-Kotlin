package p0205_isomorphic_strings

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val maps = mutableMapOf<Char, Char>()
        val hasUsed = mutableMapOf<Char, Boolean>()

        for (i in 0 until s.length) {
            val cs = s[i]
            val ct = t[i]
            if (maps[cs] == null) {
                if (hasUsed[ct] == true) return false
                
                maps[cs] = ct
                hasUsed[ct] = true
            } else if (maps[cs] != ct) return false
        }

        return true
    }
}

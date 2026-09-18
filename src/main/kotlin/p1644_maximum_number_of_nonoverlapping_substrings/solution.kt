package p1644_maximum_number_of_nonoverlapping_substrings

class Solution {
    fun maxNumOfSubstrings(s: String): List<String> {
        val L = IntArray(26) { -1 }; val R = IntArray(26) { -1 }
        s.indices.forEach { i -> val c = s[i] - 'a'; if (L[c] < 0) L[c] = i; R[c] = i }
        val ivs = mutableListOf<Pair<Int, Int>>()
        for (i in 0..25) {
            if (L[i] < 0) continue
            var l = L[i]; var r = R[i]; var ok = true; var j = l
            while (j <= r && ok) {
                if (L[s[j] - 'a'] < l) ok = false else r = maxOf(r, R[s[j] - 'a']); j++
            }
            if (ok) ivs.add(r to l)
        }
        ivs.sortBy { it.first }
        val res = mutableListOf<String>(); var last = -1
        for ((r, l) in ivs) if (l > last) { res.add(s.substring(l, r + 1)); last = r }
        return res
    }
}

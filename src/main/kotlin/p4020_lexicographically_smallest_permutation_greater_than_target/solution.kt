package p4020_lexicographically_smallest_permutation_greater_than_target

class Solution {

    fun lexGreaterPermutation(s: String, target: String): String {
        val cnt = IntArray(26)

        for (ch in s) {
            cnt[ch - 'a']++
        }

        for (ch in target) {
            cnt[ch - 'a']--
        }

        for (i in target.length - 1 downTo 0) {
            val cur = target[i] - 'a'
            cnt[cur]++

            var ok = true
            for (count in cnt) {
                if (count < 0) {
                    ok = false
                    break
                }
            }

            if (!ok) continue

            var next = -1

            for (c in cur + 1 until 26) {
                if (cnt[c] > 0) {
                    next = c
                    break
                }
            }

            if (next == -1) continue

            cnt[next]--

            val ans = StringBuilder(target.substring(0, i))
            ans.append(('a'.code + next).toChar())

            for (c in 0 until 26) {
                while (cnt[c]-- > 0) {
                    ans.append(('a'.code + c).toChar())
                }
            }

            return ans.toString()
        }

        return ""
    }
}


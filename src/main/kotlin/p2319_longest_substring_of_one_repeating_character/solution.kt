package p2319_longest_substring_of_one_repeating_character

class Solution {

    private lateinit var sArr: CharArray
    private lateinit var pre: IntArray
    private lateinit var suf: IntArray
    private lateinit var maxLen: IntArray
    private lateinit var leftChar: CharArray
    private lateinit var rightChar: CharArray

    fun longestRepeating(
        s: String,
        queryCharacters: String,
        queryIndices: IntArray
    ): IntArray {
        val n = s.length

        sArr = s.toCharArray()
        pre = IntArray(4 * n)
        suf = IntArray(4 * n)
        maxLen = IntArray(4 * n)
        leftChar = CharArray(4 * n)
        rightChar = CharArray(4 * n)

        build(1, 0, n - 1)

        val k = queryIndices.size
        val ans = IntArray(k)

        for (i in 0 until k) {
            update(
                1,
                0,
                n - 1,
                queryIndices[i],
                queryCharacters[i]
            )
            ans[i] = maxLen[1]
        }

        return ans
    }

    private fun pushUp(u: Int, l: Int, r: Int) {
        val mid = (l + r) shr 1
        val leftLen = mid - l + 1
        val rightLen = r - mid

        val left = u shl 1
        val right = (u shl 1) or 1

        leftChar[u] = leftChar[left]
        rightChar[u] = rightChar[right]

        pre[u] = pre[left]

        if (
            pre[left] == leftLen &&
            rightChar[left] == leftChar[right]
        ) {
            pre[u] = pre[left] + pre[right]
        }

        suf[u] = suf[right]

        if (
            suf[right] == rightLen &&
            rightChar[left] == leftChar[right]
        ) {
            suf[u] = suf[right] + suf[left]
        }

        maxLen[u] = maxOf(maxLen[left], maxLen[right])

        if (rightChar[left] == leftChar[right]) {
            maxLen[u] = maxOf(
                maxLen[u],
                suf[left] + pre[right]
            )
        }
    }

    private fun build(u: Int, l: Int, r: Int) {
        if (l == r) {
            pre[u] = 1
            suf[u] = 1
            maxLen[u] = 1
            leftChar[u] = sArr[l]
            rightChar[u] = sArr[l]
            return
        }

        val mid = (l + r) shr 1

        build(u shl 1, l, mid)
        build((u shl 1) or 1, mid + 1, r)

        pushUp(u, l, r)
    }

    private fun update(
        u: Int,
        l: Int,
        r: Int,
        pos: Int,
        ch: Char
    ) {
        if (l == r) {
            leftChar[u] = ch
            rightChar[u] = ch
            return
        }

        val mid = (l + r) shr 1

        if (pos <= mid) {
            update(u shl 1, l, mid, pos, ch)
        } else {
            update((u shl 1) or 1, mid + 1, r, pos, ch)
        }

        pushUp(u, l, r)
    }
}

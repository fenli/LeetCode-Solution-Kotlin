package p3150_shortest_and_lexicographically_smallest_beautiful_string

class Solution {

    fun shortestBeautifulSubstring(s: String, k: Int): String {
        var ans = ""
        val n = s.length

        for (i in 0 until n) {
            var oneCnt = 0
            val cur = StringBuilder()

            for (j in i until n) {
                cur.append(s[j])

                if (s[j] == '1') {
                    oneCnt++
                }

                // More than k ones can never become valid again
                if (oneCnt > k) {
                    break
                }

                if (oneCnt == k) {
                    val current = cur.toString()

                    if (
                        ans.isEmpty() ||
                        current.length < ans.length ||
                        (current.length == ans.length && current < ans)
                    ) {
                        ans = current
                    }
                }
            }
        }

        return ans
    }
}


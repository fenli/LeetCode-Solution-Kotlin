import java.util.*

/**
 * Problem : https://leetcode.com/problems/decode-string/description/
 * Submission : https://leetcode.com/problems/decode-string/submissions/1959796214
 */

class Solution394 {
    fun decodeString(s: String): String {
        val stack = Stack<Any>()
        var decoded = ""
        var temp = ""
        for (c in s) {
            // println(stack.joinToString(","))
            if (c.isDigit()) {
                if (temp != "" && temp.toIntOrNull() == null) {
                    stack.push(temp)
                    temp = ""
                }
                temp = temp + c
            } else if (c == '[') {
                val k = temp.toInt()
                stack.push(k)
                temp = ""
            } else if (c == ']') {
                do {
                    val top = stack.pop()
                    if (top is String) {
                        temp = top + temp
                    } else if (top is Int) {
                        if (stack.isEmpty()) {
                            decoded = decoded + temp.repeat(top)
                        } else {
                            stack.push(temp.repeat(top))
                        }
                    }
                } while (top !is Int)
                temp = ""
            } else { // Letter
                if (stack.isEmpty()) decoded = decoded + c
                else temp = temp + c
            }
        }

        return decoded
    }
}

fun main() {
    val solution = Solution394()
    check(solution.decodeString("3[a]2[bc]") == "aaabcbc")
    check(solution.decodeString("3[a2[c]]") == "accaccacc")
    check(solution.decodeString("2[abc]3[cd]ef") == "abcabccdcdcdef")
}

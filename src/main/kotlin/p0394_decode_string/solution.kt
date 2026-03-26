package p0394_decode_string

class Solution {
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

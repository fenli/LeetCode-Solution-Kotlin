package p0316_remove_duplicate_letters

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val lastIndex = mutableMapOf<Char, Int>()
        val history = mutableSetOf<Char>()
        val stack = Stack<Char>()
        // Precompute last index of every distinct char
        for (i in 0 until s.length) lastIndex[s[i]] = i
        for (i in 0 until s.length) {
            val c = s[i]
            if (history.contains(c)) continue
            while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek()] ?: 0 > i) {
                history.remove(stack.pop())
            }
            stack.push(c)
            history.add(c)
        }

        return stack.joinToString("")
    }
}

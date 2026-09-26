package p1934_evaluate_the_bracket_pairs_of_a_string

class Solution {
    fun evaluate(s: String, knowledge: List<List<String>>): String {
        val map = mutableMapOf<String, String>()
        knowledge.forEach { map[it[0]] = it[1] }

        val ans = StringBuilder()

        var readingKey = false
        val key = StringBuilder()
        s.forEach {
            when (it) {
                '(' -> readingKey = true
                ')' -> {
                    readingKey = false
                    val value = map[key.toString()] ?: "?"
                    ans.append(value)
                    key.clear()
                }
                else -> when (readingKey) {
                    true -> key.append(it)
                    false -> ans.append(it)
                }
            }
        }
        return ans.toString()
    }
}

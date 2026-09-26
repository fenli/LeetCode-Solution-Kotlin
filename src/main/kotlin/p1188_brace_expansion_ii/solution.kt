package p1188_brace_expansion_ii

class Solution {
    fun braceExpansionII(expression: String): List<String> {
        val expression = expression.toCharArray()
        var i = 0
        fun getBlock(): Set<String> {
            var mul = HashSet<String>()
            mul.add("")
            val res = HashSet<String>()
            while (i < expression.size)
                when (val char = expression[i++]) {
                    '{' -> {
                        val newMul = HashSet<String>()
                        for (next in getBlock())
                            for (prev in mul)
                                newMul.add(prev + next)
                        mul = newMul
                    }

                    '}' -> break

                    ',' -> {
                        res.addAll(mul)
                        mul = HashSet()
                        mul.add("")
                    }

                    else -> {
                        val newMul = HashSet<String>()
                        for (prev in mul)
                            newMul.add(prev + char)
                        mul = newMul
                    }
                }
            res.addAll(mul)
            return res
        }
        return getBlock().sorted()
    }
}

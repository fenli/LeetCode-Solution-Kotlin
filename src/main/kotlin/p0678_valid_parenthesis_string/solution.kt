package p0678_valid_parenthesis_string

class Solution {
    fun checkValidString(s: String): Boolean {
        // Stack to store index of chars
        val charOpen = Stack<Int>()
        val wildcard = Stack<Int>()

        // Iterate over index and eliminate the close parenthesis pairs
        s.forEachIndexed { index, char ->
            when (char) {
                '(' -> {
                    charOpen.push(index)
                }
                '*' -> {
                    wildcard.push(index)
                }
                ')' -> {
                    if(!charOpen.isEmpty()) {
                        charOpen.pop()
                    } else if (!wildcard.isEmpty()) {
                        wildcard.pop()
                    } else {
                        return false
                    }
                }        
            }
        }

        // Check for leftovers
        while (!charOpen.isEmpty()) {
            if (wildcard.isEmpty() || charOpen.pop() > wildcard.pop()) return false 
        } 

        return true    
    }
}

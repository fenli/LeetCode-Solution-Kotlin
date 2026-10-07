package p0301_remove_invalid_parentheses

class Solution {
    private companion object{
        private const val PAREN_OPEN = '('
        private const val PAREN_CLOSED = ')'
    }
    
    fun removeInvalidParentheses(str: String): List<String> {
        val ans = mutableListOf<String>()
        dfs(0, 0, str, PAREN_OPEN, PAREN_CLOSED, ans)
        return ans
    }
    
    private fun dfs(loStart: Int, 
                    hiStart: Int, 
                    str: String, 
                    parenOpen: Char, 
                    parenClosed: Char, 
                    res: MutableList<String>){
        
        val lenS = str.length
        
        var stack = 0
        loop@for(hi in hiStart until lenS){
            if(str[hi] == parenOpen) ++stack
            if(str[hi] == parenClosed) --stack
            if(stack >= 0) continue@loop
            
            for(lo in loStart..hi){
                if(str[lo] == parenClosed && (lo == 0 || str[lo - 1] != parenClosed)){
                    val deleted = StringBuilder(str).deleteCharAt(lo).toString()
                    
                    dfs(lo, hi, deleted, parenOpen, parenClosed, res)
                }
            }
            
            return
        }
        
        val reversed = str.reversed()
        if(parenOpen == PAREN_OPEN)
            dfs(0, 0, reversed, PAREN_CLOSED, PAREN_OPEN, res)
        else
            res.add(reversed)
    }
}

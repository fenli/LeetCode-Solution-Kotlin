package p4342_create_grid_with_exactly_one_path

class Solution {
    fun createGrid(m: Int, n: Int): Array<String> {
        val rez = Array<String>(m){""}
        for (i in 0 until m) {
            val sb = StringBuilder()
            for (j in 0 until n) {
                if (j==0 || i==m-1) sb.append('.')
                else sb.append('#')
            }
            rez[i]= sb.toString()
        }
        return rez        
    }
}

import kotlin.math.max

/**
 * Problem : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Submission : https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1960932805
 */

class Solution104 {
    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(maxDepth(root?.left), maxDepth(root?.right))
    }
}

fun main() {
    fun List<Int?>.toTreeNode(index: Int = 0): Solution104.TreeNode? {
        if (index >= size) return null
        if (get(index) == null) return null

        return Solution104.TreeNode(get(index)!!, toTreeNode(index * 2 + 1), toTreeNode(index * 2 + 2))
    }

    val solution = Solution104()
    check(solution.maxDepth(listOf(3, 9, 20, null, null, 15, 7).toTreeNode()) == 3)
    check(solution.maxDepth(listOf(1, null, 2).toTreeNode()) == 2)
}

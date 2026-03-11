/**
 * Problem : https://leetcode.com/problems/invert-binary-tree/description/
 * Submission : https://leetcode.com/problems/invert-binary-tree/submissions/1944759292
 */

class Solution226 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root?.left != null || root?.right != null) {
            var temp = root?.left
            root?.left = root?.right
            root?.right = temp
            invertTree(root?.left)
            invertTree(root?.right)
        }

        return root
    }
}

fun main() {
    val solution = Solution226()
}

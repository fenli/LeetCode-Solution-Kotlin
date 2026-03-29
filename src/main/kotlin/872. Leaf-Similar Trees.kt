/**
 * Problem : https://leetcode.com/problems/leaf-similar-trees/description/
 * Submission : https://leetcode.com/problems/leaf-similar-trees/submissions/1962546499
 */

class Solution872 {
    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    private val leaf1 = mutableListOf<Int>()
    private val leaf2 = mutableListOf<Int>()

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        findLeaf(root1, leaf1)
        findLeaf(root2, leaf2)

        return leaf1 == leaf2
    }

    fun findLeaf(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        if (root?.left == null && root?.right == null) {
            list.add(root!!.`val`)
        }

        findLeaf(root?.left, list)
        findLeaf(root?.right, list)
    }

    // Recursive attempt
    // fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    //     val isLeaf1 = (root1?.left == null && root1?.right == null)
    //     val isLeaf2 = (root2?.left == null && root2?.right == null)
    //     if (isLeaf1 && isLeaf2) {
    //         println("${root1?.`val`} == ${root2?.`val`}")
    //         return (root1?.`val` == root2?.`val`)
    //     }
    //     else if (isLeaf1) return leafSimilar(root1, root2?.left) xor leafSimilar(root1, root2?.right)
    //     else if (isLeaf2) return leafSimilar(root1?.left, root2) xor leafSimilar(root1?.right, root2)
    //     return leafSimilar(root1?.left ?: root1?.right, root2?.left)
    // }
}

fun main() {
    fun List<Int?>.toTreeNode(index: Int = 0): Solution872.TreeNode? {
        if (index >= size) return null
        if (get(index) == null) return null

        return Solution872.TreeNode(get(index)!!, toTreeNode(index * 2 + 1), toTreeNode(index * 2 + 2))
    }

    val solution = Solution872()
    check(
        solution.leafSimilar(
            listOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4).toTreeNode(),
            listOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8).toTreeNode()
        )
    )
    check(!solution.leafSimilar(listOf(1, 2, 3).toTreeNode(), listOf(1, 3, 2).toTreeNode()))
}

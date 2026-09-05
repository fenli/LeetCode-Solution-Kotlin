package p0104_maximum_depth_of_binary_tree

import utils.TreeNode

fun main() {
    fun List<Int?>.toTreeNode(index: Int = 0): TreeNode? {
        if (index >= size) return null
        if (get(index) == null) return null

        return TreeNode(get(index)!!, toTreeNode(index * 2 + 1), toTreeNode(index * 2 + 2))
    }

    val solution = Solution()
    check(solution.maxDepth(listOf(3, 9, 20, null, null, 15, 7).toTreeNode()) == 3)
    check(solution.maxDepth(listOf(1, null, 2).toTreeNode()) == 2)
}

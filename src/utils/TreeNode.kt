package utils

data class TreeNode(
    val data: Int,
    val children: MutableList<TreeNode> = mutableListOf()
)

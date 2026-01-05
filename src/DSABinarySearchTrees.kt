import utils.BinaryTreeNode

fun main() {
    val head = BinaryTreeNode(6)
    head.left = BinaryTreeNode(2)
    head.right = BinaryTreeNode(8)
    head.right?.left = BinaryTreeNode(7)
    head.right?.right = BinaryTreeNode(9)

    val result = searchElementInBinarySearchTree(head, 9)
    println("is 9 exists in binary search tree $result")

}

fun searchElementInBinarySearchTree(head: BinaryTreeNode?, key: Int): Boolean {
    if (head == null) return false

    if (head.data == key) return true

    return if (key < head.data) searchElementInBinarySearchTree(head.left, key)
    else searchElementInBinarySearchTree(head.right, key)
}
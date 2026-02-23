//import utils.TreeNode
//
//fun main() {
//    val root = TreeNode(1)
//    val n2 = TreeNode(2)
//    val n3 = TreeNode(3)
//    val n4 = TreeNode(4)
//    val n5 = TreeNode(5)
//    addChild(root, n2)
//    addChild(root, n3)
//    addChild(n2, n4)
//    addChild(n2, n5)
//
//    println("Printing all children")
//    printChildren(root)
//
//    println("Printing all parents")
//    printParents(root,null)
//
//    println("Printing all the leaves")
//    printLeafs(root)
//}
//
//fun addChild(parent: TreeNode, child: TreeNode) {
//    parent.children.add(child)
//}
//
//fun printLeafs(parent: TreeNode) {
//    if(parent.children.isEmpty()) {
//        print("${parent.data} ")
//    }
//
//    parent.children.forEach{
//        printLeafs(it)
//    }
//}
//
//fun printParents(child: TreeNode?, parent: TreeNode?) {
//    println("${child?.data} -> ${parent?.data}")
//
//    child?.children?.forEach{
//        printParents(it, child)
//    }
//}
//
//fun printChildren(parent: TreeNode) {
//    print(" ${parent.data} -> ")
//    for (child in parent.children) {
//        print("${child.data} ")
//    }
//    println()
//
//    for (child in parent.children) {
//        printChildren(child)
//    }
//}
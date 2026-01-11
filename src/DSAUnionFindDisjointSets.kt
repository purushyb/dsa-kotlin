fun main() {
    val numberOfElements = 5
    val rank = Array<Int>(numberOfElements) { 0 }
    val parents = Array<Int>(numberOfElements) { it }

    unionByRank(0,1, parents, rank)
    unionByRank(2,3, parents, rank)
    unionByRank(0,4, parents, rank)

    for(i in 0..<numberOfElements) {
        println("$i parent is ${findWithPathCompression(i, parents)}")
    }

}

fun findWithPathCompression(node: Int, parents: Array<Int>): Int {

    if (parents[node] == node) return node

    parents[node] = findWithPathCompression(parents[node], parents)

    return parents[node]
}

fun unionByRank(node1: Int, node2: Int, parents: Array<Int>, rank: Array<Int>) {
    val parent1 = findWithPathCompression(node1, parents)
    val parent2 = findWithPathCompression(node2, parents)

    if (parent1 == parent2) return

    if (rank[node1] < rank[node2]) {
        parents[node1] = parent2
    } else if (rank[node1] > rank[node2]) {
        parents[parent2] = parent1
    } else {
        parents[node2] = node1
        rank[node1] += 1
    }
}
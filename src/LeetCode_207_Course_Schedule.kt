class LeetCode_207_Course_Schedule {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // create adj list for graph

        val adj = Array(numCourses) { arrayListOf<Int>() }

        for((c, p) in prerequisites) {
            adj[c].add(p)
        }

        val visited = IntArray(numCourses)

        for(i in 0..<numCourses) {
            if(visited[i] == 0) {
                if(!isCycleExistsDFS(adj, IntArray(numCourses), i)) {
                    return false
                }
            }
        }

        return true
    }

    private fun isCycleExistsDFS(adj: Array<ArrayList<Int>>, visited: IntArray, vertex: Int): Boolean {

        visited[vertex] = 1
        for(i in adj[vertex]) {
            if(visited[i] == 1) return false
            else if(visited[i] == 0) if(!isCycleExistsDFS(adj, visited, i)) return false
        }
        visited[vertex] = 3
        return true
    }
}

fun main() {
    val problem = LeetCode_207_Course_Schedule()

    val prerequisites = arrayOf(intArrayOf(1,0), intArrayOf(0,1))
    val numCourses = 2
    val result = problem.canFinish(numCourses, prerequisites)
    println(result)

    val prerequisites1 = arrayOf(intArrayOf(1,0))
    val numCourses1 = 2
    val result1 = problem.canFinish(numCourses1, prerequisites1)
    println(result1)

    val prerequisites2 = arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,0))
    val numCourses2 = 3
    val result2 = problem.canFinish(numCourses2, prerequisites2)
    println(result2)

    val prerequisites3 = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(3, 18),
        intArrayOf(5, 5),
        intArrayOf(6, 11),
        intArrayOf(11, 14),
        intArrayOf(13, 1),
        intArrayOf(15, 1),
        intArrayOf(17, 4)
    )
    val numCourses3 = 20
    val result3 = problem.canFinish(numCourses3, prerequisites3)
    println(result3)
}
class LeetCode_733_Flood_Fill {
    private val neighbors = arrayOf<Pair<Int, Int>>(0 to 1, 0 to -1, 1 to 0, -1 to 0)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
        val sv = image[sr][sc]
        if (sv != color) {
            image[sr][sc] = color
            dfsAddColor(image, sr, sc, color, sv)
        }
        return image
    }

    private fun dfsAddColor(image: Array<IntArray>, sr: Int, sc: Int, color: Int, sv: Int) {
        for ((or, oc) in neighbors) {
            val nr = sr + or
            val nc = sc + oc
            if (nr >= 0
                && nr < image.size
                && nc >= 0
                && nc < image[0].size
                && image[nr][nc] == sv
            ) {
                image[nr][nc] = color
                dfsAddColor(image, nr, nc, color, sv)
            }
        }
    }
}

fun main() {
    val problem = LeetCode_733_Flood_Fill()

    val input = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
    val color = 2
    val sr = 1
    val sc = 1
    val result = problem.floodFill(input, sr, sc, color)
    for (i in result) {
        println(i.contentToString())
    }

    println()
    val input1 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
    val color1 = 0
    val sr1 = 0
    val sc1 = 0
    val result1 = problem.floodFill(input1, sr1, sc1, color1)
    for (i in result1) {
        println(i.contentToString())
    }

    println()
    val input2 = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0))
    val color2 = 2
    val sr2 = 1
    val sc2 = 1
    val result2 = problem.floodFill(input2, sr2, sc2, color2)
    for (i in result2) {
        println(i.contentToString())
    }
}
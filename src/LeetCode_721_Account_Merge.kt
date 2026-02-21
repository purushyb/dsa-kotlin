import java.util.TreeSet

class LeetCode_721_Account_Merge {

    private class DSU(size: Int) {
        val parents = IntArray(size) { it }
        val sizes = IntArray(size) { 1 }

        fun find(u: Int): Int {
            if (parents[u] == u) return u

            val result = find(parents[u])
            parents[u] = result
            return result
        }

        fun union(u: Int, v: Int) {
            val p1 = find(u)
            val p2 = find(v)

            if (p1 == p2) return

            if (sizes[p1] < sizes[p2]) {
                parents[p1] = p2
                sizes[p2] += sizes[p1]
            } else {
                parents[p2] = p1
                sizes[p1] += sizes[p2]
            }
        }

    }

    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        val parents = mutableMapOf<String, Int>()
        val n = accounts.size
        val dsu = DSU(n)

        for (i in 0..<n) {
            for (j in 1..<accounts[i].size) {
                val mail = accounts[i][j]
                if (!parents.contains(mail)) {
                    parents[mail] = i
                } else {
                    dsu.union(i, parents[mail]!!)
                }
            }
        }

        val mergedAccounts = List(n) { TreeSet<String>() }
        for ((mail, parent) in parents) {
            val cParent = dsu.find(parent)
            mergedAccounts[cParent].add(mail)
        }

        val resultAccount = mutableListOf<List<String>>()
        for (i in 0..<n) {
            if (mergedAccounts[i].isEmpty()) continue
            resultAccount.add(listOf(accounts[i].first()) + mergedAccounts[i])
        }
        return resultAccount
    }


    fun accountsMergeDFS(accounts: List<List<String>>): List<List<String>> {
        val adj = mutableMapOf<String, MutableList<String>>()
        val visited = HashSet<String>()

        for (emailsList in accounts) {
            val fEmail = emailsList[1]
            for (j in 2..<emailsList.size) {
                adj.computeIfAbsent(fEmail, { mutableListOf<String>() }).add(emailsList[j])
                adj.computeIfAbsent(emailsList[j], { mutableListOf<String>() }).add(fEmail)
            }
        }

        val resultAccounts = mutableListOf<List<String>>()

        for (emailsList in accounts) {
            val fMail = emailsList[1]
            val name = emailsList[0]

            if (!visited.contains(fMail)) {
                val account = mutableListOf<String>()
                dfs(visited, adj, account, fMail)
                resultAccounts.add(listOf(name) + account.sorted())
            }
        }

        return resultAccounts
    }

    private fun dfs(
        visited: HashSet<String>,
        adj: MutableMap<String, MutableList<String>>,
        account: MutableList<String>,
        fMail: String
    ) {
        visited.add(fMail)
        account.add(fMail)

        for (adjEmail in adj.getOrDefault(fMail, listOf())) {
            if (!visited.contains(adjEmail)) {
                dfs(visited, adj, account, adjEmail)
            }
        }
    }
}

fun main() {
    val problem = LeetCode_721_Account_Merge()

    val accounts = listOf(
        listOf("John", "johnsmith@mail.com", "john_newyork@mail.com"),
        listOf("John", "johnsmith@mail.com", "john00@mail.com"),
        listOf("Mary", "mary@mail.com"),
        listOf("John", "johnnybravo@mail.com")
    )
    val result = problem.accountsMerge(accounts)
    println(result)
}
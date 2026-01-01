package utils

data class DataBaseRecord(val id: Int, val name: String) : Comparator<DataBaseRecord> {
    override fun compare(o1: DataBaseRecord, o2: DataBaseRecord): Int {
        return o1.id.compareTo(o2.id)
    }
}


package util

object ArrayUtil {
    /**
     * 从文件中读取int数组数据,并解析还原成 int[]
     * 注意: 文件中仅有一行数据, 格式为: [1,2,3] 或者  1,2,3
     */
    fun readByFile(path: String): IntArray {
        return FileUtil.readAllLine(path)[0]
            .replace("[", "")
            .replace("]", "")
            .split(",".toRegex()).map { str -> str.convert2Int(0) }.toIntArray()
    }


}
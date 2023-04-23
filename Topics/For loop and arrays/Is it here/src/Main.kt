fun main() {
    val n = readln().toInt()
    val numbers = List(n) { readln().toInt() }
    val m = readln().toInt()
    println(if (numbers.contains(m)) "YES" else "NO")
}
fun main() {
    val n = readln().toInt()
    val numbers = List(n) { readln().toInt() }
    val m = readln().toInt()
    println(numbers.count { it == m })
}
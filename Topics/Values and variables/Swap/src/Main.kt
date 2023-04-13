fun main() {
    // Don't be afraid of the code below! 
    // In the future, you will definitely cope with it, but for now just ignore it.
    var (a, b) = readln().split(" ").map { it.toInt() }

    // Write only exchange actions here. Do not touch the lines above
    val c = a
    a = b
    b = c

    // Do not touch the lines below
    print("$a $b")
}
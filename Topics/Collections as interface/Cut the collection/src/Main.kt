fun main() {
    val originalList = readln().split(" ")
    val originalSet = originalList.toSet()
    val word = readln()

    println(dropElements(originalList, word))
    println(dropElements(originalSet, word))
}

// Write function dropElements() here
fun dropElements(elements: Collection<String>, element: String): Collection<String> {
    return elements.filter { it != element }
}
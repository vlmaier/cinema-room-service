fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val name = readln()
        if (name == "stop") {
            break
        }
        val grade = readln().toInt()
        studentsMarks.putIfAbsent(name, grade)
    }
    println(studentsMarks)
}
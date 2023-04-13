interface Animal {
    val numberOfLimbs: Int
    fun move()
    fun communicate(): String
}

// Do not change code below.

fun bark(): String { return "bark" }
fun meow(): String { return "meow" }
fun speak(): String { return "speak" }

fun walk() { println("walk") }
fun fly() { println("fly") }
fun swim() { println("swim") }

// Do not change code above.

class Dog : Animal {
    override val numberOfLimbs: Int
        get() = 4

    override fun move() {
        walk()
    }

    override fun communicate(): String {
        return bark()
    }
}
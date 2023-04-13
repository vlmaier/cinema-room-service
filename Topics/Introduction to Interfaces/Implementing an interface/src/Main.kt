// Do not change the code below.

data class Vector2(var x: Int, var y: Int)        

interface Moving {
    var currentCoordinates: Vector2

    var speed: Int

    var direction: Vector2

    // This function changes X and Y coordinates
    // of an object by the amount of the object's speed
    // (object has same speed along X and Y axis)
    // according to direction of the object.
    fun move()

    // This function reduces the speed of an object
    // along X and Y axes, subtracting given amount.
    fun slowDown(subtractedSpeed: Int)

    // This function increases the speed of an object
    // along X and Y axes, adding given amount.
    fun speedUp(addedSpeed: Int)

    // This function sets new direction for the object,
    // overwriting previous values.
    fun rotate(newDirection: Vector2)
}

// Do not change the code above.

class YourMovingObject(
    override var currentCoordinates: Vector2,
    override var speed: Int,
    override var direction: Vector2
) : Moving {

    override fun move() {
        currentCoordinates.x += speed * direction.x
        currentCoordinates.y += speed * direction.y
    }

    override fun slowDown(subtractedSpeed: Int) {
        speed -= subtractedSpeed
    }

    override fun speedUp(addedSpeed: Int) {
        speed += addedSpeed
    }

    override fun rotate(newDirection: Vector2) {
        direction = newDirection
    }
}
package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Ticket(
    val row: Int,
    @JsonProperty("column")
    val number: Int,
    val price: Int,
)

fun Ticket.toSeat(): Seat {
    return Seat(
        row = row,
        number = number,
        price = price,
    )
}
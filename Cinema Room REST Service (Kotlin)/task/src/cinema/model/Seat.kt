package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Seat (
    val row: Int,
    @JsonProperty("column")
    val number: Int,
    val price: Int,
)

fun Seat.toTicket(): Ticket {
    return Ticket(
        row = row,
        number = number,
        price = price,
    )
}
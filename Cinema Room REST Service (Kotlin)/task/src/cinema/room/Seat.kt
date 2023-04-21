package cinema.room

import com.fasterxml.jackson.annotation.JsonProperty

data class Seat (
    val row: Int,
    @JsonProperty("column")
    val number: Int,
)
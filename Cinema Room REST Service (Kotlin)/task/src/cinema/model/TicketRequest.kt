package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class TicketRequest(
    val row: Int,
    @JsonProperty("column")
    val number: Int,
)

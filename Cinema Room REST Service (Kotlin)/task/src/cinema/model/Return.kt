package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Return(
    @JsonProperty("returned_ticket")
    val ticket: Ticket,
)
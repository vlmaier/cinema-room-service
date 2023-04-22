package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Stats(
    @JsonProperty("current_income")
    val income: Int,
    @JsonProperty("number_of_available_seats")
    val availableSeats: Int,
    @JsonProperty("number_of_purchased_tickets")
    val purchasedTickets: Int,
)
package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Room(
    @JsonProperty("total_rows")
    val totalRows: Int,
    @JsonProperty("total_columns")
    val seatsPerRow: Int,
    @JsonProperty("available_seats")
    val availableSeats: List<Seat>,
)
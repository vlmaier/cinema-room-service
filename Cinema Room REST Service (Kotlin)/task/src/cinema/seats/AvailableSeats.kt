package cinema.seats

import com.fasterxml.jackson.annotation.JsonProperty

data class AvailableSeats(
    @JsonProperty("total_rows")
    val totalRows: Int,
    @JsonProperty("total_columns")
    val totalColumns: Int,
    @JsonProperty("available_seats")
    val availableSeats: List<Seat>,
)
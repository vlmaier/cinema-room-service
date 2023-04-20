package cinema

import cinema.seats.AvailableSeats
import cinema.seats.SeatService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CinemaController(
    private val seatService: SeatService
) {

    @GetMapping("/seats")
    fun getSeats(): AvailableSeats {
        val seats = seatService.getSeats()
        val maxRow = seats.map { it.row }.maxOf { it }
        val maxColumn = seats.map { it.column }.maxOf { it }
        return AvailableSeats(
            totalRows = maxRow,
            totalColumns = maxColumn,
            availableSeats = seats,
        )
    }
}
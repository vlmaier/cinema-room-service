package cinema

import cinema.room.Room
import cinema.room.RoomService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CinemaController(
    private val roomService: RoomService
) {

    @GetMapping("/seats")
    fun getSeats(): Room {
        val seats = roomService.getAvailableSeats()
        return Room(
            totalRows = seats.map { it.row }.maxOf { it },
            seatsPerRow = seats.map { it.number }.maxOf { it },
            availableSeats = seats,
        )
    }
}
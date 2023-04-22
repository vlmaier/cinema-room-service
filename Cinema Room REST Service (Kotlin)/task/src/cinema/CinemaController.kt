package cinema

import cinema.model.Room
import cinema.model.Ticket
import cinema.model.TicketRequest
import cinema.service.CinemaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CinemaController(
    private val cinemaService: CinemaService,
) {
    @GetMapping("/seats")
    fun getSeats(): Room {
        return cinemaService.getRoom()
    }

    @PostMapping("/purchase")
    fun purchaseTicket(
        @RequestBody request: TicketRequest,
    ): Ticket {
        return cinemaService.purchaseTicket(request.row, request.number)
    }
}
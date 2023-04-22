package cinema.controller

import cinema.model.Purchase
import cinema.model.Return
import cinema.model.Room
import cinema.model.TicketRequest
import cinema.model.ReturnRequest
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
    ): Purchase {
        return cinemaService.purchaseTicket(request.row, request.number)
    }

    @PostMapping("/return")
    fun returnTicket(
        @RequestBody request: ReturnRequest,
    ): Return {
        return cinemaService.returnTicket(request.token)
    }
}
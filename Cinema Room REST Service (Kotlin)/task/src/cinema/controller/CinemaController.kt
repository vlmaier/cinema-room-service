package cinema.controller

import cinema.model.*
import cinema.service.CinemaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
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

    @PostMapping("/stats")
    fun getStats(
        @RequestParam(defaultValue = "") password: String
    ): Stats {
        return cinemaService.getStats(password)
    }
}
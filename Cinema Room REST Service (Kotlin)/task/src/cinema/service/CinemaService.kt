package cinema.service

import cinema.error.InvalidSeatException
import cinema.error.InvalidTokenException
import cinema.error.UnavailableSeatException
import cinema.model.*
import org.springframework.stereotype.Service
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@Service
class CinemaService {

    private val bookedSeats = mutableListOf<Seat>()
    private val availableSeats = mutableListOf<Seat>()
    private val purchasedTickets = ConcurrentHashMap<String, Ticket>()

    init {
        val seatsPerRow = 1..SEATS_PER_ROW
        val totalRows = 1..TOTAL_ROWS
        for (row in totalRows) {
            for (number in seatsPerRow) {
                val price = calculatePrice(row)
                availableSeats.add(Seat(row, number, price))
            }
        }
    }

    fun getRoom(): Room {
        return Room(
            totalRows = availableSeats.map { it.row }.maxOf { it },
            seatsPerRow = availableSeats.map { it.number }.maxOf { it },
            availableSeats = availableSeats,
        )
    }

    fun purchaseTicket(row: Int, number: Int): Purchase {
        if (!isSeatValid(row, number)) {
            throw InvalidSeatException("The number of a row or a column is out of bounds!")
        }
        if (!isSeatAvailable(row, number)) {
            throw UnavailableSeatException("The ticket has been already purchased!")
        }
        val seat = findSeat(row, number)!!
        bookedSeats.add(seat)
        availableSeats.remove(seat)
        val ticket = seat.toTicket()
        val token = UUID.randomUUID().toString()
        purchasedTickets[token] = ticket
        return Purchase(
            token = token,
            ticket = ticket,
        )
    }

    fun returnTicket(token: String): Return {
        if (!purchasedTickets.containsKey(token)) {
            throw InvalidTokenException("Wrong token!")
        }
        val returnedTicket = Return(ticket = purchasedTickets[token]!!)
        purchasedTickets.remove(token)
        return returnedTicket
    }

    private fun isSeatValid(row: Int, number: Int): Boolean {
        if (row < 0 || number < 0) {
            return false
        }
        return !(row > TOTAL_ROWS || number > SEATS_PER_ROW)
    }

    private fun isSeatAvailable(row: Int, number: Int): Boolean {
        return findSeat(row, number) != null
    }

    private fun calculatePrice(row: Int): Int {
        val price = BASE_PRICE
        if (row > LAST_FRONT_ROW) {
            return price
        }
        return price + FRONT_ROW_CHARGE
    }

    private fun findSeat(row: Int, number: Int): Seat? {
        return availableSeats.find { it.row == row && it.number == number }
    }
}

private const val SEATS_PER_ROW = 9
private const val TOTAL_ROWS = 9
private const val LAST_FRONT_ROW = 4
private const val BASE_PRICE = 8
private const val FRONT_ROW_CHARGE = 2

package cinema.seats

import org.springframework.stereotype.Service

@Service
class SeatService {

    fun getSeats(): List<Seat> {
        val seats: MutableList<Seat> = mutableListOf()
        val range = 1..SEATS_EACH
        for (row in range) {
            for (column in range) {
                seats.add(Seat(row, column))
            }
        }
        return seats
    }
}

private const val SEATS_EACH = 9

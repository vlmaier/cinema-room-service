package cinema.room

import org.springframework.stereotype.Service

@Service
class RoomService {

    fun getAvailableSeats(): List<Seat> {
        val seats: MutableList<Seat> = mutableListOf()
        val seatsPerRow = 1..SEATS_PER_ROW
        val totalRows = 1..TOTAL_ROWS
        for (row in totalRows) {
            for (number in seatsPerRow) {
                seats.add(Seat(row, number))
            }
        }
        return seats
    }
}

private const val SEATS_PER_ROW = 9
private const val TOTAL_ROWS = 9

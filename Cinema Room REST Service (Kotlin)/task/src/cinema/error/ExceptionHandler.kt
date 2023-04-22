package cinema.error

import cinema.model.ErrorInfo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UnavailableSeatException::class, InvalidSeatException::class)
    fun onInvalidSeatException(e: RuntimeException): ResponseEntity<ErrorInfo> {
        val error = ErrorInfo(
            message = e.message ?: ""
        )
        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }
}

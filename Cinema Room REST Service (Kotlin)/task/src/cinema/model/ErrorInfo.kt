package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorInfo(
    @JsonProperty("error")
    val message: String,
)

package cinema.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ReturnRequest(
    @JsonProperty("token")
    val token: String,
)

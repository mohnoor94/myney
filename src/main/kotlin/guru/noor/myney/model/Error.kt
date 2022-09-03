package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

/**
 * An error model.
 *
 * @property code The error code.
 * @property message The error message.
 */
data class Error(
    @JsonProperty("code")
    @Schema(example = "1001", required = true, description = "Error code")
    val code: Int,

    @JsonProperty("message")
    @Schema(example = "Account not found", required = true, description = "Error message")
    val message: String,
)

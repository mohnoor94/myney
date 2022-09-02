package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.ZonedDateTime


/**
 * An account model.
 *
 * @property id The id of the account.
 * @property name The name of the account.
 * @property balance The balance of the account.
 * @property currency The currency of the account.
 * @property createdAt The date of creation of the account.
 */
data class Account(
    @JsonProperty("id")
    @Schema(example = "b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Account ID")
    val id: String,

    @JsonProperty("name")
    @Schema(example = "Mohammad Noor", required = true, description = "Account name")
    val name: String,

    @JsonProperty("balance")
    @Schema(example = "25000", required = true, description = "Account balance")
    val balance: BigDecimal,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Account currency")
    val currency: String,

    @JsonProperty("createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX z")
    @Schema(example = "2022-09-02T23:13:19.534+03:00 EEST", required = true, description = "Account creation date")
    val createdAt: ZonedDateTime,
)
package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.ZonedDateTime

/**
 * A transaction model.
 *
 * @property id the id of the transaction.
 * @property accountId the id of the receiving account.
 * @property amount the amount of the transaction.
 * @property currency the currency of the transaction.
 * @property createdAt the date & time of the transaction.
 */
data class Transaction(
    @JsonProperty("id")
    @Schema(example = "1b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Transaction ID")
    val id: String,

    @JsonProperty("accountId")
    @Schema(example = "1b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Transaction ID")
    val accountId: String,

    @JsonProperty("amount")
    @Schema(example = "2500", required = true, description = "Transaction amount")
    val amount: BigDecimal,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Transaction currency")
    val currency: String,

    @JsonProperty("createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX z")
    @Schema(example = "2022-09-02T23:13:19.534+03:00 EEST", required = true, description = "Transaction creation date")
    val createdAt: ZonedDateTime,
)
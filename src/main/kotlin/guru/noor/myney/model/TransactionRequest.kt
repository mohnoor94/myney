package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

/**
 * A representation of thr minimal required data to create a new transaction.
 *
 * @property receiverAccountId the id of the receiver account.
 * @property amount the amount of the transaction.
 * @property currency the currency of the transaction.
 */
data class TransactionRequest(
    @JsonProperty("receiverAccountId")
    @Schema(example = "f981810b-f774-475a-95a8-75090a2603db", required = true, description = "Receiver Account ID")
    val receiverAccountId: String,

    @JsonProperty("amount")
    @Schema(example = "2500", required = true, description = "Transaction amount")
    val amount: BigDecimal,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Transaction currency")
    val currency: String,
)
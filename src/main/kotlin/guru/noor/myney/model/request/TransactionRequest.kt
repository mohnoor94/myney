package guru.noor.myney.model.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal

data class TransactionRequest(
    @JsonProperty("accountId")
    @Schema(example = "1b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Transaction ID")
    val accountId: String,

    @JsonProperty("amount")
    @Schema(example = "2500", required = true, description = "Transaction amount")
    val amount: BigDecimal,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Transaction currency")
    val currency: String,
)
package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import guru.noor.myney.model.request.TransactionRequest
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*

/**
 * A transaction model.
 *
 * @property id the id of the transaction.
 * @property senderAccountId the id of the sender account.
 * @property receiverAccountId the id of the receiver account.
 * @property amount the amount of the transaction.
 * @property currency the currency of the transaction.
 * @property createdAt the date & time of the transaction.
 */
data class Transaction(
    @JsonProperty("id")
    @Schema(example = "1b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Transaction ID")
    val id: String?,

    @JsonProperty("senderAccountId")
    @Schema(example = "1b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Receiver Account ID")
    val senderAccountId: String,

    @JsonProperty("receiverAccountId")
    @Schema(example = "f981810b-f774-475a-95a8-75090a2603db", required = true, description = "Receiver Account ID")
    val receiverAccountId: String,

    @JsonProperty("amount")
    @Schema(example = "2500", required = true, description = "Transaction amount")
    val amount: BigDecimal,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Transaction currency")
    val currency: String,

    @JsonProperty("createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX z")
    @Schema(example = "2022-09-02T23:13:19.534+03:00 EEST", required = true, description = "Transaction creation date")
    val createdAt: ZonedDateTime?,
) {

    companion object {

        /**
         * Creates a new transaction.
         *
         * @param senderAccountId the id of the sending account.
         * @param receiverAccountId the id of the receiving account.
         * @param amount the amount of the transaction.
         * @param currency the currency of the transaction.
         * @return a new transaction.
         */
        fun create(
            senderAccountId: String,
            receiverAccountId: String,
            amount: BigDecimal,
            currency: String,
        ): Transaction {
            return Transaction(
                id = UUID.randomUUID().toString(),
                senderAccountId = senderAccountId,
                receiverAccountId = receiverAccountId,
                amount = amount,
                currency = currency,
                createdAt = ZonedDateTime.now()
            )
        }

        /**
         * Creates a new transaction from a transaction request and a sender accountID.
         *
         * @param senderAccountId the id of the sending account.
         * @param transactionRequest the transaction request.
         * @return a new transaction.
         */
        fun from(
            senderAccountId: String,
            transactionRequest: TransactionRequest,
        ): Transaction {
            return create(
                senderAccountId = senderAccountId,
                receiverAccountId = transactionRequest.receiverAccountId,
                amount = transactionRequest.amount,
                currency = transactionRequest.currency
            )
        }
    }
}
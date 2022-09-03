package guru.noor.myney.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import guru.noor.myney.common.EMPTY_STRING
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table


/**
 * An account model.
 *
 * @property id The id of the account.
 * @property name The name of the account.
 * @property balance The balance of the account.
 * @property currency The currency of the account.
 * @property createdAt The date of creation of the account.
 */
@Entity
@Table(name = "accounts")
class Account(
    @Id
    @JsonProperty("id")
    @Schema(example = "b3ef0159-6149-43b1-a54f-c75144e64931", required = true, description = "Account ID")
    val id: String = EMPTY_STRING,

    @JsonProperty("name")
    @Schema(example = "Mohammad Noor", required = true, description = "Account name")
    val name: String = EMPTY_STRING,

    @JsonProperty("balance")
    @Schema(example = "25000", required = true, description = "Account balance")
    var balance: BigDecimal = BigDecimal.ZERO,

    @JsonProperty("currency")
    @Schema(example = "USD", required = true, description = "Account currency")
    val currency: String = "USD",

    @JsonProperty("createdAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX z")
    @Schema(example = "2022-09-02T23:13:19.534+03:00 EEST", required = true, description = "Account creation date")
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
) {



    companion object {

        /**
         * Creates a new account.
         *
         * @param name The name of the account.
         * @param balance The balance of the account.
         * @param currency The currency of the account.
         * @param createdAt The date of creation of the account.
         * @return The created account.
         */
        fun create(
            name: String,
            balance: BigDecimal,
            currency: String = "USD",
            createdAt: ZonedDateTime = ZonedDateTime.now(),
        ): Account = Account(
            UUID.randomUUID().toString(),
            name,
            balance,
            currency,
            createdAt
        )
    }

    override fun toString(): String {
        return "Account(id='$id', name='$name', balance=$balance, currency='$currency', createdAt=$createdAt)"
    }
}
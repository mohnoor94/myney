package guru.noor.myney.error

/**
 * A general Myney exception.
 */
data class MyneyException(
    private val error: Error,
    private val throwable: Throwable? = null,
) : RuntimeException("[${error.code}] ${error.message}", throwable)

enum class Error(val code: Int, val message: String) {
    ACCOUNT_NOT_FOUND(1001, "Account not found"),
    ACCOUNT_ALREADY_EXISTS(1002, "Account already exists"),
    ACCOUNT_NOT_ACTIVE(1003, "Account not active"),

    BALANCE_NOT_ENOUGH(2001, "Account not enough balance"),

    TRANSACTION_NOT_FOUND(3001, "Transaction not found"),
    TRANSACTION_SENDER_NOT_FOUND(3002, "Transaction sender not found"),
    TRANSACTION_RECEIVER_NOT_FOUND(3003, "Transaction receiver not found"),
    TRANSACTION_AMOUNT_INSUFFICIENT(3004, "Transaction amount insufficient"),
    TRANSACTION_AMOUNT_NEGATIVE(3005, "Transaction amount negative"),
}
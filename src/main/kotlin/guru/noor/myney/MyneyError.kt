package guru.noor.myney

import guru.noor.myney.model.Error

/**
 * A general Myney exception.
 */
data class MyneyError(
    private val errorType: ErrorType,
    private val throwable: Throwable? = null,
) : RuntimeException(errorType.error.message, throwable)

enum class ErrorType(val error: Error) {
    ACCOUNT_NOT_FOUND(Error(1001, "Account not found")),
    ACCOUNT_ALREADY_EXISTS(Error(1002, "Account already exists")),
    ACCOUNT_NOT_ACTIVE(Error(1003, "Account not active")),

    BALANCE_NOT_ENOUGH(Error(2001, "Account not enough balance")),

    TRANSACTION_NOT_FOUND(Error(3001, "Transaction not found")),
    TRANSACTION_SENDER_NOT_FOUND(Error(3002, "Transaction sender not found")),
    TRANSACTION_RECEIVER_NOT_FOUND(Error(3003, "Transaction receiver not found")),
    TRANSACTION_AMOUNT_INSUFFICIENT(Error(3004, "Transaction amount insufficient")),
    TRANSACTION_AMOUNT_NEGATIVE(Error(3005, "Transaction amount negative")),
}
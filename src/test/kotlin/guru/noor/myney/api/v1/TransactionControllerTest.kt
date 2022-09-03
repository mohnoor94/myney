package guru.noor.myney.api.v1

import guru.noor.myney.mock.dao.TransactionRepositoryMock
import guru.noor.myney.model.Transaction
import guru.noor.myney.model.TransactionRequest
import guru.noor.myney.service.DefaultTransactionService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TransactionControllerTest {
    @Test
    fun `Assert that the controller is not null`() {
        val transactionRepository = TransactionRepositoryMock()
        val transactionController = TransactionController(DefaultTransactionService(transactionRepository))

        assertNotNull(transactionController)
    }

    @Test
    fun `Test getting an account`() {
        val transactionRepository = TransactionRepositoryMock()
        val transaction = Transaction.create("SenderId", "ReceiverId", 10.toBigDecimal())
        val transactionController = TransactionController(DefaultTransactionService(transactionRepository))

        transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction)).let {
            assertNotNull(it)
            assertEquals(transaction.senderAccountId, it.senderAccountId)
            assertEquals(transaction.receiverAccountId, it.receiverAccountId)
            assertEquals(transaction.amount, it.amount)
            assertEquals(transaction.currency, it.currency)
        }
    }

    private fun fromTransaction(transaction: Transaction): TransactionRequest {
        return TransactionRequest(
            transaction.receiverAccountId,
            transaction.amount,
            transaction.currency
        )
    }
}

package guru.noor.myney.api.v1

import guru.noor.myney.dao.AccountRepository
import guru.noor.myney.dao.TransactionRepository
import guru.noor.myney.error.MyneyException
import guru.noor.myney.mock.dao.AccountRepositoryMock
import guru.noor.myney.mock.dao.TransactionRepositoryMock
import guru.noor.myney.model.Account
import guru.noor.myney.model.Transaction
import guru.noor.myney.model.TransactionRequest
import guru.noor.myney.service.AccountService
import guru.noor.myney.service.DefaultAccountService
import guru.noor.myney.service.DefaultTransactionService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TransactionControllerTest {
    private lateinit var accountRepository: AccountRepository
    private lateinit var sender: Account
    private lateinit var receiver: Account
    private lateinit var accountService: AccountService
    private lateinit var transactionRepository: TransactionRepository

    @BeforeEach
    fun setUp() {
        accountRepository = AccountRepositoryMock()
        sender = accountRepository.save(Account.create("Sender", 1000.toBigDecimal()))
        receiver = accountRepository.save(Account.create("Receiver", 25.toBigDecimal()))
        accountService = DefaultAccountService(accountRepository)
        transactionRepository = TransactionRepositoryMock()
    }

    @Test
    fun `Assert that the controller is not null`() {
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        assertNotNull(transactionController)
    }

    @Test
    fun `Test creating a transaction`() {
        val transaction = Transaction.create(sender.id, receiver.id, 100.toBigDecimal())
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction)).let {
            assertNotNull(it)
            assertEquals(transaction.senderAccountId, it.senderAccountId)
            assertEquals(transaction.receiverAccountId, it.receiverAccountId)
            assertEquals(transaction.amount, it.amount)
            assertEquals(transaction.currency, it.currency)

            assertEquals(900.toBigDecimal(), accountService.findById(transaction.senderAccountId).balance)
            assertEquals(125.toBigDecimal(), accountService.findById(transaction.receiverAccountId).balance)
        }
    }

    @Test
    fun `Test creating a transaction with invalid sender account`() {
        val transaction = Transaction.create("invalid", receiver.id, 100.toBigDecimal())
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        assertThrows<MyneyException> {
            transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction))
        }
    }

    @Test
    fun `Test creating a transaction with invalid receiver account`() {
        val transaction = Transaction.create(sender.id, "invalid", 100.toBigDecimal())
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        assertThrows<MyneyException> {
            transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction))
        }
    }

    @Test
    fun `Test creating a transaction with insufficient amount`() {
        val transaction = Transaction.create(sender.id, receiver.id, 1500.toBigDecimal())
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        assertThrows<MyneyException> {
            transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction))
        }
    }

    @Test
    fun `Test creating a transaction with negative amount`() {
        val transaction = Transaction.create(sender.id, receiver.id, (-100).toBigDecimal())
        val transactionController = TransactionController(
            DefaultTransactionService(transactionRepository),
            accountService
        )

        assertThrows<MyneyException> {
            transactionController.sendMoney(transaction.senderAccountId, fromTransaction(transaction))
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

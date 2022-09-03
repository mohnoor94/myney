package guru.noor.myney.service

import guru.noor.myney.dao.TransactionRepository
import guru.noor.myney.error.Error
import guru.noor.myney.error.MyneyException
import guru.noor.myney.model.Transaction
import org.springframework.stereotype.Service

interface TransactionService {
    /** Get all transactions */
    fun findAll(): List<Transaction>

    /** Get transaction by id */
    fun findById(id: String): Transaction

    /** Create new transaction */
    fun save(transaction: Transaction): Transaction
}

@Service
class DefaultTransactionService(
    private val transactionRepository: TransactionRepository,
) : TransactionService {
    override fun findAll(): List<Transaction> = transactionRepository.findAll()

    override fun findById(id: String): Transaction =
        transactionRepository.findById(id).orElseThrow { MyneyException(Error.ACCOUNT_NOT_FOUND) }

    override fun save(transaction: Transaction): Transaction = transactionRepository.save(transaction)
}
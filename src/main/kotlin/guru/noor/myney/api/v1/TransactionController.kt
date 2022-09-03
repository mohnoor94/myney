package guru.noor.myney.api.v1

import guru.noor.myney.model.Transaction
import guru.noor.myney.model.TransactionRequest
import guru.noor.myney.service.AccountService
import guru.noor.myney.service.TransactionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

/**
 * V1 APIs for the transaction service.
 */
@RestController
@RequestMapping("/v1/accounts/{id}/transactions")
class TransactionController(
    private val transactionService: TransactionService,
    private val accountService: AccountService,
) {

    @PostMapping
    fun sendMoney(@PathVariable id: String, @RequestBody transactionRequest: TransactionRequest): Transaction {
        val sender = accountService.findById(id)
        val receiver = accountService.findById(transactionRequest.receiverAccountId)

        accountService.withdraw(sender, transactionRequest.amount).let {
            log.info("Withdrawn ${transactionRequest.currency} ${transactionRequest.amount} from account $id")
        }

        accountService.deposit(receiver, transactionRequest.amount).let {
            log.info("Deposited ${transactionRequest.currency} ${transactionRequest.amount} to account ${transactionRequest.receiverAccountId}")
        }

        return transactionService.save(Transaction.from(id, transactionRequest)).also {
            log.info("Transaction request from account {} with the details: {}", id, transactionRequest)
            log.info("Transaction created: {}", it)
        }
    }

    // I know, I know, this is not a good idea, but it's just for demo purposes.
    // `id` is ignored for this demo.
    @GetMapping
    fun getAllTransactions(@PathVariable id: String): List<Transaction> {
        transactionService.findAll().let {
            log.info("Returning ${it.size} transactions")
            return it
        }
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(TransactionController::class.java)
    }
}
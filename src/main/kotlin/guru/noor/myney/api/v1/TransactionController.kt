package guru.noor.myney.api.v1

import guru.noor.myney.model.Transaction
import guru.noor.myney.model.TransactionRequest
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
) {

    @PostMapping
    fun sendMoney(@PathVariable id: String, @RequestBody transactionRequest: TransactionRequest): Transaction {
        return transactionService.save(Transaction.from(id, transactionRequest)).also {
            log.info("Transaction request from account {} with the details: {}", id, transactionRequest)
            log.info("Transaction created: {}", it)
        }
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(TransactionController::class.java)
    }
}
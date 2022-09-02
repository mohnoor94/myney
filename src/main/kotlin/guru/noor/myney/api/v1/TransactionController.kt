package guru.noor.myney.api.v1

import guru.noor.myney.model.Transaction
import guru.noor.myney.model.request.TransactionRequest
import org.springframework.web.bind.annotation.*

/**
 * V1 APIs for the transaction service.
 */
@RestController
@RequestMapping("/v1/accounts/{id}/transactions")
class TransactionController {

    @PostMapping
    fun sendMoney(@PathVariable id: String, @RequestBody transactionRequest: TransactionRequest): Transaction {
        println("Transaction: $transactionRequest")

        return Transaction.from(transactionRequest)
    }
}
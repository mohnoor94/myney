package guru.noor.myney.api.v1

import guru.noor.myney.model.Account
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * V1 API for the Account service.
 */
@RestController
@RequestMapping("/v1/accounts")
class AccountController {

    @GetMapping("{id}")
    fun getAccount(@PathVariable id: String): Account {
        // TODO: implement
        return Account.create("Noor", 100, "USD").also {
            log.info("Returning account $it")
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(AccountController::class.java)
    }

}
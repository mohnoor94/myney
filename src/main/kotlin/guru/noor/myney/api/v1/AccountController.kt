package guru.noor.myney.api.v1

import guru.noor.myney.model.Account
import guru.noor.myney.service.AccountService
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
class AccountController(
    private val accountService: AccountService,
) {

    @GetMapping("{id}")
    fun getAccount(@PathVariable id: String): Account {
        log.info("Getting account with id: $id")

        accountService.findById(id).let {
            log.info("Returning account $it")
            return it
        }
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(AccountController::class.java)
    }

}
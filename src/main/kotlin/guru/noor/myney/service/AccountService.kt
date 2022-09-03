package guru.noor.myney.service

import guru.noor.myney.dao.AccountRepository
import guru.noor.myney.model.Account
import org.springframework.stereotype.Service

interface AccountService {
    /** Get all accounts */
    fun findAll(): List<Account>

    /** Get account by id */
    fun findById(id: String): Account

    /** Create new account */
    fun save(account: Account): Account
}

@Service
class DefaultAccountService(
    private val accountRepository: AccountRepository,
) : AccountService {
    override fun findAll(): List<Account> = accountRepository.findAll()

    override fun findById(id: String): Account =
        accountRepository.findById(id).orElseThrow { RuntimeException("Account not found") }

    override fun save(account: Account): Account = accountRepository.save(account)
}
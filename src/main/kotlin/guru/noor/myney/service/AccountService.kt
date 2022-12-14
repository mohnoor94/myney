package guru.noor.myney.service

import guru.noor.myney.dao.AccountRepository
import guru.noor.myney.error.Error
import guru.noor.myney.error.MyneyException
import guru.noor.myney.model.Account
import org.springframework.stereotype.Service
import java.math.BigDecimal

interface AccountService {
    /** Get all accounts */
    fun findAll(): List<Account>

    /** Get account by id */
    fun findById(id: String): Account

    /** Create new account */
    fun save(account: Account): Account

    /** Delete amount to account */
    fun deposit(account: Account, amount: BigDecimal): Account


    /** Withdraw amount from account */
    fun withdraw(account: Account, amount: BigDecimal): Account
}

@Service
class DefaultAccountService(
    private val accountRepository: AccountRepository,
) : AccountService {
    override fun findAll(): List<Account> = accountRepository.findAll()

    override fun findById(id: String): Account {
        return accountRepository.findById(id).orElseThrow { MyneyException(Error.ACCOUNT_NOT_FOUND) }
    }

    override fun save(account: Account): Account = accountRepository.save(account)

    override fun deposit(account: Account, amount: BigDecimal): Account {
        if (amount <= BigDecimal.ZERO) {
            throw MyneyException(Error.TRANSACTION_AMOUNT_NEGATIVE)
        }

        account.balance = account.balance.add(amount)
        return accountRepository.save(account)
    }

    override fun withdraw(account: Account, amount: BigDecimal): Account {
        if (amount <= BigDecimal.ZERO) {
            throw MyneyException(Error.TRANSACTION_AMOUNT_NEGATIVE)
        }

        if (account.balance < amount) {
            throw MyneyException(Error.TRANSACTION_AMOUNT_INSUFFICIENT)
        }

        account.balance = account.balance.subtract(amount)
        return accountRepository.save(account)
    }
}
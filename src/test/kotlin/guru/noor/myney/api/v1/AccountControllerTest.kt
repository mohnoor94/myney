package guru.noor.myney.api.v1

import guru.noor.myney.mock.dao.AccountRepositoryMock
import guru.noor.myney.model.Account
import guru.noor.myney.service.DefaultAccountService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class AccountControllerTest {
    @Test
    fun `Assert that the controller is not null`() {
        val accountRepository = AccountRepositoryMock()
        val accountController = AccountController(DefaultAccountService(accountRepository))

        assertNotNull(accountController)
    }

    @Test
    fun `Test getting an account`() {
        val accountRepository = AccountRepositoryMock()
        val account: Account = accountRepository.save(Account.create("Test Account", 1000.toBigDecimal()))
        val accountController = AccountController(DefaultAccountService(accountRepository))

        accountController.getAccount(account.id).let {
            assertNotNull(it)
            assertSame(account, it)
        }
    }
}
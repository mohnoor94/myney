package guru.noor.myney

import guru.noor.myney.api.v1.AccountController
import guru.noor.myney.api.v1.TransactionController
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApplicationTests(
    @Autowired private val accountController: AccountController,
    @Autowired private val transactionController: TransactionController,
) {

    @Test
    fun contextLoads() {
        assertNotNull(accountController)
        assertNotNull(transactionController)
    }

}

package guru.noor.myney.dao


import guru.noor.myney.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String>
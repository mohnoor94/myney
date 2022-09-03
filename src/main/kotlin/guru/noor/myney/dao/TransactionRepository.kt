package guru.noor.myney.dao


import guru.noor.myney.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, String>
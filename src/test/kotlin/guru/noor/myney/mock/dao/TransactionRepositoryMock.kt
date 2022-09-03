package guru.noor.myney.mock.dao

import guru.noor.myney.dao.TransactionRepository
import guru.noor.myney.mock.InMemoryStore
import guru.noor.myney.model.Transaction
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class TransactionRepositoryMock : TransactionRepository {
    private val transactions = InMemoryStore<Transaction>()

    override fun <S : Transaction> save(entity: S): S = transactions.save(entity) { entity.id }
    override fun findById(id: String): Optional<Transaction> = transactions.get(id)
    override fun findAll(): MutableList<Transaction> = transactions.getAll()
    override fun deleteAll(entities: MutableIterable<Transaction>): Unit = transactions.clear()


    override fun <S : Transaction?> saveAll(entities: MutableIterable<S>): MutableList<S> = TODO("Not yet implemented")
    override fun existsById(id: String): Boolean = TODO("Not yet implemented")
    override fun findAll(sort: Sort): MutableList<Transaction> = TODO("Not yet implemented")
    override fun <S : Transaction?> findAll(example: Example<S>): MutableList<S> = TODO("Not yet implemented")
    override fun <S : Transaction?> findAll(example: Example<S>, sort: Sort): MutableList<S> = TODO("Not yet implemented")
    override fun findAll(pageable: Pageable): Page<Transaction> = TODO("Not yet implemented")
    override fun <S : Transaction?> findAll(example: Example<S>, pageable: Pageable): Page<S> = TODO("Not yet implemented")
    override fun findAllById(ids: MutableIterable<String>): MutableList<Transaction> = TODO("Not yet implemented")
    override fun count(): Long = TODO("Not yet implemented")
    override fun <S : Transaction?> count(example: Example<S>): Long = TODO("Not yet implemented")
    override fun deleteById(id: String): Unit = TODO("Not yet implemented")
    override fun delete(entity: Transaction): Unit = TODO("Not yet implemented")
    override fun deleteAllById(ids: MutableIterable<String>): Unit = TODO("Not yet implemented")
    override fun deleteAll(): Unit = TODO("Not yet implemented")
    override fun <S : Transaction?> findOne(example: Example<S>): Optional<S> = TODO("Not yet implemented")
    override fun <S : Transaction?> exists(example: Example<S>): Boolean = TODO("Not yet implemented")
    override fun flush(): Unit = TODO("Not yet implemented")
    override fun <S : Transaction?> saveAndFlush(entity: S): S = TODO("Not yet implemented")
    override fun deleteAllInBatch(entities: MutableIterable<Transaction>): Unit = TODO("Not yet implemented")
    override fun deleteAllInBatch(): Unit = TODO("Not yet implemented")
    override fun deleteAllByIdInBatch(ids: MutableIterable<String>): Unit = TODO("Not yet implemented")
    override fun getOne(id: String): Transaction = TODO("Not yet implemented")
    override fun getById(id: String): Transaction = TODO("Not yet implemented")
    override fun getReferenceById(id: String): Transaction = TODO("Not yet implemented")

    override fun <S : Transaction?, R : Any?> findBy(
        example: Example<S>, queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>,
    ): R = TODO("Not yet implemented")

    override fun <S : Transaction?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> =
        TODO("Not yet implemented")
}
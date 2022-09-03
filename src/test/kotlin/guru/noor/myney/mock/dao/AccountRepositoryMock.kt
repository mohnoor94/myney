package guru.noor.myney.mock.dao

import guru.noor.myney.dao.AccountRepository
import guru.noor.myney.mock.InMemoryStore
import guru.noor.myney.model.Account
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import java.util.*
import java.util.function.Function

class AccountRepositoryMock : AccountRepository {
    private val accounts = InMemoryStore<Account>()

    override fun <S : Account> save(entity: S): S = accounts.save(entity) { entity.id }
    override fun findById(id: String): Optional<Account> = accounts.get(id)
    override fun findAll(): MutableList<Account> = accounts.getAll()
    override fun deleteAll(entities: MutableIterable<Account>): Unit = accounts.clear()


    override fun <S : Account?> saveAll(entities: MutableIterable<S>): MutableList<S> = TODO("Not yet implemented")
    override fun existsById(id: String): Boolean = TODO("Not yet implemented")
    override fun findAll(sort: Sort): MutableList<Account> = TODO("Not yet implemented")
    override fun <S : Account?> findAll(example: Example<S>): MutableList<S> = TODO("Not yet implemented")
    override fun <S : Account?> findAll(example: Example<S>, sort: Sort): MutableList<S> = TODO("Not yet implemented")
    override fun findAll(pageable: Pageable): Page<Account> = TODO("Not yet implemented")
    override fun <S : Account?> findAll(example: Example<S>, pageable: Pageable): Page<S> = TODO("Not yet implemented")
    override fun findAllById(ids: MutableIterable<String>): MutableList<Account> = TODO("Not yet implemented")
    override fun count(): Long = TODO("Not yet implemented")
    override fun <S : Account?> count(example: Example<S>): Long = TODO("Not yet implemented")
    override fun deleteById(id: String): Unit = TODO("Not yet implemented")
    override fun delete(entity: Account): Unit = TODO("Not yet implemented")
    override fun deleteAllById(ids: MutableIterable<String>): Unit = TODO("Not yet implemented")
    override fun deleteAll(): Unit = TODO("Not yet implemented")
    override fun <S : Account?> findOne(example: Example<S>): Optional<S> = TODO("Not yet implemented")
    override fun <S : Account?> exists(example: Example<S>): Boolean = TODO("Not yet implemented")
    override fun flush(): Unit = TODO("Not yet implemented")
    override fun <S : Account?> saveAndFlush(entity: S): S = TODO("Not yet implemented")
    override fun deleteAllInBatch(entities: MutableIterable<Account>): Unit = TODO("Not yet implemented")
    override fun deleteAllInBatch(): Unit = TODO("Not yet implemented")
    override fun deleteAllByIdInBatch(ids: MutableIterable<String>): Unit = TODO("Not yet implemented")
    override fun getOne(id: String): Account = TODO("Not yet implemented")
    override fun getById(id: String): Account = TODO("Not yet implemented")
    override fun getReferenceById(id: String): Account = TODO("Not yet implemented")

    override fun <S : Account?, R : Any?> findBy(
        example: Example<S>, queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>,
    ): R = TODO("Not yet implemented")

    override fun <S : Account?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> =
        TODO("Not yet implemented")
}
package guru.noor.myney.mock

import java.util.*

typealias IdSupplier = () -> String

interface BasicStore<T> {
    fun <S : T> save(item: T, idSupplier: IdSupplier): S
    fun get(id: String): Optional<T>
    fun getAll(): List<T>
    fun clear()
}

class InMemoryStore<T : Any>(
    private val items: MutableMap<String, T> = mutableMapOf(),
) : BasicStore<T> {

    override fun <S : T> save(item: T, idSupplier: IdSupplier): S {
        val id = idSupplier()
        items[id] = item
        return item as S
    }

    override fun get(id: String): Optional<T> = Optional.ofNullable(items[id])

    override fun getAll(): MutableList<T> = items.values.toMutableList()

    override fun clear() = items.clear()
}
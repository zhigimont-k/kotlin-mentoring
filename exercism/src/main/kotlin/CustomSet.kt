class CustomSet(private val items: MutableSet<Any> = mutableSetOf()):
    MutableSet<Any> by items {

    constructor(vararg input: Any): this(mutableSetOf()) {
        input.forEach { items.add(it) }
    }

    fun isSubset(that: CustomSet): Boolean =
        items.all { that.items.contains(it) }

    fun isDisjoint(that: CustomSet): Boolean = intersection(that).isEmpty()

    fun intersection(that: CustomSet): CustomSet =
        fromSet(items.intersect(that.items))

    operator fun plus(that: CustomSet): CustomSet =
        fromSet(items.plus(that.items))

    operator fun minus(that: CustomSet): CustomSet =
        fromSet(items.minus(that.items))

    override fun equals(other: Any?): Boolean = when(other) {
        is CustomSet -> items == other.items
        else    -> false
    }

    private fun fromSet(items: Set<Any>): CustomSet =
        CustomSet().apply { addAll(items) }
}

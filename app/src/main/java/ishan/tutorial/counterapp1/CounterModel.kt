package ishan.tutorial.counterapp1

class CounterRepository {
    private var _count = 0

    fun getCounter(): Int = _count
    fun incrementCounter() {
        _count++
    }

    fun decrementCounter() {
        _count--
    }
}

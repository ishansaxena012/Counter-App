package ishan.tutorial.counterapp1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {

    private val repository = CounterRepository()
    private val _count = MutableStateFlow(repository.getCounter())
    val count: StateFlow<Int> = _count

    fun increment() {
        repository.incrementCounter()
        _count.value = repository.getCounter()
    }

    fun decrement() {
        repository.decrementCounter()
        _count.value = repository.getCounter()
    }
}

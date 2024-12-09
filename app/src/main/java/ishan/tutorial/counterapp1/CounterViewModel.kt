package ishan.tutorial.counterapp1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel() : ViewModel() {

    private val _repository: CounterRepository = CounterRepository()
    private val _count = MutableStateFlow(_repository.getCounter().count)  // Use MutableStateFlow for counter value
    val count: StateFlow<Int> = _count       // Expose count as StateFlow

    fun increment() {
        _repository.incrementCounter()
        _count.value =_repository.getCounter().count
    }

    fun decrement() {
        _repository.decrementCounter()
        _count.value =_repository.getCounter().count
    }
}

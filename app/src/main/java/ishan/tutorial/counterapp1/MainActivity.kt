package ishan.tutorial.counterapp1


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: CounterViewModel = viewModel()
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CounterApp(viewModel)
            }
        }
    }
}

@Composable
fun CounterApp(viewModel: CounterViewModel) {
    // Collect the counter value from StateFlow
    val count = viewModel.count.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter: ${count.value}")  // Display the current counter value
        Button(onClick = { viewModel.increment() }) {
            Text(text = "Increment")
        }
        Button(onClick = { viewModel.decrement() }) {
            Text(text = "Decrement")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // Create a temporary ViewModel for preview purposes
    val mockViewModel = CounterViewModel()
    CounterApp(viewModel = mockViewModel)
}

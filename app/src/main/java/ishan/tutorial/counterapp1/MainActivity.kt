package ishan.tutorial.counterapp1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterApp()
        }
    }
}


@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.backgroundmaths),
            contentDescription = "Maths Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White.copy(alpha = 0.3f), shape = RoundedCornerShape(18.dp)) // Softer overlay
                .padding(20.dp)
        ) {
            // Title with Elegant Brown Gradient
            Text(
                text = "Counter",
                fontSize = 36.sp, // Increased slightly for prominence
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier
                    .shadow(8.dp, shape = RoundedCornerShape(14.dp))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF4E342E), Color(0xFF5D4037), Color(0xFFBCAAA4))
                        ),
                        shape = RoundedCornerShape(14.dp)
                    )
                    .padding(horizontal = 26.dp, vertical = 14.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            // Counter Number with Subtle Background
            Text(
                text = "$count",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .shadow(5.dp, shape = RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFF5D4037), Color(0xFFBCAAA4)) // Warm brown gradient
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .border(1.2.dp, Color(0xFF8D6E63), shape = RoundedCornerShape(16.dp)) // Refined border
                    .padding(horizontal = 18.dp, vertical = 12.dp)
            )

            Spacer(modifier = Modifier.height(22.dp))

            // Buttons with Warm Earthy Colors
            Row {
                Button(
                    onClick = { count++ },
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8D6E63)), // Warm Coffee Brown
                    modifier = Modifier
                        .padding(8.dp)
                        .shadow(6.dp, shape = RoundedCornerShape(14.dp))
                ) {
                    Text(text = "Increment", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }

                Button(
                    onClick = { count-- },
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC2A67E)), // Earthy Beige
                    modifier = Modifier
                        .padding(8.dp)
                        .shadow(6.dp, shape = RoundedCornerShape(14.dp))
                ) {
                    Text(text = "Decrement", color = Color.White, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

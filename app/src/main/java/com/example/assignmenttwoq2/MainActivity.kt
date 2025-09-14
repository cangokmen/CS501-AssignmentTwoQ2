package com.example.assignmenttwoq2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.assignmenttwoq2.ui.theme.AssignmentTwoQ2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AssignmentTwoQ2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        ToggleCard()
                    }
                }
            }
        }
    }
}

@Composable
fun ToggleCard(
    initialMessage: String = "Tap to see a fun fact!",
    toggledMessage: String = "Kotlin was created by JetBrains!",
    modifier: Modifier = Modifier
) {
    var toggled by rememberSaveable { mutableStateOf(false) }

    val currentMessage = if (toggled) toggledMessage else initialMessage

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                toggled = !toggled
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3DDC84)
        )
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = currentMessage,
                textAlign = TextAlign.Center
            )
        }
    }
}



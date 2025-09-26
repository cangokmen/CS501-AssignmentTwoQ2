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

// MainActivity is the app's main entry point.
class MainActivity : ComponentActivity() {
    // onCreate is called when the activity is first created to build the UI.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent is used to define the layout with Jetpack Compose.
        setContent {
            AssignmentTwoQ2Theme {
                // Surface acts as a main container with a background color.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Box is used here to center its content on the screen.
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(50.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        // Display the custom ToggleCard composable.
                        ToggleCard()
                    }
                }
            }
        }
    }
}

/**
 * A composable that displays a card with text that changes when tapped.
 *
 * @param initialMessage The message shown before the first tap.
 * @param toggledMessage The message shown after the card has been tapped.
 * @param modifier A Modifier for customizing the card's layout and appearance.
 */
@Composable
fun ToggleCard(
    initialMessage: String = "Tap to see a fun fact!",
    toggledMessage: String = "Kotlin was created by JetBrains!",
    modifier: Modifier = Modifier
) {
    // 'rememberSaveable' preserves the toggled state across configuration changes (like screen rotation).
    var toggled by rememberSaveable { mutableStateOf(false) }

    // Determines which message to display based on the 'toggled' state.
    val currentMessage = if (toggled) toggledMessage else initialMessage

    // The Card composable provides a styled container.
    Card(
        modifier = modifier
            .fillMaxWidth() // The card will take the full width of its parent.
            .wrapContentHeight() // The card's height will adjust to its content.
            .clickable {
                // This block is executed on tap, inverting the 'toggled' state.
                toggled = !toggled
            },
        // Sets the background color of the card.
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF3DDC84)
        )
    ) {
        // A Box to provide padding and center the text within the card.
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            // The Text composable displays the current message.
            Text(
                text = currentMessage,
                textAlign = TextAlign.Center
            )
        }
    }
}

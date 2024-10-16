package com.example.viewmodelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewmodelapp.ui.theme.ViewModelAppTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<ClickCountViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ClickCountContent(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun ClickCountContent(
    modifier: Modifier = Modifier,
    viewModel: ClickCountViewModel
) {
    val count by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 34.sp,
            text = count.toString(),
        )

        Button(onClick = {
            viewModel.increment()
        }) {
            Text(text = "Increment")
        }
    }
}


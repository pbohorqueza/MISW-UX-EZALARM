package com.miso.ezalarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.miso.ezalarm.ui.theme.EZAlarmTheme
import com.miso.ezalarm.ui.screens.EZAlarmMainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EZAlarmTheme {
                EZAlarmMainScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EZAlarmTheme {
        EZAlarmMainScreen()
    }
}
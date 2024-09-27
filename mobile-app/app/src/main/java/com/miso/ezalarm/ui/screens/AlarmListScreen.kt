package com.miso.ezalarm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.miso.ezalarm.ui.animations.AnimationAlarm

@Composable
fun AlarmListScreen(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimationAlarm(modifier = Modifier.size(150.dp))
            Spacer(modifier = Modifier.height(34.dp))
            Text(
                text = buildAnnotatedString {
                    append("Welcome to ")
                    pushStyle(SpanStyle(fontWeight = FontWeight.Bold))
                    append("EasyAlarm")
                    pop()
                    append(".\nEasyAlarm allows you to create alarms and group them according to useful categories, so now you can assign recognizable sounds.\nOn vacation? Don’t worry! just turn off work alarms tied to that category.")
                },
                style = MaterialTheme.typography.titleMedium,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                modifier = Modifier
                    .padding(start = 32.dp, end = 32.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(62.dp))
            Text("To start, create your first alarm",style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                ExtendedFloatingActionButton(
                    onClick = {
                        navigateToAlbumTab(navController)
                    },
                    icon = { Icon(Icons.Filled.Add, "Create Alarm") },
                    text = { Text(text = "Create Alarm") },
                    elevation = FloatingActionButtonDefaults.elevation(0.dp),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .padding(
                            start = 64.dp,
                            end = 64.dp
                        )
                        .height(36.dp)
                )
            }
        }
    }
}

private fun navigateToAlbumTab(navController: NavHostController) {
    navController.navigate(EZAlarmScreen.CREATE_ALARM.route) {
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }
}
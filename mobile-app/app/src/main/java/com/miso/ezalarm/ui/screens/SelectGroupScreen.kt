package com.miso.ezalarm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun SelectGroupScreen(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top=100.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            AlarmListItem(
                itemName="Work",
                itemNameColor = MaterialTheme.colorScheme.onSurface,
                onClick = {
                    navController.popBackStack()
                }
            )
            AlarmListItem(
                itemName="Family",
                itemNameColor = MaterialTheme.colorScheme.onSurface,
                onClick = {
                    navController.popBackStack()
                }
            )
            AlarmListItem(
                itemName="Birthdays",
                itemNameColor = MaterialTheme.colorScheme.onSurface,
                onClick = {
                    navController.popBackStack()
                }
            )
            AlarmListItem(
                itemName="Health",
                itemNameColor = MaterialTheme.colorScheme.onSurface,
                onClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
package com.miso.ezalarm.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.miso.ezalarm.ui.composables.ListDivider


@Composable
fun SelectRepeatScreen(
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
            AlarmListItemSwitch(
                itemName="Every Monday"
            )
            AlarmListItemSwitch(
                itemName="Every Tuesday"
            )
            AlarmListItemSwitch(
                itemName="Every Wednesday"
            )
            AlarmListItemSwitch(
                itemName="Every Thursday"
            )
            AlarmListItemSwitch(
                itemName="Every Friday"
            )
            AlarmListItemSwitch(
                itemName="Every Saturday"
            )
            AlarmListItemSwitch(
                itemName="Every Sunday"
            )
            AlarmListItemSwitch(
                itemName="Every Day"
            )
        }
    }
}



@Composable
fun AlarmListItemSwitch(
    itemName: String
    ) {

    var switchChecked by remember { mutableStateOf(false) }

    ListItem(
        modifier = Modifier
            .height(80.dp)
            .semantics { contentDescription = itemName },
        leadingContent = {

        },
        supportingContent = {

        },
        headlineContent = {
            Text(
                text = itemName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        },
        trailingContent = {
            Switch(
                checked = switchChecked,
                onCheckedChange = {
                    isChecked -> switchChecked = isChecked
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFFC1E8FF),
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedThumbColor = Color(0xFFC1E8FF),
                    uncheckedTrackColor = MaterialTheme.colorScheme.onPrimary
                )
            )

        }
    )
    ListDivider()
}
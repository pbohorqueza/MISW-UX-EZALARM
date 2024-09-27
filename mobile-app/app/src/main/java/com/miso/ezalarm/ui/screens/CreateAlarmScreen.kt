package com.miso.ezalarm.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Forward5
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.miso.ezalarm.R
import com.miso.ezalarm.ui.composables.ListDivider
import java.util.Calendar


@Composable
fun CreateAlarmScreen(
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
            /*    var selectedTime by remember { mutableStateOf("Select Time") }
            var showTimePicker by remember { mutableStateOf(false) }
            */

            EZTimePicker(
                onConfirm = {
                },
                onDismiss = {

                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            AlarmListItem(
                "Group",
                "Default",
                "Group your alarms by categories so you can easily manage them",
                Icons.Outlined.GridView,
                onClick = {
                    navController.navigate(EZAlarmScreen.SELECT_GROUP.route)
                }
            )
            AlarmListItem(
                "Label",
                "Alarm",
                "Give a name to your alarm",
                Icons.Filled.ChatBubbleOutline,
                onClick = {}
            )
            AlarmListItem("Repeat",
                "Never",
                "Set the frequency of your alarm",
                Icons.Filled.Forward5,
                onClick = {
                    navController.navigate(EZAlarmScreen.SELECT_REPEAT.route)
                }
            )
            Spacer(modifier = Modifier.height(28.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_action_name),
                contentDescription = "AI",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "You can also auto-generate your alarm\n" +
                        "by capturing an image",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))

            ExtendedFloatingActionButton(
                onClick = {

                },
                icon = { Icon(Icons.Filled.Add, "Create Alarm") },
                text = { Text(text = "Autogenerate with AI") },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZTimePicker(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF71B3D9),
                shape = MaterialTheme.shapes.medium
            )
            .padding(top = 34.dp, bottom = 0.dp, start = 34.dp, end = 34.dp)

    ) {
        Column {
            TimeInput(
                state = timePickerState,
                colors = TimePickerColors(
                    clockDialColor = Color.Red,
                    selectorColor = Color.Red,
                    containerColor = Color.Blue,
                    periodSelectorBorderColor = MaterialTheme.colorScheme.outline,
                    clockDialSelectedContentColor = Color.Red,
                    clockDialUnselectedContentColor = Color.Red,
                    periodSelectorSelectedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    periodSelectorUnselectedContainerColor = Color(0xFFE4E9EC),
                    periodSelectorSelectedContentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                    periodSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    timeSelectorSelectedContainerColor = Color(0xFF8CCFF6),
                    timeSelectorUnselectedContainerColor = Color(0xFFE2F3FF),
                    timeSelectorSelectedContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    timeSelectorUnselectedContentColor = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier
                    .focusRequester(focusRequester)
            )

            /* Button(onClick = onConfirm) {
            Text("Confirm selection")
        }
        */

        }
    }

    LaunchedEffect(Unit) {
        focusManager.clearFocus()
    }
}




@Composable
fun AlarmListItem(
    itemName: String,
    trailingSupportText: String? = null,
    itemSupportiveContent: String? = null,
    leadingIcon: ImageVector? = null,
    itemNameColor: Color = Color(0xFF0080A9),
    onClick: () -> Unit,

) {
    ListItem(
        modifier = Modifier
            .clickable { onClick() }
            .height(80.dp)
            .semantics { contentDescription = itemName },
        leadingContent = {
            leadingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = itemName,
                    tint = Color(0xFF0080A9)
                )
            }
        },
        supportingContent = {
            itemSupportiveContent?.let { // Only render if not null
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        },
        headlineContent = {
            Text(
                text = itemName,
                style = MaterialTheme.typography.bodyLarge,
                color = itemNameColor
            )
        },
        trailingContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    trailingSupportText?.let {
                        Text(
                            style = MaterialTheme.typography.labelLarge,
                            text = it,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowRight,
                        contentDescription = itemName
                    )
                }

        }
    )
    ListDivider()
}
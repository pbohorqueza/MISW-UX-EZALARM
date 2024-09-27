package com.miso.ezalarm.ui.screens

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.miso.ezalarm.R

enum class EZAlarmScreen(val route: String) {
    ALARM_LIST("alarm-list-section"),
    CREATE_ALARM("alarm-create-section"),
    SELECT_GROUP("select-group-section"),
    SELECT_REPEAT("select-repeat-section"),

}

enum class EZAlarmNavigationItem(
    val icon: ImageVector,
    @StringRes val label: Int,
    val route: String) {
    ALARMS(Icons.Outlined.Schedule, R.string.alarms, "alarms-section"),
    GROUPS(Icons.Outlined.GridView, R.string.groups, "groups-section"),
    SOUNDS(Icons.Filled.MusicNote, R.string.sounds, "sounds-section"),
    ACCOUNT(Icons.Filled.AccountCircle, R.string.account, "account-section"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EZAlarmTopAppBar(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    navigateUp: () -> Unit,
    currentRoute: String?
) {

    val title = when (currentRoute) {
        EZAlarmScreen.ALARM_LIST.route -> "Alarms"
        EZAlarmScreen.CREATE_ALARM.route -> "Create Alarm"
        EZAlarmScreen.SELECT_GROUP.route -> "Select Group"
        EZAlarmScreen.SELECT_REPEAT.route -> "Repeat"
        else -> "Alarms"
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { fullHeight -> -fullHeight }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { fullHeight -> -fullHeight }) + fadeOut(),
        content = {
            TopAppBar(
                title = { Text(
                    text = title,
                    color = MaterialTheme.colorScheme.primary
                ) },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
                    rememberTopAppBarState()
                ),
                modifier = modifier,
                navigationIcon = {
                    if (currentRoute != EZAlarmScreen.ALARM_LIST.route) {
                        IconButton(onClick = navigateUp) {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.secondaryContainer,
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                                    contentDescription = stringResource(R.string.back_button_description),
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                },
                actions = {
                    if (currentRoute != EZAlarmScreen.ALARM_LIST.route) {
                        IconButton(onClick = navigateUp) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        color = MaterialTheme.colorScheme.primary, // Set your desired background color
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Check,
                                    contentDescription = stringResource(R.string.action_confirm),
                                    tint = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }
                }
            )
        }
    )
}

@Composable
fun EZAlarmMainScreen(
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            EZAlarmTopAppBar(
                isVisible = true,
                navigateUp = { navController.navigateUp() },
                currentRoute = currentRoute
            )
        },
        bottomBar = {
            EZAlarmBottomAppNavigationBar(
                isVisible = true,
                navController = navController
            )
        },
        content = { innerPadding -> EZAlarmNavigationContent(navController, innerPadding) }
    )
}


@Composable
fun EZAlarmBottomAppNavigationBar(
    modifier: Modifier = Modifier,
    isVisible: Boolean = false,
    navController: NavHostController
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight }) + fadeIn(),
        exit = slideOutVertically(targetOffsetY = { fullHeight -> fullHeight }) + fadeOut(),
        content = {
            NavigationBar (containerColor = MaterialTheme.colorScheme.primaryContainer) {
                val currentDestination = navController.currentDestination
                EZAlarmNavigationItem.entries.forEach { item ->
                    NavigationBarItem(
                        colors = NavigationBarItemColors(
                            selectedIconColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            selectedIndicatorColor = MaterialTheme.colorScheme.secondaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            unselectedTextColor = MaterialTheme.colorScheme.onPrimary,
                            disabledIconColor = MaterialTheme.colorScheme.onPrimary,
                            disabledTextColor = MaterialTheme.colorScheme.onPrimary,
                        ),
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = stringResource(item.label),
                            )
                        },
                        modifier = modifier,
                        //selected = currentDestination?.hierarchy?.any { it.route == item.name } == true,
                        selected = item.route == EZAlarmNavigationItem.ALARMS.route,
                        enabled = item.route == EZAlarmNavigationItem.ALARMS.route,
                        onClick = {
                           /* navController.navigate(item.name) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }*/
                        },
                        label = { Text(text = stringResource(item.label)) }
                    )
                }
            }
        }
    )
}

@Composable
fun EZAlarmNavigationContent(
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues()
) {
    val tweenSpec: FiniteAnimationSpec<IntOffset> = tween(300, 0, EaseOut)

    NavHost(
        navController = navController,
        startDestination = EZAlarmNavigationItem.ALARMS.route,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
        //.background(MaterialTheme.colorScheme.background),
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tweenSpec
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Start,
                tweenSpec
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tweenSpec
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End,
                tweenSpec
            )
        }
    ) {
        navigation(
            startDestination = EZAlarmScreen.ALARM_LIST.route,
            route = EZAlarmNavigationItem.ALARMS.route
        ) {
            composable(EZAlarmScreen.ALARM_LIST.route) {
                AlarmListScreen(navController)
            }
            composable(EZAlarmScreen.CREATE_ALARM.route) {
                CreateAlarmScreen(navController)
            }
            composable(EZAlarmScreen.SELECT_GROUP.route) {
                SelectGroupScreen(navController)
            }
            composable(EZAlarmScreen.SELECT_REPEAT.route) {
                SelectRepeatScreen(navController)
            }
        }
    }
}
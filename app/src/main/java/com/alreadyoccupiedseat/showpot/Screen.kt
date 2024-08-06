package com.alreadyoccupiedseat.showpot

import androidx.annotation.DrawableRes
import com.alreadyoccupiedseat.Screens
import com.alreadyoccupiedseat.designsystem.R

sealed class Screen(
    route: String,
    title: String,
    @DrawableRes unSelectedIcon: Int? = null,
    @DrawableRes selectedIcon: Int? = null,
): Screens(
    route = route,
    title = title,
    unSelectedIcon = unSelectedIcon,
    selectedIcon = selectedIcon,
) {

    data object Home : Screen(
        route = "home",
        title = "홈",
        unSelectedIcon = R.drawable.ic_home_24,
        selectedIcon = R.drawable.ic_home_24_filled,
    )

    data object Notification: Screen(
        route = "notification",
        title = "내 알림",
        unSelectedIcon = R.drawable.ic_alarm_navigation_24,
        selectedIcon = R.drawable.ic_alarm_navigation_24_filled,
    )

    data object MyPage: Screen(
        route = "myPage",
        title = "마이",
        unSelectedIcon = R.drawable.ic_my_24,
        selectedIcon = R.drawable.ic_my_24_filled,
    )

    data object Search: Screen(
        route = "search",
        title = "검색"
    )

    data object SubscriptionGenre: Screen(
        route = "genre",
        title = "장르 구독"
    )

    data object SubscriptionArtist: Screen(
        route = "subscriptionArtist",
        title = "아티스트 구독"
    )

    data object ShowDetail: Screen(
        route = "showDetail",
        title = "공연정보"
    )

    data object MyAlarm: Screen(
        route = "myAlarm",
        title = "내알림"
    )

    companion object {
        val bottomNavigationItems = listOf(Home, Notification, MyPage)
    }
}
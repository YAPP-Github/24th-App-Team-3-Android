package com.alreadyoccupiedseat.design_app

import androidx.annotation.DrawableRes
import com.alreadyoccupiedseat.Screens
import com.alreadyoccupiedseat.designsystem.R

sealed class Screen(
    route: String,
    title: String,
    @DrawableRes unSelectedIcon: Int?,
    @DrawableRes selectedIcon: Int?,
): Screens(
    route = route,
    title = title,
    unSelectedIcon = unSelectedIcon,
    selectedIcon = selectedIcon,
) {

    data object Typo : Screen(
        route = "typo",
        title = "폰트",
        unSelectedIcon = R.drawable.ic_ticket_24,
        selectedIcon = R.drawable.ic_ticket_24_filled,
    )

    data object Icon: Screen(
        route = "icon",
        title = "아이콘",
        unSelectedIcon = R.drawable.ic_ticket_24,
        selectedIcon = R.drawable.ic_ticket_24_filled,
    )

    data object Color : Screen(
        route = "color",
        title = "컬러",
        unSelectedIcon = R.drawable.ic_ticket_24,
        selectedIcon = R.drawable.ic_ticket_24_filled,
    )

    companion object {
        val bottomNavigationItems = listOf(Typo, Icon, Color)
    }
}
package com.alreadyoccupiedseat

import androidx.annotation.DrawableRes

abstract class Screens(
    val route: String,
    val title: String,
    @DrawableRes val unSelectedIcon: Int? = null,
    @DrawableRes val selectedIcon: Int? = null,
)
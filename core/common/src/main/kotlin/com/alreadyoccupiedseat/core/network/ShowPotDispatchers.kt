package com.alreadyoccupiedseat.core.network

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val niaDispatcher: ShowPotDispatchers)

enum class ShowPotDispatchers {
    Default,
    IO,
    Main
}

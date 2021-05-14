package com.droid.base.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface AppCoroutineDispatchers {
    fun io(): CoroutineDispatcher

    fun default(): CoroutineDispatcher
}

class AppCoroutineDispatchersImpl @Inject constructor() : AppCoroutineDispatchers {

    override fun io() = Dispatchers.IO

    override fun default() = Dispatchers.Default
}

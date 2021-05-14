package com.droid.test.core

import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutinesTestDispatcherExtension::class)
interface CoroutineTest {
    var testScope: TestCoroutineScope
    var dispatcher: TestCoroutineDispatcher
}

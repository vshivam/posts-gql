package com.droid.posts.fake

import com.droid.base.coroutines.AppCoroutineDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher

class FakeCoroutineDispatchers : AppCoroutineDispatchers {

    override fun io(): CoroutineDispatcher = TestCoroutineDispatcher()

    override fun default(): CoroutineDispatcher = TestCoroutineDispatcher()
}

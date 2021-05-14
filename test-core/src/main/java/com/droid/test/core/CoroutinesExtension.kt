package com.droid.test.core

import org.junit.jupiter.api.extension.ExtendWith
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(CoroutinesTestDispatcherExtension::class)
annotation class CoroutinesExtension

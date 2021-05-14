object Libs {

    // region material design
    const val material = "com.google.android.material:material:1.4.0-beta01"
    // end region

    //region Coroutines
    const val kotlinStdLibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3"
    //end region

    //region AndroidX
    const val androidxKotlinExtensions = "androidx.core:core-ktx:1.6.0-alpha03"
    const val androidxAppCompat = "androidx.appcompat:appcompat:1.3.0-rc01"
    const val androidxLifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val androidxLifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-alpha01"
    const val androidxLifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha01"
    const val androidxActivity = "androidx.activity:activity-ktx:1.3.0-alpha07"

    //region Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:1.3.0-alpha07"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha04"
    const val composeNavigation = "androidx.navigation:navigation-compose:1.0.0-alpha10"
    const val composePaging = "androidx.paging:paging-compose:1.0.0-alpha08"
    const val accompanistInsets = "com.google.accompanist:accompanist-insets:0.9.1"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:0.9.1"

    //region Dagger
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    //end region

    //region Test
    const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.jUnitJupiter}"
    const val junitJupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.jUnitJupiter}"
    const val junitJupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.jUnitJupiter}"
    const val mockitoInline = "org.mockito:mockito-inline:3.10.0"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:3.2.0"
    const val assertJ = "org.assertj:assertj-core:3.19.0"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.4.3"
    const val androidXArchTest = "androidx.arch.core:core-testing:2.1.0"
    //end region

    //region Networking
    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime:${Versions.apolloAndroid}"
    const val apolloCoroutines = "com.apollographql.apollo:apollo-coroutines-support:${Versions.apolloAndroid}"
    //end region
}
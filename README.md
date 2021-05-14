## Developed on Android Studio
* Android Studio Arctic Fox | 2020.3.1 Canary 13
* Runtime version: 11.0.8+10-b944.6842174 x86_64
* VM: OpenJDK 64-Bit Server VM 

## Tech Stack
* Kotlin + coroutines + flow
* Android architecture components
* Dagger for Dependency Injection
* Apollo-android for graphql queries
* Junit5, Mockito for testing

## Architecture
Follows the MVVM architecture with a data -> domain <- presentation setup. 

```
posts/
├── app
│   └── src/main
│   └── src/test (tests are available here)
├── base
├── test-core 
├── buildSrc
```
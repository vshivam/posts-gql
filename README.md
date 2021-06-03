The app loads a paginated list of post previews along with a post-details screen. 

The UI is written in Jetpack-compose and pagination is implemented using the Paging 3 library. The fake post data is loaded from the [GraphQL Zero](https://graphqlzero.almansi.me/) playground. 

![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/831071/120659563-c681f700-c486-11eb-8405-4c81e61eea27.gif)

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

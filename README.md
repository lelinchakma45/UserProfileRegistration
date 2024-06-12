
## User Profile Registration (NSDA)

This Kotlin program implements a basic user profile registration system for the National Skills Development Authority (NSDA) project using the Model-View-ViewModel (MVVM) architecture. It prompts users to input their username, email, date of birth, phone number, and home district. Subsequently, it displays the entered details back to the user. This project serves as a straightforward demonstration of user registration implementation in Kotlin following the MVVM design pattern.


## Features

- Room Database
- Follow Model View ViewModel (MVVM) Structure
- Add User with Details
- Update and Delete also
- Custom RecyclerView


## Tool Used

- Android Studio (Jellyfish)
- Programming
    - Kotlin (OOP)
    - Android SDK 17-28


## Screenshots

<img src="https://github.com/lelinchakma45/UserProfileRegistration/blob/master/app/src/main/screenshoot/Screenshot_20240516_091832.png?raw=true" alt="Splash Screen" width="98" height="200" /><img src="https://github.com/lelinchakma45/UserProfileRegistration/blob/master/app/src/main/screenshoot/Screenshot_20240516_091801.png?raw=true" alt="Splash Screen" width="100" height="200" /> <img src="https://github.com/lelinchakma45/UserProfileRegistration/blob/master/app/src/main/screenshoot/Screenshot_20240516_091843.png?raw=true" alt="Splash Screen" width="100" height="200" /> <img src="https://github.com/lelinchakma45/UserProfileRegistration/blob/master/app/src/main/screenshoot/Screenshot_20240516_091857.png?raw=true" alt="Splash Screen" width="100" height="200" /> 


## Dependencies

List the Kotlin dependencies used in your project. Include the name of the dependency and its version.
 

[CircleImageView](https://github.com/hdodenhof/CircleImageView)
```de.hdodenhof:circleimageview:3.1.0```

```gradle
dependencies {
    // Room Database
    implementation "androidx.room:room-runtime:2.6.1"
    implementation "androidx.room:room-ktx:2.6.1"
    ksp "androidx.room:room-compiler:2.6.1"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.7.0"
}
```
This code replace in plugins code:
```gradle
plugins {
    id("com.google.devtools.ksp")
}
```

This "com.google.devtools.ksp" code add in build.gradle.kts(Project) file:

```gradle
id("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
```

## Authors

- [@lelinchakma45](https://www.github.com/lelinchakma45)


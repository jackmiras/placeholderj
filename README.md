# PlaceholderJ
PaceholderJ is a simple Android library created to help you handle easily with screens of empty list, no itens found, loading and error.

##Observations
Before you start is important you keep in mind that PlaceholderJ views are projected to handle with errors 
received from failures of some request submited to an API and this request must be made by Retrofit becouse the errors expected in this library are retrofit errors.
In other words if you will pass an error to PlaceholderJ make sure with this error is a RetrofitError.           

So if you whant to your error view or empty view handle with other errors you are encouraged to implement this and send me a pull request ;).

### Include this library:

``` groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

``` groovy
dependencies {
  compile 'com.github.jackmiras:placeholderj:1.0.2'
}
```

# PlaceholderJ
PaceholderJ is a simple Android library created to help you to easily handle easily screens with empty lists, no itens found, loading and errors.

##Screenshots
-----------

![Demo screenshot](https://github.com/jackmiras/placeholderj/blob/master/art/sample.gif)

##Observations
Before you start is important you keep in mind that PlaceholderJ views were projected only to handle with errors
generated by Retrofit. So, If need your error/empty views to handle errors from other sources, you're encouraged to
implement it yourself and send me a pull request! ;)

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
    compile 'com.github.jackmiras:placeholderj:2.1'
}
```
###Quick Start
-----------
####Step 1 -  You will need some views for PlaceHolderJ in your layout.
``` xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <include layout="@layout/item_toolbar" />

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerview_cupon"
        android:scrollbars="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginTop="?attr/actionBarSize"
        android:padding="8dp" />

    <include layout="@layout/view_empty" />

    <include layout="@layout/view_loading" />

    <include layout="@layout/view_error" />

</FrameLayout>
```
As you see, you can include a loading, empty and error views, but it's better to include only the views you'll be using.

####Step 2 - You will need create a instance of PlaceHolderJ in your Activity or Fragment.
##### Activity
``` java
public class MainActivity extends AppCompatActivity {

    private PlaceHolderJ placeHolderJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        placeHolderJ = new PlaceHolderJ(this, R.id.recyclerview_cupon);
        placeHolderJ.init(R.id.view_loading, R.id.view_empty, R.id.view_error);
    }
}
```
##### Fragment
``` java
public class MainFragment extends Fragment {

    private PlaceHolderJ placeHolderJ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.fragment_main, null);
        
        placeHolderJ = new PlaceHolderJ(container, R.id.recyclerview_cupon);
        placeHolderJ.init(R.id.view_loading, R.id.view_empty, R.id.view_error);
        
        return container;
    }
}
```
Note the PlaceHolderJ() constructor you takes two parameters, the Activity/ViewGroup that contains the views that will be managed by PlaceHolderJ, and the view that will contain the placeholders.
You have to call the init method of your placeHolderJ instance and it takes up to three parameters, corresponding to the ids of the placeholder views for "loading", "error" and "empty", but you only have to include the ones you need. 

####Step 3 - If you need customize something in the PlaceHolderJ views, you can use PlaceHolderManager for that. 
You should keep a singleton of the PlaceHolderManager in your application. The usage of PlaceHolderManager is exemplified below:

#####Application
``` java
public class SampleApplication extends Application {

    private static PlaceHolderManager placeHolderManager;

    @Override
    public void onCreate() {
        super.onCreate();

        placeHolderManager = new PlaceHolderManager.Configurator()
                .loadingBackground(android.R.color.holo_green_light)
                .errorText(R.string.global_custom_error, 0, 0)
                .config();
    }

    public static PlaceHolderManager getPlaceHolderManager() {
        return placeHolderManager;
    }
}
```
#####Don't forget to add the Application class at your AndroidManifest.xml
``` xml
<application
        android:name=".SampleApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/SampleTheme" >
```
#####And after that you only need to pass your PlaceHolderManager instance to the constructor of PlaceHolderJ in your Activity or Fragment. The implementation looks like the code below:

``` java
public class MainActivity extends AppCompatActivity {

    private PlaceHolderJ placeHolderJ;
    private PlaceHolderManager placeHolderManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        placeHolderManager  = SampleApplication.getPlaceHolderManager();
        placeHolderJ = new PlaceHolderJ(this, R.id.recyclerview_cupon, placeHolderManager);
        placeHolderJ.init(R.id.view_loading, R.id.view_empty, R.id.view_error);
    }
}
```
If you want check a sample app to get a more realistic idea of how use PlaceHolderJ click [here](https://github.com/jackmiras/placeholderj/tree/master/app/src/main).

If you want download the sample app click [here](https://drive.google.com/file/d/0B0Tf80UFMc0WZTFIb1dUbGdSLUk/view?usp=sharing).

## Pull Requests

I welcome and encourage all pull requests. It usually takes me around 48 hours to respond to any issue or request. Here are some basic rules to follow to ensure the fastest reviewing and addition of your request:
  1. Match coding style (braces, spacing, etc.) This is best achieved using CRTL+ALT+L (Reformat code) on Linux and CMD+Option+L on Mac (not sure for Windows) with Android Studio defaults.
  2. If it's a feature, bugfix, or anything else, please only change code where strictly necessary.
   **DO NOT** do this: Ex: Title "Fixes Crash Related to Bug" but includes other files that were changed without explanation or that weren't related to the bug you fixed. Another example is a non-descriptive title "Fixes Stuff".
  3. Pull requests must be made against ```develop``` branch.
  4. Have fun!

## Maintainers

[Jack Miras](https://github.com/jackmiras) ([@jackmiras](https://www.twitter.com/@jackmiras))

### Contributors

[Daivid Silverio](https://github.com/daividssilverio) ([@daividssilverio](https://www.twitter.com/@daividssilverio))

[Analira Scalabrini](https://github.com/analiras2) ([@analiras2](https://www.twitter.com/@analiras2))

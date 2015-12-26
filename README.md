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
###Quick Start
-----------
####Step 1 - You will need some view from PlaceHolderJ in your layout.
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
As you see you can include a loading view, empty view or error view but is a good practice include only the view that you will use.

####Step 2 - You will need create a instance of PlaceHolderJ in your Activity or Fragment.
##### Activity
``` java
public class MainActivity extends AppCompatActivity {

    PlaceHolderJ placeHolderJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        placeHolderJ = new PlaceHolderJ(SampleApplication.getPlaceHolderManager());
        placeHolderJ.init(this, R.id.recyclerview_cupon, R.id.view_loading, R.id.view_empty, R.id.view_error);
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
        placeHolderJ = new PlaceHolderJ(SampleApplication.getPlaceHolderManager());
        placeHolderJ.init(container, R.id.recyclerview_cupon, R.id.view_loading, R.id.view_empty, R.id.view_error);
        return container;
    }
}
```
Note that in placeHolderJ.init() you can pass five parameters but just the Activity or View, first view id and second view id are obligatory. This three parameters are obligatory because you always has to pass the Activity or View that will be used to find the views passed on placeHolderJ.init(). Activity or View also is used to find child view from views like R.id.view_error.

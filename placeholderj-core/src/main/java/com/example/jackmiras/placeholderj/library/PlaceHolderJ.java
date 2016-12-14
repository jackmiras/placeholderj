package com.example.jackmiras.placeholderj.library;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.UnknownHostException;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by jackmiras on 03/10/15.
 */
public class PlaceHolderJ implements Parcelable {

    private View parent;
    private PlaceHolderManager placeHolderManager;
    private Context context;

    private View viewContent = null;
    private int viewContentId = 0;

    private ViewGroup viewLoading = null;
    private TextView viewLoadingMessage = null;

    private ViewGroup viewEmpty = null;
    private ImageView viewEmptyImage = null;
    private TextView viewEmptyMessage = null;
    private Button viewEmptyTryAgainButton = null;

    private ViewGroup viewError = null;
    private ImageView viewErrorImage = null;
    private TextView viewErrorMessage = null;
    private Button viewErrorTryAgainButton = null;

    private boolean viewsAreCustomized;

    private PlaceHolderJ(Parcel in) {
        this.viewsAreCustomized = in.readByte() != 0;
    }

    /**
     * @param activity           The activity used to find the parent with the viewContentId and the placeholders in the init method.
     * @param viewContentId      The parent that represent your content and will be replaced by PlaceHolderJ views.
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views.
     */
    public PlaceHolderJ(Activity activity, int viewContentId, PlaceHolderManager placeHolderManager) {
        this(activity.getWindow().getDecorView(), viewContentId, placeHolderManager);
    }

    /**
     * @param parent             The parent used to find the parent with the viewContentId and the placeholders in the init method.
     * @param viewContentId      The parent that represent your content and will be replaced by PlaceHolderJ views.
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views.
     */
    public PlaceHolderJ(View parent, int viewContentId, PlaceHolderManager placeHolderManager) {
        this(parent, viewContentId);
        this.placeHolderManager = placeHolderManager;
    }

    /**
     * @param activity      The activity used to find the parent with the viewContentId and the placeholders in the init method.
     * @param viewContentId The parent that represent your content and will be replaced by PlaceHolderJ views.
     */
    public PlaceHolderJ(Activity activity, int viewContentId) {
        this(activity.getWindow().getDecorView(), viewContentId);
    }

    /**
     * @param parent        The parent used to find the parent with the viewContentId and the placeholders in the init method.
     * @param viewContentId The parent that represent your content and will be replaced by PlaceHolderJ views.
     */
    public PlaceHolderJ(View parent, int viewContentId) {
        this.parent = parent;
        this.viewContentId = viewContentId;
        findContainerView(viewContentId);
    }

    private void findContainerView(int viewContentId) {
        viewContent = parent.findViewById(viewContentId);
        if (viewContent == null) {
            throw new NullPointerException("Unable to access Container View. You should pass the parent that will be replaced by PlaceHolderJ views");
        }
    }

    /**
     * Called when a instance of this class is created and needs to be initialized.
     * The init method will get all views with ids in viewsId using the Activity/View passed
     * in the constructor.
     *
     * @param viewsId ids of the placeholder views
     */
    public void init(int... viewsId) {
        context = parent.getContext();
        for (int aViewsId : viewsId) {
            if (aViewsId == R.id.view_loading) {
                viewLoading = (ViewGroup) parent.findViewById(R.id.view_loading);
                viewLoadingMessage = (TextView) viewLoading.findViewById(R.id.view_loading_text);
            } else if (aViewsId == R.id.view_empty) {
                viewEmpty = (ViewGroup) parent.findViewById(R.id.view_empty);
                viewEmptyImage = (ImageView) parent.findViewById(R.id.imageview_empty_icon);
                viewEmptyMessage = (TextView) parent.findViewById(R.id.textview_empty_message);
                viewEmptyTryAgainButton = (Button) parent.findViewById(R.id.button_empty_try_again);
            } else if (aViewsId == R.id.view_error) {
                viewError = (ViewGroup) parent.findViewById(R.id.view_error);
                viewErrorImage = (ImageView) parent.findViewById(R.id.imageview_error_icon);
                viewErrorMessage = (TextView) parent.findViewById(R.id.textview_error_message);
                viewErrorTryAgainButton = (Button) parent.findViewById(R.id.button_error_try_again);
            }
        }
        if (viewEmpty == null && viewError == null && viewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, Error View or Loading View. You should pass at least one placeholder parent to init PlaceHolderJ");
        }
        customizeViews();
    }

    private void customizeViews() {
        if (placeHolderManager != null && !viewsAreCustomized) {
            CustomizeViews customizeViews = new CustomizeViews(placeHolderManager, context);
            customizeViews.customize(viewLoading, viewLoadingMessage, viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton, viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
            viewsAreCustomized = true;
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /**
     * Makes the loading parent visible if the loading parent was added to your layout.
     */
    public void showLoading(int textRes) {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Loading View, check if the loading parent was initialized");
        } else {
            viewLoadingMessage.setText(textRes);
            showLoading();
        }
    }

    /**
     * Makes the loading parent visible if the loading parent was added to your layout.
     */
    public void showLoading() {
        hideUnlessViewEquals(viewLoading.getId());
        setViewVisibility(viewLoading, VISIBLE);
    }

    /**
     * Makes the empty parent visible if the empty parent was added to your layout.
     *
     * @param messageRes      The message that will be shown in the empty parent.
     * @param onClickListener The action that will be performed by the try again button present in empty parent layout.
     */
    public void showEmpty(int messageRes, View.OnClickListener onClickListener) {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, check if the empty parent was initialized.");
        } else {
            messageRes = messageRes == 0 ? R.string.global_empty_list : messageRes;
            viewEmptyMessage.setText(messageRes);
            showEmpty(onClickListener);
        }
    }

    /**
     * Makes the empty parent visible if the empty parent was added to your layout.
     *
     * @param onClickListener The action that will be performed by the try again button present in empty parent layout.
     */
    public void showEmpty(View.OnClickListener onClickListener) {
        hideUnlessViewEquals(viewEmpty.getId());
        if (onClickListener == null) {
            viewEmptyTryAgainButton.setVisibility(GONE);
        } else {
            viewEmptyTryAgainButton.setVisibility(VISIBLE);
            viewEmptyTryAgainButton.setOnClickListener(onClickListener);
        }
        setViewVisibility(viewEmpty, VISIBLE);
    }

    /**
     * Makes the error parent visible if the error parent was added to your layout.
     *
     * @param error           The retrofit error from one of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in error parent layout.
     */
    public void showError(Throwable error, View.OnClickListener onClickListener) {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Error View, check if the error parent was initialized.");
        } else {
            hideUnlessViewEquals(viewError.getId());
            if (!viewsAreCustomized) {
                boolean isNetworkError = error != null && error instanceof UnknownHostException;
                viewErrorImage.setImageResource(isNetworkError ? R.drawable.icon_error_network : R.drawable.icon_error_unknown);
                viewErrorMessage.setText(isNetworkError ? R.string.global_network_error : R.string.global_unknown_error);
            }
            viewErrorTryAgainButton.setOnClickListener(onClickListener);
            setViewVisibility(viewError, VISIBLE);
        }
    }

    /**
     * Makes the content parent visible if the content parent was added to your layout.
     */
    public void showContent() {
        if (viewContent == null) {
            throw new NullPointerException("Unable to access Content View, check if the content parent " +
                    "was initialized.");
        } else {
            hideUnlessViewEquals(viewContentId);
            setViewVisibility(viewContent, VISIBLE);
        }
    }

    private void hideUnlessViewEquals(int viewId) {
        if (R.id.view_loading != viewId) setViewVisibility(viewLoading, GONE);
        if (R.id.view_empty != viewId) setViewVisibility(viewEmpty, GONE);
        if (R.id.view_error != viewId) setViewVisibility(viewError, GONE);
        if (viewContentId != viewId) setViewVisibility(viewContent, GONE);
    }


    /***********************************************************************************************
     *                             Parcelable methods implementation.                              *
     **********************************************************************************************/
    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.viewsAreCustomized ? (byte) 1 : (byte) 0);
    }

    public static final Creator<PlaceHolderJ> CREATOR = new Creator<PlaceHolderJ>() {
        @Override
        public PlaceHolderJ createFromParcel(Parcel source) {return new PlaceHolderJ(source);}

        @Override
        public PlaceHolderJ[] newArray(int size) {return new PlaceHolderJ[size];}
    };
}
package com.placeholderj;

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

    private View mParent;
    private PlaceHolderManager mPlaceHolderManager;
    private Context mContext;

    private View mViewContent = null;
    private int mViewContentId = 0;

    private ViewGroup mViewLoading = null;
    private TextView mViewLoadingMessage = null;

    private ViewGroup mViewEmpty = null;
    private ImageView mViewEmptyImage = null;
    private TextView mViewEmptyMessage = null;
    private Button mViewEmptyTryAgainButton = null;

    private ViewGroup mViewError = null;
    private ImageView mViewErrorImage = null;
    private TextView mViewErrorMessage = null;
    private Button mViewErrorTryAgainButton = null;

    private boolean mViewsAreCustomized;

    private PlaceHolderJ(Parcel in) {
        this.mViewsAreCustomized = in.readByte() != 0;
    }

    /**
     * @param activity           The activity used to find the view with the mViewContentId and the placeholders in the init method.
     * @param viewContentId      The id that represent your content view that will be replaced by PlaceHolderJ views.
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views.
     */
    public PlaceHolderJ(Activity activity, int viewContentId, PlaceHolderManager placeHolderManager) {
        this(activity.getWindow().getDecorView(), viewContentId, placeHolderManager);
    }

    /**
     * @param parent             The view used to find the view with the mViewContentId and the placeholders in the init method.
     * @param viewContentId      The id that represent your content view that will be replaced by PlaceHolderJ views.
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views.
     */
    public PlaceHolderJ(View parent, int viewContentId, PlaceHolderManager placeHolderManager) {
        this(parent, viewContentId);
        this.mPlaceHolderManager = placeHolderManager;
    }

    /**
     * @param activity           The activity used to find the view with the mViewContentId and the placeholders in the init method.
     * @param viewContentId The id that represent your content view that will be replaced by PlaceHolderJ views.
     */
    public PlaceHolderJ(Activity activity, int viewContentId) {
        this(activity.getWindow().getDecorView(), viewContentId);
    }

    /**
     * @param parent        The view used to find the parent with the mViewContentId and the placeholders in the init method.
     * @param viewContentId The id that represent your content view that will be replaced by PlaceHolderJ views.
     */
    public PlaceHolderJ(View parent, int viewContentId) {
        this.mParent = parent;
        this.mViewContentId = viewContentId;
        findContainerView(viewContentId);
    }

    private void findContainerView(int viewContentId) {
        mViewContent = mParent.findViewById(viewContentId);
        if (mViewContent == null) {
            throw new NullPointerException("Unable to access Container View. You should pass the view that will be replaced by PlaceHolderJ views");
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
        mContext = mParent.getContext();
        for (int aViewsId : viewsId) {
            if (aViewsId == R.id.view_loading) {
                mViewLoading = (ViewGroup) mParent.findViewById(R.id.view_loading);
                mViewLoadingMessage = (TextView) mViewLoading.findViewById(R.id.view_loading_text);
            } else if (aViewsId == R.id.view_empty) {
                mViewEmpty = (ViewGroup) mParent.findViewById(R.id.view_empty);
                mViewEmptyImage = (ImageView) mParent.findViewById(R.id.imageview_empty_icon);
                mViewEmptyMessage = (TextView) mParent.findViewById(R.id.textview_empty_message);
                mViewEmptyTryAgainButton = (Button) mParent.findViewById(R.id.button_empty_try_again);
            } else if (aViewsId == R.id.view_error) {
                mViewError = (ViewGroup) mParent.findViewById(R.id.view_error);
                mViewErrorImage = (ImageView) mParent.findViewById(R.id.imageview_error_icon);
                mViewErrorMessage = (TextView) mParent.findViewById(R.id.textview_error_message);
                mViewErrorTryAgainButton = (Button) mParent.findViewById(R.id.button_error_try_again);
            }
        }
        if (mViewEmpty == null && mViewError == null && mViewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, Error View or Loading View. " +
                    "You should pass at least one placeholder view to init PlaceHolderJ");
        }
        customizeViews();
    }

    private void customizeViews() {
        if (mPlaceHolderManager != null && !mViewsAreCustomized) {
            CustomizeViews customizeViews = new CustomizeViews(mPlaceHolderManager, mContext);
            customizeViews.customize(
                    mViewLoading,
                    mViewLoadingMessage,
                    mViewEmpty,
                    mViewEmptyImage,
                    mViewEmptyMessage,
                    mViewEmptyTryAgainButton,
                    mViewError,
                    mViewErrorImage,
                    mViewErrorMessage,
                    mViewErrorTryAgainButton
            );
            mViewsAreCustomized = true;
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /**
     * Makes the loading view visible if the loading view was added to your layout.
     */
    public void showLoading(int textRes) {
        if (mViewLoading == null) {
            throw new NullPointerException("Unable to access Loading View, check if the loading view was initialized");
        } else {
            mViewLoadingMessage.setText(textRes);
            showLoading();
        }
    }

    /**
     * Makes the loading view visible if the loading view was added to your layout.
     */
    public void showLoading() {
        hideUnlessViewEquals(mViewLoading.getId());
        setViewVisibility(mViewLoading, VISIBLE);
    }

    /**
     * Makes the empty view visible if the empty view was added to your layout.
     *
     * @param messageRes      The message that will be shown in the empty view.
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(int messageRes, View.OnClickListener onClickListener) {
        if (mViewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, check if the empty view was initialized.");
        } else {
            messageRes = messageRes == 0 ? R.string.global_empty_list : messageRes;
            mViewEmptyMessage.setText(messageRes);
            showEmpty(onClickListener);
        }
    }

    /**
     * Makes the empty view visible if the empty view was added to your layout.
     *
     * @param messageRes The message that will be shown in the empty view.
     */
    public void showEmpty(int messageRes) {
        showEmpty(messageRes, null);
    }

    /**
     * Makes the empty view visible if the empty view was added to your layout.
     *
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(View.OnClickListener onClickListener) {
        hideUnlessViewEquals(mViewEmpty.getId());
        if (onClickListener == null) {
            mViewEmptyTryAgainButton.setVisibility(GONE);
        } else {
            mViewEmptyTryAgainButton.setVisibility(VISIBLE);
            mViewEmptyTryAgainButton.setOnClickListener(onClickListener);
        }
        setViewVisibility(mViewEmpty, VISIBLE);
    }

    /**
     * Makes the error view visible if the error view was added to your layout.
     *
     * @param error           The retrofit error from one of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in error view layout.
     */
    public void showError(Throwable error, View.OnClickListener onClickListener) {
        if (mViewLoading == null) {
            throw new NullPointerException("Unable to access Error View, check if the error view was initialized.");
        } else {
            hideUnlessViewEquals(mViewError.getId());
            if (!mViewsAreCustomized) {
                boolean isNetworkError = error != null && error instanceof UnknownHostException;
                mViewErrorImage.setImageResource(isNetworkError ? R.drawable.icon_error_network : R.drawable.icon_error_unknown);
                mViewErrorMessage.setText(isNetworkError ? R.string.global_network_error : R.string.global_unknown_error);
            }
            mViewErrorTryAgainButton.setOnClickListener(onClickListener);
            setViewVisibility(mViewError, VISIBLE);
        }
    }

    /**
     * Makes the content view visible if the content view was added to your layout.
     */
    public void showContent() {
        if (mViewContent == null) {
            throw new NullPointerException("Unable to access Content View, check if the content view " +
                    "was initialized.");
        } else {
            hideUnlessViewEquals(mViewContentId);
            setViewVisibility(mViewContent, VISIBLE);
        }
    }

    private void hideUnlessViewEquals(int viewId) {
        if (R.id.view_loading != viewId) setViewVisibility(mViewLoading, GONE);
        if (R.id.view_empty != viewId) setViewVisibility(mViewEmpty, GONE);
        if (R.id.view_error != viewId) setViewVisibility(mViewError, GONE);
        if (mViewContentId != viewId) setViewVisibility(mViewContent, GONE);
    }


    /***********************************************************************************************
     *                              Parcelable methods implementation.                             *
     **********************************************************************************************/
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.mViewsAreCustomized ? (byte) 1 : (byte) 0);
    }

    public static final Creator<PlaceHolderJ> CREATOR = new Creator<PlaceHolderJ>() {
        @Override
        public PlaceHolderJ createFromParcel(Parcel source) {
            return new PlaceHolderJ(source);
        }

        @Override
        public PlaceHolderJ[] newArray(int size) {
            return new PlaceHolderJ[size];
        }
    };
}
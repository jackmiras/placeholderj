package com.example.jackmiras.placeholderj.managers;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jackmiras.placeholderj.R;
import com.example.jackmiras.placeholderj.enums.PlaceHolderType;

import retrofit.RetrofitError;

/**
 * Created by jackmiras on 03/10/15.
 */
public class PlaceHolderManager {

    private View viewContainer = null;
    private View framelayoutViewLoading = null;
    private ViewGroup linearlayoutViewEmpty = null;
    private TextView textViewEmptyMessage;
    private TextView textViewEmptyTryAgain = null;
    private ViewGroup linearlayoutViewError = null;
    private ImageView imageViewErrorIcon = null;
    private TextView textViewErrorMessage = null;
    private TextView textViewErrorTryAgain = null;
    private boolean isLoadingViewBeingShown;
    private boolean isErrorViewBeingShown;
    private boolean isEmptyViewBeingShown;


    public PlaceHolderManager(Activity activity, int viewContainerId, int viewId, PlaceHolderType type) {
        this(activity.getWindow().getDecorView(), viewContainerId, viewId, type);
    }

    public PlaceHolderManager(View view, int viewContainerId, int viewId, PlaceHolderType type) {
        switch (type) {
            case LOADING:
                setup(view, viewContainerId, viewId, 0, 0);
                break;
            case EMPTY:
                setup(view, viewContainerId, 0, viewId, 0);
                break;
            case ERROR:
                setup(view, viewContainerId, 0, 0, viewId);
                break;
        }
    }

    public PlaceHolderManager(Activity activity, int viewContainerId, int loadingViewId, int emptyTextId, int errorViewId) {
        this(activity.getWindow().getDecorView(), viewContainerId, loadingViewId, emptyTextId, errorViewId);
    }

    public PlaceHolderManager(View view, int viewContainerId, int loadingViewId, int emptyTextId, int errorViewId) {
        setup(view, viewContainerId, loadingViewId, emptyTextId, errorViewId);
    }

    public void setup(View view, int viewContainerId, int loadingViewId, int emptyTextId, int errorViewId) {
        if (viewContainerId != 0)
            viewContainer = view.findViewById(viewContainerId);
        if (loadingViewId != 0)
            framelayoutViewLoading = view.findViewById(loadingViewId);
        if (emptyTextId != 0) {
            linearlayoutViewEmpty = (ViewGroup) view.findViewById(emptyTextId);
            textViewEmptyMessage = (TextView) view.findViewById(R.id.textview_empty_message);
            textViewEmptyTryAgain = (TextView) view.findViewById(R.id.textview_empty_try_again);
        }
        if (errorViewId != 0) {
            linearlayoutViewError = (ViewGroup) view.findViewById(errorViewId);
            imageViewErrorIcon = (ImageView) view.findViewById(R.id.imageview_error_icon);
            textViewErrorMessage = (TextView) view.findViewById(R.id.textview_error_message);
            textViewErrorTryAgain = (TextView) view.findViewById(R.id.textview_error_try_again);
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null)
            view.setVisibility(visibility);
    }

    public void showLoading() {
        isLoadingViewBeingShown = true;
        changeViewsVisibility();
        setViewVisibility(framelayoutViewLoading, View.VISIBLE);
    }

    public void showEmpty(int messageRes, RetrofitError error, View.OnClickListener callback) {
        textViewEmptyMessage.setText(messageRes);
        showEmpty(error, callback);
    }

    public void showEmpty(RetrofitError error, View.OnClickListener callback) {
        isEmptyViewBeingShown = true;
        changeViewsVisibility();
        if (error == null && textViewEmptyTryAgain.getVisibility() == View.VISIBLE) {
            textViewEmptyTryAgain.setVisibility(View.GONE);
        } else {
            textViewEmptyTryAgain.setVisibility(View.VISIBLE);
            textViewEmptyTryAgain.setOnClickListener(callback);
        }
        setViewVisibility(linearlayoutViewEmpty, View.VISIBLE);
    }

    public void showError(RetrofitError error, View.OnClickListener callback) {
        isErrorViewBeingShown = true;
        changeViewsVisibility();
        if (error != null && error.getKind() == RetrofitError.Kind.NETWORK) {
            imageViewErrorIcon.setImageResource(R.drawable.icon_error_network);
            textViewErrorMessage.setText(R.string.global_network_error);
        } else {
            imageViewErrorIcon.setImageResource(R.drawable.icon_error_unknown);
            textViewErrorMessage.setText(R.string.global_unknown_error);
        }
        textViewErrorTryAgain.setOnClickListener(callback);
        setViewVisibility(linearlayoutViewError, View.VISIBLE);
    }

    public void hideLoading() {
        isLoadingViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(framelayoutViewLoading, View.GONE);
    }

    public void hideEmpty() {
        isEmptyViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(linearlayoutViewEmpty, View.GONE);
    }

    public void hideError() {
        isErrorViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(linearlayoutViewError, View.GONE);
    }

    public void changeViewsVisibility() {
        if (!isLoadingViewBeingShown)
            setViewVisibility(framelayoutViewLoading, View.GONE);
        if (!isEmptyViewBeingShown)
            setViewVisibility(linearlayoutViewEmpty, View.GONE);
        if (!isEmptyViewBeingShown)
            setViewVisibility(linearlayoutViewError, View.GONE);
        if (isLoadingViewBeingShown || isEmptyViewBeingShown || isErrorViewBeingShown)
            setViewVisibility(viewContainer, View.GONE);
        if (!isLoadingViewBeingShown && !isEmptyViewBeingShown && !isErrorViewBeingShown)
            setViewVisibility(viewContainer, View.VISIBLE);
    }
}
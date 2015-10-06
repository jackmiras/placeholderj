package com.example.jackmiras.placeholderj.managers;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jackmiras.placeholderj.R;

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


    public PlaceHolderManager(Activity activity, int... viewsId) {
        this(activity.getWindow().getDecorView(), viewsId);
    }

    public PlaceHolderManager(View view, int... viewsId) {
        if (viewsId.length >= 2 && viewsId.length <= 4) {
            for (int index = 0; index < viewsId.length; index++) {
                if (viewsId[index] == R.id.framelayout_view_loading) {
                    framelayoutViewLoading = view.findViewById(R.id.framelayout_view_loading);
                } else if (viewsId[index] == R.id.linearlayout_view_empty) {
                    linearlayoutViewEmpty = (ViewGroup) view.findViewById(R.id.linearlayout_view_empty);
                    textViewEmptyMessage = (TextView) view.findViewById(R.id.textview_empty_message);
                    textViewEmptyTryAgain = (TextView) view.findViewById(R.id.textview_empty_try_again);
                } else if (viewsId[index] == R.id.linearlayout_view_error) {
                    linearlayoutViewError = (ViewGroup) view.findViewById(R.id.linearlayout_view_error);
                    imageViewErrorIcon = (ImageView) view.findViewById(R.id.imageview_error_icon);
                    textViewErrorMessage = (TextView) view.findViewById(R.id.textview_error_message);
                    textViewErrorTryAgain = (TextView) view.findViewById(R.id.textview_error_try_again);
                } else {
                    viewContainer = view.findViewById(viewsId[index]);
                    if (viewContainer == null)
                        throw new IllegalArgumentException("PlaceHolderManager can not inflate a root view with the id informed, please check the id of your root view is correct.");
                }
            }
        } else {
            throw new IllegalArgumentException("PlaceHolderManager(View view, int... viewsId) viewsId should have at least layout root id, one placeholder id and no more than three placeholders.");
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
        if (!isLoadingViewBeingShown && framelayoutViewLoading != null && framelayoutViewLoading.getVisibility() == View.VISIBLE)
            setViewVisibility(framelayoutViewLoading, View.GONE);
        if (!isEmptyViewBeingShown && linearlayoutViewEmpty != null && linearlayoutViewEmpty.getVisibility() == View.VISIBLE)
            setViewVisibility(linearlayoutViewEmpty, View.GONE);
        if (!isEmptyViewBeingShown && linearlayoutViewError != null && linearlayoutViewError.getVisibility() == View.VISIBLE)
            setViewVisibility(linearlayoutViewError, View.GONE);
        if (isLoadingViewBeingShown || isEmptyViewBeingShown || isErrorViewBeingShown)
            setViewVisibility(viewContainer, View.GONE);
        if (!isLoadingViewBeingShown && !isEmptyViewBeingShown && !isErrorViewBeingShown)
            setViewVisibility(viewContainer, View.VISIBLE);
    }
}
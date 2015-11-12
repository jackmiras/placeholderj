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

    /**
     * Called when a new instance of this class is create. The constructor will get all views passed
     * in viewsId using the Activity passed together whit viewsId.
     *
     * @param activity The activity used to find the views that will be passeds in viewsId.
     * @param viewsId  A set of view that will interact between himself.
     */
    public PlaceHolderManager(Activity activity, int... viewsId) {
        this(activity.getWindow().getDecorView(), viewsId);
    }

    /**
     * Called when a new instance of this class is create. The constructor will get all views passed
     * in viewsId using the Activity passed together whit viewsId.
     *
     * @param view The view used to find the views that will be passeds in viewsId.
     * @param viewsId  A set of view that will interact between himself.
     */
    public PlaceHolderManager(View view, int... viewsId) {
        for (int aViewsId : viewsId) {
            if (aViewsId == R.id.view_loading) {
                framelayoutViewLoading = view.findViewById(R.id.view_loading);
            } else if (aViewsId == R.id.view_empty) {
                linearlayoutViewEmpty = (ViewGroup) view.findViewById(R.id.view_empty);
                textViewEmptyMessage = (TextView) view.findViewById(R.id.textview_empty_message);
                textViewEmptyTryAgain = (TextView) view.findViewById(R.id.textview_empty_try_again);
            } else if (aViewsId == R.id.view_error) {
                linearlayoutViewError = (ViewGroup) view.findViewById(R.id.view_error);
                imageViewErrorIcon = (ImageView) view.findViewById(R.id.imageview_error_icon);
                textViewErrorMessage = (TextView) view.findViewById(R.id.textview_error_message);
                textViewErrorTryAgain = (TextView) view.findViewById(R.id.textview_error_try_again);
            } else {
                viewContainer = view.findViewById(aViewsId);
            }
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null)
            view.setVisibility(visibility);
    }

    /**
     * Makes the loading view visible if the loaing view is added in your layout.
     */
    public void showLoading() {
        isLoadingViewBeingShown = true;
        changeViewsVisibility();
        setViewVisibility(framelayoutViewLoading, View.VISIBLE);
    }

    /**
     * Makes the empty view visible if the empty view is added in your layout.
     *
     * @param messageRes      The message that will be show in the empty view.
     * @param error           The retrofit error get of some of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(int messageRes, RetrofitError error, View.OnClickListener onClickListener) {
        textViewEmptyMessage.setText(messageRes);
        showEmpty(error, onClickListener);
    }

    /**
     * Makes the empty view visible if the empty view is added in your layout.
     *
     * @param error           The retrofit error get of some of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(RetrofitError error, View.OnClickListener onClickListener) {
        isEmptyViewBeingShown = true;
        changeViewsVisibility();
        if (error == null && textViewEmptyTryAgain.getVisibility() == View.VISIBLE) {
            textViewEmptyTryAgain.setVisibility(View.GONE);
        } else if (onClickListener != null) {
            textViewEmptyTryAgain.setVisibility(View.VISIBLE);
            textViewEmptyTryAgain.setOnClickListener(onClickListener);
        }
        setViewVisibility(linearlayoutViewEmpty, View.VISIBLE);
    }

    /**
     * Makes the error view visible if the error view is added in your layout.
     *
     * @param error           The retrofit error get of some of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in error view layout.
     */
    public void showError(RetrofitError error, View.OnClickListener onClickListener) {
        isErrorViewBeingShown = true;
        changeViewsVisibility();
        if (error != null && error.getKind() == RetrofitError.Kind.NETWORK) {
            imageViewErrorIcon.setImageResource(R.drawable.icon_error_network);
            textViewErrorMessage.setText(R.string.global_network_error);
        } else {
            imageViewErrorIcon.setImageResource(R.drawable.icon_error_unknown);
            textViewErrorMessage.setText(R.string.global_unknown_error);
        }
        textViewErrorTryAgain.setOnClickListener(onClickListener);
        setViewVisibility(linearlayoutViewError, View.VISIBLE);
    }

    /**
     * Makes the loading view invisible if the loaing view is added in your layout.
     */
    public void hideLoading() {
        isLoadingViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(framelayoutViewLoading, View.GONE);
    }

    /**
     * Makes the empty view invisible if the loaing view is added in your layout.
     */
    public void hideEmpty() {
        isEmptyViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(linearlayoutViewEmpty, View.GONE);
    }

    /**
     * Makes the empty view invisible if the loaing view is added in your layout.
     */
    public void hideError() {
        isErrorViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(linearlayoutViewError, View.GONE);
    }

    private void changeViewsVisibility() {
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
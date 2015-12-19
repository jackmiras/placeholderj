package com.example.jackmiras.placeholderj.library;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit.RetrofitError;

/**
 * Created by jackmiras on 03/10/15.
 */
public class PlaceHolderJ {

    private PlaceHolderManager placeHolderManager;
    private CustomizeViews customizeViews;
    private Context context;

    private View viewContainer = null;
    public View viewLoading = null;
    public ViewGroup viewEmpty = null;
    public ImageView viewEmptyImage = null;
    public TextView viewEmptyMessage;
    public Button viewEmptyTryAgainButton = null;
    public ViewGroup viewError = null;
    public ImageView viewErrorImage = null;
    public TextView viewErrorMessage = null;
    public Button viewErrorTryAgainButton = null;
    private boolean isLoadingViewBeingShown;
    private boolean isErrorViewBeingShown;
    private boolean isEmptyViewBeingShown;
    private boolean viewsAreCustomized;

    public PlaceHolderJ() {
    }

    public PlaceHolderJ(PlaceHolderManager placeHolderManager) {
        this.placeHolderManager = placeHolderManager;
        customizeViews = new CustomizeViews(placeHolderManager);
    }

    /**
     * Called when a new instance of this class is create. The constructor will get all views passed
     * in viewsId using the Activity passed together whit viewsId.
     *
     * @param activity The activity used to find the views that will be passeds in viewsId.
     * @param viewsId  A set of view that will interact between himself.
     */
    public void init(Activity activity, int... viewsId) {
        init(activity.getWindow().getDecorView(), viewsId);
    }

    /**
     * Called when a new instance of this class is create. The constructor will get all views passed
     * in viewsId using the Activity passed together whit viewsId.
     *
     * @param view    The view used to find the views that will be passeds in viewsId.
     * @param viewsId A set of view that will interact between himself.
     */
    public void init(View view, int... viewsId) {
        context = view.getContext();
        for (int aViewsId : viewsId) {
            if (aViewsId == R.id.view_loading) {
                viewLoading = view.findViewById(R.id.view_loading);
            } else if (aViewsId == R.id.view_empty) {
                viewEmpty = (ViewGroup) view.findViewById(R.id.view_empty);
                viewEmptyImage = (ImageView) view.findViewById(R.id.imageview_empty_icon);
                viewEmptyMessage = (TextView) view.findViewById(R.id.textview_empty_message);
                viewEmptyTryAgainButton = (Button) view.findViewById(R.id.button_empty_try_again);
            } else if (aViewsId == R.id.view_error) {
                viewError = (ViewGroup) view.findViewById(R.id.view_error);
                viewErrorImage = (ImageView) view.findViewById(R.id.imageview_error_icon);
                viewErrorMessage = (TextView) view.findViewById(R.id.textview_error_message);
                viewErrorTryAgainButton = (Button) view.findViewById(R.id.button_error_try_again);
            } else {
                viewContainer = view.findViewById(aViewsId);
                if (viewContainer == null) {
                    throw new IllegalArgumentException("You should pass the view that will change the visibility with PlaceHolderJ views");
                }
            }
        }
        if (viewEmpty == null && viewError == null && viewLoading == null) {
            throw new IllegalArgumentException("You should pass at least one placeholder view to init PlaceHolderJ");
        }
        customizeViews();
    }

    private void customizeViews() {
        if (placeHolderManager != null && !viewsAreCustomized) {
            customizeViews.customize(context, viewLoading, viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton, viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
            viewsAreCustomized = true;
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /**
     * Makes the loading view visible if the loaing view is added in your layout.
     */
    public void showLoading() {
        isLoadingViewBeingShown = true;
        changeViewsVisibility();
        setViewVisibility(viewLoading, View.VISIBLE);
        //TODO Lançar exceção se essa view for nula
    }

    /**
     * Makes the empty view visible if the empty view is added in your layout.
     *
     * @param messageRes      The message that will be show in the empty view.
     * @param error           The retrofit error get of some of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(int messageRes, RetrofitError error, View.OnClickListener onClickListener) {
        viewEmptyMessage.setText(messageRes);
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
        if (error == null && viewEmptyTryAgainButton.getVisibility() == View.VISIBLE) {
            viewEmptyTryAgainButton.setVisibility(View.GONE);
        } else if (onClickListener != null) {
            viewEmptyTryAgainButton.setVisibility(View.VISIBLE);
            viewEmptyTryAgainButton.setOnClickListener(onClickListener);
        }
        setViewVisibility(viewEmpty, View.VISIBLE);
        //TODO Lançar exceção se essa view for nula
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
        if (!viewsAreCustomized) {
            boolean isNetworkError = (error != null && error.getKind() == RetrofitError.Kind.NETWORK);
            viewErrorImage.setImageResource(isNetworkError ? R.drawable.icon_error_network : R.drawable.icon_error_unknown);
            viewErrorMessage.setText(isNetworkError ? R.string.global_network_error : R.string.global_unknown_error);
        }
        viewErrorTryAgainButton.setOnClickListener(onClickListener);
        setViewVisibility(viewError, View.VISIBLE);
        //TODO Lançar exceção se essa view for nula
    }

    /**
     * Makes the loading view invisible if the loaing view is added in your layout.
     */
    public void hideLoading() {
        isLoadingViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(viewLoading, View.GONE);
    }

    /**
     * Makes the empty view invisible if the loaing view is added in your layout.
     */
    public void hideEmpty() {
        isEmptyViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(viewEmpty, View.GONE);
    }

    /**
     * Makes the empty view invisible if the loaing view is added in your layout.
     */
    public void hideError() {
        isErrorViewBeingShown = false;
        changeViewsVisibility();
        setViewVisibility(viewError, View.GONE);
    }

    private void changeViewsVisibility() {
        if (!isLoadingViewBeingShown && viewLoading != null && viewLoading.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewLoading, View.GONE);
        }
        if (!isEmptyViewBeingShown && viewEmpty != null && viewEmpty.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewEmpty, View.GONE);
        }
        if (!isEmptyViewBeingShown && viewError != null && viewError.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewError, View.GONE);
        }
        if (isLoadingViewBeingShown || isEmptyViewBeingShown || isErrorViewBeingShown) {
            setViewVisibility(viewContainer, View.GONE);
        }
        if (!isLoadingViewBeingShown && !isEmptyViewBeingShown && !isErrorViewBeingShown) {
            setViewVisibility(viewContainer, View.VISIBLE);
        }

        //TODO Quando a checagem de view nula for feita nos metodos que pedem para as view serem mostradas os null checks desse metodo não serão mais necessários
    }
}
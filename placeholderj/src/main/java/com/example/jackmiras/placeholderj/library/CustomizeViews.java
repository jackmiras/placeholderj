package com.example.jackmiras.placeholderj.library;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jackson on 13/12/15.
 */
public class CustomizeViews {

    private final PlaceHolderManager placeHolderManager;

    public CustomizeViews(PlaceHolderManager placeHolderManager) {
        this.placeHolderManager = placeHolderManager;
    }

    public void customize(Context context, View viewLoading, ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton, ViewGroup viewError, ImageView viewErrorImage, TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        if (placeHolderManager.viewErrorBackgroundColor > 0) {
            viewError.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewErrorBackgroundColor));
        } else if (placeHolderManager.viewErrorBackgroundResource > 0) {
            viewError.setBackgroundResource(placeHolderManager.viewErrorBackgroundResource);
        }
        if (placeHolderManager.viewErrorText > 0) {
            viewErrorMessage.setText(placeHolderManager.viewErrorText);
        }
        if (placeHolderManager.viewErrorTextSize > 0) {
            viewErrorMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, placeHolderManager.viewErrorTextSize);
        }
        if (placeHolderManager.viewErrorTextColor > 0) {
            viewErrorMessage.setTextColor(ContextCompat.getColor(context, placeHolderManager.viewErrorTextColor));
        }
        if (placeHolderManager.viewErrorTryAgainButtonText > 0) {
            viewErrorTryAgainButton.setText(placeHolderManager.viewErrorTryAgainButtonText);
        }
        if (placeHolderManager.viewErrorTryAgainButtonBackgroundResource > 0) {
            viewErrorTryAgainButton.setBackgroundColor(placeHolderManager.viewErrorTryAgainButtonBackgroundResource);
        }
        if (placeHolderManager.viewErrorImage > 0) {
            viewErrorImage.setImageDrawable(ContextCompat.getDrawable(context, placeHolderManager.viewErrorImage));
        }
        if (placeHolderManager.viewLoadingBackgroundColor > 0) {
            viewLoading.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewLoadingBackgroundColor));
        } else if (placeHolderManager.viewLoadingBackgroundResource > 0) {
            viewLoading.setBackgroundResource(placeHolderManager.viewLoadingBackgroundResource);
        }
        if (placeHolderManager.viewEmptyBackgroundColor > 0) {
            viewEmpty.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewEmptyBackgroundColor));
        } else if (placeHolderManager.viewEmptyBackgroundResource > 0) {
            viewEmpty.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewEmptyBackgroundColor));
        }
        if (placeHolderManager.viewEmptyText > 0) {
            viewEmptyMessage.setText(placeHolderManager.viewEmptyText);
        }
        if (placeHolderManager.viewEmptyTextSize > 0) {
            viewEmptyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, placeHolderManager.viewEmptyTextSize);
        }
        if (placeHolderManager.viewEmptyTextColor > 0) {
            viewEmptyMessage.setTextColor(ContextCompat.getColor(context, placeHolderManager.viewEmptyTextColor));
        }
        if (placeHolderManager.viewEmptyTryAgainButtonText > 0) {
            viewEmptyTryAgainButton.setText(placeHolderManager.viewEmptyTryAgainButtonText);
        }
        if (placeHolderManager.viewEmptyTryAgainButtonBackgroundResource > 0) {
            viewEmptyTryAgainButton.setBackgroundResource(placeHolderManager.viewEmptyTryAgainButtonBackgroundResource);
        }
        if (placeHolderManager.viewEmptyImage > 0) {
            viewEmptyImage.setImageDrawable(ContextCompat.getDrawable(context, placeHolderManager.viewEmptyImage));
        }
    }
}

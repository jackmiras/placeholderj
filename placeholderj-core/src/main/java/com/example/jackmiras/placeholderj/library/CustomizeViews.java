package com.example.jackmiras.placeholderj.library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by jackson on 13/12/15.
 */
public class CustomizeViews implements Parcelable {

    private final PlaceHolderManager placeHolderManager;
    private final Context context;

    public CustomizeViews(PlaceHolderManager placeHolderManager, Context context) {
        this.placeHolderManager = placeHolderManager;
        this.context = context;
    }

    public void customize(View viewLoading, TextView viewLoadingMessage, ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton, ViewGroup viewError, ImageView viewErrorImage, TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        customizeViewError(viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
        customizeViewLoading(viewLoading, viewLoadingMessage);
        customizeViewEmpty(viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton);
    }

    private void customizeViewError(ViewGroup viewError, ImageView viewErrorImage, TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        if (viewError != null) {
            if (placeHolderManager.viewErrorBackgroundColor != 0) {
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
            if (placeHolderManager.viewErrorTextColor != 0) {
                viewErrorMessage.setTextColor(ContextCompat.getColor(context, placeHolderManager.viewErrorTextColor));
            }
            if (placeHolderManager.viewErrorTryAgainButtonText > 0) {
                viewErrorTryAgainButton.setText(placeHolderManager.viewErrorTryAgainButtonText);
            }
            if (placeHolderManager.viewErrorTryAgainButtonBackgroundResource > 0) {
                viewErrorTryAgainButton.setBackgroundResource(placeHolderManager.viewErrorTryAgainButtonBackgroundResource);
            }
            if (placeHolderManager.viewErrorImage > 0) {
                viewErrorImage.setImageDrawable(ContextCompat.getDrawable(context, placeHolderManager.viewErrorImage));
            }
        }
    }

    private void customizeViewLoading(View viewLoading, TextView viewLoadingMessage) {
        if (viewLoading != null) {
            if (placeHolderManager.viewLoadingBackgroundColor != 0) {
                viewLoading.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewLoadingBackgroundColor));
            } else if (placeHolderManager.viewLoadingBackgroundResource > 0) {
                viewLoading.setBackgroundResource(placeHolderManager.viewLoadingBackgroundResource);
            }
            if (placeHolderManager.viewLoadingProgressBarColor != 0) {
                ProgressBar progressBar = (ProgressBar) viewLoading.findViewById(R.id.view_loading_progress);
                progressBar.getIndeterminateDrawable().setColorFilter(placeHolderManager.viewLoadingProgressBarColor, PorterDuff.Mode.SRC_IN);
            }
            if (placeHolderManager.viewLoadingText > 0) {
                viewLoadingMessage.setText(placeHolderManager.viewLoadingText);
            }
            if (placeHolderManager.viewLoadingTextSize > 0) {
                viewLoadingMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, placeHolderManager.viewLoadingTextSize);
            }
            if (placeHolderManager.viewLoadingTextColor != 0) {
                viewLoadingMessage.setTextColor(ContextCompat.getColor(context, placeHolderManager.viewLoadingTextColor));
            }
        }
    }

    private void customizeViewEmpty(ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton) {
        if (viewEmpty != null) {
            if (placeHolderManager.viewEmptyBackgroundColor != 0) {
                viewEmpty.setBackgroundColor(ContextCompat.getColor(context, placeHolderManager.viewEmptyBackgroundColor));
            } else if (placeHolderManager.viewEmptyBackgroundResource > 0) {
                viewEmpty.setBackgroundResource(placeHolderManager.viewEmptyBackgroundResource);
            }
            if (placeHolderManager.viewEmptyText > 0) {
                viewEmptyMessage.setText(placeHolderManager.viewEmptyText);
            }
            if (placeHolderManager.viewEmptyTextSize > 0) {
                viewEmptyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, placeHolderManager.viewEmptyTextSize);
            }
            if (placeHolderManager.viewEmptyTextColor != 0) {
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

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.placeHolderManager, flags);
    }

    protected CustomizeViews(Parcel in) {
        this.placeHolderManager = in.readParcelable(PlaceHolderManager.class.getClassLoader());
        this.context = in.readParcelable(Context.class.getClassLoader());
    }

    public static final Parcelable.Creator<CustomizeViews> CREATOR = new Parcelable.Creator<CustomizeViews>() {
        @Override
        public CustomizeViews createFromParcel(Parcel source) {return new CustomizeViews(source);}

        @Override
        public CustomizeViews[] newArray(int size) {return new CustomizeViews[size];}
    };
}

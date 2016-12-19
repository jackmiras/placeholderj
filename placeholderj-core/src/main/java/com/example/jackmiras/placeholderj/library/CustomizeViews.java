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

    private final PlaceHolderManager mPlaceHolderManager;
    private Context mContext;

    private CustomizeViews(Parcel in) {
        this.mPlaceHolderManager = in.readParcelable(PlaceHolderManager.class.getClassLoader());
    }

    CustomizeViews(PlaceHolderManager placeHolderManager, Context context) {
        this.mPlaceHolderManager = placeHolderManager;
        this.mContext = context;
    }

    void customize(View viewLoading, TextView viewLoadingMessage, ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton, ViewGroup viewError, ImageView viewErrorImage, TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        customizeViewError(viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
        customizeViewLoading(viewLoading, viewLoadingMessage);
        customizeViewEmpty(viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton);
    }

    private void customizeViewError(ViewGroup viewError, ImageView viewErrorImage, TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        if (viewError != null) {
            if (mPlaceHolderManager.viewErrorBackgroundColor != 0) {
                viewError.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewErrorBackgroundColor));
            } else if (mPlaceHolderManager.viewErrorBackgroundResource > 0) {
                viewError.setBackgroundResource(mPlaceHolderManager.viewErrorBackgroundResource);
            }
            if (mPlaceHolderManager.viewErrorText > 0) {
                viewErrorMessage.setText(mPlaceHolderManager.viewErrorText);
            }
            if (mPlaceHolderManager.viewErrorTextSize > 0) {
                viewErrorMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.viewErrorTextSize);
            }
            if (mPlaceHolderManager.viewErrorTextColor != 0) {
                viewErrorMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewErrorTextColor));
            }
            if (mPlaceHolderManager.viewErrorTryAgainButtonText > 0) {
                viewErrorTryAgainButton.setText(mPlaceHolderManager.viewErrorTryAgainButtonText);
            }
            if (mPlaceHolderManager.viewErrorTryAgainButtonBackgroundResource > 0) {
                viewErrorTryAgainButton.setBackgroundResource(mPlaceHolderManager.viewErrorTryAgainButtonBackgroundResource);
            }
            if (mPlaceHolderManager.viewErrorImage > 0) {
                viewErrorImage.setImageDrawable(ContextCompat.getDrawable(mContext, mPlaceHolderManager.viewErrorImage));
            }
        }
    }

    private void customizeViewLoading(View viewLoading, TextView viewLoadingMessage) {
        if (viewLoading != null) {
            if (mPlaceHolderManager.viewLoadingBackgroundColor != 0) {
                viewLoading.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewLoadingBackgroundColor));
            } else if (mPlaceHolderManager.viewLoadingBackgroundResource > 0) {
                viewLoading.setBackgroundResource(mPlaceHolderManager.viewLoadingBackgroundResource);
            }
            if (mPlaceHolderManager.viewLoadingProgressBarColor != 0) {
                ProgressBar progressBar = (ProgressBar) viewLoading.findViewById(R.id.view_loading_progress);
                progressBar.getIndeterminateDrawable().setColorFilter(mPlaceHolderManager.viewLoadingProgressBarColor, PorterDuff.Mode.SRC_IN);
            }
            if (mPlaceHolderManager.viewLoadingText > 0) {
                viewLoadingMessage.setText(mPlaceHolderManager.viewLoadingText);
            }
            if (mPlaceHolderManager.viewLoadingTextSize > 0) {
                viewLoadingMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.viewLoadingTextSize);
            }
            if (mPlaceHolderManager.viewLoadingTextColor != 0) {
                viewLoadingMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewLoadingTextColor));
            }
        }
    }

    private void customizeViewEmpty(ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton) {
        if (viewEmpty != null) {
            if (mPlaceHolderManager.viewEmptyBackgroundColor != 0) {
                viewEmpty.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewEmptyBackgroundColor));
            } else if (mPlaceHolderManager.viewEmptyBackgroundResource > 0) {
                viewEmpty.setBackgroundResource(mPlaceHolderManager.viewEmptyBackgroundResource);
            }
            if (mPlaceHolderManager.viewEmptyText > 0) {
                viewEmptyMessage.setText(mPlaceHolderManager.viewEmptyText);
            }
            if (mPlaceHolderManager.viewEmptyTextSize > 0) {
                viewEmptyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.viewEmptyTextSize);
            }
            if (mPlaceHolderManager.viewEmptyTextColor != 0) {
                viewEmptyMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.viewEmptyTextColor));
            }
            if (mPlaceHolderManager.viewEmptyTryAgainButtonText > 0) {
                viewEmptyTryAgainButton.setText(mPlaceHolderManager.viewEmptyTryAgainButtonText);
            }
            if (mPlaceHolderManager.viewEmptyTryAgainButtonBackgroundResource > 0) {
                viewEmptyTryAgainButton.setBackgroundResource(mPlaceHolderManager.viewEmptyTryAgainButtonBackgroundResource);
            }
            if (mPlaceHolderManager.viewEmptyImage > 0) {
                viewEmptyImage.setImageDrawable(ContextCompat.getDrawable(mContext, mPlaceHolderManager.viewEmptyImage));
            }
        }
    }

    /***********************************************************************************************
     *                              Parcelable methods implementation.                             *
     **********************************************************************************************/
    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mPlaceHolderManager, flags);
    }

    public static final Creator<CustomizeViews> CREATOR = new Creator<CustomizeViews>() {
        @Override
        public CustomizeViews createFromParcel(Parcel source) {return new CustomizeViews(source);}

        @Override
        public CustomizeViews[] newArray(int size) {return new CustomizeViews[size];}
    };
}

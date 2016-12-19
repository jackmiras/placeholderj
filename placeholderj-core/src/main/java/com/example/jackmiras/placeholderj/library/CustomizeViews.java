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
            if (mPlaceHolderManager.mViewErrorBackgroundColor != 0) {
                viewError.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewErrorBackgroundColor));
            } else if (mPlaceHolderManager.mViewErrorBackgroundResource > 0) {
                viewError.setBackgroundResource(mPlaceHolderManager.mViewErrorBackgroundResource);
            }
            if (mPlaceHolderManager.mViewErrorText > 0) {
                viewErrorMessage.setText(mPlaceHolderManager.mViewErrorText);
            }
            if (mPlaceHolderManager.mViewErrorTextSize > 0) {
                viewErrorMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.mViewErrorTextSize);
            }
            if (mPlaceHolderManager.mViewErrorTextColor != 0) {
                viewErrorMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewErrorTextColor));
            }
            if (mPlaceHolderManager.mViewErrorTryAgainButtonText > 0) {
                viewErrorTryAgainButton.setText(mPlaceHolderManager.mViewErrorTryAgainButtonText);
            }
            if (mPlaceHolderManager.mViewErrorTryAgainButtonBackgroundResource > 0) {
                viewErrorTryAgainButton.setBackgroundResource(mPlaceHolderManager.mViewErrorTryAgainButtonBackgroundResource);
            }
            if (mPlaceHolderManager.mViewErrorImage > 0) {
                viewErrorImage.setImageDrawable(ContextCompat.getDrawable(mContext, mPlaceHolderManager.mViewErrorImage));
            }
        }
    }

    private void customizeViewLoading(View viewLoading, TextView viewLoadingMessage) {
        if (viewLoading != null) {
            if (mPlaceHolderManager.mViewLoadingBackgroundColor != 0) {
                viewLoading.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewLoadingBackgroundColor));
            } else if (mPlaceHolderManager.mViewLoadingBackgroundResource > 0) {
                viewLoading.setBackgroundResource(mPlaceHolderManager.mViewLoadingBackgroundResource);
            }
            if (mPlaceHolderManager.mViewLoadingProgressBarColor != 0) {
                ProgressBar progressBar = (ProgressBar) viewLoading.findViewById(R.id.view_loading_progress);
                progressBar.getIndeterminateDrawable().setColorFilter(mPlaceHolderManager.mViewLoadingProgressBarColor, PorterDuff.Mode.SRC_IN);
            }
            if (mPlaceHolderManager.mViewLoadingText > 0) {
                viewLoadingMessage.setText(mPlaceHolderManager.mViewLoadingText);
            }
            if (mPlaceHolderManager.mViewLoadingTextSize > 0) {
                viewLoadingMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.mViewLoadingTextSize);
            }
            if (mPlaceHolderManager.mViewLoadingTextColor != 0) {
                viewLoadingMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewLoadingTextColor));
            }
        }
    }

    private void customizeViewEmpty(ViewGroup viewEmpty, ImageView viewEmptyImage, TextView viewEmptyMessage, Button viewEmptyTryAgainButton) {
        if (viewEmpty != null) {
            if (mPlaceHolderManager.mViewEmptyBackgroundColor != 0) {
                viewEmpty.setBackgroundColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewEmptyBackgroundColor));
            } else if (mPlaceHolderManager.mViewEmptyBackgroundResource > 0) {
                viewEmpty.setBackgroundResource(mPlaceHolderManager.mViewEmptyBackgroundResource);
            }
            if (mPlaceHolderManager.mViewEmptyText > 0) {
                viewEmptyMessage.setText(mPlaceHolderManager.mViewEmptyText);
            }
            if (mPlaceHolderManager.mViewEmptyTextSize > 0) {
                viewEmptyMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, mPlaceHolderManager.mViewEmptyTextSize);
            }
            if (mPlaceHolderManager.mViewEmptyTextColor != 0) {
                viewEmptyMessage.setTextColor(ContextCompat.getColor(mContext, mPlaceHolderManager.mViewEmptyTextColor));
            }
            if (mPlaceHolderManager.mViewEmptyTryAgainButtonText > 0) {
                viewEmptyTryAgainButton.setText(mPlaceHolderManager.mViewEmptyTryAgainButtonText);
            }
            if (mPlaceHolderManager.mViewEmptyTryAgainButtonBackgroundResource > 0) {
                viewEmptyTryAgainButton.setBackgroundResource(mPlaceHolderManager.mViewEmptyTryAgainButtonBackgroundResource);
            }
            if (mPlaceHolderManager.mViewEmptyImage > 0) {
                viewEmptyImage.setImageDrawable(ContextCompat.getDrawable(mContext, mPlaceHolderManager.mViewEmptyImage));
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

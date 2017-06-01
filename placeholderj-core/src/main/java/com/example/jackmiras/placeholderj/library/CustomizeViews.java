package com.example.jackmiras.placeholderj.library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
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

    CustomizeViews(PlaceHolderManager placeHolderManager, Context context) {
        this.mPlaceHolderManager = placeHolderManager;
        this.mContext = context;
    }

    void customize(View viewLoading, TextView viewLoadingMessage, ViewGroup viewEmpty,
                   ImageView viewEmptyImage, TextView viewEmptyMessage,
                   Button viewEmptyTryAgainButton, ViewGroup viewError, ImageView viewErrorImage,
                   TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        customizeViewError(viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
        customizeViewLoading(viewLoading, viewLoadingMessage);
        customizeViewEmpty(viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton);
    }

    private void customizeViewError(ViewGroup viewError, ImageView viewErrorImage,
                                    TextView viewErrorMessage, Button viewErrorTryAgainButton) {
        if (viewError != null) {
            if (mPlaceHolderManager.mViewErrorBackgroundColor != 0) {
                viewError.setBackgroundColor(getColor(mPlaceHolderManager.mViewErrorBackgroundColor));
            } else if (mPlaceHolderManager.mViewErrorBackgroundResource > 0) {
                viewError.setBackgroundResource(mPlaceHolderManager.mViewErrorBackgroundResource);
            }
            if (mPlaceHolderManager.mViewErrorText > 0) {
                viewErrorMessage.setText(mPlaceHolderManager.mViewErrorText);
            }
            if (mPlaceHolderManager.mViewErrorTextSize > 0) {
                setTextSize(viewErrorMessage, mPlaceHolderManager.mViewErrorTextSize);
            }
            if (mPlaceHolderManager.mViewErrorTextColor != 0) {
                viewErrorMessage.setTextColor(getColor(mPlaceHolderManager.mViewErrorTextColor));
            }
            if (mPlaceHolderManager.mViewErrorTryAgainButtonText > 0) {
                viewErrorTryAgainButton.setText(mPlaceHolderManager.mViewErrorTryAgainButtonText);
            }
            if (mPlaceHolderManager.mViewErrorTryAgainButtonTextColor > 0) {
                viewErrorTryAgainButton.setTextColor(mPlaceHolderManager.mViewErrorTryAgainButtonTextColor);
            }
            if (mPlaceHolderManager.mViewErrorTryAgainButtonBackgroundResource > 0) {
                int backgroundRes = mPlaceHolderManager.mViewErrorTryAgainButtonBackgroundResource;
                viewErrorTryAgainButton.setBackgroundResource(backgroundRes);
            }
            if (mPlaceHolderManager.mViewErrorImage > 0) {
                viewErrorImage.setImageDrawable(getDrawable(mPlaceHolderManager.mViewErrorImage));
            }
        }
    }

    private void customizeViewLoading(View viewLoading, TextView viewLoadingMessage) {
        if (viewLoading != null) {
            if (mPlaceHolderManager.mViewLoadingBackgroundColor != 0) {
                viewLoading.setBackgroundColor(getColor(mPlaceHolderManager.mViewLoadingBackgroundColor));
            } else if (mPlaceHolderManager.mViewLoadingBackgroundResource > 0) {
                viewLoading.setBackgroundResource(mPlaceHolderManager.mViewLoadingBackgroundResource);
            }
            if (mPlaceHolderManager.mViewLoadingProgressBarColor != 0) {
                ProgressBar progressBar = (ProgressBar) viewLoading.findViewById(R.id.view_loading_progress);
                int color = mPlaceHolderManager.mViewLoadingProgressBarColor;
                progressBar.getIndeterminateDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
            if (mPlaceHolderManager.mViewLoadingText > 0) {
                viewLoadingMessage.setText(mPlaceHolderManager.mViewLoadingText);
            }
            if (mPlaceHolderManager.mViewLoadingTextSize > 0) {
                setTextSize(viewLoadingMessage, mPlaceHolderManager.mViewLoadingTextSize);
            }
            if (mPlaceHolderManager.mViewLoadingTextColor != 0) {
                viewLoadingMessage.setTextColor(getColor(mPlaceHolderManager.mViewLoadingTextColor));
            }
        }
    }

    private void customizeViewEmpty(ViewGroup viewEmpty, ImageView viewEmptyImage,
                                    TextView viewEmptyMessage, Button viewEmptyTryAgainButton) {
        if (viewEmpty != null) {
            if (mPlaceHolderManager.mViewEmptyBackgroundColor != 0) {
                viewEmpty.setBackgroundColor(getColor(mPlaceHolderManager.mViewEmptyBackgroundColor));
            } else if (mPlaceHolderManager.mViewEmptyBackgroundResource > 0) {
                viewEmpty.setBackgroundResource(mPlaceHolderManager.mViewEmptyBackgroundResource);
            }
            if (mPlaceHolderManager.mViewEmptyText > 0) {
                viewEmptyMessage.setText(mPlaceHolderManager.mViewEmptyText);
            }
            if (mPlaceHolderManager.mViewEmptyTextSize > 0) {
                setTextSize(viewEmptyMessage, mPlaceHolderManager.mViewEmptyTextSize);
            }
            if (mPlaceHolderManager.mViewEmptyTextColor != 0) {
                viewEmptyMessage.setTextColor(getColor(mPlaceHolderManager.mViewEmptyTextColor));
            }
            if (mPlaceHolderManager.mViewEmptyTryAgainButtonText > 0) {
                viewEmptyTryAgainButton.setText(mPlaceHolderManager.mViewEmptyTryAgainButtonText);
            }
            if (mPlaceHolderManager.mViewEmptyTryAgainButtonTextColor > 0) {
                viewEmptyTryAgainButton.setTextColor(mPlaceHolderManager.mViewEmptyTryAgainButtonTextColor);
            }
            if (mPlaceHolderManager.mViewEmptyTryAgainButtonBackgroundResource > 0) {
                int backgroundRes = mPlaceHolderManager.mViewEmptyTryAgainButtonBackgroundResource;
                viewEmptyTryAgainButton.setBackgroundResource(backgroundRes);
            }
            if (mPlaceHolderManager.mViewEmptyImage > 0) {
                viewEmptyImage.setImageDrawable(getDrawable(mPlaceHolderManager.mViewEmptyImage));
            }
        }
    }

    private int getColor(int colorRes) {
        return ContextCompat.getColor(mContext, colorRes);
    }

    private Drawable getDrawable(int drawableRes) {
        return ContextCompat.getDrawable(mContext, drawableRes);
    }

    private void setTextSize(TextView textView, int textSize) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
    }

    /***********************************************************************************************
     *                              Parcelable methods implementation.                             *
     **********************************************************************************************/
    private CustomizeViews(Parcel in) {
        this.mPlaceHolderManager = in.readParcelable(PlaceHolderManager.class.getClassLoader());
    }

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

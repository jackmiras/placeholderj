package com.example.jackmiras.placeholderj.library;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jackson on 12/12/15.
 */
public class PlaceHolderManager implements Parcelable {

    public int mViewErrorBackgroundColor;
    public int mViewErrorBackgroundResource;
    public int mViewErrorText;
    public int mViewErrorTextSize;
    public int mViewErrorTextColor;
    public int mViewErrorTryAgainButtonText;
    public int mViewErrorTryAgainButtonBackgroundResource;
    public int mViewErrorImage;
    public int mViewLoadingBackgroundColor;
    public int mViewLoadingBackgroundResource;
    public int mViewLoadingProgressBarColor;
    public int mViewLoadingText;
    public int mViewLoadingTextSize;
    public int mViewLoadingTextColor;
    public int mViewEmptyBackgroundColor;
    public int mViewEmptyBackgroundResource;
    public int mViewEmptyText;
    public int mViewEmptyTextSize;
    public int mViewEmptyTextColor;
    public int mViewEmptyTryAgainButtonText;
    public int mViewEmptyTryAgainButtonBackgroundResource;
    public int mViewEmptyImage;

    protected PlaceHolderManager(Parcel in) {
        this.mViewErrorBackgroundColor = in.readInt();
        this.mViewErrorBackgroundResource = in.readInt();
        this.mViewErrorText = in.readInt();
        this.mViewErrorTextSize = in.readInt();
        this.mViewErrorTextColor = in.readInt();
        this.mViewErrorTryAgainButtonText = in.readInt();
        this.mViewErrorTryAgainButtonBackgroundResource = in.readInt();
        this.mViewErrorImage = in.readInt();
        this.mViewLoadingBackgroundColor = in.readInt();
        this.mViewLoadingBackgroundResource = in.readInt();
        this.mViewLoadingProgressBarColor = in.readInt();
        this.mViewLoadingText = in.readInt();
        this.mViewLoadingTextSize = in.readInt();
        this.mViewLoadingTextColor = in.readInt();
        this.mViewEmptyBackgroundColor = in.readInt();
        this.mViewEmptyBackgroundResource = in.readInt();
        this.mViewEmptyText = in.readInt();
        this.mViewEmptyTextSize = in.readInt();
        this.mViewEmptyTextColor = in.readInt();
        this.mViewEmptyTryAgainButtonText = in.readInt();
        this.mViewEmptyTryAgainButtonBackgroundResource = in.readInt();
        this.mViewEmptyImage = in.readInt();
    }

    public PlaceHolderManager(int viewErrorBackgroundColor, int viewErrorBackgroundResource,
                              int viewErrorText, int viewErrorTextSize, int viewErrorTextColor,
                              int viewErrorTryAgainButtonText,
                              int viewErrorTryAgainButtonBackgroundResource, int viewErrorImage,
                              int viewLoadingBackgroundColor, int viewLoadingBackgroundResource,
                              int viewLoadingProgressBarColor, int viewLoadingText,
                              int viewLoadingTextSize, int viewLoadingTextColor,
                              int viewEmptyBackgroundColor, int viewEmptyBackgroundResource,
                              int viewEmptyText, int viewEmptyTextSize, int viewEmptyTextColor,
                              int viewEmptyTryAgainButtonText,
                              int viewEmptyTryAgainButtonBackgroundResource, int viewEmptyImage) {
        this.mViewErrorBackgroundColor = viewErrorBackgroundColor;
        this.mViewErrorBackgroundResource = viewErrorBackgroundResource;
        this.mViewErrorText = viewErrorText;
        this.mViewErrorTextSize = viewErrorTextSize;
        this.mViewErrorTextColor = viewErrorTextColor;
        this.mViewErrorTryAgainButtonText = viewErrorTryAgainButtonText;
        this.mViewErrorTryAgainButtonBackgroundResource = viewErrorTryAgainButtonBackgroundResource;
        this.mViewErrorImage = viewErrorImage;
        this.mViewLoadingBackgroundColor = viewLoadingBackgroundColor;
        this.mViewLoadingBackgroundResource = viewLoadingBackgroundResource;
        this.mViewLoadingProgressBarColor = viewLoadingProgressBarColor;
        this.mViewLoadingText = viewLoadingText;
        this.mViewLoadingTextSize = viewLoadingTextSize;
        this.mViewLoadingTextColor = viewLoadingTextColor;
        this.mViewEmptyBackgroundColor = viewEmptyBackgroundColor;
        this.mViewEmptyBackgroundResource = viewEmptyBackgroundResource;
        this.mViewEmptyText = viewEmptyText;
        this.mViewEmptyTextSize = viewEmptyTextSize;
        this.mViewEmptyTextColor = viewEmptyTextColor;
        this.mViewEmptyTryAgainButtonText = viewEmptyTryAgainButtonText;
        this.mViewEmptyTryAgainButtonBackgroundResource = viewEmptyTryAgainButtonBackgroundResource;
        this.mViewEmptyImage = viewEmptyImage;
    }


    public static class Configurator {
        private static int sViewErrorBackgroundColor;
        private static int sViewErrorBackgroundResource;
        private static int sViewErrorText;
        private static int sViewErrorTextSize;
        private static int sViewErrorTextColor;
        private static int sViewErrorTryAgainButtonText;
        private static int sViewErrorTryAgainButtonBackgroundResource;
        private static int sViewErrorImage;
        private static int sViewLoadingBackgroundColor;
        private static int sViewLoadingBackgroundResource;
        private static int sViewLoadingProgressBarColor;
        private static int sViewLoadingText;
        private static int sViewLoadingTextSize;
        private static int sViewLoadingTextColor;
        private static int sViewEmptyBackgroundColor;
        private static int sViewEmptyBackgroundResource;
        private static int sViewEmptyText;
        private static int sViewEmptyTextSize;
        private static int sViewEmptyTextColor;
        private static int sViewEmptyTryAgainButtonText;
        private static int sViewEmptyTryAgainButtonBackgroundResource;
        private static int sViewEmptyImage;

        public Configurator() {
            sViewErrorBackgroundColor = 0;
            sViewErrorBackgroundResource = 0;
            sViewErrorText = 0;
            sViewErrorTextSize = 0;
            sViewErrorTextColor = 0;
            sViewErrorTryAgainButtonText = 0;
            sViewErrorTryAgainButtonBackgroundResource = 0;
            sViewErrorImage = 0;
            sViewLoadingBackgroundColor = 0;
            sViewLoadingBackgroundResource = 0;
            sViewLoadingProgressBarColor = 0;
            sViewLoadingText = 0;
            sViewLoadingTextSize = 0;
            sViewLoadingTextColor = 0;
            sViewEmptyBackgroundColor = 0;
            sViewEmptyBackgroundResource = 0;
            sViewEmptyText = 0;
            sViewEmptyTextSize = 0;
            sViewEmptyTextColor = 0;
            sViewEmptyTryAgainButtonText = 0;
            sViewEmptyTryAgainButtonBackgroundResource = 0;
            sViewEmptyImage = 0;
        }

        /**
         * Customize the error view background color.
         *
         * @param color The id of the color to be applied to the background.
         * @return Configurator The configurator object with the background color to the view.
         */
        public Configurator errorBackground(int color) {
            if (color != 0) {
                sViewErrorBackgroundColor = color;
            }
            return this;
        }

        /**
         * Customize the error view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         * @return Configurator The configurator object with the background resource to the view.
         */
        public Configurator errorBackgroundResource(int backgroundRes) {
            if (backgroundRes > 0) {
                sViewErrorBackgroundResource = backgroundRes;
            }
            return this;
        }

        /**
         * Customize the error view text.
         *
         * @param textRes   Id of the text to be applied.
         * @param textSize  Text size to be applied (in sp).
         * @param textColor The id of the color to be applied to the text.
         * @return Configurator The configurator object with the text resource, text size and text color to the error view.
         */
        public Configurator errorText(int textRes, int textSize, int textColor) {
            if (textRes > 0) {
                sViewErrorText = textRes;
            }
            if (textSize > 0) {
                sViewErrorTextSize = textSize;
            }
            if (textColor > 0) {
                sViewErrorTextColor = textColor;
            }
            return this;
        }

        /**
         * Customize the error view button.
         *
         * @param textRes       Id of the text to be applied.
         * @param backgroundRes Id of the resource to be applied to the background
         * @return Configurator The configurator object with the text and background resource to the error button.
         */
        public Configurator errorButton(int textRes, int backgroundRes) {
            if (textRes > 0) {
                sViewErrorTryAgainButtonText = textRes;
            }
            if (backgroundRes > 0) {
                sViewErrorTryAgainButtonBackgroundResource = backgroundRes;
            }
            return this;
        }

        /**
         * Customize the error view image.
         *
         * @param imageRes Id of the image to be applied on the error view.
         * @return Configurator The configurator object with the image resource to the error view.
         */
        public Configurator errorImage(int imageRes) {
            if (imageRes > 0) {
                sViewErrorImage = imageRes;
            }
            return this;
        }

        /**
         * Customize the error view text.
         *
         * @param textRes   Id of the text to be applied.
         * @param textSize  Text size to be applied (in sp).
         * @param textColor The id of the color to be applied to the text.
         * @return Configurator The configurator object with the text resource, text size and text color to the error view.
         */
        public Configurator loadingText(int textRes, int textSize, int textColor) {
            if (textRes > 0) {
                sViewLoadingText = textRes;
            }
            if (textSize > 0) {
                sViewLoadingTextSize = textSize;
            }
            if (textColor > 0) {
                sViewLoadingTextColor = textColor;
            }
            return this;
        }

        /**
         * Customize the loading view background.
         *
         * @param color The id of the color to be applied to the background.
         * @return Configurator The configurator object with the background color to the loading view.
         */
        public Configurator loadingBackground(int color) {
            if (color != 0) {
                sViewLoadingBackgroundColor = color;
            }
            return this;
        }

        /**
         * Customize the loading view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         * @return Configurator The configurator object with the background resource to the loading view.
         */
        public Configurator loadingBackgroundResource(int backgroundRes) {
            if (backgroundRes > 0) {
                sViewLoadingBackgroundResource = backgroundRes;
            }
            return this;
        }

        /**
         * Customize the progress bar color inside loading view.
         *
         * @param color The id of the color to be applied to the progress bar.
         * @return Configurator The configurator object with the progress bar color to the loading view.
         */
        public Configurator progressBarColor(int color) {
            if (color != 0) {
                sViewLoadingProgressBarColor = color;
            }
            return this;
        }

        /**
         * Customize the empty view background.
         *
         * @param color The id of the color to be applied to the background.
         * @return Configurator The configurator object with the background color to the empty view.
         */
        public Configurator emptyBackground(int color) {
            if (color != 0) {
                sViewEmptyBackgroundColor = color;
            }
            return this;
        }

        /**
         * Customize the empty view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         * @return Configurator The configurator object with the background resource to the empty view.
         */
        public Configurator emptyBackgroundResource(int backgroundRes) {
            if (backgroundRes > 0) {
                sViewEmptyBackgroundResource = backgroundRes;
            }
            return this;
        }

        /**
         * Customize the error view text.
         *
         * @param textRes   Id of the text to be applied.
         * @param textSize  Text size to be applied (in sp).
         * @param textColor The id of the color to be applied to the text.
         * @return Configurator The configurator object with the text resource, text size and text color to the error view.
         */
        public Configurator emptyText(int textRes, int textSize, int textColor) {
            if (textRes > 0) {
                sViewEmptyText = textRes;
            }
            if (textSize > 0) {
                sViewEmptyTextSize = textSize;
            }
            if (textColor > 0) {
                sViewEmptyTextColor = textColor;
            }
            return this;
        }

        /**
         * Customize the empty view button.
         *
         * @param textRes       Id of the text to be applied.
         * @param backgroundRes Id of the resource to be applied to the background
         * @return Configurator The configurator object with the text and background resource to the empty view.
         */
        public Configurator emptyButton(int textRes, int backgroundRes) {
            if (textRes > 0) {
                sViewEmptyTryAgainButtonText = textRes;
            }
            if (backgroundRes > 0) {
                sViewEmptyTryAgainButtonBackgroundResource = backgroundRes;
            }
            return this;
        }

        /**
         * Customize the empty view image.
         *
         * @param imageRes Id of the image to be applied on the empty view.
         * @return Configurator The configurator object with the image resource to the empty view.
         */
        public Configurator emptyImage(int imageRes) {
            if (imageRes > 0) {
                sViewEmptyImage = imageRes;
            }
            return this;
        }

        public PlaceHolderManager config() {
            return new PlaceHolderManager(sViewErrorBackgroundColor,
                    sViewErrorBackgroundResource,
                    sViewErrorText, sViewErrorTextSize,
                    sViewErrorTextColor,
                    sViewErrorTryAgainButtonText,
                    sViewErrorTryAgainButtonBackgroundResource,
                    sViewErrorImage,
                    sViewLoadingBackgroundColor,
                    sViewLoadingBackgroundResource,
                    sViewLoadingProgressBarColor,
                    sViewLoadingText,
                    sViewLoadingTextSize,
                    sViewLoadingTextColor,
                    sViewEmptyBackgroundColor,
                    sViewEmptyBackgroundResource,
                    sViewEmptyText,
                    sViewEmptyTextSize,
                    sViewEmptyTextColor,
                    sViewEmptyTryAgainButtonText,
                    sViewEmptyTryAgainButtonBackgroundResource,
                    sViewEmptyImage);
        }
    }

    /***********************************************************************************************
     *                              Parcelable methods implementation.                             *
     **********************************************************************************************/
    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mViewErrorBackgroundColor);
        dest.writeInt(this.mViewErrorBackgroundResource);
        dest.writeInt(this.mViewErrorText);
        dest.writeInt(this.mViewErrorTextSize);
        dest.writeInt(this.mViewErrorTextColor);
        dest.writeInt(this.mViewErrorTryAgainButtonText);
        dest.writeInt(this.mViewErrorTryAgainButtonBackgroundResource);
        dest.writeInt(this.mViewErrorImage);
        dest.writeInt(this.mViewLoadingBackgroundColor);
        dest.writeInt(this.mViewLoadingBackgroundResource);
        dest.writeInt(this.mViewLoadingProgressBarColor);
        dest.writeInt(this.mViewLoadingText);
        dest.writeInt(this.mViewLoadingTextSize);
        dest.writeInt(this.mViewLoadingTextColor);
        dest.writeInt(this.mViewEmptyBackgroundColor);
        dest.writeInt(this.mViewEmptyBackgroundResource);
        dest.writeInt(this.mViewEmptyText);
        dest.writeInt(this.mViewEmptyTextSize);
        dest.writeInt(this.mViewEmptyTextColor);
        dest.writeInt(this.mViewEmptyTryAgainButtonText);
        dest.writeInt(this.mViewEmptyTryAgainButtonBackgroundResource);
        dest.writeInt(this.mViewEmptyImage);
    }

    public static final Creator<PlaceHolderManager> CREATOR = new Creator<PlaceHolderManager>() {
        @Override
        public PlaceHolderManager createFromParcel(Parcel source) {return new PlaceHolderManager(source);}

        @Override
        public PlaceHolderManager[] newArray(int size) {return new PlaceHolderManager[size];}
    };
}

package com.example.jackmiras.placeholderj.library;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jackson on 12/12/15.
 */
public class PlaceHolderManager implements Parcelable {

    public int viewErrorBackgroundColor;
    public int viewErrorBackgroundResource;
    public int viewErrorText;
    public int viewErrorTextSize;
    public int viewErrorTextColor;
    public int viewErrorTryAgainButtonText;
    public int viewErrorTryAgainButtonBackgroundResource;
    public int viewErrorImage;
    public int viewLoadingBackgroundColor;
    public int viewLoadingBackgroundResource;
    public int viewLoadingProgressBarColor;
    public int viewLoadingText;
    public int viewLoadingTextSize;
    public int viewLoadingTextColor;
    public int viewEmptyBackgroundColor;
    public int viewEmptyBackgroundResource;
    public int viewEmptyText;
    public int viewEmptyTextSize;
    public int viewEmptyTextColor;
    public int viewEmptyTryAgainButtonText;
    public int viewEmptyTryAgainButtonBackgroundResource;
    public int viewEmptyImage;

    protected PlaceHolderManager(Parcel in) {
        this.viewErrorBackgroundColor = in.readInt();
        this.viewErrorBackgroundResource = in.readInt();
        this.viewErrorText = in.readInt();
        this.viewErrorTextSize = in.readInt();
        this.viewErrorTextColor = in.readInt();
        this.viewErrorTryAgainButtonText = in.readInt();
        this.viewErrorTryAgainButtonBackgroundResource = in.readInt();
        this.viewErrorImage = in.readInt();
        this.viewLoadingBackgroundColor = in.readInt();
        this.viewLoadingBackgroundResource = in.readInt();
        this.viewLoadingProgressBarColor = in.readInt();
        this.viewLoadingText = in.readInt();
        this.viewLoadingTextSize = in.readInt();
        this.viewLoadingTextColor = in.readInt();
        this.viewEmptyBackgroundColor = in.readInt();
        this.viewEmptyBackgroundResource = in.readInt();
        this.viewEmptyText = in.readInt();
        this.viewEmptyTextSize = in.readInt();
        this.viewEmptyTextColor = in.readInt();
        this.viewEmptyTryAgainButtonText = in.readInt();
        this.viewEmptyTryAgainButtonBackgroundResource = in.readInt();
        this.viewEmptyImage = in.readInt();
    }

    public PlaceHolderManager(int viewErrorBackgroundColor, int viewErrorBackgroundResource, int viewErrorText, int viewErrorTextSize, int viewErrorTextColor, int viewErrorTryAgainButtonText, int viewErrorTryAgainButtonBackgroundResource, int viewErrorImage, int viewLoadingBackgroundColor, int viewLoadingBackgroundResource, int viewLoadingProgressBarColor, int viewLoadingText, int viewLoadingTextSize, int viewLoadingTextColor, int viewEmptyBackgroundColor, int viewEmptyBackgroundResource, int viewEmptyText, int viewEmptyTextSize, int viewEmptyTextColor, int viewEmptyTryAgainButtonText, int viewEmptyTryAgainButtonBackgroundResource, int viewEmptyImage) {
        this.viewErrorBackgroundColor = viewErrorBackgroundColor;
        this.viewErrorBackgroundResource = viewErrorBackgroundResource;
        this.viewErrorText = viewErrorText;
        this.viewErrorTextSize = viewErrorTextSize;
        this.viewErrorTextColor = viewErrorTextColor;
        this.viewErrorTryAgainButtonText = viewErrorTryAgainButtonText;
        this.viewErrorTryAgainButtonBackgroundResource = viewErrorTryAgainButtonBackgroundResource;
        this.viewErrorImage = viewErrorImage;
        this.viewLoadingBackgroundColor = viewLoadingBackgroundColor;
        this.viewLoadingBackgroundResource = viewLoadingBackgroundResource;
        this.viewLoadingProgressBarColor = viewLoadingProgressBarColor;
        this.viewLoadingText = viewLoadingText;
        this.viewLoadingTextSize = viewLoadingTextSize;
        this.viewLoadingTextColor = viewLoadingTextColor;
        this.viewEmptyBackgroundColor = viewEmptyBackgroundColor;
        this.viewEmptyBackgroundResource = viewEmptyBackgroundResource;
        this.viewEmptyText = viewEmptyText;
        this.viewEmptyTextSize = viewEmptyTextSize;
        this.viewEmptyTextColor = viewEmptyTextColor;
        this.viewEmptyTryAgainButtonText = viewEmptyTryAgainButtonText;
        this.viewEmptyTryAgainButtonBackgroundResource = viewEmptyTryAgainButtonBackgroundResource;
        this.viewEmptyImage = viewEmptyImage;
    }


    public static class Configurator {
        private static int viewErrorBackgroundColor;
        private static int viewErrorBackgroundResource;
        private static int viewErrorText;
        private static int viewErrorTextSize;
        private static int viewErrorTextColor;
        private static int viewErrorTryAgainButtonText;
        private static int viewErrorTryAgainButtonBackgroundResource;
        private static int viewErrorImage;
        private static int viewLoadingBackgroundColor;
        private static int viewLoadingBackgroundResource;
        private static int viewLoadingProgressBarColor;
        private static int viewLoadingText;
        private static int viewLoadingTextSize;
        private static int viewLoadingTextColor;
        private static int viewEmptyBackgroundColor;
        private static int viewEmptyBackgroundResource;
        private static int viewEmptyText;
        private static int viewEmptyTextSize;
        private static int viewEmptyTextColor;
        private static int viewEmptyTryAgainButtonText;
        private static int viewEmptyTryAgainButtonBackgroundResource;
        private static int viewEmptyImage;

        public Configurator() {
            viewErrorBackgroundColor = 0;
            viewErrorBackgroundResource = 0;
            viewErrorText = 0;
            viewErrorTextSize = 0;
            viewErrorTextColor = 0;
            viewErrorTryAgainButtonText = 0;
            viewErrorTryAgainButtonBackgroundResource = 0;
            viewErrorImage = 0;
            viewLoadingBackgroundColor = 0;
            viewLoadingBackgroundResource = 0;
            viewLoadingProgressBarColor = 0;
            viewLoadingText = 0;
            viewLoadingTextSize = 0;
            viewLoadingTextColor = 0;
            viewEmptyBackgroundColor = 0;
            viewEmptyBackgroundResource = 0;
            viewEmptyText = 0;
            viewEmptyTextSize = 0;
            viewEmptyTextColor = 0;
            viewEmptyTryAgainButtonText = 0;
            viewEmptyTryAgainButtonBackgroundResource = 0;
            viewEmptyImage = 0;
        }

        /**
         * Customize the error view background color.
         *
         * @param color The id of the color to be applied to the background.
         * @return Configurator The configurator object with the background color to the view.
         */
        public Configurator errorBackground(int color) {
            if (color != 0) {
                viewErrorBackgroundColor = color;
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
                viewErrorBackgroundResource = backgroundRes;
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
                viewErrorText = textRes;
            }
            if (textSize > 0) {
                viewErrorTextSize = textSize;
            }
            if (textColor > 0) {
                viewErrorTextColor = textColor;
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
                viewErrorTryAgainButtonText = textRes;
            }
            if (backgroundRes > 0) {
                viewErrorTryAgainButtonBackgroundResource = backgroundRes;
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
                viewErrorImage = imageRes;
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
                viewLoadingText = textRes;
            }
            if (textSize > 0) {
                viewLoadingTextSize = textSize;
            }
            if (textColor > 0) {
                viewLoadingTextColor = textColor;
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
                viewLoadingBackgroundColor = color;
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
                viewLoadingBackgroundResource = backgroundRes;
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
                viewLoadingProgressBarColor = color;
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
                viewEmptyBackgroundColor = color;
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
                viewEmptyBackgroundResource = backgroundRes;
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
                viewEmptyText = textRes;
            }
            if (textSize > 0) {
                viewEmptyTextSize = textSize;
            }
            if (textColor > 0) {
                viewEmptyTextColor = textColor;
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
                viewEmptyTryAgainButtonText = textRes;
            }
            if (backgroundRes > 0) {
                viewEmptyTryAgainButtonBackgroundResource = backgroundRes;
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
                viewEmptyImage = imageRes;
            }
            return this;
        }

        public PlaceHolderManager config() {
            return new PlaceHolderManager(viewErrorBackgroundColor,
                    viewErrorBackgroundResource,
                    viewErrorText, viewErrorTextSize,
                    viewErrorTextColor,
                    viewErrorTryAgainButtonText,
                    viewErrorTryAgainButtonBackgroundResource,
                    viewErrorImage,
                    viewLoadingBackgroundColor,
                    viewLoadingBackgroundResource,
                    viewLoadingProgressBarColor,
                    viewLoadingText,
                    viewLoadingTextSize,
                    viewLoadingTextColor,
                    viewEmptyBackgroundColor,
                    viewEmptyBackgroundResource,
                    viewEmptyText,
                    viewEmptyTextSize,
                    viewEmptyTextColor,
                    viewEmptyTryAgainButtonText,
                    viewEmptyTryAgainButtonBackgroundResource,
                    viewEmptyImage);
        }
    }

    /***********************************************************************************************
     *                              Parcelable methods implementation.                             *
     **********************************************************************************************/
    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.viewErrorBackgroundColor);
        dest.writeInt(this.viewErrorBackgroundResource);
        dest.writeInt(this.viewErrorText);
        dest.writeInt(this.viewErrorTextSize);
        dest.writeInt(this.viewErrorTextColor);
        dest.writeInt(this.viewErrorTryAgainButtonText);
        dest.writeInt(this.viewErrorTryAgainButtonBackgroundResource);
        dest.writeInt(this.viewErrorImage);
        dest.writeInt(this.viewLoadingBackgroundColor);
        dest.writeInt(this.viewLoadingBackgroundResource);
        dest.writeInt(this.viewLoadingProgressBarColor);
        dest.writeInt(this.viewLoadingText);
        dest.writeInt(this.viewLoadingTextSize);
        dest.writeInt(this.viewLoadingTextColor);
        dest.writeInt(this.viewEmptyBackgroundColor);
        dest.writeInt(this.viewEmptyBackgroundResource);
        dest.writeInt(this.viewEmptyText);
        dest.writeInt(this.viewEmptyTextSize);
        dest.writeInt(this.viewEmptyTextColor);
        dest.writeInt(this.viewEmptyTryAgainButtonText);
        dest.writeInt(this.viewEmptyTryAgainButtonBackgroundResource);
        dest.writeInt(this.viewEmptyImage);
    }

    public static final Creator<PlaceHolderManager> CREATOR = new Creator<PlaceHolderManager>() {
        @Override
        public PlaceHolderManager createFromParcel(Parcel source) {return new PlaceHolderManager(source);}

        @Override
        public PlaceHolderManager[] newArray(int size) {return new PlaceHolderManager[size];}
    };
}

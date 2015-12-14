package com.example.jackmiras.placeholderj.managers.library;

/**
 * Created by jackson on 12/12/15.
 */
public class PlaceHolderManager {

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
    public int viewEmptyBackgroundColor;
    public int viewEmptyBackgroundResource;
    public int viewEmptyText;
    public int viewEmptyTextSize;
    public int viewEmptyTextColor;
    public int viewEmptyTryAgainButtonText;
    public int viewEmptyTryAgainButtonBackgroundResource;
    public int viewEmptyImage;

    public PlaceHolderManager(int viewErrorBackgroundColor, int viewErrorBackgroundResource, int viewErrorText, int viewErrorTextSize, int viewErrorTextColor, int viewErrorTryAgainButtonText, int viewErrorTryAgainButtonBackgroundResource, int viewErrorImage, int viewLoadingBackgroundColor, int viewLoadingBackgroundResource, int viewEmptyBackgroundColor, int viewEmptyBackgroundResource, int viewEmptyText, int viewEmptyTextSize, int viewEmptyTextColor, int viewEmptyTryAgainButtonText, int viewEmptyTryAgainButtonBackgroundResource, int viewEmptyImage) {
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
        private static int viewEmptyBackgroundColor;
        private static int viewEmptyBackgroundResource;
        private static int viewEmptyText;
        private static int viewEmptyTextSize;
        private static int viewEmptyTextColor;
        private static int viewEmptyTryAgainButtonText;
        private static int viewEmptyTryAgainButtonBackgroundResource;
        private static int viewEmptyImage;

        /**
         * Error view configurations
         */
        public Configurator errorBackgroundColor(int color) {
            viewErrorBackgroundColor = color;
            return this;
        }

        public Configurator errorBackgroundResource(int backgroundRes) {
            viewErrorBackgroundResource = backgroundRes;
            return this;
        }

        public Configurator errorText(int text, int textSize, int textColor) {
            viewErrorText = text;
            viewErrorTextSize = textSize;
            viewErrorTextColor = textColor;
            return this;
        }

        public Configurator errorButton(int text, int resource) {
            viewErrorTryAgainButtonText = text;
            viewErrorTryAgainButtonBackgroundResource = resource;
            return this;
        }

        public Configurator errorImage(int imageRes) {
            viewErrorImage = imageRes;
            return this;
        }

        /**
         * Loading view configurations
         */
        public Configurator loadingBackground(int color) {
            viewLoadingBackgroundColor = color;
            return this;
        }

        public Configurator loadingBackgroundResource(int backgroundRes) {
            viewLoadingBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Empty view configurations
         */
        public Configurator emptyBackground(int color) {
            viewEmptyBackgroundColor = color;
            return this;
        }

        public Configurator emptyBackgroundResource(int backgroundResource) {
            viewEmptyBackgroundResource = backgroundResource;
            return this;
        }

        public Configurator emptyText(int text, int textSize, int textColor) {
            viewEmptyText = text;
            viewEmptyTextSize = textSize;
            viewEmptyTextColor = textColor;
            return this;
        }

        public Configurator emptyButton(int text, int resource) {
            viewEmptyTryAgainButtonText = text;
            viewEmptyTryAgainButtonBackgroundResource = resource;
            return this;
        }

        public Configurator emptyImage(int imageRes) {
            viewEmptyImage = imageRes;
            return this;
        }

        public PlaceHolderManager config() {
            return new PlaceHolderManager(viewErrorBackgroundColor, viewErrorBackgroundResource, viewErrorText, viewErrorTextSize, viewErrorTextColor, viewErrorTryAgainButtonText, viewErrorTryAgainButtonBackgroundResource, viewErrorImage, viewLoadingBackgroundColor, viewLoadingBackgroundResource, viewEmptyBackgroundColor, viewEmptyBackgroundResource, viewEmptyText, viewEmptyTextSize, viewEmptyTextColor, viewEmptyTryAgainButtonText, viewEmptyTryAgainButtonBackgroundResource, viewEmptyImage);
        }
    }
}

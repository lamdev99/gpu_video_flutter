package com.example.fl_plugin.sample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.fl_plugin.R;
import com.example.fl_plugin.egl.filter.GlBilateralFilter;
import com.example.fl_plugin.egl.filter.GlBoxBlurFilter;
import com.example.fl_plugin.egl.filter.GlBrightnessFilter;
import com.example.fl_plugin.egl.filter.GlBulgeDistortionFilter;
import com.example.fl_plugin.egl.filter.GlCGAColorspaceFilter;
import com.example.fl_plugin.egl.filter.GlContrastFilter;
import com.example.fl_plugin.egl.filter.GlCrosshatchFilter;
import com.example.fl_plugin.egl.filter.GlExposureFilter;
import com.example.fl_plugin.egl.filter.GlFilter;
import com.example.fl_plugin.egl.filter.GlFilterGroup;
import com.example.fl_plugin.egl.filter.GlGammaFilter;
import com.example.fl_plugin.egl.filter.GlGaussianBlurFilter;
import com.example.fl_plugin.egl.filter.GlGrayScaleFilter;
import com.example.fl_plugin.egl.filter.GlHalftoneFilter;
import com.example.fl_plugin.egl.filter.GlHazeFilter;
import com.example.fl_plugin.egl.filter.GlHighlightShadowFilter;
import com.example.fl_plugin.egl.filter.GlHueFilter;
import com.example.fl_plugin.egl.filter.GlInvertFilter;
import com.example.fl_plugin.egl.filter.GlLookUpTableFilter;
import com.example.fl_plugin.egl.filter.GlLuminanceFilter;
import com.example.fl_plugin.egl.filter.GlLuminanceThresholdFilter;
import com.example.fl_plugin.egl.filter.GlMonochromeFilter;
import com.example.fl_plugin.egl.filter.GlOpacityFilter;
import com.example.fl_plugin.egl.filter.GlPixelationFilter;
import com.example.fl_plugin.egl.filter.GlPosterizeFilter;
import com.example.fl_plugin.egl.filter.GlRGBFilter;
import com.example.fl_plugin.egl.filter.GlSaturationFilter;
import com.example.fl_plugin.egl.filter.GlSepiaFilter;
import com.example.fl_plugin.egl.filter.GlSharpenFilter;
import com.example.fl_plugin.egl.filter.GlSolarizeFilter;
import com.example.fl_plugin.egl.filter.GlSphereRefractionFilter;
import com.example.fl_plugin.egl.filter.GlSwirlFilter;
import com.example.fl_plugin.egl.filter.GlToneCurveFilter;
import com.example.fl_plugin.egl.filter.GlToneFilter;
import com.example.fl_plugin.egl.filter.GlVibranceFilter;
import com.example.fl_plugin.egl.filter.GlVignetteFilter;
import com.example.fl_plugin.egl.filter.GlWatermarkFilter;
import com.example.fl_plugin.egl.filter.GlWeakPixelInclusionFilter;
import com.example.fl_plugin.egl.filter.GlWhiteBalanceFilter;
import com.example.fl_plugin.egl.filter.GlZoomBlurFilter;
import com.example.fl_plugin.sample.filter.GlBitmapOverlaySample;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public enum FilterType {
    DEFAULT,
    BILATERAL_BLUR,
    BOX_BLUR,
    BRIGHTNESS,
    BULGE_DISTORTION,
    CGA_COLORSPACE,
    CONTRAST,
    CROSSHATCH,
    EXPOSURE,
    FILTER_GROUP_SAMPLE,
    GAMMA,
    GAUSSIAN_FILTER,
    GRAY_SCALE,
    HALFTONE,
    HAZE,
    HIGHLIGHT_SHADOW,
    HUE,
    INVERT,
    LOOK_UP_TABLE_SAMPLE,
    LUMINANCE,
    LUMINANCE_THRESHOLD,
    MONOCHROME,
    OPACITY,
    OVERLAY,
    PIXELATION,
    POSTERIZE,
    RGB,
    SATURATION,
    SEPIA,
    SHARP,
    SOLARIZE,
    SPHERE_REFRACTION,
    SWIRL,
    TONE_CURVE_SAMPLE,
    TONE,
    VIBRANCE,
    VIGNETTE,
    WATERMARK,
    WEAK_PIXEL,
    WHITE_BALANCE,
    ZOOM_BLUR,
    BITMAP_OVERLAY_SAMPLE;


    public static List<FilterType> createFilterList() {
        return Arrays.asList(FilterType.values());
    }

    public static GlFilter createGlFilter(FilterType filterType, Context context) {
        switch (filterType) {
            case DEFAULT:
                return new GlFilter();
            case BILATERAL_BLUR:
                return new GlBilateralFilter();
            case BOX_BLUR:
                return new GlBoxBlurFilter();
            case BRIGHTNESS:
                GlBrightnessFilter glBrightnessFilter = new GlBrightnessFilter();
                glBrightnessFilter.setBrightness(0.2f);
                return glBrightnessFilter;
            case BULGE_DISTORTION:
                return new GlBulgeDistortionFilter();
            case CGA_COLORSPACE:
                return new GlCGAColorspaceFilter();
            case CONTRAST:
                GlContrastFilter glContrastFilter = new GlContrastFilter();
                glContrastFilter.setContrast(2.5f);
                return glContrastFilter;
            case CROSSHATCH:
                return new GlCrosshatchFilter();
            case EXPOSURE:
                return new GlExposureFilter();
            case FILTER_GROUP_SAMPLE:
                return new GlFilterGroup(new GlSepiaFilter(), new GlVignetteFilter());
            case GAMMA:
                GlGammaFilter glGammaFilter = new GlGammaFilter();
                glGammaFilter.setGamma(2f);
                return glGammaFilter;
            case GAUSSIAN_FILTER:
                return new GlGaussianBlurFilter();
            case GRAY_SCALE:
                return new GlGrayScaleFilter();
            case HALFTONE:
                return new GlHalftoneFilter();
            case HAZE:
                GlHazeFilter glHazeFilter = new GlHazeFilter();
                glHazeFilter.setSlope(-0.5f);
                return glHazeFilter;
            case HIGHLIGHT_SHADOW:
                return new GlHighlightShadowFilter();
            case HUE:
                return new GlHueFilter();
            case INVERT:
                return new GlInvertFilter();
            case LOOK_UP_TABLE_SAMPLE:
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.lookup_sample);
                return new GlLookUpTableFilter(bitmap);
            case LUMINANCE:
                return new GlLuminanceFilter();
            case LUMINANCE_THRESHOLD:
                return new GlLuminanceThresholdFilter();
            case MONOCHROME:
                return new GlMonochromeFilter();
            case OPACITY:
                return new GlOpacityFilter();
            case PIXELATION:
                return new GlPixelationFilter();
            case POSTERIZE:
                return new GlPosterizeFilter();
            case RGB:
                GlRGBFilter glRGBFilter = new GlRGBFilter();
                glRGBFilter.setRed(0f);
                return glRGBFilter;
            case SATURATION:
                return new GlSaturationFilter();
            case SEPIA:
                return new GlSepiaFilter();
            case SHARP:
                GlSharpenFilter glSharpenFilter = new GlSharpenFilter();
                glSharpenFilter.setSharpness(4f);
                return glSharpenFilter;
            case SOLARIZE:
                return new GlSolarizeFilter();
            case SPHERE_REFRACTION:
                return new GlSphereRefractionFilter();
            case SWIRL:
                return new GlSwirlFilter();
            case TONE_CURVE_SAMPLE:
                try {
                    InputStream is = context.getAssets().open("acv/tone_cuver_sample.acv");
                    return new GlToneCurveFilter(is);
                } catch (IOException e) {
                    Log.e("FilterType", "Error");
                }
                return new GlFilter();
            case TONE:
                return new GlToneFilter();
            case VIBRANCE:
                GlVibranceFilter glVibranceFilter = new GlVibranceFilter();
                glVibranceFilter.setVibrance(3f);
                return glVibranceFilter;
            case VIGNETTE:
                return new GlVignetteFilter();
            case WATERMARK:
                return new GlWatermarkFilter(BitmapFactory.decodeResource(context.getResources(), R.drawable.sample_bitmap), GlWatermarkFilter.Position.RIGHT_BOTTOM);
            case WEAK_PIXEL:
                return new GlWeakPixelInclusionFilter();
            case WHITE_BALANCE:
                GlWhiteBalanceFilter glWhiteBalanceFilter = new GlWhiteBalanceFilter();
                glWhiteBalanceFilter.setTemperature(2400f);
                glWhiteBalanceFilter.setTint(2f);
                return glWhiteBalanceFilter;
            case ZOOM_BLUR:
                return new GlZoomBlurFilter();
            case BITMAP_OVERLAY_SAMPLE:
                return new GlBitmapOverlaySample(BitmapFactory.decodeResource(context.getResources(), R.drawable.sample_bitmap));
            default:
                return new GlFilter();
        }
    }

    public static FilterAdjuster createFilterAdjuster(FilterType filterType) {
        switch (filterType) {
            case BILATERAL_BLUR:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlBilateralFilter) filter).setBlurSize(range(percentage, 0.0f, 1.0f));
                    }
                };
            case BOX_BLUR:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlBoxBlurFilter) filter).setBlurSize(range(percentage, 0.0f, 1.0f));
                    }
                };
            case BRIGHTNESS:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlBrightnessFilter) filter).setBrightness(range(percentage, -1.0f, 1.0f));
                    }
                };
            case CONTRAST:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlContrastFilter) filter).setContrast(range(percentage, 0.0f, 2.0f));
                    }
                };
            case CROSSHATCH:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlCrosshatchFilter) filter).setCrossHatchSpacing(range(percentage, 0.0f, 0.06f));
                        ((GlCrosshatchFilter) filter).setLineWidth(range(percentage, 0.0f, 0.006f));
                    }
                };
            case EXPOSURE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlExposureFilter) filter).setExposure(range(percentage, -10.0f, 10.0f));
                    }
                };
            case GAMMA:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlGammaFilter) filter).setGamma(range(percentage, 0.0f, 3.0f));
                    }
                };
            case HAZE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlHazeFilter) filter).setDistance(range(percentage, -0.3f, 0.3f));
                        ((GlHazeFilter) filter).setSlope(range(percentage, -0.3f, 0.3f));
                    }
                };
            case HIGHLIGHT_SHADOW:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlHighlightShadowFilter) filter).setShadows(range(percentage, 0.0f, 1.0f));
                        ((GlHighlightShadowFilter) filter).setHighlights(range(percentage, 0.0f, 1.0f));
                    }
                };
            case HUE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlHueFilter) filter).setHue(range(percentage, 0.0f, 360.0f));
                    }
                };
            case LUMINANCE_THRESHOLD:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlLuminanceThresholdFilter) filter).setThreshold(range(percentage, 0.0f, 1.0f));
                    }
                };
            case MONOCHROME:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlMonochromeFilter) filter).setIntensity(range(percentage, 0.0f, 1.0f));
                    }
                };
            case OPACITY:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlOpacityFilter) filter).setOpacity(range(percentage, 0.0f, 1.0f));
                    }
                };
            case PIXELATION:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlPixelationFilter) filter).setPixel(range(percentage, 1.0f, 100.0f));
                    }
                };
            case POSTERIZE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        // In theorie to 256, but only first 50 are interesting
                        ((GlPosterizeFilter) filter).setColorLevels((int) range(percentage, 1, 50));
                    }
                };
            case RGB:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlRGBFilter) filter).setRed(range(percentage, 0.0f, 1.0f));
                    }
                };
            case SATURATION:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlSaturationFilter) filter).setSaturation(range(percentage, 0.0f, 2.0f));
                    }
                };
            case SHARP:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlSharpenFilter) filter).setSharpness(range(percentage, -4.0f, 4.0f));
                    }
                };
            case SOLARIZE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlSolarizeFilter) filter).setThreshold(range(percentage, 0.0f, 1.0f));
                    }
                };
            case SWIRL:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlSwirlFilter) filter).setAngle(range(percentage, 0.0f, 2.0f));
                    }
                };
            case VIBRANCE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlVibranceFilter) filter).setVibrance(range(percentage, -1.2f, 1.2f));
                    }
                };
            case VIGNETTE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlVignetteFilter) filter).setVignetteStart(range(percentage, 0.0f, 1.0f));
                    }
                };
            case WHITE_BALANCE:
                return new FilterAdjuster() {
                    @Override
                    public void adjust(GlFilter filter, int percentage) {
                        ((GlWhiteBalanceFilter) filter).setTemperature(range(percentage, 2000.0f, 8000.0f));
                    }
                };
            default:
                return null;
        }
    }

    private static float range(int percentage, float start, float end) {
        return (end - start) * percentage / 100.0f + start;
    }
}

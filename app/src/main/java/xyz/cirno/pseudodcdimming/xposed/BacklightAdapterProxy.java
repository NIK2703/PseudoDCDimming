package xyz.cirno.pseudodcdimming.xposed;

import java.lang.reflect.Method;

public class BacklightAdapterProxy {
    private final Object adapter;
    private final Method setBacklightMethod;
    private volatile boolean galleryHdrBoost;

    public BacklightAdapterProxy(Object adapter, Method setBacklightMethod) {
        this.adapter = adapter;
        this.setBacklightMethod = setBacklightMethod;
    }

    public void setGalleryHdrBoost(boolean galleryHdrBoost) {
        this.galleryHdrBoost = galleryHdrBoost;
    }

    public void setBacklight(float sdrBacklight, float sdrNits, float backlight, float nits) {
        try {
            if (setBacklightMethod.getParameterCount() == 5) {
                setBacklightMethod.invoke(adapter, sdrBacklight, sdrNits, backlight, nits, galleryHdrBoost);
            } else {
                setBacklightMethod.invoke(adapter, sdrBacklight, sdrNits, backlight, nits);
            }
        } catch (Exception e) {
            // ignore
        }
    }
}

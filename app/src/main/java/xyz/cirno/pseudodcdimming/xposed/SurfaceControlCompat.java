package xyz.cirno.pseudodcdimming.xposed;

import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceControl$StaticDisplayInfo;

import de.robv.android.xposed.XposedHelpers;

public class SurfaceControlCompat {
    private static final String TAG = "PseudoDcBacklight.Xposed";

    public static SurfaceControl$StaticDisplayInfo getStaticDisplayInfo(IBinder displayToken) {
        if (Build.VERSION.SDK_INT >= 34) {
            var dc = DisplayControlProxy.getInstance();
            if (dc != null) {
                for (var physicalDisplayId : dc.getPhysicalDisplayIds()) {
                    if (displayToken.equals(dc.getPhysicalDisplayToken(physicalDisplayId))) {
                        try {
                            return (SurfaceControl$StaticDisplayInfo) XposedHelpers.callStaticMethod(
                                    SurfaceControl.class, "getStaticDisplayInfo", physicalDisplayId);
                        } catch (Throwable t) {
                            Log.w(TAG, "getStaticDisplayInfo(long) failed", t);
                            break;
                        }
                    }
                }
            }
        }
        try {
            return (SurfaceControl$StaticDisplayInfo) XposedHelpers.callStaticMethod(
                    SurfaceControl.class, "getStaticDisplayInfo", displayToken);
        } catch (Throwable t) {
            Log.w(TAG, "getStaticDisplayInfo(IBinder) failed", t);
            return null;
        }
    }
}

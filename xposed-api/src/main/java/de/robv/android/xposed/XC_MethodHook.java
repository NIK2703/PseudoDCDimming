package de.robv.android.xposed;

import android.os.Bundle;

import java.lang.reflect.Member;

public abstract class XC_MethodHook {
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    }

    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
    }

    public static class MethodHookParam {
        public Member method;
        public Object thisObject;
        public Object[] args;
        private final Bundle extra = new Bundle();
        private Throwable throwable;
        private Object result;

        public Bundle getExtra() {
            return extra;
        }

        public boolean hasThrowable() {
            return throwable != null;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }
    }

    public static class Unhook {
        public void unhook() {
        }
    }
}

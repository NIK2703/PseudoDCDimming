package de.robv.android.xposed;

public final class XposedHelpers {
    private XposedHelpers() {
    }

    public static Class<?> findClass(String className, ClassLoader classLoader) {
        throw new RuntimeException("stub");
    }

    public static java.lang.reflect.Method findMethodExact(Class<?> clazz, String methodName, Object... parameterTypes) {
        throw new RuntimeException("stub");
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> clazz, Object... parameterTypesAndCallback) {
        throw new RuntimeException("stub");
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String className, ClassLoader classLoader, String methodName, Object... parameterTypesAndCallback) {
        throw new RuntimeException("stub");
    }

    public static Object callMethod(Object obj, String methodName, Object... args) {
        throw new RuntimeException("stub");
    }

    public static Object callStaticMethod(Class<?> clazz, String methodName, Object... args) {
        throw new RuntimeException("stub");
    }

    public static Object getAdditionalInstanceField(Object obj, String key) {
        throw new RuntimeException("stub");
    }

    public static Object setAdditionalInstanceField(Object obj, String key, Object value) {
        throw new RuntimeException("stub");
    }

    public static boolean getBooleanField(Object obj, String fieldName) {
        throw new RuntimeException("stub");
    }
}

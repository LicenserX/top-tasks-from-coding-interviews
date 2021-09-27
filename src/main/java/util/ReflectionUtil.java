package util;

import java.lang.reflect.Field;

public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static final Object getNonPublicFieldAsObject(Object source, String nameOfFieldToBeExtracted)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = source.getClass().getDeclaredField(nameOfFieldToBeExtracted);
        field.setAccessible(true);
        return field.get(source);
    }
}

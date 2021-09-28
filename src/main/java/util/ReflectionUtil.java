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

    public static final void setValueForNonPublicField(Object target,
                                                       String nameOfFieldToBeInjected,
                                                       Object injectedValue)
            throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(nameOfFieldToBeInjected);
        field.setAccessible(true);
        field.set(target, injectedValue);
    }

    public static final boolean isLeaf(Object treeNode) throws NoSuchFieldException, IllegalAccessException {
        Object leftNode = getNonPublicFieldAsObject(treeNode, "left");
        Object rightNode = getNonPublicFieldAsObject(treeNode, "right");

        if (leftNode == null){
            return rightNode == null;
        }
        return false;
    }
}

package com.perezmejia.systemvd.helper.mapperobject.utils;

import java.lang.reflect.*;

/**
 * Created by Guil on 5/8/2016.
 */
public class MapperUtils {

    public static Class<?> rawTypeFor(Type type) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            return (Class<?>) ((ParameterizedType) type).getRawType();
        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(rawTypeFor(componentType), 0).getClass();
        } else if (type instanceof TypeVariable) {
            return rawTypeFor(((TypeVariable<?>) type).getBounds()[0]);
        } else if (type instanceof WildcardType) {
            return rawTypeFor(((WildcardType) type).getUpperBounds()[0]);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Could not determine raw type for " + className);
        }
    }
}

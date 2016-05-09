package com.perezmejia.systemvd.helper.mapperobject;

import com.perezmejia.systemvd.helper.mapperobject.utils.MapperUtils;

import java.lang.reflect.*;

/**
 * Created by gaperez on 5/5/2016.
 */
@SuppressWarnings("unchecked")
public class TypeToken<T> {
    private final Type type;
    private final Class<T> rawType;

    protected TypeToken() {
        Type superclass = getClass().getGenericSuperclass();
        type = ((ParameterizedType) superclass).getActualTypeArguments()[0];
        rawType = (Class<T>) MapperUtils.rawTypeFor(type);
    }

    private TypeToken(Type type) {
        this.type = type;
        rawType = (Class<T>) MapperUtils.rawTypeFor(type);
    }

    /**
     * Returns the raw type for {@code T}.
     */
    public final Class<T> getRawType() {
        return rawType;
    }

    /**
     * Returns the generic type {@code T}.
     */
    public final Type getType() {
        return type;
    }

    @Override
    public final boolean equals(Object object) {
        return object instanceof TypeToken<?> && type.equals(((TypeToken<?>) object).type);
    }

    @Override
    public final int hashCode() {
        return type.hashCode();
    }

    @Override
    public final String toString() {
        return type.toString();
    }
}

package com.perezmejia.systemvd.helper.mapperobject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by gaperez on 4/29/2016.
 */
public interface Mapper {
    public <T> T map(Object source, T destination);

    public <T> T map(Object source, Class<T> destinationClass);

    public <T> List<T> map(Object source, Type destinationType);

}

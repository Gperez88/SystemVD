package com.perezmejia.systemvd.helper.mapperobject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Guil on 5/7/2016.
 */
public abstract class ParsableObject<D, V extends Parsable> implements Parsable<D, V> {

    private Mapper mapper = MapperObject.getInstance();

    @Override
    public D parse() {
        return mapper.map(this, getDomainClass());
    }

    @SuppressWarnings("unchecked")
    @Override
    public V load(D domain) {
        return (V) mapper.map(domain, this);
    }

//    @Override
//    public List<V> convertViewList(List<D> domainList) {
//        Type domainListType = new TypeToken<List<V>>(){}.getType();
//        return mapper.map(domainList, domainListType);
//    }
//
//    @Override
//    public List<D> convertDomainList(List<V> viewList) {
//        Type viewListType = new TypeToken<List<D>>(){}.getType();
//        return mapper.map(viewList, viewListType);
//    }

    public abstract Class<D> getDomainClass();
}

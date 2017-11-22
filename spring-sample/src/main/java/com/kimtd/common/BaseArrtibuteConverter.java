package com.kimtd.common;

import com.fasterxml.jackson.databind.JavaType;
import com.kimtd.utils.JsonUtils;
import org.springframework.core.ResolvableType;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseArrtibuteConverter<T> implements AttributeConverter<Object,String> {

    private JavaType javaType;

    public BaseArrtibuteConverter() {
        ResolvableType resolvableType = ResolvableType.forClass(getClass());
        Type type = resolvableType.getSuperType().getGeneric().getType();
        javaType = JsonUtils.constructType(type);
    }

    public String convertToDatabaseColumn(Object o) {
        if (o == null)
        return null;
        return JsonUtils.toJson(o);
    }

    public Object convertToEntityAttribute(String s) {
        if (StringUtils.isEmpty(s)) {
            if (List.class.isAssignableFrom(javaType.getRawClass()))
                return Collections.EMPTY_LIST;
            else if (Set.class.isAssignableFrom(javaType.getRawClass()))
                return Collections.EMPTY_SET;
            else if (Map.class.isAssignableFrom(javaType.getRawClass()))
                return Collections.EMPTY_MAP;
            else
                return null;
        }
        return JsonUtils.toObject(s,javaType);
    }
}

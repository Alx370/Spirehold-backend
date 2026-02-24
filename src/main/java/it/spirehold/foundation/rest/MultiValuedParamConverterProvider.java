package com.waveinformatica.hello.foundation.rest;

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Provider
public class MultiValuedParamConverterProvider implements ParamConverterProvider {

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (List.class.isAssignableFrom(rawType)) {
            return (ParamConverter<T>) new MultiValuedParamConverter();
        }

        return null;
    }

    public static class MultiValuedParamConverter implements ParamConverter<List<?>> {

        @Override
        public List<?> fromString(String param) {
            if (param == null || param.trim().isEmpty()) {
                return null;
            }
            return parse(param.split(","));
        }
        @Override
        public String toString(List<?> list) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            return stringify(list);
        }

        private static <T> String stringify(List<T> list) {
            StringBuffer sb = new StringBuffer();
            for (T s : list) {
                sb.append(s).append(',');
            }
            return sb.toString();
        }

        private static List<String> parse(String[] params) {
            List<String> list = new ArrayList<>();
            for (String param : params) {
                list.add(param);
            }
            return list;
        }
    }
}
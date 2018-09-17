package com.arbor.note.poi;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * 利用反射 将POI Excel解析成的map对象转换成POJO实例
 *
 * @author qiaomu.wang
 * @date 2018-09-10
 */
public abstract class BasePoiDTO {

    public static BasePoiDTO setAttribute(BasePoiDTO dto, String name, Object value) {
        Class t = dto.getClass();
        Field[] fields = t.getDeclaredFields();
        for (Field field : fields) {
            TakeoutPoi poi = field.getDeclaredAnnotation(TakeoutPoi.class);
            if (poi.name().equals(name)) {
                try {
                    field.setAccessible(true);
                    field.set(dto, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return dto;
    }

    public static BasePoiDTO generateDTO(Map<String, Object> attrMap, Class<? extends BasePoiDTO> c) {
        try {
            BasePoiDTO dto = c.newInstance();
            Field[] fields = dto.getClass().getDeclaredFields();
            for (Field field : fields) {
                TakeoutPoi annotation = field.getAnnotation(TakeoutPoi.class);
                Object value = attrMap.get(annotation.name());
                if (value == null) {
                    continue;
                }
                field.setAccessible(true);
                field.set(dto, value);
            }
            return dto;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<BasePoiDTO> generateDTOList(List<Map<String, Object>> attrMap, Class<? extends BasePoiDTO> c) {
        if (attrMap == null || attrMap.size() <= 0) {
            return Collections.emptyList();
        }
        List<BasePoiDTO> result = Lists.newArrayList();
        for (Map<String, Object> map : attrMap) {
            result.add(generateDTO(map, c));
        }
        return result;
    }

    public static void main(String[] args) {

        demo2();

        demo1();
    }

    private static void demo2() {
        Map<String, Object> attrMap = Maps.newHashMap();
        attrMap.put("序号", "55555");
        attrMap.put("名称", "555牌");
        attrMap.put("55123", "555牌");
        BasePoiDTO basePoiDTO = generateDTO(attrMap, API.class);
        System.out.println(basePoiDTO);
        API api = (API) basePoiDTO;
        System.out.println(api);
    }

    private static void demo1() {
        API api = new API();
        api.setId("123123");
        System.out.println(api);
        api = (API) setAttribute(api, "名称", "张三");
        System.out.println(api);
    }

    static class API extends BasePoiDTO {
        @TakeoutPoi(name = "序号")
        private String id;
        @TakeoutPoi(name = "名称")
        private String name;

        public String getId() {
            return id;
        }

        public BasePoiDTO.API setId(String id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public BasePoiDTO.API setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("id", id)
                    .append("name", name)
                    .toString();
        }
    }

}

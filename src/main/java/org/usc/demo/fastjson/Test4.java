package org.usc.demo.fastjson;

import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;

/**
 *
 * @author Shunli
 */
public class Test4 {
    public static void main(String[] args) {
        // // Result result = new Result(1, Lists.newArrayList(new ResultDetail("1_1")));
        // Result result = new Result(1, new ResultDetail("1_1"));
        // String json = JSON.toJSONString(result);
        // System.out.println(json);

        // ExtraProcessor processor = new ExtraProcessor() {
        // public void processExtra(Object object, String key, Object value) {
        // Result2 vo = (Result2) object;
        // vo.setName(JSON.parseObject(value.toString()).getString("name"));
        // }
        // };
        //
        // String json = "{\"detail\":{\"name\":\"1_1\"},\"id\":1}";
        // Result2 parseObject = JSON.parseObject(json, Result2.class, processor);
        // System.out.println(parseObject);

        ExtraProcessor processor = new ExtraProcessor() {
            public void processExtra(Object object, String key, Object value) {
                Result2 vo = (Result2) object;
                vo.setName(JSON.parseObject(value.toString()).getString("name"));
            }
        };

        String json = "{\"detail\":{\"name\":\"1_1\"},\"id\":1}";
        Result2 parseObject = JSON.parseObject(json, Result2.class, new MyExtraProcessor());
        System.out.println(parseObject);

        // System.out.println(JSON.parseObject(json).getJSONObject("detail").toJSON(parseObject));

    }
}

class MyExtraProcessor implements ExtraProcessor, ExtraTypeProvider {
    public void processExtra(Object object, String key, Object value) {
        // VO vo = (VO) object;
        // vo.getAttributes().put(key, value);
    }

    @Override
    public Type getExtraType(Object object, String key) {
        System.out.println("1:" + object);
        System.out.println("2:" + key);
        if ("detail".equals(key)) {
            return String.class;
        }

        return null;
    }

};

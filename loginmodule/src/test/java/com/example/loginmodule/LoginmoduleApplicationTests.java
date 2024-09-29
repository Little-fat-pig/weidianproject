package com.example.loginmodule;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class LoginmoduleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testJsonObject() {

        /**
         * 关于Optional整体使用描述
         * 方案一：
         * 1.如果为空，直接跳过下面代码的执行
         * 方案二：
         * 1.如果为空，设置默认的数据，从而执行下面的判断，在退出程序的执行
         *
         */
        JSONObject jsonObject1 = null;

        //方案一下的实现   小点    Optional可以设置单个值  或者是一个对象  下面的列子  对象为主

        Optional<JSONObject> jsonObject11 = Optional.ofNullable(jsonObject1);
        if (jsonObject11.isPresent()) {
            //跳出程序执行过程
            return;
        }

        //方案二   设置默认值  继续程序的执行，在后面的程序处理中   跳出程序的执行过程  这里一般使用orElseGet   orElse不支持lambda表达式

        //如果为空  设置字段设置默认值的两种方式    orElse   orElseGet（支持lambda表达式）
        String code = Optional.ofNullable(jsonObject1).map(x -> x.getString("code")).orElse("-1");
        String code1 = Optional.ofNullable(jsonObject1).map(x -> x.getString("code")).orElseGet(() -> "-1");


        //列举的一个反例
        //对象为空设置默认的对象  并设置默认的错误响应值  orElse只能设置一个空对象   无法为空对象设置 默认值
//        JSONObject jsonObject = Optional.ofNullable(jsonObject1).orElse(()->
//        {JSONObject j= new JSONObject();
//                jsonObject.put("code","-1");
//        }
//        );

        //这种方式可以设置默认的对象  从而可以在方法中获取对应的参数信息

        jsonObject1 = Optional.ofNullable(jsonObject1).orElseGet(() -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", "-1");
            return jsonObject;
        });

        jsonObject1 = Optional.ofNullable(jsonObject1).orElseGet(() -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userFaceList", new JSONArray());
            return jsonObject;
        });

        for (int i = 0; i < jsonObject1.getJSONArray("userFaceList").size(); i++) {
            System.out.println();
        }


        //这段代码表示，具体的业务中使用Optional处理过后的对象的应用
        if ("0".equals(jsonObject1.getString("code"))) {
            System.out.println(jsonObject1);
        }


    }
}

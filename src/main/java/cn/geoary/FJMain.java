/**
 * FileName: FJMain
 * Author:   Geoary
 * Date:     2019/3/16 16:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间         版本号              描述
 */
package cn.geoary;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 *
 * @author Geoary
 * @create 2019/3/16
 */
public class FJMain {
    public static void main(String[] args) {
        getJSONInfo(GenerateJSONObject());
    }

    /**
     * 构建一个jsonobject对象
     *
     * @Author Zhangc
     * @Description
     * @Date 16:55 2019/3/16
     * @Param
     * @return
     **/
    public static JSONObject GenerateJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "阿三");
        jsonObject.put("age", 30);
        jsonObject.put("gender", "男");
        jsonObject.put("deposit", 800000.12);
        List<HashMap<String, String>> listExperience = new ArrayList<>();
        HashMap<String, String> experience1 = new HashMap<>();
        experience1.put("company", "百度");
        experience1.put("workTime", "24月");
        experience1.put("workPlace", "背景");
        HashMap<String, String> experience2 = new HashMap<>();
        experience2.put("company", "阿里");
        experience2.put("workTime", "30月");
        experience2.put("workPlace", "杭州");
        HashMap<String, String> experience3 = new HashMap<>();
        experience3.put("company", "京东");
        experience3.put("workTime", "12月");
        experience3.put("workPlace", "北京");
        listExperience.add(experience1);
        listExperience.add(experience2);
        listExperience.add(experience3);
        jsonObject.put("listExperience", listExperience);
        //System.out.println("该jsonObject对象是："+jsonObject.toString());
        return jsonObject;
    }

    /**
     * 获取jsonobject中的数据
     * 特别注意获取jsonarray的方法==> 先获取成String 再转换成
     *
     * @Author Zhangc
     * @Description
     * @Date 16:56 2019/3/16
     * @Param
     * @return
     **/
    public static void getJSONInfo(JSONObject jsonObject){
        String name = jsonObject.getString("name");
        // 输出为：获取到的name属性为：阿三
        System.out.println("获取到的name属性为："+name);
        int age = jsonObject.getInteger("age");
        // 输出为：获取到的age属性为：30
        System.out.println("获取到的age属性为："+age);
        // 输出为：获取到的deposit属性为：800000.12
        double deposit = jsonObject.getDouble("deposit");
        System.out.println("获取到的deposit属性为："+deposit);
        System.out.println("==================直接使用 getJSONArray           获取array开始==================");
        JSONArray listExperience1 = jsonObject.getJSONArray("listExperience");
        // 输出为java.util.HashMap
        System.out.println(listExperience1.get(0).getClass().getName());
        System.out.println("==================直接使用 getJSONArray           获取array结束==================");
        // 输出为： [{company=百度, workTime=24月, workPlace=背景}, {company=阿里, workTime=30月, workPlace=杭州}, {company=京东, workTime=12月, workPlace=北京}]
        System.out.println(jsonObject.get("listExperience").toString());
        System.out.println("==================先转string 再 转array                    开始==================");
        String listExperience = jsonObject.getJSONArray("listExperience").toString();
        JSONArray listExperience2 = JSONArray.parseArray(listExperience);
        // 输出为：com.alibaba.fastjson.JSONObject
        System.out.println(listExperience2.get(0).getClass().getName());
        System.out.println("==================先转string 再 转array                    结束==================");
        for (Object o : listExperience2){
            // 输出为：获取到的listExperience 中的元数据有：{"company":"百度","workTime":"24月","workPlace":"背景"}
            System.out.println("获取到的listExperience 中的元数据有："+o.toString());
            JSONObject basicObject = JSONObject.parseObject(o.toString());
            for(Map.Entry entry : basicObject.entrySet()){
                System.out.println("元数据中的key为："+entry.getKey()+"  value为："+entry.getValue());
            }
        }
    }

}
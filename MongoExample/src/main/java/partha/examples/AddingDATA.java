package partha.examples;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import partha.dto.Test;

/**
 *
 * @author Partha
 */
public class AddingDATA {

    public static void main(String arg[]) throws Exception {
        String collectionname = "collectionname";
        //This is example set DTO and calling DBManger.getDB.add("collectionName",json)
        Test exmpleDto = new Test();
        exmpleDto.setName("Git");
        exmpleDto.setStatus("active");
        exmpleDto.setInfo("testing working with mongo");
        exmpleDto.setCreatedate(System.currentTimeMillis() + "");//make sure you do not set _id 

        String json = new Gson().toJson(exmpleDto);
        System.out.println(json + "example1: " + add(collectionname, json));

        //This is example to set map instead of DTO ,convert this map to json and send to mongo by calling add method
        HashMap testmap = new HashMap();
        testmap.put("key", "value1");
        testmap.put("key2", "value2");
        testmap.put("key3", "value3");
        testmap.put("key4", "value4");
        testmap.put("key5", "value5");

        String json2 = new Gson().toJson(testmap);
        System.out.println(json2 + "example1: " + add(collectionname, json2));

        //This is example to add data in json form but extra functionality of adding status active,createdate
        //and updatedate automatically to system time 
        Test exmpleDto2 = new Test();
        exmpleDto2.setName("test2");

        String json3 = new Gson().toJson(exmpleDto2);
        System.out.println(json3 + "example2: " + addSecondfunctionality(collectionname, json));

        //This is example to add a map directly to the mongo intead of converting to json
        HashMap testmap2 = new HashMap();
        testmap2.put("key", "value1");
        testmap2.put("key2", "value2");
        testmap2.put("key3", "value3");
        testmap2.put("key4", "value4");
        testmap2.put("key5", "value5");

        System.out.println("example3: " + addThirdfunctionality(collectionname, testmap2));

    }

    /*
     add method would push json into data base 
     The Json foramt should be something like this
     {"name":"Git","info":"testing working with mongo","status":"active","createdate":"1437975092953"}
     */
    public static String add(String collectionname, String json) throws Exception {
        if (json == null || json.equals("") || collectionname == null || collectionname.equals("")) {
            return null;
        }
        return DBManager.getDB().add(collectionname, json);
    }

    /*
     addDefault method would push json into data base along with autoamatic data such status being set
     active, createddate and updatedate being set to sytem time

     */
    public static String addSecondfunctionality(String collectionname, String json) throws Exception {
        if (json == null || json.equals("") || collectionname == null || collectionname.equals("")) {
            return null;
        }
        return DBManager.getDB().addDefault(collectionname, json);
    }

    /*
     addByMap method would push map into data base 

     */
    public static String addThirdfunctionality(String collectionname, Map testmp) throws Exception {
        if (testmp == null || testmp.isEmpty() || collectionname == null || collectionname.equals("")) {
            return null;
        }
        return DBManager.getDB().addByMap(collectionname, testmp);
    }

    /*
     addDefaultMap method would push map into data base along with autoamatic data such status being set
     active, createddate and updatedate being set to sytem time

     */
    public static String addfourthfunctionality(String collectionname, Map testmp) throws Exception {
        if (testmp == null || testmp.isEmpty() || collectionname == null || collectionname.equals("")) {
            return null;
        }
        return DBManager.getDB().addDefaultMap(collectionname, testmp);
    }

}

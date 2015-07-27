package partha.examples;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import partha.dto.Test;

/**
 *
 * @author Partha
 */
public class FetchingDATA {

    public static void main(String arg[]) throws Exception {

        //This is the example to fetch data by using the MongoObject id in form of string
        //The collection name has to be given as from which DbCollection to fetch data from 
        String collectionName = "collectionname";
        String id = "55b5c1a0440adc59f98fa37a";//in this example I have used dummy id please change  to id which u received while add data to mongo
        String resultJson = fetchData(collectionName, id);
        System.out.println(resultJson);

        // to further realise the received json
        List<Test> res = new Gson().fromJson(resultJson, new TypeToken<List<Test>>() {
        }.getType());
        //Since the Json we get is List
        //The first element of the list is the data 
        //first element cause only one object of the _id is poassible
        Test testObj = res.get(0);
        System.out.println(testObj);

        //to id in form of string from the testObj
        Map<String, String> idMap = (Map<String, String>) testObj.getId();
        String receiveId = idMap.get("$oid");
        System.out.println(receiveId);

        
        
        
        
        
        //to get all the data which status active
        String resultJson2 = fetchAllData(collectionName);
        List<Test> res2 = new Gson().fromJson(resultJson2, new TypeToken<List<Test>>() {
        }.getType());
        System.out.println(res2);

        
        
        
        //to get all data which matches required condition
        HashMap conditionMap=new HashMap();
        conditionMap.put("name","Git");
        String resultJson3 = fetchAllData(collectionName);
        List<Test> res3 = new Gson().fromJson(resultJson3, new TypeToken<List<Test>>() {
        }.getType());
        System.out.println(res3);
        
        
        
        
    }

    /*
     The method getByKey requires a collectionName and mongo object id iin form of string
     You will receive a json of list 
     type convert remove the object from the list
    
     */
    public static String fetchData(String collectionName, String _id) throws Exception {
        if (_id == null || _id.equals("") || collectionName == null || collectionName.equals("")) {
            return null;
        }
        return DBManager.getDB().getByKey(collectionName, _id);
    }

    /*
     The method getAll requires a collectionName 
     You will receive a json of list 
     type convert remove the object from the list
     You receive all the objects which have the status active
     This is mainly useful to be used when use addDefault method
     */
    public static String fetchAllData(String collectionName) throws Exception {
        if (collectionName == null || collectionName.equals("")) {
            return null;
        }
        return DBManager.getDB().getAll(collectionName);
    }

    /*
     The method getByCondition requires a collectionName and a map which has column name as key and column element as value
     You will receive a json of list 
     type convert remove the object from the list
     You receive all the objects which have the condition matched
     */
    public static String fetchCondition(String collectionName, Map conditionMap) throws Exception {
        if (conditionMap == null || conditionMap.isEmpty() || collectionName == null || collectionName.equals("")) {
            return null;
        }
        return DBManager.getDB().getByCondition(collectionName, conditionMap);
    }
    
 
    
    
    
}

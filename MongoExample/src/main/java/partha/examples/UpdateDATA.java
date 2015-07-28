package partha.examples;

import java.util.Map;

/**
 *
 * @author Partha
 */
public class UpdateDATA {

    static String collectionName = "collectionname";

    public static void main(String arg[]) {

    }

    public static boolean modifyFunctionality1(String collectionName, String json, String _id) throws Exception {
        if (collectionName == null || collectionName.equals("") || json == null || json.equals("") || _id == null || _id.equals("")) {
            return false;
        }

        DBManager.getDB().modify(collectionName, json, _id);
        return false;
    }

    public static boolean modifyFunctionality2(String collectionName, String json, Map condition) throws Exception {
        if (collectionName == null || collectionName.equals("") || json == null || json.equals("") || condition == null || condition.isEmpty()) {
            return false;
        }
        return DBManager.getDB().modifyByCondition(collectionName, json, condition);
    }

}

package validate;

public class Validate {
    public static String validateString(String value, String substitution){
        return (value == null || value.isBlank() || value.isEmpty()) ? substitution : value;
    }

    public static Boolean validateString(String value){
        return !(value == null || value.isBlank() || value.isEmpty());
    }

    public static Boolean validateBoolean (Boolean value){return value != null && value;}

    public static Integer validateInteger (Integer value, Integer substitution){
        return (value == null || value <= 0) ? substitution : value;
    }
}
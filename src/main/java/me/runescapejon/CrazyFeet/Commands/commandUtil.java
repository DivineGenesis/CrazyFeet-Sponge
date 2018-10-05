package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commandUtil {

    public static List<String> colors = Arrays.asList("red","blue","green","yellow","orange","white","brown","purple","black");
    private static List<String> clearType = Arrays.asList("none","clear","disable","off");

    private static boolean identityExists (String identity, ArrayList<String> list) {
        for (String s : list) {
            if(s.startsWith(identity)) {
                return true;
            }
        }
        return false;
    }

    private static boolean stringExists (String identity,String color,ArrayList<String> listType) {
        for (String s : listType) {
            if (s.matches(identity + "-" + color)) {
                return true;
            }
        }
        return false;
    }


    static boolean invalidCommand (String color,String identity, ArrayList<String> list) {
        if (getColors().contains(color.toLowerCase())) {
            if (!identityExists(identity,list)) {
                list.add(identity+"-"+color);
            } else if (identityExists(identity,list) && !stringExists(identity,color,list)) {
                for (String s : list) {
                    if (s.startsWith(identity)) {
                        list.remove(s);
                        break;
                    }
                }
                list.add(identity+"-"+color);
            }
            return false;
        } else if (getClearType().contains(color)) {
            for (String s : list) {
                if (s.startsWith(identity)) {
                    list.remove(s);
                    break;
                }
            }
        } else {
            return true;
        }
        return false;
    }

    public static List<String> getColors () {
        return colors;
    }
    private static List<String> getClearType () {
        return clearType;
    }

}

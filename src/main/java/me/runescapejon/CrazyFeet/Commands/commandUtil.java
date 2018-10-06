package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commandUtil {
    private static String choice = null;

    private static List<String> colors = Arrays.asList("red","blue","green","yellow","orange","white","brown","purple","black");
    private static List<String> clearType = Arrays.asList("none","clear","disable","off");
    private static List<String> bodyTypes = Arrays.asList("head","body","feet");

    private static ArrayList<ArrayList<String>> trailLists = new ArrayList<>();


    private static boolean identityExists (String identity,ArrayList<String> list) {
        for (String s : list) {
            if (s.startsWith(identity)) {
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


    static boolean invalidCommand (CommandSource src,ArrayList<String> list,String argument) {
        Player player = (Player) src;
        String identity = player.getUniqueId().toString();
        choice = null;
        if (getBodyTypes().contains(argument)) {
            switch (argument) {
                case "head": {
                    choice = "2.5";
                    break;
                }
                case "body": {
                    choice = "1.2";
                    break;
                }
                case "feet": {
                    choice = "0.1";
                    break;
                }
                default: {
                    player.sendMessage(Text.of("Default hit"));
                    break;
                }
            }
        } else if (getColors().contains(argument.toLowerCase())) {
            choice = argument;
        }
        if (!getClearType().contains(argument)) {
            if (!identityExists(identity,list)) {
                applyTrail(list,src,getChoice());
            } else if (identityExists(identity,list) && !stringExists(identity,getChoice(),list)) {
                for (String s : list) {
                    if (s.startsWith(identity)) {
                        list.remove(s);
                        break;
                    }
                }
                applyTrail(list,src,getChoice());
            }
            return false;
        } else if (getClearType().contains(argument)) {
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

    private static void applyTrail (ArrayList<String> list,CommandSource src,String choice) {
        Player player = (Player) src;

        String identity = player.getUniqueId().toString();
        removeTrails(player);
        list.add(identity + "-" + choice);
    }

    static void removeTrails (Player player) {
        getTrailLists().add(helix.getParticleInfo());
        getTrailLists().add(globe.getParticleInfo());
        getTrailLists().add(hearts.getParticleInfo());

        String identity = player.getUniqueId().toString();
        for (ArrayList<String> aList : getTrailLists()) {
            for (String s : aList) {
                if (s.startsWith(identity)) {
                    aList.remove(s);
                    break;
                }
            }
        }
    }


    private static ArrayList<ArrayList<String>> getTrailLists () {
        return trailLists;
    }

    public static List<String> getColors () {
        return colors;
    }

    private static List<String> getClearType () {
        return clearType;
    }

    public static List<String> getBodyTypes () {
        return bodyTypes;
    }

    private static String getChoice () {
        return choice;
    }
}

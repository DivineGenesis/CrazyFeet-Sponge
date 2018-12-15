package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.entity.living.player.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class commandUtil {
    private static String choice;
    private static List<String> colors = Arrays.asList("red","blue","green","yellow","orange","white","brown","purple","black");
    private static List<String> clearType = Arrays.asList("none","clear","disable","off");
    private static List<String> bodyTypes = Arrays.asList("head","body","feet");
    private static HashMap<UUID, String> uuidStringMap = new HashMap<>();
    private static HashMap<UUID, Double> uuidDoubleHashMap = new HashMap<>();
    private static HashMap<HashMap<UUID, Double>, ParticleType> particleTypeHashMap = new HashMap<>();
    private static HashMap<HashMap<UUID, String>, String> stringHashMap = new HashMap<>();


    private static boolean identityExists (UUID identity,HashMap map) {
        return map.containsKey(identity);
    }

    private static boolean stringNotExist (UUID identity,String arg,HashMap map) {
        return !map.containsKey(identity) || !map.containsValue(arg);
    }


    static boolean invalidCommand (CommandSource src,String argument,ParticleType particleType) {
        Player player = (Player) src;
        UUID identity = player.getUniqueId();
        choice = null;
        if (!getClearType().contains(argument)) {
            switch (argument) {
                case "head": {
                    choice = "2.5";
                    break;
                }
                case "body": {
                    choice = "1.0";
                    break;
                }
                case "feet": {
                    choice = "0.1";
                    break;
                }
                default: {
                    return true;
                }
            }
            Double arg = Double.valueOf(getChoice());
            if (!identityExists(identity,getUuidDoubleHashMap())) {
                applyTrail(src,arg,particleType);
            } else if (identityExists(identity,getUuidDoubleHashMap()) && stringNotExist(identity,argument,getUuidDoubleHashMap())) {
                if (getUuidDoubleHashMap().containsKey(identity)) {
                    getUuidDoubleHashMap().remove(identity);
                    applyTrail(src,arg,particleType);
                }
            }
            return false;
        } else if (getClearType().contains(argument)) {
            if (getUuidDoubleHashMap().containsKey(identity)) {
                getUuidDoubleHashMap().remove(identity);
            }
        } else {
            return true;
        }
        return false;

    }

    static boolean invalidCommand (CommandSource src,String argument,String effect) {
        Player player = (Player) src;
        UUID identity = player.getUniqueId();

        HashMap<HashMap<UUID, String>, String> map = commandUtil.getStringHashMap();
        String innerMap = map.get(commandUtil.getUuidStringMap());


        if (getClearType().contains(argument)) { //If not clearing
            if (getUuidStringMap().containsKey(identity)) {
                getUuidStringMap().remove(identity);
            }
            return false;
        }
        if (!getColors().contains(argument)) {
            return true;
        }
        if (!identityExists(identity,getUuidStringMap())) { //if Identity is not in Map
            applyTrail(src,argument,effect);
            //If identity is in Map, but color is not
        } else if (identityExists(identity,getUuidStringMap()) && stringNotExist(identity,argument,getUuidStringMap())) {
            if (getUuidStringMap().containsKey(identity)) {
                getUuidStringMap().remove(identity);
                applyTrail(src,argument,effect);
            }
        } else if (!innerMap.equals(effect)) {
            getUuidStringMap().remove(identity);
            applyTrail(src,argument,effect);
        } else {
            return true;
        }
        return false;
    }

    private static void applyTrail (CommandSource src,String argument,String effect) {
        Player player = (Player) src;

        UUID identity = player.getUniqueId();
        removeTrails(player,getUuidStringMap());
        getUuidStringMap().put(identity,argument);
        getStringHashMap().put(getUuidStringMap(),effect);
    }

    private static void applyTrail (CommandSource src,Double argument,ParticleType particleType) {
        Player player = (Player) src;

        UUID identity = player.getUniqueId();
        removeTrails(player,getUuidDoubleHashMap());
        getUuidDoubleHashMap().put(identity,argument);
        getParticleTypeHashMap().put(getUuidDoubleHashMap(),particleType);
    }

    static void removeTrails (Player player,HashMap map) {

        UUID identity = player.getUniqueId();
        if (map.containsKey(identity)) {
            map.remove(identity);
        }
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

    public static HashMap<UUID, String> getUuidStringMap () {
        return uuidStringMap;
    }

    public static HashMap<UUID, Double> getUuidDoubleHashMap () {
        return uuidDoubleHashMap;
    }

    public static HashMap<HashMap<UUID, Double>, ParticleType> getParticleTypeHashMap () {
        return particleTypeHashMap;
    }

    public static HashMap<HashMap<UUID, String>, String> getStringHashMap () {
        return stringHashMap;
    }


}

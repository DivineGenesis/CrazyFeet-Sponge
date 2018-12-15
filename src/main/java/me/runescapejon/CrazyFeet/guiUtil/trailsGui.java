package me.runescapejon.CrazyFeet.guiUtil;

import com.mcsimonflash.sponge.teslalibs.inventory.*;
import me.runescapejon.CrazyFeet.CrazyFeet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class trailsGui {

    private static ItemStack glass = ItemStack.builder().itemType(ItemTypes.STAINED_GLASS_PANE)
            .add(Keys.DISPLAY_NAME, Text.of("")).add(Keys.DYE_COLOR,DyeColors.GRAY).build();
    private static ItemStack flame = ItemStack.builder().itemType(ItemTypes.TORCH)
            .add(Keys.DISPLAY_NAME, Text.of("Flame Trail")).build();

    private static final String commandPrefix = "trail ";

    private static ArrayList<String> trailTypes = new ArrayList<>();

    private static Consumer<Action.Click> fire_head = user -> getCommand(user.getPlayer(),commandPrefix +getTrailTypes().get(1) +"head");
    private static Consumer<Action.Click> fire_body = user -> getCommand(user.getPlayer(),commandPrefix +getTrailTypes().get(1) +"body");
    private static Consumer<Action.Click> fire_feet = user -> getCommand(user.getPlayer(),commandPrefix +getTrailTypes().get(1) +"feet");

    //List Of Commands
    


    private static Element border = Element.of(glass);
    private static Element fireHeadTrail = Element.of(flame,getFire_head());
    private static Element fireBodyTrail = Element.of(flame,getFire_body());
    private static Element fireFeetTrail = Element.of(flame,getFire_feet());

    public static Layout layout = Layout.builder()
            .dimension(InventoryDimension.of(9,6))
            .border(border)
            .set(fireHeadTrail,13)
            .set(fireBodyTrail,22)
            .set(fireFeetTrail,31)
            .build();

    public static View view =
            View.builder()
                    .archetype(InventoryArchetypes.DOUBLE_CHEST)
                    .property(InventoryTitle.of(Text.of("Trails Menu")))
                    .build(CrazyFeet.getPlugin());


    private static CommandResult getCommand (Player player,String command) {
        player.sendMessage(Text.of("You have activated Flame Trail!"));
        return Sponge.getCommandManager().process(player,command);
    }

    public static ArrayList<String> getTrailTypes () {
        trailTypes.add("fire_head");
        return trailTypes;
    }

    static View getView () {
        return view;
    }

    private static Consumer<Action.Click> getFire_head () {
        return fire_head;
    }

    private static Consumer<Action.Click> getFire_body () {
        return fire_body;
    }

    private static Consumer<Action.Click> getFire_feet () {
        return fire_feet;
    }
}

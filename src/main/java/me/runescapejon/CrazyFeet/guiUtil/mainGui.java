package me.runescapejon.CrazyFeet.guiUtil;

import com.mcsimonflash.sponge.teslalibs.inventory.*;
import me.runescapejon.CrazyFeet.CrazyFeet;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.Text;

import java.util.function.Consumer;

public class mainGui {
    private static ItemStack glass = ItemStack.builder().itemType(ItemTypes.STAINED_GLASS_PANE)
            .add(Keys.DISPLAY_NAME, Text.of("")).add(Keys.DYE_COLOR,DyeColors.GRAY).build();
    private static ItemStack redstone = ItemStack.builder().itemType(ItemTypes.REDSTONE)
            .add(Keys.DISPLAY_NAME, Text.of("Trails")).build();

    private static Consumer<Action.Click> action = user -> trailsGui.getView().open(user.getPlayer());


    private static Element border = Element.of(glass);
    private static Element trails = Element.of(redstone,getAction());

    public static Layout layout = Layout.builder()
            .dimension(InventoryDimension.of(9,3))
            .border(border)
            .center(trails)
            .build();

    private static View view =
            View.builder()
                    .archetype(InventoryArchetypes.CHEST)
                    .property(InventoryTitle.of(Text.of("Trails Menu")))
                    .build(CrazyFeet.getPlugin());


    public static View getView () {
        return view;
    }

    private static Consumer<Action.Click> getAction () {
        return action;
    }
}

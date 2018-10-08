package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;
import java.util.UUID;

public class storm implements CommandExecutor {
    private static ArrayList<UUID> Storm = new ArrayList<>();

    public CommandResult execute (CommandSource src,CommandContext args) {
        Player player = (Player) src;
        UUID identity = player.getUniqueId();
        if (!getCrazyStorm().contains(identity)) {
            getCrazyStorm().add(identity);
        }
        return CommandResult.success();

    }

    public static ArrayList<UUID> getCrazyStorm () {
        return Storm;
    }
}
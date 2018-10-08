package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class disableTrails implements CommandExecutor {
    @Override
    public CommandResult execute (CommandSource src,CommandContext args) {
        Player player = (Player) src;
        try {
            commandUtil.removeTrails(player,commandUtil.getUuidStringMap());
        } catch (NullPointerException e) {
            e.addSuppressed(e);
        }
        try {
            commandUtil.removeTrails(player,commandUtil.getUuidDoubleHashMap());
        } catch (NullPointerException e) {
            e.addSuppressed(e);
        }

        return CommandResult.success();
    }
}

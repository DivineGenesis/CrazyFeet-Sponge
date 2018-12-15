package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.guiUtil.mainGui;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class gui implements CommandExecutor {
    @Override
    public CommandResult execute (CommandSource src,CommandContext args) {
        Player player = (Player) src;

        mainGui.getView().open(player);

        return CommandResult.success();
    }
}

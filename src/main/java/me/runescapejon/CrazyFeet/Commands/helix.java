package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.ArrayList;

public class helix implements CommandExecutor {

    private static ArrayList<String> helixParticleInfo = new ArrayList<>();

    @Override
    public CommandResult execute (CommandSource src,CommandContext args) throws CommandException {
        String color = args.requireOne(messages.colorCommandKey);
        if (src instanceof Player) {
            if (commandUtil.invalidCommand(src,getParticleInfo(),color)) {
                src.sendMessage(Text.of(TextColors.RED,messages.colorError));
            }
        }

        return CommandResult.success();
    }

    public static ArrayList<String> getParticleInfo () {
        return helixParticleInfo;
    }

}

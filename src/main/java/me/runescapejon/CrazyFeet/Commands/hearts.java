package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;

public class hearts implements CommandExecutor {
    private static ArrayList<String> particleInfo = new ArrayList<>();

    @Override
    public CommandResult execute (CommandSource src,CommandContext args) throws CommandException {
        String bodyType = args.requireOne(messages.bodyCommandKey);
        if (src instanceof Player) {
            if (commandUtil.invalidCommand(src,getParticleInfo(),bodyType)) {
                src.sendMessage(Text.of(messages.bodyError));
            }
        }
        return CommandResult.success();
    }

    public static ArrayList<String> getParticleInfo () {
        return particleInfo;
    }

}



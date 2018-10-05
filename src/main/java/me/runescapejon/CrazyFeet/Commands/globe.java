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

public class globe implements CommandExecutor {

    private static ArrayList<String> globeParticleInfo = new ArrayList<>();

    @Override
    public CommandResult execute (CommandSource src,CommandContext args) throws CommandException {
        Player player = (Player) src;
        String identity = player.getUniqueId().toString();
        String color = args.requireOne(messages.commandKey);
        if(commandUtil.invalidCommand(color,identity,getParticleInfo())) {
            player.sendMessage(Text.of(TextColors.RED,"Invalid Choice! Available colors are\n" + commandUtil.getColors().toString()));
        }
        return CommandResult.success();
    }
    public static ArrayList<String> getParticleInfo () {
        return globeParticleInfo;
    }

}


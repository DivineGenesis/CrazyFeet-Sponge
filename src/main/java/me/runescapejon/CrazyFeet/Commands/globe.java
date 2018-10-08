package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class globe implements CommandExecutor {
    @Override
    public CommandResult execute (CommandSource src,CommandContext args) {
        String color = args.requireOne(messages.colorCommandKey);

        if (src instanceof Player) {
            if (commandUtil.invalidCommand(src,color,"globe")) {
                src.sendMessage(Text.of(TextColors.RED,"Invalid Choice! Available colors are\n" + commandUtil.getColors().toString()));
            }
        }
        return CommandResult.success();

    }
}


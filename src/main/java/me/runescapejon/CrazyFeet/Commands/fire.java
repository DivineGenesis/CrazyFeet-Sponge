package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class fire implements CommandExecutor {
    @Override
    public CommandResult execute (CommandSource src,CommandContext args) {
        String bodyType = args.requireOne(messages.bodyCommandKey);
        if (src instanceof Player) {
            if (commandUtil.invalidCommand(src,bodyType,ParticleTypes.FLAME)) {
                src.sendMessage(Text.of(TextColors.RED,messages.bodyError));
            }
        }
        return CommandResult.success();
    }

}
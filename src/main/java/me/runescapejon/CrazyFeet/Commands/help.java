package me.runescapejon.CrazyFeet.Commands;

import com.google.common.collect.Lists;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.List;

public class help implements CommandExecutor {
    @Override
    public CommandResult execute (CommandSource src,CommandContext args) throws CommandException {
        List<Text> commandHelp = Lists.newArrayList();
        commandHelp.add(helpTextStructure("helix <color>","Creates a helix trail for you"));

        PaginationList.builder()
                .title(Text.of(TextColors.GOLD,"CrazyFeet Help Menu"))
                .padding(Text.of(TextColors.GREEN,TextStyles.STRIKETHROUGH,'='))
                .contents(commandHelp)
                .sendTo(src);
        return CommandResult.success();
    }

    private Text helpTextStructure (String command,String reason) {
        return Text.of(TextColors.GREEN,Text.builder(command).onClick(TextActions.suggestCommand("/trail " + command)),
                TextColors.DARK_GRAY,TextStyles.ITALIC," - ",reason);
    }
}

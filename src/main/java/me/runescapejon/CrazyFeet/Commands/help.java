package me.runescapejon.CrazyFeet.Commands;

import com.google.common.collect.Lists;
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
    private String bodyTypes = commandUtil.getBodyTypes().toString();
    private String availableColors = commandUtil.getColors().toString();

    @Override
    public CommandResult execute (CommandSource src,CommandContext args) {
        List<Text> commandHelp = Lists.newArrayList();
        commandHelp.add(helpTextStructure("helix <color>","Creates a helix trail for you",availableColors));
        commandHelp.add(helpTextStructure("globe <color>","Creates a globe trail for you",availableColors));
        commandHelp.add(helpTextStructure("hearts <body type>","Creates a heart trail",bodyTypes));
        commandHelp.add(helpTextStructure("fire <body type>","Creates a fire trail",bodyTypes));
        commandHelp.add(helpTextStructure("magic <body type>","Creates a magic trail",bodyTypes));
        commandHelp.add(helpTextStructure("note <body type>","Creates a note trail",bodyTypes));
        commandHelp.add(helpTextStructure("pearl <body type>","Creates a pearl trail",bodyTypes));
        commandHelp.add(helpTextStructure("smoke <body type>","Creates a smoke trail",bodyTypes));
        commandHelp.add(helpTextStructure("witch <body type>","Creates a witch trail",bodyTypes));
        commandHelp.add(helpTextStructure("clear","turns off all trails",null));

        PaginationList.builder()
                .title(Text.of(TextColors.GOLD,"CrazyFeet Help Menu"))
                .padding(Text.of(TextColors.GREEN,TextStyles.STRIKETHROUGH,'='))
                .contents(commandHelp)
                .sendTo(src);
        return CommandResult.success();
    }

    private Text helpTextStructure (String command,String reason,String options) {
        return Text.of(TextColors.GREEN,Text.builder(command).onClick(TextActions.suggestCommand("/trails " + command)).onHover(TextActions
                        .showText(Text.of("arguments: " + options))),
                TextColors.GRAY,TextStyles.ITALIC," - ",reason);
    }
}

package me.runescapejon.CrazyFeet.Commands;

import com.google.common.collect.Lists;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyCheckCommands;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyDisableCmds;
import me.runescapejon.CrazyFeet.Commands.head.*;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class commandLoader {

    private CommandSpec reload = CommandSpec.builder().description(Text.of("reloads crazyfeet configs!"))
            .permission("crazyfeet.reload").executor(new CrazyFeetReloadCommand()).build();


    private CommandSpec gui = CommandSpec.builder().description(Text.of("crazy a nice gui for crazyfeet particles"))
            .permission("crazyfeet.crazygui").executor(new GuiCommand()).build();


    // CrazyWitchHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyWitchHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable Pearl Head particles"))
            .permission("crazyfeet.crazywitchhead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyWitchHeadCommand()).build();

    // CrazySmokeHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazySmokeHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable Pearl Head particles"))
            .permission("crazyfeet.crazysmokehead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazySmokeHeadCommand()).build();

    // CrazyPearlHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyPearlHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable Pearl Head particles"))
            .permission("crazyfeet.crazypearlhead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyPearlHeadCommand()).build();

    // CrazyNoteHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazynoteHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable Magic Head particles"))
            .permission("crazyfeet.crazynotehead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyNoteHeadCommand()).build();

    // CrazyMagicHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyMagicHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable Magic Head particles"))
            .permission("crazyfeet.crazymagichead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyMagicHeadCommand()).build();

    // CrazyHeartHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyHeartHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable fire Head particles"))
            .permission("crazyfeet.crazyfirehead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyHeartHeadCommand()).build();

    // CrazyFireHead <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyFireHeadSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable fire Head particles"))
            .permission("crazyfeet.crazyfirehead")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyFireHeadCommand()).build();

    // CrazyFire <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyFireSpec = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable fire particles")).permission("crazyfeet.crazyfire")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyFireCommands()).build();

    // Crazynote <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyNoteSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable note particles")).permission("crazyfeet.crazynote")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyNoteCommands()).build();

    // Crazymagic <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyMagicSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable magic particles")).permission("crazyfeet.crazymagic")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyMagicCommands()).build();

    // Crazyheart <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyHeartSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable heart particles")).permission("crazyfeet.crazyheart")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyHeartCommands()).build();

    // CrazySmoke <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazySmokeSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Smoke particles")).permission("crazyfeet.crazysmoke")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazySmokeCommands()).build();

    // CrazyPearl <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazypearlSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Pearl particles")).permission("crazyfeet.crazypearl")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyPearlCommands()).build();

    // CrazyWitch <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyWitchSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Witch particles")).permission("crazyfeet.crazywitch")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyWitchCommands()).build();

    private CommandSpec CrazyCheckSpec = CommandSpec.builder()
            .description(Text.of("crazycheck your particles status - helpful to see what enabled"))
            .permission("crazyfeet.crazycheck")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyCheckCommands()).build();

    private CommandSpec CrazyDisableSpec = CommandSpec.builder()
            .description(Text.of("crazydisable disable your/other particles all of them"))
            .permission("crazyfeet.crazydisable")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyDisableCmds()).build();

    private CommandSpec CrazyRingSpec = CommandSpec.builder()
            .description(Text.of("crazyglobe to enable/disable globe particles")).permission("crazyfeet.crazyglobe")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyGlobeCommands()).build();

    private CommandSpec CrazyhelixmenuSpec = CommandSpec.builder()
            .description(Text.of("crazyguihelix access Gui for helixes colors")).executor(new HelixGUICommand())
            .build();

    private CommandSpec CrazyGui2Spec = CommandSpec.builder()
            .description(Text.of("crazyhelix to enable/disable Helix Particles")).executor(new GuiPage2Cmd())
            .permission("crazyfeet.crazygui")
            .build();

    private CommandSpec CrazystormSpec = CommandSpec.builder()
            .description(Text.of("crazyhelix to enable/disable Storm Particles"))
            .permission("crazyFeet.crazystorm")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyStormCommand()).build();

    private CommandSpec Helix = CommandSpec.builder()
            .description(Text.of("test"))
            .permission("crazyFeet.superHelix")
            .arguments(GenericArguments.string(Text.of("color")))
            .executor(this::superHelix)
            .build();


    public CommandSpec crazyRoot = CommandSpec.builder()
            .description(Text.of("Root command for Crazyfeet"))
            .executor(this::help)
            .permission("crazyfeet.base")
            .child(CrazystormSpec,"storm")
            .child(CrazyCheckSpec,"check")
            .child(CrazyDisableSpec,"disable","remove")
            .child(CrazyFireHeadSpec,"fireHead")
            .child(CrazyFireSpec,"fire")
            .child(CrazyHeartHeadSpec,"heartHead")
            .child(CrazyHeartSpec,"heart")
            .child(CrazyGui2Spec,"gui2")
            .child(CrazyhelixmenuSpec,"helixMenu")
            .child(CrazyMagicHeadSpec,"magicHead")
            .child(CrazyMagicSpec,"magic")
            .child(CrazynoteHeadSpec,"noteHead")
            .child(CrazyNoteSpec,"note")
            .child(CrazyPearlHeadSpec,"pearlHead")
            .child(CrazypearlSpec,"pearl")
            .child(CrazyRingSpec,"ring")
            .child(CrazySmokeHeadSpec,"smokeHead")
            .child(CrazySmokeSpec,"smoke")
            .child(CrazyWitchHeadSpec,"witchHead")
            .child(CrazyWitchSpec,"witch")
            .child(reload,"reload")
            .child(gui,"gui")
            .child(Helix,"helix")
            .build();

    private CommandResult help (CommandSource src,CommandContext args) {
        List<Text> commandHelp = Lists.newArrayList();
        commandHelp.add(helpTextStructure("menu","Opens a menu for trails"));

        PaginationList.builder()
                .title(Text.of(TextColors.GOLD,"BetterSoulbinding Help Menu"))
                .padding(Text.of(TextColors.GREEN,TextStyles.STRIKETHROUGH,'='))
                .contents(commandHelp)
                .sendTo(src);
        return CommandResult.success();
    }
    private Text helpTextStructure (String command,String reason) {
        return Text.of(TextColors.GREEN,Text.builder(command).onClick(TextActions.suggestCommand("/crazy " + command)),
                TextColors.DARK_GRAY,TextStyles.ITALIC," - ",reason);
    }

    private static ArrayList<String> particleInfo = new ArrayList<>();
    private List<String> colors = Arrays.asList("red","blue","green","yellow","orange","white","brown","purple","black");

    private CommandResult superHelix (CommandSource src,CommandContext args) {
        Player player = (Player) src;
        String identity = player.getUniqueId().toString();
        String color = args.requireOne("color");
        if(getColors().contains(color.toLowerCase())) {
            if (!identityExists(identity)) {
                getParticleInfo().add(identity + "-" + color);
            } else if (identityExists(identity) && !stringExists(identity,color)) {
                for (String s : getParticleInfo()) {
                    if (s.startsWith(identity)) {
                        getParticleInfo().remove(s);
                        break;
                    }
                }
                getParticleInfo().add(identity + "-" + color);
            }
            return CommandResult.success();
        }
        player.sendMessage(Text.of(TextColors.RED,"Invalid Choice! Available colors are\n" + colors.toString()));
        return CommandResult.success();
    }

    private boolean identityExists (String identity) {
        for(String s: getParticleInfo()) {
            if(s.startsWith(identity)) {
                return true;
            }
        }
        return false;
    }

    private boolean stringExists (String identity, String color) {
        for(String s: getParticleInfo()) {
            if(s.matches(identity+"-"+color)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getParticleInfo () {
        return particleInfo;
    }

    private List<String> getColors () {
        return colors;
    }



}

package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.Commands.Util.CrazyCheckCommands;
import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class commandLoader {

    private CommandSpec reload = CommandSpec.builder().description(Text.of("reloads crazyfeet configs!"))
            .permission("crazyfeet.reload").executor(new CrazyFeetReloadCommand()).build();


    private CommandSpec gui = CommandSpec.builder().description(Text.of("crazy a nice gui for crazyfeet particles"))
            .permission("crazyfeet.crazygui").executor(new GuiCommand()).build();

    private CommandSpec hearts = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable fire Head particles"))
            .permission("crazyfeet.hearts")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new hearts()).build();

    // CrazyFire <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec fire = CommandSpec.builder()
            .description(Text.of("crazyfire to enable/disable fire particles"))
            .permission("crazyfeet.fire")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new fire())
            .build();

    // Crazynote <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyNoteSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable note particles")).permission("crazyfeet.crazynote")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new note())
            .build();

    // Crazymagic <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyMagicSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable magic particles")).permission("crazyfeet.crazymagic")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new magic())
            .build();

    // CrazySmoke <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazySmokeSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Smoke particles")).permission("crazyfeet.crazysmoke")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new smoke())
            .build();

    // CrazyPearl <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazypearlSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Pearl particles")).permission("crazyfeet.crazypearl")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new pearl())
            .build();

    // CrazyWitch <PlayerName> - Register and <PlayerName> is Optional
    private CommandSpec CrazyWitchSpec = CommandSpec.builder()
            .description(Text.of("crazymagic to enable/disable Witch particles")).permission("crazyfeet.crazywitch")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new witch())
            .build();

    private CommandSpec CrazyCheckSpec = CommandSpec.builder()
            .description(Text.of("crazycheck your particles status - helpful to see what enabled"))
            .permission("crazyfeet.crazycheck")
            .arguments(GenericArguments.firstParsing(GenericArguments.flags()
                    .buildWith(GenericArguments.firstParsing(
                            GenericArguments.optional(GenericArguments.player(Text.of("target"))),
                            GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
            .executor(new CrazyCheckCommands()).build();

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

    private CommandSpec disable = CommandSpec.builder()
            .description(Text.of("Disables particles"))
            .permission("crazyfeet.disable")
            .executor(new disableTrails())
            .build();

    private CommandSpec Globe = CommandSpec.builder()
            .description(Text.of("crazyglobe to enable/disable globe particles"))
            .permission("crazyfeet.globe")
            .arguments(GenericArguments.string(Text.of(messages.colorCommandKey)))
            .executor(new globe())
            .build();


    private CommandSpec Helix = CommandSpec.builder()
            .description(Text.of("Creates a helix around the player of selected color"))
            .permission("crazyFeet.helix")
            .arguments(GenericArguments.string(Text.of(messages.colorCommandKey)))
            .executor(new helix())
            .build();


    public CommandSpec crazyRoot = CommandSpec.builder()
            .description(Text.of("Root command for Crazyfeet"))
            .executor(new help())
            .permission("crazyfeet.base")
            .child(CrazystormSpec,"storm")
            .child(CrazyCheckSpec,"check")
            .child(fire,"fire")
            .child(hearts,"hearts","heart")
            .child(CrazyGui2Spec,"gui2")
            .child(CrazyhelixmenuSpec,"helixMenu")
            .child(CrazyMagicSpec,"magic")
            .child(CrazyNoteSpec,"note")
            .child(CrazypearlSpec,"pearl")
            .child(Globe,"globe","ring")
            .child(CrazySmokeSpec,"smoke")
            .child(CrazyWitchSpec,"witch")
            .child(reload,"reload")
            .child(gui,"gui")
            .child(Helix,"helix")
            .child(disable,"disable","remove","stop","none","off")
            .build();
}

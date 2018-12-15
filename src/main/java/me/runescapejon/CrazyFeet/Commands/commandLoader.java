package me.runescapejon.CrazyFeet.Commands;

import me.runescapejon.CrazyFeet.messages;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

public class commandLoader {
    private CommandSpec hearts = CommandSpec.builder()
            .description(Text.of("Heart trail"))
            .permission("crazyfeet.hearts")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new hearts()).build();

    private CommandSpec fire = CommandSpec.builder()
            .description(Text.of("Flame Trail"))
            .permission("crazyfeet.fire")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new fire())
            .build();

    private CommandSpec note = CommandSpec.builder()
            .description(Text.of("Note Trail"))
            .permission("crazyfeet.note")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new note())
            .build();

    private CommandSpec magic = CommandSpec.builder()
            .description(Text.of("Magic Trail"))
            .permission("crazyfeet.magic")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new magic())
            .build();

    private CommandSpec smoke = CommandSpec.builder()
            .description(Text.of("Smoke Trail"))
            .permission("crazyfeet.smoke")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new smoke())
            .build();

    private CommandSpec pearl = CommandSpec.builder()
            .description(Text.of("Pearl Trail"))
            .permission("crazyfeet.pearl")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new pearl())
            .build();

    private CommandSpec witch = CommandSpec.builder()
            .description(Text.of("witch Trail"))
            .permission("crazyfeet.witch")
            .arguments(GenericArguments.string(Text.of(messages.bodyCommandKey)))
            .executor(new witch())
            .build();

    private CommandSpec storm = CommandSpec.builder()
            .description(Text.of("Storm Trail"))
            .permission("crazyFeet.storm")
            .executor(new storm())
            .build();

    private CommandSpec disable = CommandSpec.builder()
            .description(Text.of("Disables particles"))
            .permission("crazyfeet.disable")
            .executor(new disableTrails())
            .build();

    private CommandSpec Globe = CommandSpec.builder()
            .description(Text.of("Globe/Ring trail"))
            .permission("crazyfeet.globe")
            .arguments(GenericArguments.string(Text.of(messages.colorCommandKey)))
            .executor(new globe())
            .build();


    private CommandSpec Helix = CommandSpec.builder()
            .description(Text.of("Helix Trail"))
            .permission("crazyFeet.helix")
            .arguments(GenericArguments.string(Text.of(messages.colorCommandKey)))
            .executor(new helix())
            .build();

    private CommandSpec Gui = CommandSpec.builder()
            .description(Text.of("Opens GUI"))
            .permission("crazyFeet.guiUtil")
            .executor(new gui())
            .build();


    public CommandSpec crazyRoot = CommandSpec.builder()
            .description(Text.of("Root command for Crazyfeet"))
            .executor(new help())
            .permission("crazyfeet.base")
            .child(storm,"storm")
            .child(fire,"fire","flame")
            .child(hearts,"hearts","heart")
            .child(magic,"magic")
            .child(note,"note")
            .child(pearl,"pearl")
            .child(Globe,"globe","ring")
            .child(smoke,"smoke")
            .child(witch,"witch")
            .child(Helix,"helix")
            .child(Gui,"guiUtil","menu")
            .child(disable,"disable","remove","stop","none","off","clear")
            .build();
}

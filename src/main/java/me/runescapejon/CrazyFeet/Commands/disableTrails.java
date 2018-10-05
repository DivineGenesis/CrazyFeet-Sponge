package me.runescapejon.CrazyFeet.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import java.util.ArrayList;

public class disableTrails implements CommandExecutor {

    private ArrayList<ArrayList<String>> lists = new ArrayList<>();

    @Override
    public CommandResult execute (CommandSource src,CommandContext args) throws CommandException {
        lists.add(helix.getParticleInfo());
        lists.add(globe.getParticleInfo());
        Player player = (Player) src;
        String identity = player.getUniqueId().toString();

        for (ArrayList<String> aList : lists) {
            for (String s : aList) {
                if (s.startsWith(identity)) {
                    aList.remove(s);
                    break;
                }
            }
        }
        return CommandResult.success();
    }
}

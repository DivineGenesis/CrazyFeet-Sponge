package me.runescapejon.CrazyFeet;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.google.inject.Inject;
import me.runescapejon.CrazyFeet.Commands.*;
import me.runescapejon.CrazyFeet.utils.Config;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.World;

import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetAdminCmd;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetCommands;
import me.runescapejon.CrazyFeet.Listeners.CrazyListener;

@Plugin(id = "crazyfeetsponge", name = "CrazyFeetSponge", authors = {
		"runescapejon" }, description = "CrazyFeet Ported over to Sponge", version = "1.14")
public class CrazyFeet {
    private ArrayList<UUID> crazyFireHead = new ArrayList<>();
    private ArrayList<UUID> crazyHeartHead = new ArrayList<>();
    private ArrayList<UUID> crazyMagicHead = new ArrayList<>();
    private ArrayList<UUID> crazyNoteHead = new ArrayList<>();
    private ArrayList<UUID> crazyWitchHead = new ArrayList<>();
    private ArrayList<UUID> crazySmokeHead = new ArrayList<>();
    private ArrayList<UUID> crazyPearlHead = new ArrayList<>();
    private ArrayList<UUID> crazyFire = new ArrayList<>();
    private ArrayList<UUID> crazySmoke = new ArrayList<>();
    private ArrayList<UUID> crazyMagic = new ArrayList<>();
    private ArrayList<UUID> crazyPearl = new ArrayList<>();
    private ArrayList<UUID> crazyNote = new ArrayList<>();
    private ArrayList<UUID> crazyWitch = new ArrayList<>();
    private ArrayList<UUID> crazyHeart = new ArrayList<>();
    private ArrayList<UUID> globe = new ArrayList<>();
    private ArrayList<UUID> Storm = new ArrayList<>();
    private static CrazyFeet instance;

    public static CrazyFeet getInstance () {
        return instance;
    }

    @Inject
    private Logger logger;

    @Inject ()
    @ConfigDir (sharedRoot = false)
    private File configDirectory;

    private Config languageConfig = new Config("language.conf",false);

    @Listener
    public void onConstruct (GameConstructionEvent event) {
        instance = this;
    }

    private static PluginContainer plugin;

    @Listener
    public void onPreInitializationEvent (GamePreInitializationEvent event) {
        plugin = Sponge.getPluginManager().getPlugin("crazyfeetsponge").get();
        instance = this;
    }

    public static PluginContainer getPlugin () {
        return plugin;
    }

    @Listener
    public void onGamePreInitialization (GamePreInitializationEvent event) {
        if (!configDirectory.exists()) {
            configDirectory.mkdirs();
        }
        languageConfig.activate();
    }

    @Listener
    public void onGameInitlization (GameInitializationEvent event) {
        // CrazyFeet Register
        HashMap<List<String>, CommandSpec> subcommands = new HashMap<>();
        subcommands.put(Collections.singletonList("admin"),
                CommandSpec.builder().description(Text.of("crazyfeet admin")).permission("crazyfeet.admin")
                        .executor(new CrazyFeetAdminCmd()).build());

        CommandSpec CrazyFeetSpec = CommandSpec.builder().description(Text.of("crazyfeet"))
                .permission("crazyfeet.crazyfeet").executor(new CrazyFeetCommands()).children(subcommands).build();
        Sponge.getCommandManager().register(this,CrazyFeetSpec,"crazyfeet");

        // CrazyHeadListener Registering here
        CrazyListener head = new CrazyListener();
        Sponge.getEventManager().registerListeners(this,head);

        Sponge.getEventManager().registerListeners(this,new GuiCommand());

        Sponge.getEventManager().registerListeners(this,new HelixGUICommand());

        Sponge.getEventManager().registerListeners(this,new GuiPage2Cmd());

        Sponge.getCommandManager().register(this,new commandLoader().crazyRoot,"trail","trails");
    }

    public Logger getLogger () {
        return logger;
    }

    public File getConfigDirectory () {
        return configDirectory;
    }

    public Config getLanguageConfig () {
        return languageConfig;
    }

    public ArrayList<UUID> getCrazyFireHead () {
        return crazyFireHead;
    }

    public ArrayList<UUID> getCrazyHeartHead () {
        return crazyHeartHead;
    }

    public ArrayList<UUID> getCrazyMagicHead () {
        return crazyMagicHead;
    }

    public ArrayList<UUID> getCrazyNoteHead () {
        return crazyNoteHead;
    }

    public ArrayList<UUID> getCrazyWitchHead () {
        return crazyWitchHead;
    }

    public ArrayList<UUID> getCrazySmokeHead () {
        return crazySmokeHead;
    }

    public ArrayList<UUID> getCrazyPearlHead () {
        return crazyPearlHead;
    }

    public ArrayList<UUID> getCrazyFire () {
        return crazyFire;
    }

    public ArrayList<UUID> getCrazySmoke () {
        return crazySmoke;
    }

    public ArrayList<UUID> getCrazyMagic () {
        return crazyMagic;
    }

    public ArrayList<UUID> getCrazyPearl () {
        return crazyPearl;
    }

    public ArrayList<UUID> getCrazyNote () {
        return crazyNote;
    }

    public ArrayList<UUID> getCrazyWitch () {
        return crazyWitch;
    }

    public ArrayList<UUID> getCrazyHeart () {
        return crazyHeart;
    }

    private void helix (Optional<Player> player,Color color) {
        helixMath(player,color);
    }

    public ArrayList<UUID> getCrazyGlobe () {
        return globe;
    }

    public ArrayList<UUID> getCrazyStorm () {
        return Storm;
    }

    private void cloudMath (Player player,double x,double y,double z) {
        World world = player.getWorld();
        world.spawnParticles(
                ParticleEffect.builder().type(ParticleTypes.CLOUD).build(),
                player.getLocation().getPosition().add(x,y,z));
    }

    private void helixMath (Optional<Player> player,Color c) {
        phi = phi + Math.PI / 16;
        double x, y, z;
        for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
            for (double i = 0; i <= 1; i = i + 1) {
                x = 0.15 * (2 * Math.PI - t) * Math.cos(t + phi + i * Math.PI);
                y = 0.5 * t;
                z = 0.15 * (2 * Math.PI - t) * Math.sin(t + phi + i * Math.PI);
                World world = player.get().getWorld();
                world.spawnParticles(
                        ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
                                .option(ParticleOptions.COLOR,c).build(),
                        player.get().getLocation().getPosition().add(x,y,z));

            }
        }
    }

    private void StyleGlobe (Player player) {
        pi += Math.PI / 10;
        for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 40) {
            double r = 1.5;
            double x = r * Math.cos(theta) * Math.sin(pi);
            double y = r * Math.cos(pi) + 1.5;
            double z = r * Math.sin(theta) * Math.sin(pi);

            // double z = r*Math.sin(theta)+Math.sin(pi);
            World world = player.getWorld();
            world.spawnParticles(
                    ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
                            .option(ParticleOptions.COLOR,Color.ofRgb(255,0,0)).build(),
                    player.getLocation().getPosition().add(x,y,z));

        }
    }

    private void Cloud (Player player) {
        cloudMath(player,0,2.5,0);
        cloudMath(player,0.2,2.5,0.2);
        cloudMath(player,0,2.5,0.4);
        cloudMath(player,0.4,2.5,0);
    }

    private void Rain (Player player) {
        World world = player.getWorld();
        world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WATER_DROP).build(),
                player.getLocation().getPosition().add(0,2.5,0));
    }

    private double phi = 0;
    private double pi = 0;

    @Listener
    public void onServerStart (GameStartedServerEvent event) {
        Task.builder()
                .interval(63,TimeUnit.MILLISECONDS)
                .name("globe")
                .execute(() -> {
                    if (!globe.isEmpty()) {
                        globe.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::StyleGlobe));
                    }
                })
                .submit(this);

        Task.builder()
                .intervalTicks(1)
                .execute(() -> {
                    if (!Storm.isEmpty()) {
                        Storm.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::Cloud));
                        Storm.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::Rain));
                    }
                })
                .submit(this);

        Task.builder()
                .interval(63,TimeUnit.MILLISECONDS)
                .name("helix")
                .execute(() -> {
                    if (!commandLoader.getParticleInfo().isEmpty()) {
                        for (String s : commandLoader.getParticleInfo()) {
                            UUID identity = UUID.fromString(s.substring(0,36));
                            String choice = s.substring(37);
                            if (Sponge.getServer().getPlayer(identity).isPresent()) {
                                helix(Sponge.getServer().getPlayer(identity),colorChoice(choice));
                            }
                        }
                    }
                })
                .submit(this);
    }




    private Color colorChoice (String choice) {
        switch (choice.toLowerCase()) {
            case "red": {
                return Color.RED;
            }
            case "blue": {
                return Color.BLUE;
            }
            case "green": {
                return Color.GREEN;
            }
            case "yellow": {
                return Color.YELLOW;
            }
            case "orange": {
                return Color.ofRgb(249,119,7);
            }
            case "white": {
                return Color.WHITE;
            }
            case "brown": {
                return Color.ofRgb(127,85,42);
            }
            case "purple": {
                return Color.PURPLE;
            }
            default:
                return Color.BLACK;
        }
    }

    // this here is basically so i can test and do a bit of math
    //so i can add new particle animation and things like that you can ignore this
/*	public void test(Player player) {
		for (int degree = 90; degree < 360; degree++) {
			double radians = Math.toRadians(degree);
			double x = Math.cos(radians);
			double z = Math.sin(radians);
			World world = player.getWorld();
			world.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
							.option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
					player.getLocation().getPosition().add(x, 2.5, z));
		}
		for (int degree = 90; degree < 360; degree++) {
			double radians = Math.toRadians(degree);
			double x = Math.cos(radians);
			double z = Math.sin(radians);
			World world = player.getWorld();
			world.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
							.option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
					player.getLocation().getPosition().add(x, 1.5, z));
		}
		for (int degree = 90; degree < 360; degree++) {
			double radians = Math.toRadians(degree);
			double x = Math.cos(radians);
			double z = Math.sin(radians);
			World world = player.getWorld();
			world.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
							.option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
					player.getLocation().getPosition().add(x, 0.1, z));
		}
	}
	*/



}

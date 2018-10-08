package me.runescapejon.CrazyFeet;

import com.google.inject.Inject;
import me.runescapejon.CrazyFeet.Commands.*;
import me.runescapejon.CrazyFeet.Listeners.CrazyListener;
import me.runescapejon.CrazyFeet.utils.Config;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
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
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.World;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Plugin(id = "crazyfeetsponge", name = "CrazyFeetSponge", authors = {
		"runescapejon" }, description = "CrazyFeet Ported over to Sponge", version = "1.14")
public class CrazyFeet {
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


    private void helix (Optional<Player> player,Color color) {
        helixMath(player,color);
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

    private void StyleGlobe (Optional<Player> player,Color c) {
        pi += Math.PI / 10;
        for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 40) {
            double r = 1.5;
            double x = r * Math.cos(theta) * Math.sin(pi);
            double y = r * Math.cos(pi) + 1.5;
            double z = r * Math.sin(theta) * Math.sin(pi);

            World world = player.get().getWorld();
            world.spawnParticles(
                    ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
                            .option(ParticleOptions.COLOR,c).build(),
                    player.get().getLocation().getPosition().add(x,y,z));

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
                    for (UUID uuid : commandUtil.getUuidStringMap().keySet()) {
                        if (Sponge.getServer().getPlayer(uuid).isPresent()) {
                            helix(Sponge.getServer().getPlayer(uuid),colorChoice(commandUtil.getUuidStringMap().get(uuid)));
                        }
                    }
                })
                .submit(this);


        Task.builder()
                .interval(63,TimeUnit.MILLISECONDS)
                .name("superglobe")
                .execute(() -> {
                    for (UUID uuid : commandUtil.getUuidStringMap().keySet()) {
                        if (Sponge.getServer().getPlayer(uuid).isPresent()) {
                            StyleGlobe(Sponge.getServer().getPlayer(uuid),colorChoice(commandUtil.getUuidStringMap().get(uuid)));
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

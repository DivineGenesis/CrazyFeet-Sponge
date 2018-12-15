package me.runescapejon.CrazyFeet.Listeners;

import me.runescapejon.CrazyFeet.Commands.commandUtil;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.effect.sound.SoundTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.block.ChangeBlockEvent;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class CrazyListener {
	private GameRegistry gameRegistry = Sponge.getRegistry();

	@Listener
	public void onMove (MoveEntityEvent event,@Root Player player) {
		if (player.get(Keys.INVISIBLE).get()) {
			return;
		}
		World world = player.getWorld();
		for (UUID uuid : commandUtil.getUuidDoubleHashMap().keySet()) {
			if (commandUtil.getUuidDoubleHashMap().containsKey(uuid)) {
				HashMap<HashMap<UUID, Double>, ParticleType> map = commandUtil.getParticleTypeHashMap();
				ParticleType innerMap = map.get(commandUtil.getUuidDoubleHashMap());
				Double bodyType = commandUtil.getUuidDoubleHashMap().get(uuid);
				if (!innerMap.equals(ParticleTypes.NOTE)) {
					applyParticle(world,player,innerMap,bodyType);
				} else {
					applyParticle(world,player,innerMap,bodyType);
				}
			}
		}
	}

	private void applyParticle (World world,Player player,ParticleType pType,double bodyType) {
		Random randomGenerator = new Random();
		ArrayList<NotePitch> noteTypes = new ArrayList<>(getGameRegistry().getAllOf(NotePitch.class));
		if (pType.equals(ParticleTypes.NOTE)) {
			int index = randomGenerator.nextInt(noteTypes.size());
			world.spawnParticles(ParticleEffect.builder().type(pType)
							.option(ParticleOptions.NOTE,noteTypes.get(index)).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		} else {
			world.spawnParticles(ParticleEffect.builder().type(pType).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		}

	}
	private GameRegistry getGameRegistry () {
		return gameRegistry;
	}
}

package me.runescapejon.CrazyFeet.Listeners;

import me.runescapejon.CrazyFeet.Commands.hearts;
import me.runescapejon.CrazyFeet.CrazyFeet;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.data.type.NotePitches;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class CrazyListener {
	@Listener
	public void onMove (MoveEntityEvent event,@Root Player player) {
		if (player.get(Keys.INVISIBLE).get()) {
			return;
		}
		World world = player.getWorld();

		for (String s : hearts.getParticleInfo()) {
			UUID identity = UUID.fromString(s.substring(0,36));
			String choice = s.substring(37);
			if (player.getUniqueId().equals(identity)) {
				applyParticle(world,player,ParticleTypes.HEART,false,Double.valueOf(choice));
			}
		}


		double head = 2.5;
		double feet = 0.1;
		boolean fire = CrazyFeet.getInstance().getCrazyFire().contains(player.getUniqueId()),
				note = CrazyFeet.getInstance().getCrazyNote().contains(player.getUniqueId()),
				magic = CrazyFeet.getInstance().getCrazyMagic().contains(player.getUniqueId()),
				smoke = CrazyFeet.getInstance().getCrazySmoke().contains(player.getUniqueId()),
				pearl = CrazyFeet.getInstance().getCrazyPearl().contains(player.getUniqueId()),
				witch = CrazyFeet.getInstance().getCrazyWitch().contains(player.getUniqueId()),
				fireHead = CrazyFeet.getInstance().getCrazyFireHead().contains(player.getUniqueId()),
				noteHead = CrazyFeet.getInstance().getCrazyNoteHead().contains(player.getUniqueId()),
				magicHead = CrazyFeet.getInstance().getCrazyMagicHead().contains(player.getUniqueId()),
				smokeHead = CrazyFeet.getInstance().getCrazySmokeHead().contains(player.getUniqueId()),
				pearlHead = CrazyFeet.getInstance().getCrazyPearlHead().contains(player.getUniqueId()),
				witchHead = CrazyFeet.getInstance().getCrazyWitchHead().contains(player.getUniqueId());


		if (note) {
			// Thanks to @Cybermaxke for telling me how to change colors
			applyParticle(world,player,ParticleTypes.NOTE,true,feet);
		}
		if (fire) {
			applyParticle(world,player,ParticleTypes.MOBSPAWNER_FLAMES,false,feet);
		}
		if (magic) {
			applyParticle(world,player,ParticleTypes.INSTANT_SPELL,false,feet);
		}
		if (smoke) {
			applyParticle(world,player,ParticleTypes.SMOKE,false,feet);
		}
		if (pearl) {
			applyParticle(world,player,ParticleTypes.ENDER_TELEPORT,false,feet);
		}
		if (witch) {
			applyParticle(world,player,ParticleTypes.WITCH_SPELL,false,feet);
		}
		if (noteHead) {
			applyParticle(world,player,ParticleTypes.NOTE,true,head);
		}
		if (fireHead) {
			applyParticle(world,player,ParticleTypes.MOBSPAWNER_FLAMES,false,head);
		}
		if (magicHead) {
			applyParticle(world,player,ParticleTypes.INSTANT_SPELL,false,head);
		}
		if (smokeHead) {
			applyParticle(world,player,ParticleTypes.SMOKE,false,head);
		}
		if (pearlHead) {
			applyParticle(world,player,ParticleTypes.ENDER_TELEPORT,false,head);
		}
		if (witchHead) {
			applyParticle(world,player,ParticleTypes.WITCH_SPELL,false,head);
		}
	}

	private void applyParticle (World world,Player player,ParticleType pType,boolean isNote,double bodyType) {
		Random randomGenerator = new Random();
		ArrayList<NotePitch> noteTypes = new ArrayList<>();
		noteTypes.add(NotePitches.A1);
		noteTypes.add(NotePitches.A2);
		noteTypes.add(NotePitches.A_SHARP1);
		noteTypes.add(NotePitches.A_SHARP2);
		noteTypes.add(NotePitches.B1);
		noteTypes.add(NotePitches.B2);
		noteTypes.add(NotePitches.C1);
		noteTypes.add(NotePitches.C2);
		noteTypes.add(NotePitches.C_SHARP1);
		noteTypes.add(NotePitches.C_SHARP2);
		noteTypes.add(NotePitches.D1);
		noteTypes.add(NotePitches.D2);
		noteTypes.add(NotePitches.D_SHARP1);
		noteTypes.add(NotePitches.D_SHARP2);
		noteTypes.add(NotePitches.E1);
		noteTypes.add(NotePitches.E2);
		noteTypes.add(NotePitches.F1);
		noteTypes.add(NotePitches.F2);
		noteTypes.add(NotePitches.F_SHARP0);
		noteTypes.add(NotePitches.F_SHARP1);
		noteTypes.add(NotePitches.F_SHARP2);
		noteTypes.add(NotePitches.D_SHARP2);
		noteTypes.add(NotePitches.G0);
		noteTypes.add(NotePitches.G1);
		noteTypes.add(NotePitches.G_SHARP0);
		noteTypes.add(NotePitches.G_SHARP1);
		if (isNote) {
			int index = randomGenerator.nextInt(noteTypes.size());
			world.spawnParticles(ParticleEffect.builder().type(pType)
							.option(ParticleOptions.NOTE,noteTypes.get(index)).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		} else {
			world.spawnParticles(ParticleEffect.builder().type(pType).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		}
	}
}

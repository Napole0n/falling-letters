package mgsoft.fallingletters.particles;

import javafx.geometry.Dimension2D;
import mgsoft.fallingletters.common.Config;
import mgsoft.fallingletters.engine.Particle;
import mgsoft.fallingletters.engine.ParticleEmissor;

public class ExplosionParticleEmissor extends ParticleEmissor {

	private double xOrigin, yOrigin;

    public ExplosionParticleEmissor(double targetX, double targetY) {
		this.xOrigin = targetX;
		this.yOrigin = targetY;
	}
	
	@Override
	protected int getParticleAmmmount() {
		return 100;
	}

	@Override
	protected Particle getParticleSample() {
		return new SimpleParticle(Math.random() * 180, Math.random() * 50, this.xOrigin, this.yOrigin - 20, new Dimension2D(Config.LARGURA_TELA, Config.ALTURA_TELA));
	}

}

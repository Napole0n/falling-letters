package mgsoft.fallingletters.engine;

public abstract class ParticleEmissor {

	protected abstract int getParticleAmmmount();
	
	protected abstract Particle getParticleSample();
	
	public void emmit() {
		for(int i=0; i<getParticleAmmmount(); i++) {
			getParticleSample().start();
		}
	}
}

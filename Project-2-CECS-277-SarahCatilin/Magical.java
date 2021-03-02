public interface Magical {

	static final String MAGIC_MENU = "1. Magic Missile\n2. Fireball\n3. Thunderclap";

	/**
	 * Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	public String magicMissile(Entity e);

	/**
	 * Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	public String fireball(Entity e);

	/**
	 * Magical attack, works similarly to {@link #attack(Entity e) attack()} method.
	 * 
	 * @param e the Entity to receive damage
	 * @return String representing attack and how much damage was done
	 */
	public String thunderclap(Entity e);

}

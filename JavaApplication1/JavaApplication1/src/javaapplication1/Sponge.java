package javaapplication1;

/**
 * Sponge (creature). The subclass of Creature.
 */
public class Sponge extends Creature {
    /**
     * Constructor. New Sponge creature with the name and initial water level.
     * @param name The name of the creature.
     * @param initialWaterLevel The initial water level of the creature.
     */
    public Sponge(String name, int initialWaterLevel) { super(name, initialWaterLevel); maxWaterLevel = 20; }

    /**
     * Sunny day: Update the water level.
     * Checks if it's alive.
     */
    @Override
    public void sunny() { currentWaterLevel -= 4; if (currentWaterLevel <= 0) alive = false; }

    /**
     * Cloudy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void cloudy() { currentWaterLevel -= 1; distance += 1; if(currentWaterLevel <= 0) alive = false; }

    /**
     * Rainy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void rainy() { currentWaterLevel += 6; distance += 3; if(currentWaterLevel <= 0) alive = false; }
}
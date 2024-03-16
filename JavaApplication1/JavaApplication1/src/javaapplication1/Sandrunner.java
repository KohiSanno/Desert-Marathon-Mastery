package javaapplication1;
/**
 * Sandrunner (creature). The subclass of Creature.
 */
public class Sandrunner extends Creature {
    /**
     * Constructor. New Sandrunner creature with the name and initial water level.
     * @param name The name of the creature.
     * @param initialWaterLevel The initial water level of the creature.
     */
    public Sandrunner(String name, int initialWaterLevel) { super(name, initialWaterLevel); maxWaterLevel = 8; }

    /**
     * Sunny day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void sunny() { currentWaterLevel -= 1; distance += 3; if(currentWaterLevel <= 0) alive = false; }

    /**
     * Cloudy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void cloudy() { distance += 1; if(currentWaterLevel <= 0) alive = false; }

    /**
     * Rainy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void rainy() { currentWaterLevel += 3; if(currentWaterLevel <= 0) alive = false; }
}

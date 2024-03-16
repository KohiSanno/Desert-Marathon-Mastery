package javaapplication1;
/**
 * Walker (creature). The subclass of Creature.
 */
public class Walker extends Creature {
    /**
     * Constructor. New Walker creature with the name and initial water level.
     * @param name The name of the creature.
     * @param initialWaterLevel The initial water level of the creature.
     */
    public Walker(String name, int initialWaterLevel) { super(name, initialWaterLevel); maxWaterLevel = 12; }

    /**
     * Sunny day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void sunny() { currentWaterLevel -= 2; distance += 1; if(currentWaterLevel <= 0) alive = false; }

    /**
     * Cloudy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void cloudy() { currentWaterLevel -= 1; distance += 2; if(currentWaterLevel <= 0) alive = false; }

    /**
     * Rainy day: Update the water level and the distance.
     * Checks if it's alive.
     */
    @Override
    public void rainy() { currentWaterLevel += 3; distance += 1; if(currentWaterLevel <= 0) alive = false; }
}

package javaapplication1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Creature. The abstract superclass of the 3 creatures.
 * It gives the subclasses some common fields and methods.
 */
public abstract class Creature {
    protected String name;    
    protected int distance;
    protected int initialWaterLevel;
    protected int currentWaterLevel;
    protected int maxWaterLevel;
    protected boolean alive = true; // default state

    /**
     * Constructor. Creature superclass with the name and initial water level.
     * @param name The name of the creature.
     * @param initialWaterLevel The initial water level of the creature.
     */
    public Creature(String name, int initialWaterLevel)
    {
        this.name = name;
        this.initialWaterLevel = initialWaterLevel;
        this.currentWaterLevel = initialWaterLevel;
    }

    /**
     * Sunny day: the creature's activity. Abstract method.
     */
    public abstract void sunny();

    /**
     * Cloudy day: the creature's activity. Abstract method.
     */
    public abstract void cloudy();

    /**
     * Rainy day: the creature's activity. Abstract method.
     */
    public abstract void rainy();


    /**
     * Checks whether the creature is alive or not.
     * @return If the creature is alive, it's true, otherwise it's false.
     */
    public boolean isAlive() { return alive; }

    /**
     * The name of the creature.
     * @return The name of the creature.
     */
    public String getName() { return name; }

    /**
     * The distance the creature has traversed.
     * @return The distance the creature has traversed.
     */
    public int getDistance() { return distance; }
}


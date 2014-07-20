package celestibytes.tankytanks.common.util;

/**
 * The reason to have our own math helper is that we don't need to change the method names after updates and our helper
 * has better documentation
 */
public class MathHelper
{
	
	 /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @param min   = minimum possible value
     */
    public static int clampInt(int value, int min, int max)
    {
        return (value < min) ? min : (value > max) ? max : value;
    }
	
    /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @param min   = minimum possible value
     */
    public static double clampDouble(double value, double min, double max)
    {
        return (value < min) ? min : (value > max) ? max : value;
    }
    
    /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @param min   = minimum possible value
     */
    public static float clampFloat(float value, float min, float max)
    {
        return (value < min) ? min : (value > max) ? max : value;
    }
    
    /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @return an int clamped between 0 and max
     */
    public static int clampZero_int(int value, int max)
    {
        return clampInt(value, 0, max);
    }

    /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @return a float clamped between 0 and max
     */
    public static float clampZero_float(float value, float max)
    {
        return clampFloat(value, 0f, max);
    }

    /**
     * @param value = the number to clamp
     * @param max   = maximum possible value
     * @return a double clamped between 0 and max
     */
    public static double clampZero_double(double value, double max)
    {
        return clampDouble(value, 0d, max);
    }
}

package android.tk.wastelandempires.tools.maths;

import java.util.Random;

public class Maths
{

    public static int randomInt(int max)
    {
        return randomInt(0, max);
    }

    public static int randomInt(int min, int max)
    {
        int random = new Random().nextInt(max - min);
        return min + random;
    }

}
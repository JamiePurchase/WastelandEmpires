package android.tk.wastelandempires.tools.graphics;

import android.graphics.Bitmap;

public class Spritesheet
{
    private Bitmap sheet;
    private int imgWide;
    private int imgHigh;

    public Spritesheet(Bitmap sheet, int wide, int high)
    {
        this.sheet = sheet;
        this.imgWide = wide;
        this.imgHigh = high;
    }

    public Bitmap getImage(int imageX, int imageY)
    {
        return Bitmap.createBitmap(this.sheet, imageX * imgWide, imageY * imgHigh, imgWide, imgHigh);
    }

}
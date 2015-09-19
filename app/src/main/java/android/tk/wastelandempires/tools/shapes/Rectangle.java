package android.tk.wastelandempires.tools.shapes;

import android.graphics.Point;
import android.graphics.Rect;

public class Rectangle
{
    public int x, y, width, height;

    public Rectangle(int posX, int posY, int sizeX, int sizeY)
    {
        this.x = posX;
        this.y = posY;
        this.width = sizeX;
        this.height = sizeY;
    }

    public boolean contains(float posX, float posY)
    {
        return contains((int) posX, (int) posY);
    }

    public boolean contains(int posX, int posY)
    {
        return this.getRect().contains(posX, posY);
    }

    private Rect getRect()
    {
        return new Rect(this.x, this.y, this.x + this.width, this.y + this.height);
    }

}
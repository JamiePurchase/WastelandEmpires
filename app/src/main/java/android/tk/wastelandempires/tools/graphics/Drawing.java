package android.tk.wastelandempires.tools.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.tk.wastelandempires.application.GameDisplay;
import android.tk.wastelandempires.tools.shapes.Shapes;

import java.util.HashMap;

public class Drawing
{
    public static HashMap<String, Color> colors;

    public static int[] getColour(String name)
    {
        // Named Colours
        if(name == "BLACK") {return new int[]{0, 0, 0};}
        if(name == "WHITE") {return new int[]{255, 255, 255};}

        // Theme Colours
        if(name == "BattleGrass1") {return new int[]{169, 230, 115};}
        if(name == "MenuGreen") {return new int[]{145, 181, 89};}
        if(name == "MenuGreen2") {return new int[]{155, 201, 99};}
        if(name == "MenuShadow") {return new int[]{95, 151, 59};}

        // Default
        return new int[]{0, 0, 0};
    }

    public static Paint getPaint(String colour)
    {
        return getPaint(colour, 0);
    }

    public static Paint getPaint(String colour, int border)
    {
        Paint paint = new Paint();
        if(border > 0)
        {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(border);
        }
        else {paint.setStyle(Paint.Style.FILL);}
        int[] rgb = getColour(colour);
        paint.setColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
        return paint;
    }

    public static Paint getPaint(int r, int g, int b, int border)
    {
        Paint paint = new Paint();
        if(border > 0)
        {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(border);
        }
        else {paint.setStyle(Paint.Style.FILL);}
        paint.setColor(Color.rgb(r, g, b));
        return paint;
    }

    public static void imageDraw(Canvas canvas, Bitmap image, int posX, int posY)
    {
        canvas.drawBitmap(image, posX, posY, null);
    }

    public static void imageDrawTile(Canvas canvas, Bitmap image, int sizeX, int sizeY)
    {
        int drawX = 0;
        int drawY = 0;
        while(drawX < GameDisplay.WIDTH)
        {
            while(drawY < GameDisplay.HEIGHT)
            {
                canvas.drawBitmap(image, drawX, drawY, null);
                drawY = drawY + sizeY;
            }
            drawX = drawX + sizeX;
            drawY = 0;
        }
    }

    public static void rectDraw(Canvas canvas, String colour, Rect rect)
    {
        canvas.drawRect(rect, getPaint(colour, 1));
    }

    public static void rectDraw(Canvas canvas, String colour, int drawX, int drawY, int sizeX, int sizeY)
    {
        rectDraw(canvas, colour, new Rect(drawX, drawY, drawX + sizeX, drawY + sizeY));
    }

    public static void rectFill(Canvas canvas, String colour, Rect rect)
    {
        canvas.drawRect(rect, getPaint(colour));
    }

    public static void rectFill(Canvas canvas, String colour, int drawX, int drawY, int sizeX, int sizeY)
    {
        rectFill(canvas, colour, new Rect(drawX, drawY, drawX + sizeX, drawY + sizeY));
    }

    public static void rectShadow(Canvas canvas, String colour, Rect rect)
    {
        rectFill(canvas, colour, Shapes.rectOffset(rect, 2, 2));
        rectFill(canvas, colour, Shapes.rectOffset(rect, 4, 4));
    }

    public static void screenFill(Canvas canvas, String colour)
    {
        canvas.drawRect(new Rect(0, 0, GameDisplay.WIDTH, GameDisplay.HEIGHT), getPaint(colour));
    }

    public static void screenFill(Canvas canvas, int r, int g, int b)
    {
        canvas.drawRect(new Rect(0, 0, GameDisplay.WIDTH, GameDisplay.HEIGHT), getPaint(r, g, b, 0));
    }

    public static void textWrite(Canvas canvas, String text, String colour, int drawX, int drawY, int size)
    {
        Paint paint = new Paint();
        int[] rgb = getColour(colour);
        paint.setColor(Color.rgb(rgb[0], rgb[1], rgb[2]));
        paint.setTextSize(size);
        canvas.drawText(text, drawX, drawY, paint);
    }
}
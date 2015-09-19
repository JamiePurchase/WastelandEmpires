package android.tk.wastelandempires.war.entity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.tk.wastelandempires.application.GameDisplay;
import android.tk.wastelandempires.tools.graphics.Spritesheet;
import android.tk.wastelandempires.tools.shapes.Rectangle;
import android.tk.wastelandempires.war.engine.War;

public class Entity
{
    // Entity
    private War entityWar;
    private String entityName;

    // Position
    private int entityPosX, entityPosY;
    private Face entityPosF;

    // Animation
    private Spritesheet entityAnimImage;
    private int entityAnimTickNow, entityAnimTickMax, entityAnimFrameNow, entityAnimFrameMax;

    // TEMP
    private boolean tempTouch;

    public Entity(War war, String name, Spritesheet image, int posX, int posY, Face face)
    {
        // Entity
        this.entityWar = war;
        this.entityName = name;

        // Position
        this.entityPosX = 3;
        this.entityPosY = 3;
        this.entityPosF = face;

        // Animation
        this.entityAnimImage = image;
        this.entityAnimTickNow = 0;
        this.entityAnimTickMax = 12;
        this.entityAnimFrameNow = 0;
        this.entityAnimFrameMax = 2;

        // TEMP
        this.tempTouch = false;
    }

    public Rectangle getRenderArea()
    {
        return new Rectangle(this.getRenderPosX(), this.getRenderPosY(), 100, 100);
    }

    private Bitmap getRenderImage()
    {
        return this.entityAnimImage.getImage(this.entityAnimFrameNow, 0);
    }

    private int getRenderPosX()
    {
        return 33 + (this.entityPosX * 100);
    }

    private int getRenderPosY()
    {
        return 30 + (this.entityPosY * 100);
    }

    public void render(Canvas canvas)
    {
        // TEMP
        if(this.tempTouch) {canvas.drawBitmap(GameDisplay.assetEntitySelect1, this.getRenderPosX(), this.getRenderPosY(), null);}

        canvas.drawBitmap(this.getRenderImage(), this.getRenderPosX(), this.getRenderPosY(), null);
    }

    public void tick()
    {
        this.entityAnimTickNow += 1;
        if(this.entityAnimTickNow > this.entityAnimTickMax)
        {
            this.entityAnimTickNow = 0;
            this.entityAnimFrameNow += 1;
            if(this.entityAnimFrameNow > this.entityAnimFrameMax)
            {
                this.entityAnimFrameNow = 0;
            }
        }
    }

    public void touch()
    {
        // TEMP
        this.tempTouch = true;
    }

}
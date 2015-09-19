package android.tk.wastelandempires.war.engine;

import android.graphics.Canvas;
import android.tk.wastelandempires.application.GameDisplay;
import android.tk.wastelandempires.states.StateWar;
import android.tk.wastelandempires.war.entity.Entity;
import android.tk.wastelandempires.war.entity.Face;
import android.view.MotionEvent;

import java.util.ArrayList;

public class War
{
    // War
    private StateWar warState;

    // Time
    private int timeTick;

    // Entity
    private ArrayList<Entity> entityAlly, entityEnemy;

    // Selection
    private boolean selectActive;

    public War(StateWar state)
    {
        // War
        this.warState = state;

        // Time
        this.timeTick = 0;

        // Entity
        this.entityAlly = new ArrayList();
        this.entityEnemy = new ArrayList();

        // TEMP
        this.entityAlly.add(new Entity(this, "SAMURAI", GameDisplay.assetEntitySamuraiIdle, 3, 3, Face.EAST));
        this.entityEnemy.add(new Entity(this, "SAMURAI", GameDisplay.assetEntitySamuraiIdle, 8, 3, Face.WEST));

        // Selection
        this.selectActive = false;
    }

    public void render(Canvas canvas)
    {
        this.renderBackground(canvas);
        this.renderEntity(canvas);
        this.renderUi(canvas);
    }

    private void renderBackground(Canvas canvas)
    {
        canvas.drawBitmap(GameDisplay.assetWarBackground1, 0, 0, null);
    }

    private void renderEntity(Canvas canvas)
    {
        this.renderEntityAlly(canvas);
        this.renderEntityEnemy(canvas);
    }

    private void renderEntityAlly(Canvas canvas)
    {
        for(int x = 0; x < this.entityAlly.size(); x++)
        {
            this.entityAlly.get(x).render(canvas);
        }
    }

    private void renderEntityEnemy(Canvas canvas)
    {
        for(int x = 0; x < this.entityEnemy.size(); x++)
        {
            this.entityEnemy.get(x).render(canvas);
        }
    }

    private void renderUi(Canvas canvas)
    {
        //
    }

    public void tick()
    {
        this.tickTime();
        this.tickEntity();
    }

    private void tickEntity()
    {
        this.tickEntityAlly();
        this.tickEntityEnemy();
    }

    private void tickEntityAlly()
    {
        for(int x = 0; x < this.entityAlly.size(); x++)
        {
            this.entityAlly.get(x).tick();
        }
    }

    private void tickEntityEnemy()
    {
        for(int x = 0; x < this.entityEnemy.size(); x++)
        {
            this.entityEnemy.get(x).tick();
        }
    }

    private void tickTime()
    {
        this.timeTick += 1;
    }

    public void touch(MotionEvent event)
    {
        // NOTE: check user interface
        // NOTE: check entities
        this.touchEntity(event);
    }

    private void touchEntity(MotionEvent event)
    {
        this.touchEntityAlly(event);
        this.touchEntityEnemy(event);
    }

    private void touchEntityAlly(MotionEvent event)
    {
        for(int x = 0; x < this.entityAlly.size(); x++)
        {
            if(this.entityAlly.get(x).getRenderArea().contains(event.getX(), event.getY())) {this.entityAlly.get(x).touch();}
        }
    }

    private void touchEntityEnemy(MotionEvent event)
    {
        for(int x = 0; x < this.entityEnemy.size(); x++)
        {
            if(this.entityEnemy.get(x).getRenderArea().contains(event.getX(), event.getY())) {this.entityEnemy.get(x).touch();}
        }
    }

}
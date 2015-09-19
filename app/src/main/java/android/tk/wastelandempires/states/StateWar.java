package android.tk.wastelandempires.states;

import android.graphics.Canvas;
import android.tk.wastelandempires.application.GameDisplay;
import android.tk.wastelandempires.war.engine.War;
import android.view.MotionEvent;

public class StateWar extends State
{
    private War warEngine;

    public StateWar()
    {
        this.warEngine = new War(this);
    }

    public void render(Canvas canvas)
    {
        // NOTE: check for pause
        this.renderWar(canvas);
    }

    private void renderWar(Canvas canvas)
    {
        this.warEngine.render(canvas);
    }

    public void tick()
    {
        this.warEngine.tick();
    }

    public void touchAction(MotionEvent event)
    {
        // NOTE: check pause interface
        this.warEngine.touch(event);
    }

}
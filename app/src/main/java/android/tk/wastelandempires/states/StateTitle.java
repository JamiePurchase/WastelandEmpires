package android.tk.wastelandempires.states;

import android.graphics.Canvas;
import android.tk.wastelandempires.application.GameDisplay;
import android.tk.wastelandempires.tools.graphics.Drawing;
import android.view.MotionEvent;

public class StateTitle extends State
{

    public StateTitle()
    {
        //
    }

    public void render(Canvas canvas)
    {
        this.renderBackground(canvas);
    }

    private void renderBackground(Canvas canvas)
    {
        Drawing.screenFill(canvas, "BLACK");
        canvas.drawBitmap(GameDisplay.assetTitleBackground, 0, 0, null);
    }

    public void tick()
    {

    }

    public void touchAction(MotionEvent event)
    {
        GameDisplay.setState(new StateWar());
    }

}
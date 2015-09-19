package android.tk.wastelandempires.states;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public abstract class State
{

    public abstract void render(Canvas canvas);
    public abstract void tick();

    public void touch(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {this.touchAction(event);}
    }

    public abstract void touchAction(MotionEvent event);

}
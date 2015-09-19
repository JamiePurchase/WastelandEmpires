package android.tk.wastelandempires.application;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.tk.wastelandempires.R;
import android.tk.wastelandempires.states.State;
import android.tk.wastelandempires.states.StateTitle;
import android.tk.wastelandempires.tools.graphics.Spritesheet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;

public class GameDisplay extends SurfaceView implements SurfaceHolder.Callback
{
    // Display
    public static Context CONTEXT;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;

    // Engine
    private GameThread thread;
    private static State state;

    // Assets: Bitmaps
    public static Bitmap assetTitleBackground;
    public static Bitmap assetWarBackground1, assetEntitySelect1;

    // Assets: Spritesheets
    public static Spritesheet assetEntitySamuraiIdle;

    public GameDisplay(Context context)
    {
        // Display
        super(context);
        CONTEXT = context;
        getHolder().addCallback(this);

        // Engine
        thread = new GameThread(getHolder(), this, 30);
        setFocusable(true);

        // Assets: Bitmap
        assetTitleBackground = BitmapFactory.decodeResource(getResources(), R.drawable.title_logo2);
        assetWarBackground1 = BitmapFactory.decodeResource(getResources(), R.drawable.war_background1);
        assetEntitySelect1 = BitmapFactory.decodeResource(getResources(), R.drawable.war_entity_select1);

        // Assets: Spritesheets
        assetEntitySamuraiIdle = new Spritesheet(BitmapFactory.decodeResource(getResources(), R.drawable.war_entity_samurai_idle), 100, 100);
    }

    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth() / (WIDTH * 1.f);
        final float scaleFactorY = getHeight() / (HEIGHT * 1.f);
        if(canvas != null)
        {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            state.render(canvas);
            canvas.restoreToCount(savedState);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
        {
            state.touch(event);
            return true;
        }

        // TEST
        if(event.getAction() == MotionEvent.EDGE_TOP)
        {
            state.touch(event);
        }

        if(event.getAction() == MotionEvent.ACTION_UP)
        {
            return true;
        }

        return super.onTouchEvent(event);
    }

    public static void setState(State newState)
    {
        state = newState;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {
        //
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            {
                thread.setRunning(false);
                thread.join();
            }
            catch(InterruptedException e) {e.printStackTrace();}
            retry = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        setState(new StateTitle());
        thread.setRunning(true);
        thread.start();
    }

    public void tick()
    {
        state.tick();
    }

}
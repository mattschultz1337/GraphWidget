package edu.binghamton.cs.surface;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{



    private boolean drawBall = true;

    private LinearLayout canvasLayout = null;

    MySurface customSurfaceView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SurfaceView");

        initControls();

        // Hide the app title bar.
        getSupportActionBar().hide();

        // Make app full screen to hide top status bar.
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create custom surfaceview object.
        customSurfaceView = new MySurface(getApplicationContext());

        // Set this as the onTouchListener to process custom surfaceview ontouch event.
        customSurfaceView.setOnTouchListener(this);

        // Add the custom surfaceview object to the layout.
        canvasLayout.addView(customSurfaceView);

        final SeekBar xint = (SeekBar) findViewById(R.id.xint);
        final TextView xnum = (TextView) findViewById(R.id.xnum);
        final int xstep = 1;
        int xmax = 1080;
        final int xmin = 0;

// Ex :
// If you want values from 3 to 5 with a step of 0.1 (3, 3.1, 3.2, ..., 5)
// this means that you have 21 possible values in the seekbar.
// So the range of the seek bar will be [0 ; (5-3)/0.1 = 20].
        xint.setMax((xmax - xmin) / xstep);
        xint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stu
                double xvalue = xmin + (progress * xstep);

                customSurfaceView.setCircleX((float) progress);

                // Create and set a red paint to custom surfaceview.
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                customSurfaceView.setPaint(paint);
                xnum.setText(String.valueOf(xvalue));
                customSurfaceView.drawBall();
            }
        });


        final SeekBar yint = (SeekBar) findViewById(R.id.yint);
        final TextView ynum = (TextView) findViewById(R.id.ynum);
        final int ystep = 1;
        int ymax = 1900;
        final int ymin = 0;

// Ex :
// If you want values from 3 to 5 with a step of 0.1 (3, 3.1, 3.2, ..., 5)
// this means that you have 21 possible values in the seekbar.
// So the range of the seek bar will be [0 ; (5-3)/0.1 = 20].
        yint.setMax((ymax - ymin) / ystep);
        yint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // TODO Auto-generated method stu
                double yvalue = ymin + (progress * ystep);

                customSurfaceView.setCircleY((float) yvalue);

                // Create and set a red paint to custom surfaceview.
                Paint paint = new Paint();
                paint.setColor(Color.RED);
                customSurfaceView.setPaint(paint);
                ynum.setText(String.valueOf(yvalue));
                customSurfaceView.drawBall();

            }
        });
    }

    /* Initialise ui controls. */
    private void initControls()
    {


        // This layout is used to contain custom surfaceview object.
        if(canvasLayout == null)
        {
            canvasLayout = (LinearLayout)findViewById(R.id.customViewLayout);
        }
    }

    /* If user finger touch the surfaceview object. */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // If user touch the custom SurfaceView object.
        if(view instanceof SurfaceView) {
            view.invalidate();

            float x = motionEvent.getX();

            float y = motionEvent.getY();

            //customSurfaceView.setCircleX(x);

            //customSurfaceView.setCircleY(y);

            //if (drawBall) {
                // Create and set a red paint to custom surfaceview.
                //Paint paint = new Paint();
               // paint.setColor(Color.RED);
               // customSurfaceView.setPaint(paint);

              //  customSurfaceView.drawBall();
           // }

            // Tell android os the onTouch event has been processed.
           return true;
        }else
        {
            // Tell android os the onTouch event has not been processed.
            return false;
        }
    }
}

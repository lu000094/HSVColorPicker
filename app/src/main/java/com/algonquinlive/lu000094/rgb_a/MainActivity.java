package com.algonquinlive.lu000094.rgb_a;

import android.app.DialogFragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import com.algonquinlive.lu000094.model.RGBAModel;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller for RGBAModel.
 *
 * As the Controller:
 *   a) event handler for the View
 *   b) observer of the Model (RGBAModel)
 *
 * Features the Update / React Strategy.
 *
 * @author Wenjuan Lu (lu000094)
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener{

    private SeekBar mAlphaSB;
    private SeekBar mBlueSB;
    private TextView mColorSwatch;
    private SeekBar mGreenSB;
    private RGBAModel mModel;
    private SeekBar mRedSB;
    private static final String ABOUT_DIALOG_TAG;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch( seekBar.getId() ) {
            case R.id.seekBar_red:
                mModel.setRed( mRedSB.getProgress() );
                break;
            case R.id.seekBar_green:
                mModel.setGreen( mGreenSB.getProgress() );
                break;
            case R.id.seekBar_blue:
                mModel.setBlue( mBlueSB.getProgress() );
                break;
            case R.id.seekBar_alpha:
                mModel.setAlpha(mAlphaSB.getProgress() );
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate a new RGB-A model
        // and observer it
        mModel = new RGBAModel( RGBAModel.MAX_RGB, RGBAModel.MAX_RGB, RGBAModel.MAX_RGB, RGBAModel.MAX_ALPHA );
        mModel.addObserver( this );

        // reference each View component
        mAlphaSB = (SeekBar) findViewById( R.id.seekBar_alpha );
        mRedSB = (SeekBar) findViewById( R.id.seekBar_red );
        mGreenSB = (SeekBar) findViewById( R.id.seekBar_green );
        mBlueSB = (SeekBar) findViewById( R.id.seekBar_blue );
        mColorSwatch = (TextView) findViewById(R.id.textView_colorSwatch);

        SeekBar mAlphaSB = (SeekBar) findViewById( R.id.seekBar_alpha );

        //Set the Domain Values
        mAlphaSB.setMax(RGBAModel.MAX_ALPHA);
        mRedSB.setMax(RGBAModel.MAX_RGB);
        mGreenSB.setMax(RGBAModel.MAX_RGB);
        mBlueSB.setMax(RGBAModel.MAX_RGB);
        //Register the Event Handlers
        mAlphaSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mModel.setAlpha( seekBar.getProgress() );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mRedSB.setOnSeekBarChangeListener( this );
        mGreenSB.setOnSeekBarChangeListener( this );
        mBlueSB.setOnSeekBarChangeListener( this );

        //this.updateView( );

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_black:
                mModel.asBlack();
                return true;
            case R.id.action_blue:
                mModel.asBlue();
                return true;
            case R.id.action_cyan:
                mModel.asCyan();
                return true;
            case R.id.action_green:
                mModel.asGreen();
                return true;
            case R.id.action_magenta:
                mModel.asMagenta();
                return true;
            case R.id.action_red:
                mModel.asRed();
                return true;
            case R.id.action_white:
                mModel.asWhite();
                return true;
            case R.id.action_yellow:
                mModel.asYellow();
                return true;
            case R.id.action_about:
                DialogFragment newFragment = new AboutDialogFragment();
                newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    // GET the Red value from the model, and
    // SET the blue <SeekBar> to the model's Red value
    private void updateRedSB() {
        mRedSB.setProgress( mModel.getRed() );
    }

    // GET the blue value from the model, and
    // SET the blue <SeekBar> to the model's blue value
    private void updateGreenSB() {
        mGreenSB.setProgress( mModel.getGreen() );
    }

    // GET the blue value from the model, and
    // SET the blue <SeekBar> to the model's blue value
    private void updateBlueSB() {
        mBlueSB.setProgress( mModel.getBlue() );
    }

    // GET the color value from the model, and
    // SET the color-swatch's background color to the model's color
    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(Color.argb(mModel.getAlpha()
                , mModel.getRed()
                , mModel.getGreen()
                , mModel.getBlue()));
    }



    // Synchronize each View component with the current state of the Model.
    public void updateView() {
        this.updateBlueSB();
        this.updateGreenSB();
        this.updateRedSB();
        this.updateColorSwatch();
    }
}

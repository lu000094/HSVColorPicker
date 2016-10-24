package com.algonquinlive.lu000094.hsv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.algonquinlive.lu000094.model.HSVModel;
import com.algonquinlive.lu000094.hsv.R;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

/**
 * Controller for HSVModel.
 * <p>
 * As the Controller:
 * a) event handler for the View
 * b) observer of the Model (HSVModel)
 * <p>
 * Features the Update / React Strategy.
 *
 * @author Wenjuan Lu (lu000094)
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener {

    private SeekBar mHueSB;
    private TextView mColorSwatch;
    private SeekBar mSaturationSB;
    private HSVModel mModel;
    private SeekBar mValueLightnessSB;
    private TextView mHueTV;
    private TextView mSatTV;
    private TextView mValueTV;

    private static final String ABOUT_DIALOG_TAG;
    private static final String degree_char;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
        degree_char = "°";
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekBar_hue:
                mModel.setHue(mHueSB.getProgress());
                mHueTV.setText("HUE: " + mModel.getHue() + degree_char);
                this.updateView();
                break;
            case R.id.seekBar_saturation:
                mModel.setSaturation(mSaturationSB.getProgress());
                mSatTV.setText("SATURATION: " + mModel.getSaturation() + "%");
                break;
            case R.id.seekBar_value:
                mModel.setValueLightness(mValueLightnessSB.getProgress());
                mValueTV.setText("VALUE/LIGHTNESS: " + mModel.getValueLightness() + "%");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mHueTV.setText("Hue");
        mSatTV.setText("Saturation");
        mValueTV.setText("Value/Lightness");
        this.updateView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate a new HSV model
        // and observer it
        //Default will be black.
        mModel = new HSVModel(HSVModel.MIN_HUE, HSVModel.MIN_SATURATION, HSVModel.MIN_VALUE_LIGHTNESS);
        mModel.addObserver(this);

        // reference each View component
        mHueSB = (SeekBar) findViewById(R.id.seekBar_hue);
        mSaturationSB = (SeekBar) findViewById(R.id.seekBar_saturation);
        mValueLightnessSB = (SeekBar) findViewById(R.id.seekBar_value);
        mColorSwatch = (TextView) findViewById(R.id.textView_colorSwatch);
        mHueTV = (TextView) findViewById(R.id.textView_hue);
        mSatTV = (TextView) findViewById(R.id.textView_sat);
        mValueTV = (TextView) findViewById(R.id.textView_value);

        //Set the Domain Values
        mHueSB.setMax(HSVModel.MAX_HUE);
        mSaturationSB.setMax(HSVModel.MAX_SATURATION);
        mValueLightnessSB.setMax(HSVModel.MAX_VALUE_LIGHTNESS);

        mHueSB.setOnSeekBarChangeListener(this);
        mSaturationSB.setOnSeekBarChangeListener(this);
        mValueLightnessSB.setOnSeekBarChangeListener(this);

        this.updateView();

        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), " H:" + mModel.getHue() + degree_char + " S:" + mModel.getSaturation() + "%" + " V:" + mModel.getValueLightness() + "%", Toast.LENGTH_LONG).show();

                return true;
            }
        });

        Button blackButton = (Button) findViewById(R.id.blackButton);
        Button redButton = (Button) findViewById(R.id.redButton);
        Button limeButton = (Button) findViewById(R.id.limeButton);
        Button blueButton = (Button) findViewById(R.id.blueButton);
        Button yellowButton = (Button) findViewById(R.id.yellowButton);
        Button cyanButton = (Button) findViewById(R.id.cyanButton);
        Button magentaButton = (Button) findViewById(R.id.magentaButton);
        Button silverButton = (Button) findViewById(R.id.silverButton);
        Button grayButton = (Button) findViewById(R.id.grayButton);
        Button maroonButton = (Button) findViewById(R.id.maroonButton);
        Button oliveButton = (Button) findViewById(R.id.oliveButton);
        Button greenButton = (Button) findViewById(R.id.greenButton);
        Button purpleButton = (Button) findViewById(R.id.purpleButton);
        Button tealButton = (Button) findViewById(R.id.tealButton);
        Button navyButton = (Button) findViewById(R.id.navyButton);

        blackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlack();
                toastAndUpdateView();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asRed();
                toastAndUpdateView();
            }
        });

        limeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asLime();
                toastAndUpdateView();
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlue();
                toastAndUpdateView();
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asYellow();
                toastAndUpdateView();
            }
        });

        cyanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asCyan();
                toastAndUpdateView();
            }
        });

        magentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMagenta();
                toastAndUpdateView();
            }
        });

        silverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asSilver();
                toastAndUpdateView();
            }
        });

        grayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGray();
                toastAndUpdateView();
            }
        });

        maroonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMaroon();
                toastAndUpdateView();
            }
        });

        oliveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asOlive();
                toastAndUpdateView();
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGreen();
                toastAndUpdateView();
            }
        });

        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asPurple();
                toastAndUpdateView();
            }
        });

        tealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asTeal();
                toastAndUpdateView();
            }
        });

        navyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asNavy();
                toastAndUpdateView();
            }
        });

    }

    private void toastAndUpdateView() {
        Toast.makeText(getApplicationContext(), " H:" + mModel.getHue() + degree_char + " S:" + mModel.getSaturation() + "%" + " V:" + mModel.getValueLightness() + "%", Toast.LENGTH_LONG).show();
        mHueTV.setText("Hue");
        mSatTV.setText("Saturation");
        mValueTV.setText("Value/Lightness");
        this.updateView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    // GET the Hue value from the model, and
    // SET the Hue <SeekBar> to the model's Hue value
    private void updateHueSB() {

        mHueSB.setProgress(mModel.getHue());

    }

    // GET the saturation value from the model, and
    // SET the saturation <SeekBar> to the model's saturation value
    private void updateSaturationSB() {
        mSaturationSB.setProgress(mModel.getSaturation());
    }

    // GET the value/Lightness value from the model, and
    // SET the value <SeekBar> to the model's value/Lightness value
    private void updateValueLightnessSB() {
        mValueLightnessSB.setProgress(mModel.getValueLightness());
    }

    // GET the color value from the model, and
    // SET the color-swatch's background color to the model's color
    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(mModel.getColor());
    }


    // Synchronize each View component with the current state of the Model.
    public void updateView() {
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueLightnessSB();
        this.updateColorSwatch();
    }


}

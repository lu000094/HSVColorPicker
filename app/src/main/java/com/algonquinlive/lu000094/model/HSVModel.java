package com.algonquinlive.lu000094.model;

import android.graphics.Color;

import java.util.Observable;

/**
 * The model holds the data.
 *
 * Model color.
 * Based on hue, saturation and value/lightness (HSV).
 *
 * @author Wenjuan Lu (lu000094)
 * @version 1.0
 */

public class HSVModel extends Observable {
    public static final Integer MAX_HUE = 359;
    public static final Integer MIN_HUE  = 0;

    public static final Integer MAX_SATURATION = 100;
    public static final Integer MIN_SATURATION  = 0;

    public static final Integer MAX_VALUE_LIGHTNESS = 100;
    public static final Integer MIN_VALUE_LIGHTNESS = 0;

    private Integer hue;
    private Integer saturation;
    private Integer valueLightness;

    /**
     * No-argument Class constructor.
     */
    public HSVModel( ){
        this( MIN_HUE, MIN_SATURATION, MIN_VALUE_LIGHTNESS );
    }

    /**
     * Class constructor specifying HSV.
     * @param hue   value
     * @param saturation value
     * @param valueLightness  value
     */
    public HSVModel( Integer hue, Integer saturation, Integer valueLightness) {
        super();

        this.hue = hue;
        this.saturation = saturation;
        this.valueLightness = valueLightness;
    }

    /*
        Instance methods.
     */

    public void asBlack() {
        this.setHSV(0,0,0);
    }

    public void asRed() {
        this.setHSV(0,100,100);
    }

    public void asLime() {
        this.setHSV(120,100,100);
    }

    public void asBlue() {
        this.setHSV(240,100,100);
    }

    public void asYellow() {
        this.setHSV(60,100,100);
    }

    public void asCyan() {
        this.setHSV(180,100,100);
    }

    public void asMagenta() {
        this.setHSV(300,100,100);
    }

    public void asSilver() {
        this.setHSV(0,0,75);
    }

    public void asGray() {
        this.setHSV(0,0,50);
    }

    public void asMaroon() {
        this.setHSV(0,100,50);
    }

    public void asOlive() {
        this.setHSV(60,100,50);
    }

    public void asGreen() {
        this.setHSV(120,100,50);
    }

    public void asPurple() {
        this.setHSV(300,100,50);
    }

    public void asTeal() {
        this.setHSV(180,100,50);
    }

    public void asNavy() {
        this.setHSV(240,100,50);
    }


    public Integer getHue() {
        return hue;
    }

    public void setHue(Integer hue) {
        this.hue = hue;

        // the model's state has changed!
        this.updateObservers();
    }

    public Integer getSaturation() {
        return saturation;
    }

    public void setSaturation(Integer saturation) {
        this.saturation = saturation;

        // the model's state has changed!
        this.updateObservers();
    }

    public Integer getValueLightness() {
        return valueLightness;
    }

    public void setValueLightness(Integer valueLightness) {
        this.valueLightness = valueLightness;

        // the model's state has changed!
        this.updateObservers();
    }

    public int getColor() {
        float[] hsv = new float[3];
        hsv[0] =  hue;
        hsv[1] = (float) saturation/100;
        hsv[2] = (float) valueLightness/100;
        return Color.HSVToColor(hsv);
    }



    public void setHSV(Integer hue, Integer saturation, Integer valueLightness ) {
        this.hue = hue;
        this.saturation = saturation;
        this.valueLightness = valueLightness;

        // the model's state has changed!
        this.updateObservers();
    }

    /*
        String Representation
     */
    @Override
    public String toString() {
        return "HSV [hue=" + hue + " sat=" + saturation + " value=" + valueLightness + "]";
    }

    /**
     * The model's state has changed!
     *
     * Notify all registered observers that this model has changed
     * state, and the registered observers should change too.
     */
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

    public static void main( String[] args ) {
        HSVModel model = new HSVModel( 127, 127, 127);

        System.out.println( model );
    }


}

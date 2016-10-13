package com.algonquinlive.lu000094.model;

import android.graphics.Color;

import java.util.Observable;

/**
 * The model holds the data.
 *
 * Model color.
 * Based on red, green, blud and alpha (transparency).
 *
 * RGB: integer values in the domain range of 0 to 255 (inclusive).
 * Alpha: integer value in the domain range of 0 to 255 (inclusive).
 *
 * @author Wenjuan Lu (lu000094)
 * @version 1.0
 */

public class RGBAModel extends Observable {
    public static final Integer MAX_ALPHA = 255;
    public static final Integer MAX_RGB = 255;
    public static final Integer MIN_ALPHA  = 0;
    public static final Integer MIN_RGB  = 0;

    private Integer alpha;
    private Integer red;
    private Integer green;
    private Integer blue;

    /**
     * No-argument Class constructor.
     */
    public RGBAModel( ){
        this( MAX_RGB, MAX_RGB, MAX_RGB, MAX_ALPHA );
    }

    /**
     * Class constructor specifying RGB and alpha values.
     * @param red   value
     * @param green value
     * @param blue  value
     * @param alpha value
     */
    public RGBAModel( Integer red, Integer green, Integer blue, Integer alpha ) {
        super();

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /*
        Instance methods.
     */
    public void asBlack() {
        this.setRGB( MIN_RGB, MIN_RGB, MIN_RGB );
    }

    public void asBlue() {
        this.setRGB( MIN_RGB, MIN_RGB, MAX_RGB );
    }

    public void asCyan() {
        this.setRGB( MIN_RGB, MAX_RGB, MAX_RGB );
    }

    public void asGreen() {
        this.setRGB( MIN_RGB, MAX_RGB, MIN_RGB );
    }

    public void asMagenta() {
        this.setRGB( MAX_RGB, MIN_RGB, MAX_RGB );
    }

    public void asRed() {
        this.setRGB( MAX_RGB, MIN_RGB, MIN_RGB );
    }

    public void asWhite() {
        this.setRGB( MAX_RGB, MAX_RGB, MAX_RGB );
    }

    public void asYellow() {
        this.setRGB( MAX_RGB, MAX_RGB, MIN_RGB );
    }

    public Integer getAlpha() {
        return alpha;
    }

    public void setAlpha(Integer alpha) {
        this.alpha = alpha;

        // the model's state has changed!
        this.updateObservers();
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;

        // the model's state has changed!
        this.updateObservers();
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;

        // the model's state has changed!
        this.updateObservers();
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;

        // the model's state has changed!
        this.updateObservers();
    }

    public int getColor() {
        return Color.argb( alpha, red, green, blue );
    }



    public void setRGB(Integer red, Integer green, Integer blue ) {
        this.red = red;
        this.green = green;
        this.blue = blue;

        // the model's state has changed!
        this.updateObservers();
    }

    /*
        String Representation
     */
    @Override
    public String toString() {
        return "RGB-A [r=" + red + " g=" + green + " b=" + blue + " alpha=" + alpha + "]";
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
        RGBAModel model = new RGBAModel( 127, 127, 127, 255 );

        System.out.println( model );
    }


}

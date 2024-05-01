package com.guardianvn.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MC extends BaseActor{
    public Animation normal;
    public Animation normalF;
    public Animation grin;
    public Animation grinF;

    public Animation normal2;
    public Animation normal2F;
    public Animation grin2;
    public Animation grin2F;
    MC(float x, float y, Stage s ){

        // Sharing the elements of baseActor to this constructor
        super(x,y,s);

        // Setting each parameter with a texture
        normal = loadTexture("Guardian/Normal.png");
        normalF = loadTexture("Guardian/Normal - Copy.png");
        grin = loadTexture("Guardian/Look - Copy.png");
        grinF = loadTexture("Guardian/Look.png");
        normal2 = loadTexture("Guardian/Normal2.png");
        normal2F = loadTexture("Guardian/Normal2 - Copy.png");
        grin2 = loadTexture("Guardian/Look2.png");
        grin2F = loadTexture("Guardian/Look2 - Copy.png");

    }

}

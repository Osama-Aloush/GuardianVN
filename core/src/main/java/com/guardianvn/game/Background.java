package com.guardianvn.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

// Made by Darren


/**
 * This class is designed to hold multiple different backgrounds for the visual novel.
 *
 *
 * */

public class Background extends BaseActor {



    /** The Animation declaration is a imported library from the libGDX framework that stores a list of objects
     * representing a animated sequence. Sort of like a Key frame. This is going to simplify the transition between each
     * each background for the visual novel.
     * */

    // Each parameter is used for a different background inside of the visual novel.
    public Animation cliff;
    public Animation badmood;
    public Animation forestDay;
    public Animation forestMorning;
    public Animation forestNight;
    public Animation forestSunset;
    public Animation cave;
    public Animation forest;
    public Animation theEnd;
    public Animation groundTex;
    public Animation RamaTex;
    public Animation black;
    public Animation battle;

    // This is a background constructor that the statement to inherit the constructor from the superclass BaseActor.
    public Background(float x, float y, Stage s){
        super(x,y,s);

        // These variables are being stored into a string list in the loadTexture method inside of the BaseActor
        // class that we are extending from.
        cliff = loadTexture("Background/cliffBG.jpg");
        badmood = loadTexture("Background/badmood.png");
        forestDay = loadTexture("Background/forestday.jpg");
        forestMorning = loadTexture("Background/forestmorning.jpg");
        forestNight = loadTexture("Background/forestnight.jpg");
        forestSunset = loadTexture("Background/forestsunset.jpg");
        cave = loadTexture("Background/cave.jpg");
        forest = loadTexture("Background/forest2.jpg");
        groundTex = loadTexture("Extra/GroundTexture.png");
        RamaTex = loadTexture("Extra/GroundRama.png");
        theEnd = loadTexture("Background/the-end.png");
        black = loadTexture("Extra/Black.png");
        battle = loadTexture("Background/Forest1.png");
        setSize(1280,720);
        centerAtPosition(640,360);

    }

}

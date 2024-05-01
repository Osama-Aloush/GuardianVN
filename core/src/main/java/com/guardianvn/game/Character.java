package com.guardianvn.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Character extends BaseActor{
    public Animation brotherNormal;
    public Animation brotherGrin;
    public Animation brotherNormal2;
    public Animation brotherGrin2;
    public Animation brotherAngry;
    public Animation brotherAngry2;
    public Animation banditOne1;
    public Animation banditOne2;
    public Animation banditTwo1;
    public Animation banditTwo2;
    public Animation Boss;
    public Animation Boss2;

    Character(float x, float y, Stage s ){

        // Sharing the elements of baseActor to this constructor
        super(x,y,s);

        // Setting each parameter with a texture
        brotherNormal = loadTexture("Brother/Normal.png");
        brotherGrin = loadTexture("Brother/Look.png");
        brotherNormal2 = loadTexture("Brother/Normal2.png");
        brotherGrin2 = loadTexture("Brother/Look2.png");
        brotherAngry = loadTexture("Brother/Angry.png");
        brotherAngry2 = loadTexture("Brother/Angry2.png");
        banditOne1 = loadTexture("Enemy/Bandit11.png");
        banditOne2 = loadTexture("Enemy/Bandit12.png");
        banditTwo1 = loadTexture("Enemy/Bandit21.png");
        banditTwo2 = loadTexture("Enemy/Bandit22.png");
        Boss = loadTexture("Enemy/Muscle.png");
        Boss2 = loadTexture("Enemy/Muscle2.png");


    }

}

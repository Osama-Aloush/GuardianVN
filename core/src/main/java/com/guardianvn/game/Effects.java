package com.guardianvn.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Effects extends BaseActor{

    private TextureAtlas fireFX;
    public Animation<TextureRegion> fireFXAni;

    private float stateTime;
    //public Sprite frame = new Sprite (player1Animation.getKeyFrame(stateTime, true));


    public Effects(float x, float y, Stage s) {
        super(x,y,s);

        //batch = new SpriteBatch();

        fireFX = new TextureAtlas(Gdx.files.internal("effects/FireFx/FireFx.atlas")); // Replace with your atlas file;
        fireFXAni = new Animation<>(1f / 24f, fireFX.getRegions()); // Adjust frame duration as needed;
        fireFXAni.setPlayMode(Animation.PlayMode.LOOP);


        stateTime = 0f; // Initialize stateTime here
        //TextureRegion currentFrame = player1Animation.getKeyFrame(stateTime, true);
        setSize(1280,720);
        centerAtPosition(640,360);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        stateTime += delta; // Update stateTime with delta time

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Enable blending for screen blending effect
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE);

        // Draw the animation
        batch.draw(fireFXAni.getKeyFrame(stateTime, true), getX(), getY(), getOriginX(), getOriginY(),
            getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

        // Reset the blend function to default

        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }


}

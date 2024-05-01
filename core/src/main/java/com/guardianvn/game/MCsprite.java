package com.guardianvn.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MCsprite extends BaseActor{
    private TextureAtlas mcIdle;
    private Animation<TextureRegion> idleAni;
    public Sprite idle;

    private TextureAtlas mcPunch;
    private Animation<TextureRegion> punchAni;
    public Sprite punch;


    private float stateTime;
    MCsprite(float x, float y, Stage s ){

        // Sharing the elements of baseActor to this constructor
        super(x,y,s);

        // Setting each parameter with a texture
        mcIdle = new TextureAtlas(Gdx.files.internal("kroy/kroy_idle.atlas")); // Replace with your atlas file;
        idleAni = new Animation<>(1f / 24f, mcIdle.getRegions());
        idleAni.setPlayMode(Animation.PlayMode.NORMAL);
        idle = new Sprite(idleAni.getKeyFrame(stateTime,false));

        mcPunch = new TextureAtlas(Gdx.files.internal("kroy/kroy_idle.atlas")); // Replace with your atlas file;
        punchAni = new Animation<>(1f / 24f, mcPunch.getRegions());
        punchAni.setPlayMode(Animation.PlayMode.NORMAL);

        punch = new Sprite(punchAni.getKeyFrame(stateTime,false));


    }

}

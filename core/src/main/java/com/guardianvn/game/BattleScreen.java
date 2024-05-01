package com.guardianvn.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class BattleScreen extends BaseScreen{
    protected Stage mainStage;
    private Background background;
    private MCsprite mc;
    private float stateTime;
    @Override
    public void initialize() {
        background = new Background(0,0, mainStage); // Sets a new background first
        background.setAnimation(background.battle);
        background.setSize(1280, 720);
        background.setOrigin(640, 360);
        background.setVisible(true);

        mc = new MCsprite(0, 0, mainStage);
        mc.setSprite(mc.idle);
        mc.scaleBy(1.5f);
        mc.setPosition(960,360);
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

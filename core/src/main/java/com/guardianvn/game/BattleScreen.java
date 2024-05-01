package com.guardianvn.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class BattleScreen extends BaseScreen{
    protected Stage mainStage;
    private Scene scene;
    private Background background;
    private BaseActor base;
    private MCsprite mc;
    private DialogBox dialogBox;
    private Table buttonTable;
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

        dialogBox = new DialogBox(0,0, uiStage); // Sets the dialog box on top of rose

        dialogBox.setDialogSize(1000, 200);
        //dialogBox.setBackgroundColor( new Color(0, 0, 0, 1) );

        dialogBox.setVisible(false);
        dialogBox.addAction(new TypewriterAction(" "));

        base = new BaseActor(0,0,uiStage);
        base.loadTexture("button.png");
        base.setSize(32,32);
        base.setVisible(false);

        dialogBox.addActor(base); // uses the dialog box add actor parameter inside of the constructor to declare the button image.
        base.setPosition( dialogBox.getWidth() - base.getWidth(), 0 ); // sets the position of the button image

        buttonTable = new Table(); // creates a button table for the options when it comes down to the time of selecting a option in the store.
        buttonTable.setVisible(false);

        // Ui table adjust the columns and rows used in the row
        uiTable.add().expandY();
        uiTable.row();
        uiTable.add(buttonTable);
        uiTable.row();
        uiTable.add(dialogBox);
        uiStage.addActor(uiTable);

        mainStage.addActor(scene);

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

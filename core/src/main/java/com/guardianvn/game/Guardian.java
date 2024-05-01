package com.guardianvn.game;



/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Guardian extends BaseGame {


    @Override
    public void create () {
        super.create();
        setActiveScreen(new MenuScreen());
    }



}

package com.guardianvn.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Action;

/**
 *  This is directly from the book Java Game Development with LibGDX written by Lee Stemkoski
 */

public class SetAnimationAction extends Action{

    protected Animation animationToDisplay;
    public SetAnimationAction(Animation a)
    {
        animationToDisplay = a;
    }
    public boolean act(float dt)
    {
        BaseActor ba = (BaseActor)target;
        ba.setAnimation( animationToDisplay );
        return true;
    }

}

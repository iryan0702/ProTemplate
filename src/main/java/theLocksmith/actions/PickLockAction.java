package theLocksmith.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theLocksmith.LocksmithMod;

public class PickLockAction extends AbstractGameAction {
    private AbstractGameAction followUpAction;
    private int targetLock;

    public PickLockAction(int targetLock){
        this(targetLock, null);
    }
    public PickLockAction(int targetLock, AbstractGameAction followUpAction) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
        this.source = AbstractDungeon.player;
        this.targetLock = targetLock;
        this.followUpAction = followUpAction;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            isDone = true;
            if(LocksmithMod.lockManager.pickLock(targetLock)){
                if(followUpAction != null){
                    addToTop(followUpAction);
                }
            }
        }

        this.isDone = true;
    }

}
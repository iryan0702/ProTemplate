package theLocksmith.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import theLocksmith.LocksmithMod;
import theLocksmith.powers.LambdaLockPower;

public class PickLockAction extends AbstractGameAction {
    private AbstractGameAction followUpAction;
    private int targetLock;

    public PickLockAction(){
        this(-1, null);
    }
    public PickLockAction(int targetLock){
        this(targetLock, null);
    }
    public PickLockAction(int targetLock, AbstractGameAction followUpAction) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.actionType = ActionType.WAIT;
        this.source = AbstractDungeon.player;

        if(targetLock == -1){
            int rand = AbstractDungeon.cardRandomRng.random(2,5);
            if(rand == 4) rand = 7;
            this.targetLock = rand;
        }else{
            this.targetLock = targetLock;
        }
        this.followUpAction = followUpAction;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            isDone = true;
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(Settings.WIDTH/2.0f, Settings.HEIGHT/2.0f, AttackEffect.SHIELD));
            if(LocksmithMod.lockManager.pickLock(targetLock)){
                if(followUpAction != null){
                    addToTop(followUpAction);
                }
                for(AbstractPower power: AbstractDungeon.player.powers){
                    if(power instanceof LambdaLockPower){
                        ((LambdaLockPower)power).activateLock(targetLock);
                    }
                }
            }
        }

        this.isDone = true;
    }

}
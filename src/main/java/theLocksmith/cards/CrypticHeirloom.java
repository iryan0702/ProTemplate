package theLocksmith.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theLocksmith.LocksmithMod;
import theLocksmith.TheLocksmith;
import theLocksmith.actions.PickLockAction;
import theLocksmith.util.LockManager;
import theLocksmith.util.LockTargeting;

import static com.megacrit.cardcrawl.cards.AbstractCard.CardTarget.SELF;
import static theLocksmith.LocksmithMod.makeID;

public class CrypticHeirloom extends AbstractEasyCard {
    public final static String ID = makeID("CrypticHeirloom");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public CrypticHeirloom() {
        super(ID, 0, CardType.SKILL, CardRarity.BASIC, SELF);
        this.selfRetain = true;
        this.isInnate = true;
    }

    @Override
    public void update() {
        super.update();

        if(AbstractDungeon.player.hoveredCard == this){
            int target = 0;

            if(InputHelper.mY < Settings.HEIGHT/2){
                if(InputHelper.mX < Settings.WIDTH/4){
                    target = 2;
                }else if(InputHelper.mX < Settings.WIDTH/4*2){
                    target = 3;
                }else if(InputHelper.mX < Settings.WIDTH/4*3){
                    target = 5;
                }else{
                    target = 7;
                }
            }

            if (target == 0)
                return;
            if(this.baseMagicNumber != target){
                this.baseSecondMagic = this.baseMagicNumber;
                this.baseMagicNumber = target;
            }
        }
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        int a = LocksmithMod.lockManager.getLock(this.baseMagicNumber);
        int b = LocksmithMod.lockManager.getLock(this.baseSecondMagic);
        LocksmithMod.lockManager.setLock(this.baseMagicNumber, b);
        LocksmithMod.lockManager.setLock(this.baseSecondMagic, a);
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}
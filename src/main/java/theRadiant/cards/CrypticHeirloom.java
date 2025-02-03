package theRadiant.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theRadiant.RadiantMod;
import theRadiant.util.LockAndToolTargeting;

import static theRadiant.RadiantMod.makeID;

public class CrypticHeirloom extends AbstractEasyCard {
    public final static String ID = makeID("CrypticHeirloom");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public CrypticHeirloom() {
        super(ID, 0, CardType.SKILL, CardRarity.BASIC, LockAndToolTargeting.LOCK_AND_TOOL_TARGET);
        this.selfRetain = true;
        this.isInnate = true;
    }

    @Override
    public void update() {
        super.update();

        if(AbstractDungeon.player != null && AbstractDungeon.player.hoveredCard == this){
            int target = 0;

            if(InputHelper.mY > Settings.HEIGHT/2){
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
        int target = LockAndToolTargeting.getTarget(this);

        if (target == 0)
            target = 999;

        if (target == 999){
            addToBot(new DrawCardAction(p, 1));
        }else{
            int a = RadiantMod.lockManager.getLock(this.baseMagicNumber);
            int b = RadiantMod.lockManager.getLock(this.baseSecondMagic);
            RadiantMod.lockManager.setLock(this.baseMagicNumber, b);
            RadiantMod.lockManager.setLock(this.baseSecondMagic, a);
        }
    }

    @Override
    public void upp() {

    }
}
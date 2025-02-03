package theRadiant.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import theRadiant.actions.PickLockAction;
import theRadiant.powers.LambdaLockPower;

import static theRadiant.RadiantMod.makeID;
import static theRadiant.util.Wiz.applyToSelf;

public class BruteForce extends AbstractEasyCard {
    public final static String ID = makeID("BruteForce");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public BruteForce() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 8;
    }

    @Override
    public void triggerWhenDrawn() {
        addToTop(new PickLockAction());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaLockPower(makeID("LockVigorPower"), cardStrings.EXTENDED_DESCRIPTION[0], AbstractPower.PowerType.BUFF, false, p, magicNumber) {
            @Override
            public void activateLock(int lockValue) {
                if(lockValue == 3){
                    this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, this));
                    this.addToBot(new ApplyPowerAction(this.owner, this.owner, new VigorPower(this.owner, this.amount), this.amount));
                }
            }

            @Override
            public void updateDescription() {
                description = cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2];
            }
        });
    }

    @Override
    public void upp() {
        upgradeMagicNumber(3);
    }
}
package theLocksmith.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theLocksmith.actions.PickLockAction;

import static theLocksmith.LocksmithMod.makeID;

public class Defend7 extends AbstractEasyCard {
    public final static String ID = makeID("Defend7");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Defend7() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        addToBot(new PickLockAction(7));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}
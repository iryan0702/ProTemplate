package theRadiant.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theRadiant.actions.PickLockAction;

import static theRadiant.RadiantMod.makeID;

public class Defend5 extends AbstractEasyCard {
    public final static String ID = makeID("Defend5");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Defend5() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 5;
        tags.add(CardTags.STARTER_DEFEND);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        addToBot(new PickLockAction(5));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
    }
}
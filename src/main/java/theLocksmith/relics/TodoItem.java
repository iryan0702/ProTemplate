package theLocksmith.relics;

import theLocksmith.TheLocksmith;

import static theLocksmith.LocksmithMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, TheLocksmith.Enums.LOCKSMITH_COLOR);
    }
}

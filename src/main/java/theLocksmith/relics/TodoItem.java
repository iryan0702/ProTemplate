package theLocksmith.relics;

import theLocksmith.CharacterFile;

import static theLocksmith.ModFile.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, CharacterFile.Enums.LOCKSMITH_COLOR);
    }
}

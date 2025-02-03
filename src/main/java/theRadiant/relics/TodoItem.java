package theRadiant.relics;

import theRadiant.TheRadiant;

import static theRadiant.RadiantMod.makeID;

public class TodoItem extends AbstractEasyRelic {
    public static final String ID = makeID("TodoItem");

    public TodoItem() {
        super(ID, RelicTier.STARTER, LandingSound.FLAT, TheRadiant.Enums.LOCKSMITH_COLOR);
    }
}

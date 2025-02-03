package theRadiant.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.mod.stslib.cards.targeting.TargetingHandler;
import com.evacipated.cardcrawl.mod.stslib.patches.CustomTargeting;
import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.input.InputHelper;

public class LockTargeting extends TargetingHandler<Integer> {
    @SpireEnum
    public static AbstractCard.CardTarget LOCK_TARGET;

    public static Integer getTarget(AbstractCard card) {
        return CustomTargeting.getCardTarget(card);
    }

    private int hovered = 0;

    @Override
    public boolean hasTarget() {
        return hovered != 0;
    }

    @Override
    public void updateHovered() {
        hovered = 0;
        if(InputHelper.mX < Settings.WIDTH/4){
            hovered = 2;
        }else if(InputHelper.mX < Settings.WIDTH/4*2){
            hovered = 3;
        }else if(InputHelper.mX < Settings.WIDTH/4*3){
            hovered = 5;
        }else{
            hovered = 7;
        }
    }

    @Override
    public Integer getHovered() {
        return hovered;
    }

    @Override
    public void clearHovered() {
        hovered = 0;
    }

    @Override
    public void renderReticle(SpriteBatch sb) {
//        if (hovered != null) {
//            hovered.renderReticle(sb);
//        }
    }

    //Keyboard support is entirely optional, but this is an example based on how the basegame implements it
    @Override
    public void setDefaultTarget() {
        hovered = 2;
    }
    @Override
    public int getDefaultTargetX() {
        return (int) AbstractDungeon.player.hb.cX;
    }
    @Override
    public int getDefaultTargetY() {
        return (int) AbstractDungeon.player.hb.cY;
    }

    @Override
    public void updateKeyboardTarget() {
//        int directionIndex = 0;
//
//        if (InputActionSet.left.isJustPressed() || CInputActionSet.left.isJustPressed() || CInputActionSet.altLeft.isJustPressed()) {
//            --directionIndex;
//        }
//
//        if (InputActionSet.right.isJustPressed() || CInputActionSet.right.isJustPressed() || CInputActionSet.altRight.isJustPressed()) {
//            ++directionIndex;
//        }
//
//        if (directionIndex != 0) {
//            ArrayList<AbstractMonster> sortedMonsters = new ArrayList<>(AbstractDungeon.getCurrRoom().monsters.monsters);
//
//            sortedMonsters.removeIf(AbstractCreature::isDeadOrEscaped);
//
//            AbstractCreature newTarget = null;
//
//            if (sortedMonsters.isEmpty()) {
//                if (hovered == null) {
//                    newTarget = AbstractDungeon.player;
//                }
//                else {
//                    return;
//                }
//            }
//            else {
//                sortedMonsters.sort(AbstractMonster.sortByHitbox);
//
//                if (this.hovered == null) {
//                    if (directionIndex == 1) {
//                        newTarget = sortedMonsters.get(0);
//                    } else {
//                        newTarget = AbstractDungeon.player;
//                    }
//                } else {
//                    if (hovered == AbstractDungeon.player) {
//                        if (directionIndex == 1) {
//                            newTarget = sortedMonsters.get(0);
//                        } else {
//                            newTarget = sortedMonsters.get(sortedMonsters.size() - 1);
//                        }
//                    }
//                    else if (hovered instanceof AbstractMonster) {
//                        int currentTargetIndex = sortedMonsters.indexOf(hovered);
//                        int newTargetIndex = currentTargetIndex + directionIndex;
//
//                        if (newTargetIndex == -1) {
//                            newTarget = AbstractDungeon.player;
//                        }
//                        else {
//                            newTargetIndex = (newTargetIndex + sortedMonsters.size()) % sortedMonsters.size();
//                            newTarget = sortedMonsters.get(newTargetIndex);
//                        }
//                    }
//                }
//            }
//
//
//            if (newTarget != null) {
//                Hitbox target = newTarget.hb;
//                Gdx.input.setCursorPosition((int)target.cX, Settings.HEIGHT - (int)target.cY); //cursor y position is inverted for some reason :)
//                hovered = newTarget;
//                ReflectionHacks.setPrivate(AbstractDungeon.player, AbstractPlayer.class, "isUsingClickDragControl", true);
//                AbstractDungeon.player.isDraggingCard = true;
//            }
//
//            if (hovered instanceof AbstractMonster && hovered.halfDead) {
//                hovered = null;
//            }
//        }
    }
}
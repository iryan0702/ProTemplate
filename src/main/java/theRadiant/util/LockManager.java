package theRadiant.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.TipHelper;

public class LockManager {
    public int lock2 = 1;
    public int lock3 = 1;
    public int lock5 = 5;
    public int lock7 = 1;

    public boolean pickLock(int targetLock){
        boolean success = isLockActive(targetLock);
        switch (targetLock) {
            case 2:
                lock2 = (lock2%210+1);
                break;
            case 3:
                lock3 = (lock3%210+1);
                break;
            case 5:
                lock5 = (lock5%210+1);
                break;
            case 7:
                lock7 = (lock7%210+1);
                break;
            default:
                break;
        }
        return success;
    }

    public boolean isLockActive(int targetLock){
        switch (targetLock) {
            case 2:
                return lock2 % 2 == 0;
            case 3:
                return lock3 % 3 == 0;
            case 5:
                return lock5 % 5 == 0;
            case 7:
                return lock7 % 7 == 0;
            default:
                break;
        }
        return false;
    }

    public int getLock(int targetLock){
        switch (targetLock) {
            case 2:
                return lock2;
            case 3:
                return lock3;
            case 5:
                return lock5;
            case 7:
                return lock7;
            default:
                break;
        }
        return -1;
    }

    public void setLock(int targetLock, int value){
        switch (targetLock) {
            case 2:
                lock2 = value;
                break;
            case 3:
                lock3 = value;
                break;
            case 5:
                lock5 = value;
                break;
            case 7:
                lock7 = value;
                break;
            default:
                break;
        }
    }

    public void render(SpriteBatch sb){
        StringBuilder renderStr = new StringBuilder();

        renderStr.append("Lock 2: ");
        renderStr.append(lock2 % 2 == 0 ? "active" : "inactive");
        renderStr.append(" NL Lock 3: ");
        renderStr.append(lock3 % 3 == 0 ? "active" : "inactive");
        renderStr.append(" NL Lock 5: ");
        renderStr.append(lock5 % 5 == 0 ? "active" : "inactive");
        renderStr.append(" NL Lock 7: ");
        renderStr.append(lock7 % 7 == 0 ? "active" : "inactive");

        int displayX = Settings.WIDTH/8;
        int displayY = Settings.HEIGHT/4*3;
        TipHelper.renderGenericTip(displayX,displayY,"Locks",renderStr.toString());

        TipHelper.render(sb);
    }
}

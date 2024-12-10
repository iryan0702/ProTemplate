package theLocksmith.util;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.TipHelper;

import java.util.logging.Logger;

public class LockManager {
    public int lock2 = 1;
    public int lock3 = 1;
    public int lock5 = 5;
    public int lock7 = 1;

    public boolean pickLock(int targetLock){
        boolean success = false;
        switch (targetLock) {
            case 2:
                if(lock2 % 2 == 0){
                    success = true;
                    lock2 = (lock2%210+1);
                }
                break;
            case 3:
                if(lock3 % 3 == 0){
                    success = true;
                    lock3 = (lock3%210+1);
                }
                break;
            case 5:
                if(lock5 % 5 == 0){
                    success = true;
                    lock5 = (lock5%210+1);
                }
                break;
            case 7:
                if(lock7 % 7 == 0){
                    success = true;
                    lock7 = (lock7%210+1);
                }
                break;
            default:
                break;
        }
        return success;
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

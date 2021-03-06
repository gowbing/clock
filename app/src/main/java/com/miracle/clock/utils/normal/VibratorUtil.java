package com.miracle.clock.utils.normal;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

/**
 * 手机震动工具类
 *
 * @author Administrator
 */
public class VibratorUtil {

    /**
     * final Activity activity  ：调用该方法的Activity实例
     * long milliseconds ：震动的时长，单位是毫秒
     * long[] pattern  ：自定义震动模式 。数组中数字的含义依次是[静止时长，震动时长，静止时长，震动时长。。。]时长的单位是毫秒
     * boolean isRepeat ： 是否反复震动，如果是true，反复震动，如果是false，只震动一次
     */
    static Vibrator vib;

    public static void Vibrate(final Application application, long milliseconds) {
        if (vib == null) {
            vib = (Vibrator) application.getSystemService(Service.VIBRATOR_SERVICE);
        }
        vib.vibrate(milliseconds);
    }

    public static void Vibrate(final Application application, long[] pattern, boolean isRepeat) {
        if (vib == null) {
            vib = (Vibrator) application.getSystemService(Service.VIBRATOR_SERVICE);
        }
        vib.vibrate(pattern, isRepeat ? 0 : -1);
    }

    public static void cancel() {
        if (vib != null) {
            vib.cancel();
        }
    }

}

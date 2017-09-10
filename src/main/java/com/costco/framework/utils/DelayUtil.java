package com.costco.framework.utils;

/**
 * Created by PaxoStudent on 3/31/2017.
 */
public class DelayUtil {

  protected int timeMilli;

  public static void delayFor(int timeMilli) {

        try {
            Thread.sleep(timeMilli);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}

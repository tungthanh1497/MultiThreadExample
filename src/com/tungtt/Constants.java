package com.tungtt;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tungtt a.k.a TungTT
 * On Mon, 16 Nov 2020 - 15:01
 */
public class Constants {
    @Retention(RetentionPolicy.SOURCE)
    public @interface DELAY_TIME {
        long SEND_REQUEST = 600;
        long UPLOAD = 700;
        long GET_DATA = 800;
        long INSERT_DATA_LOCAL = 900;
        long DO_ACTION = 1000;
    }

}

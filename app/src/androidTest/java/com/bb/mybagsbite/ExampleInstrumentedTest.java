package com.bb.mybagsbite;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.bb.mybagsbite.Fragments.RegisterFragment;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.bb.mybagsbite", appContext.getPackageName());
    }

    @Test
    public void testDB() throws Exception{
        Context appContext = InstrumentationRegistry.getTargetContext();

        String[] dbs = appContext.databaseList();

        assertEquals(dbs[0].toString(),"MyBagsBite.db");
    }

    @Test
    public void testRegister() throws Exception{
        Context appContext = InstrumentationRegistry.getTargetContext();

    }
}

package com.peertopark.java.dates;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class BirthdayUtilsTest {

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isAdultTest() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        Date adultDate = dateFormat.parse("18-01-1988");
        Date now = Dates.now();
        assertTrue(BirthdayUtils.isAdultInSpain(now, adultDate));
    }
}

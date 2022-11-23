package ru.croc.task10;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

import java.util.concurrent.ExecutionException;

public class TestingPasswords {

    private static final String INITIAL_HASH = "40682260CC011947FC2D0B1A927138C5";
    
    @Test
    private void positiveMainCaseTest() {
        int threadsNumber = 4;

        String password = null;
        try {
            password = Solution.calculatePassword(threadsNumber, INITIAL_HASH);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        String hash = Hash.hashPassword(password);

        assertEquals(hash, INITIAL_HASH);
    }
    @Test
    private void negativeMainCaseTest() {
        int threadsNumber = 4;

        String someStrForTest = "smsmbls";
        String someStringHash = Hash.hashPassword(someStrForTest);
        String password = null;
        try {
            password = Solution.calculatePassword(threadsNumber, someStringHash);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        String recalculatedHash = Hash.hashPassword(password);

        assertNotSame(recalculatedHash, INITIAL_HASH);
    }
}
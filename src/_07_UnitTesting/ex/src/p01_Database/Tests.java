package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Tests {

    private static final Integer[] INITIAL_VALUES = {0, 1, 2};


    public Tests() throws OperationNotSupportedException {
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testConstructorWithValidParameters() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, OperationNotSupportedException {

        Integer[] expectedResult = new Integer[16];
        System.arraycopy(INITIAL_VALUES, 0, expectedResult, 0, INITIAL_VALUES.length);

        Class dbClass = Database.class;
        Field structure = dbClass.getDeclaredField("structure");
        structure.setAccessible(true);
        Database db = new Database(INITIAL_VALUES);
        Integer[] actualResult = (Integer[]) structure.get(db);
        boolean areEqual = true;

        if (expectedResult.length == actualResult.length) {
            for (int i = 0; i < expectedResult.length; i++) {
                if (expectedResult[i] != null && actualResult[i] != null)
                if ((int) expectedResult[i] != actualResult[i]) {
                    areEqual = false;
                    break;
                }
            }
        } else {
            areEqual = false;
        }

        Assert.assertTrue("Structures are not equal.", areEqual);
    }
}

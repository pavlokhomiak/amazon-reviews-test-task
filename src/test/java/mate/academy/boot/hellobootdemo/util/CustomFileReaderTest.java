package mate.academy.boot.hellobootdemo.util;

import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomFileReaderTest {
    private static final String EXIST_FILE_PATH = "./src/test/resources/test.csv";
    private static final String NOT_EXIST_FILE_PATH = "./src/test/resources/not.csv";
    private static final String[] EXPECTED_HEADER = new String[] {"Id","ProductId","UserId","ProfileName",
            "HelpfulnessNumerator","HelpfulnessDenominator","Score","Time","Summary","Text"};
    private static final String[] EXPECTED_FIRST_ROW = new String[] {"38","B001EO5QW8","A3MGP2E1ZZ6GRB","Zardoz \"focuspuller\""
            ,"1","1","5","1238457600","it's oatmeal","What else do you need to know? Oatmeal, instant (make it with a "
            + "half cup of low-fat milk and add raisins\tnuke for 90 seconds). More expensive than something. It's "
            + "still just oatmeal. Mmm, convenient!"};
    private static final String[] EXPECTED_SECOND_ROW = new String[] {"39","B001EO5QW8","A2GHZ2UTV2B0CD","JERRY REITH","0","0","4","1350777600",
            "GOOD WAY TO START THE DAY....","I WAS COFFEE , HE CAME WITH ( A PACKET OF McCANNS INSTANT IRISH OATMEAL "
            + ".) HE SUGGESTED THAT I TRY IT FOR MY OWN USE ,IN MY STASH . A CHANCE TO SAY NO , APPLE AND CINN ."};

    private static ReadFileService readFileService;

    @BeforeClass
    public static void injectReadFileServiceImplementation() {
        readFileService = new CustomFileReader();
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowException() {
        readFileService.readFile(NOT_EXIST_FILE_PATH);
    }

    @Test
    public void shouldExecute_OK() {
        List<String[]> actual = readFileService.readFile(EXIST_FILE_PATH);

        Assert.assertArrayEquals(EXPECTED_HEADER, actual.get(0));
        Assert.assertArrayEquals(EXPECTED_FIRST_ROW, actual.get(1));
        Assert.assertArrayEquals(EXPECTED_SECOND_ROW, actual.get(2));
    }
}

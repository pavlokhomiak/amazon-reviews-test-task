package mate.academy.boot.hellobootdemo.util;

import java.util.List;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CsvFileParserTest {
    private static final String EXPECTED_HEADER = "Id,ProductId,UserId,ProfileName,"
            + "HelpfulnessNumerator,HelpfulnessDenominator,Score,Time,Summary,Text";
    private static final String EXPECTED_FIRST_ROW = "38,B001EO5QW8,A3MGP2E1ZZ6GRB,\"Zardoz \"\"focuspuller\"\"\""
            + ",1,1,5,1238457600,it's oatmeal,\"What else do you need to know? Oatmeal, instant (make it with a "
            + "half cup of low-fat milk and add raisins\tnuke for 90 seconds). More expensive than something. It's "
            + "still just oatmeal. Mmm, convenient!\"";
    private static final String EXPECTED_SECOND_ROW = "39,B001EO5QW8,A2GHZ2UTV2B0CD,JERRY REITH,0,0,4,1350777600,"
            + "GOOD WAY TO START THE DAY....,\"I WAS COFFEE , HE CAME WITH ( A PACKET OF McCANNS INSTANT IRISH OATMEAL "
            + ".) HE SUGGESTED THAT I TRY IT FOR MY OWN USE ,IN MY STASH . A CHANCE TO SAY NO , APPLE AND CINN .\"";
    private static final List<String> INPUT_DATA = List.of(EXPECTED_HEADER, EXPECTED_FIRST_ROW, EXPECTED_SECOND_ROW);
    private static final List<ReviewDto> EXPECTED_LIST = List.of(
            new ReviewDto(Long.parseLong("38"), "B001EO5QW8", "A3MGP2E1ZZ6GRB", "\"Zardoz "
                    + "\"\"focuspuller\"\"\"", Integer.parseInt("1"), Integer.parseInt("1"), Integer.parseInt("5"),
                    Long.parseLong("1238457600"), "it's oatmeal", "\"What else do you need to know? "
                    + "Oatmeal, instant (make it with a half cup of low-fat milk and add raisins\tnuke"
                    + " for 90 seconds). More expensive than something. It's still just oatmeal. Mmm, convenient!\""),
            new ReviewDto(Long.parseLong("39"), "B001EO5QW8", "A2GHZ2UTV2B0CD", "JERRY REITH",
                    Integer.parseInt("0"), Integer.parseInt("0"), Integer.parseInt("4"), Long.parseLong("1350777600"),
                    "GOOD WAY TO START THE DAY....", "\"I WAS COFFEE , HE CAME WITH ( A PACKET OF McCANNS INSTANT "
                    + "IRISH OATMEAL .) HE SUGGESTED THAT I TRY IT FOR MY OWN USE ,IN MY STASH . A CHANCE TO SAY NO , APPLE "
                    + "AND CINN .\""));

    private static CsvFileParser csvFileParser;

    @BeforeClass
    public static void injectCsvFileParser() {
        csvFileParser = new CsvFileParser();
    }

    @Test
    public void shouldExecute_OK() {
        List<ReviewDto> actualList = csvFileParser.parseDataToDto(INPUT_DATA);

        Assert.assertEquals(EXPECTED_LIST, actualList);
    }
}
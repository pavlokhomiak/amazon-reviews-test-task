package mate.academy.boot.hellobootdemo.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mate.academy.boot.hellobootdemo.models.ReviewDto;
import org.springframework.stereotype.Component;

@Component
public class CsvFileParser {
    private static final int REVIEW_ID_INDEX = 0;
    private static final int PRODUCT_ID_INDEX = 1;
    private static final int USER_ID_INDEX = 2;
    private static final int PROFILE_NAME_INDEX = 3;
    private static final int HELPFULNESS_NUMERATOR_INDEX = 4;
    private static final int HELPFULNESS_DENOMINATOR_INDEX = 5;
    private static final int SCORE_INDEX = 6;
    private static final int TIME_INDEX = 7;
    private static final int SUMMARY_INDEX = 8;
    private static final int TEXT_INDEX = 9;

    public List<ReviewDto> parseDataToDto(List<String[]> dataList) {
        return IntStream.range(1, dataList.size())
                .mapToObj(i -> parseToDto(dataList.get(i)))
                .collect(Collectors.toList());
    }

    private ReviewDto parseToDto(String[] data) {
        ReviewDto dto = new ReviewDto();
        dto.setReviewId(Long.parseLong(data[REVIEW_ID_INDEX]));
        dto.setProductId(data[PRODUCT_ID_INDEX]);
        dto.setUserId(data[USER_ID_INDEX]);
        dto.setProfileName(data[PROFILE_NAME_INDEX]);
        dto.setHelpfulnessNumerator(Integer.parseInt(data[HELPFULNESS_NUMERATOR_INDEX]));
        dto.setHelpfulnessDenominator(Integer.parseInt(data[HELPFULNESS_DENOMINATOR_INDEX]));
        dto.setScore(Integer.parseInt(data[SCORE_INDEX]));
        dto.setTime(Long.parseLong(data[TIME_INDEX]));
        dto.setSummary(data[SUMMARY_INDEX]);
        dto.setText(data[TEXT_INDEX]);
        return dto;
    }
}

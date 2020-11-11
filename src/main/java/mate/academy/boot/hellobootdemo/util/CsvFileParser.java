package mate.academy.boot.hellobootdemo.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mate.academy.boot.hellobootdemo.models.ReviewDto;

public class CsvFileParser {

    public List<ReviewDto> parseDataToDto(List<String> dataList) {
        return IntStream.range(1, dataList.size())
                .mapToObj(i -> parseToDto(dataList.get(i)))
                .collect(Collectors.toList());
    }

    private ReviewDto parseToDto(String data) {
        String[] dataArray = data.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i < dataArray.length; i++) {
            sb.append(dataArray[i] + ",");
        }
        ReviewDto dto = new ReviewDto();
        dto.setReviewId(Long.parseLong(dataArray[0]));
        dto.setProductId(dataArray[1]);
        dto.setUserId(dataArray[2]);
        dto.setProfileName(dataArray[3]);
        dto.setHelpfulnessNumerator(Integer.parseInt(dataArray[4]));
        dto.setHelpfulnessDenominator(Integer.parseInt(dataArray[5]));
        dto.setScore(Integer.parseInt(dataArray[6]));
        dto.setTime(Long.parseLong(dataArray[7]));
        dto.setSummary(dataArray[8]);
        dto.setText(sb.substring(0, sb.length() - 1));
        return dto;
    }
}

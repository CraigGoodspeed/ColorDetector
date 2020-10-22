package Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ColorDetector {

    List<Color> data;
    ObjectMapper mapper;

    public ColorDetector(String configurationFile) throws IOException {
        mapper = new ObjectMapper();
        data = Arrays.asList(mapper.readValue(new File(configurationFile), Objects.Color[].class));
    }

    public List<Color> getData() {
        return data;
    }

    public Optional<Color> findColor(String hex) {
        return this.findColor(Long.parseLong(hex,16));
    }

    public Optional<Color> findColor(long value) {
        return getData().stream().filter(
                (color) -> color.existsInRange(value)
        ).findFirst();
    }
}

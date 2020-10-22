import Objects.Color;
import Objects.ColorDetector;
import Objects.ColorValue;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Start {
    public static void main(String[] args){
        try {
            Class<?> cls = Class.forName("Start");
            ColorDetector detector = new ColorDetector(cls.getClassLoader().getResource("colorconfig.json").getFile());
            ObjectMapper mapper = new ObjectMapper();
            List<ColorValue> data = Arrays.asList(mapper.readValue(new File(cls.getClassLoader().getResource("testData.json").getFile()), ColorValue[].class));
            data.forEach(
                    colorValue -> {
                        Optional<Color> returned = detector.findColor(colorValue.getValue());
                        if(returned.isPresent()){
                            System.out.println(
                                    String.format(
                                            "found the color %s for value %s so the associated year is %s",
                                            returned.get().getName(),
                                            colorValue.getValue(),
                                            returned.get().getYear()
                                    ));
                        }
                    }
            );
        }
        catch(ClassNotFoundException err){
            System.out.println(err);
        }
        catch(IOException io) {
            System.out.println(io);
        }
    }
}

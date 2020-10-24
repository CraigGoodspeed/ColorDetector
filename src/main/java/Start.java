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
            String val = "FF183810";

            List<Color> returned =  detector.findColor(val.substring(2));

            if(returned.isEmpty())
                System.out.println(String.format("could not find a value for detected color %s with the integer value %s", val, Integer.parseInt(val,16)));
            else
                System.out.println(returned.get(0).getYear());

            /*ObjectMapper mapper = new ObjectMapper();
            List<ColorValue> data = Arrays.asList(mapper.readValue(new File(cls.getClassLoader().getResource("testData.json").getFile()), ColorValue[].class));
            data.forEach(
                    colorValue -> {
                        List<Color> returned = detector.findColor(colorValue.getLongValue());
                        if(!returned.isEmpty()){
                            returned.forEach(
                                c -> {
                                    System.out.println(
                                            String.format(
                                                    "found the color %s for value %s so the associated year is %s",
                                                    c.getName(),
                                                    colorValue.getLongValue(),
                                                    c.getYear()
                                            ));

                                }
                            );
                        }
                        else {
                            System.out.println(
                                String.format(
                                    "could not find color, %s with hex code. Consider re-evaluating the color configuration data.",
                                    colorValue.getLongValue(),
                                    colorValue.getHexValue()
                                )
                            );
                        }
                    }
            );*/
        }
        catch(ClassNotFoundException err){
            System.out.println(err);
        }
        catch(IOException io) {
            System.out.println(io);
        }
    }
}

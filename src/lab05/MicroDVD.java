package lab05;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MicroDVD {
    static void delay(String input, String output, int delay, int fps) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
        String line;
        String pattern = "{1111}{1111}";

        String regex = "^\\{(\\d+)}\\{(\\d+)}(.*)";
        Pattern r = Pattern.compile(regex);


        while ((line = bufferedReader.readLine()) != null) {
            for (int i = 0; i < 12; i++) {
                if (line.charAt(i) == pattern.charAt(i)) {
                    continue;
                }

//                if (Character.getNumericValue(pattern.charAt(i)) == 1) {
//                    if (!Character.isDigit(line.charAt(i))) {
//                        throw new WrongFormatOfFrames();
//                    }
//                } else {
//                    throw new WrongFormatOfFrames();
//                }
            }

            Matcher result = r.matcher(line);

            int timeStart,timeEnd;

            if (result.find( )) {
                timeStart = Integer.valueOf(result.group(1));
                timeEnd = Integer.valueOf(result.group(2));
            }else {
                throw new NoMatchedFrames(line);
            }

            if(timeStart>timeEnd) throw new WrongOrderOfFrames(line);

            timeStart += delay * fps;
            timeEnd += delay * fps;

            if (timeStart < 0 || timeEnd < 0) throw new Exception();

            line = "{" + Integer.toString(timeStart) + "}{" + Integer.toString(timeEnd) + "}" + result.group(3);

            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class WrongOrderOfFrames extends Exception{
    public WrongOrderOfFrames(String message) {
        super(message);
    }
}

class NoMatchedFrames extends Exception{
    public NoMatchedFrames(String message) {
        super(message);
    }
}
class WrongFormatOfFrames extends Exception{
    public WrongFormatOfFrames(String message) {
        super(message);
    }
}


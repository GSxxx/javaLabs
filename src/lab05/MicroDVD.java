package lab05;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MicroDVD {
    static void delay(String input, String output, int delay, int fps) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
        String line;

        String regex = "^\\{(\\d+)}\\{(\\d+)}(.*)";
        Pattern r = Pattern.compile(regex);


        while ((line = bufferedReader.readLine()) != null) {

            Matcher result = r.matcher(line);

            int timeStart, timeEnd;

            if (result.find()) {
                timeStart = Integer.valueOf(result.group(1));
                timeEnd = Integer.valueOf(result.group(2));
            } else {
                throw new NoMatchedFrames(line);
            }

            if (timeStart > timeEnd) throw new WrongOrderOfFrames(line);

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

class WrongOrderOfFrames extends Exception {
    WrongOrderOfFrames(String message) {
        super(message);
        System.out.println("Wrong order of frames!");
    }
}

class NoMatchedFrames extends Exception {
    NoMatchedFrames(String message) {
        super(message);
        System.out.println("Wrong format of frames!");
    }
}



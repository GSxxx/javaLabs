package lab05.segregator;

import io.indico.Indico;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;


public class Segregator {
    public static void main(String[] args) {

        Indico indico = null;
        try {
            indico = new Indico("aa5afbecdefafdc602aa73a55d8a9a00");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        NumberFormat formatter = new DecimalFormat("#0.0000");

        String[] input = Segregator.returnPathsOfFilesThatMatchToPattern(args[0], ".*\\.jpg$");


        Map<String, Object> params = new HashMap<>();
        params.put("top_n", 1);
//        params.put("threshold",0.009);

        try {
            BatchIndicoResult multiple = indico.imageRecognition.predict(input, params);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }


        for (String anExample : input) {
            System.out.print(anExample + ": ");
            IndicoResult single = null;
            try {
                single = indico.imageRecognition.predict(
                        anExample, params
                );
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IndicoException e) {
                e.printStackTrace();
            }
            Map<String, Double> result = null;
            try {
                result = single.getImageRecognition();
            } catch (IndicoException e) {
                e.printStackTrace();
            }
//            result.forEach((key, value) -> System.out.println(key + " *** " + formatter.format(value)));

            String newPath = "src/lab05/segregator/foto2/" + result.entrySet().iterator().next().getKey();
            File new_folder = new File(newPath);
            new_folder.mkdirs();


            String pattern = ".*(/[^/]+)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(anExample);
            if (m.find()) {
                System.out.println("Found value: " + m.group(1));
            }
            try {
                FileUtils.copyFile(new File(anExample), new File(newPath + m.group(1)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


//        List<Map<String, Double>> results = multiple.getImageRecognition();
//        for (Map<String, Double> x : results) {
//
//            ValueComparator bvc = new ValueComparator(x);
//            Map<String, Double> sorted_map = new TreeMap<>(bvc);
//            sorted_map.putAll(x);
////            System.out.println(sorted_map);
//            sorted_map.forEach((key, value) -> System.out.println(key + " *** " + formatter.format(value)));
//
//            System.out.println();
//        }


    }

    private static String[] returnPathsOfFilesThatMatchToPattern(String pathname, String pattern) {
        String[] temp = new File(pathname).list();
        String[] output = new String[temp.length];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i].matches(pattern)) {
                output[i] = pathname + "/" + temp[i];
            }
        }

        return output;
    }


}

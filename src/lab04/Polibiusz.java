package lab04;

public class Polibiusz implements Algorithm {
    @Override
    public String crypt(String input) {
        final char pattern[][] = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'k'},
                {'l', 'm', 'n', 'o', 'p'},
                {'q', 'r', 's', 't', 'u'},
                {'v', 'w', 'x', 'y', 'z'},
        };
        StringBuilder output = new StringBuilder();
        for (int z = 0; z < input.length(); z++) {

            if (input.charAt(z) == 'j') {
                output.append("14 ");
                continue;
            }
//            if(input.charAt(z)==' '){
//                output.append("");
//                continue;
//            }

            for (int i = 0; i < 5; i++) {
                for (int d = 0; d < 5; d++) {
                    if (input.charAt(z) == pattern[i][d]) {
                        output.append(String.format("%d%d ", i + 1, d + 1));
                    }
                }
            }
        }
        return output.toString();
    }

    @Override
    public String decrypt(String input) {
        final char pattern[][] = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'k'},
                {'l', 'm', 'n', 'o', 'p'},
                {'q', 'r', 's', 't', 'u'},
                {'v', 'w', 'x', 'y', 'z'},
        };
        StringBuilder output = new StringBuilder();
        for (int z = 0; z < input.length() - 2; z++) {

            if (input.charAt(z) != ' ' && input.charAt(z + 1) != ' ') {
                output.append(String.format("%c ", pattern[Character.getNumericValue(input.charAt(z))-1][Character.getNumericValue(input.charAt(z+1))-1]));
            }
        }


        return output.toString();
    }
}

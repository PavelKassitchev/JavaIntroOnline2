package by.pavka.string.object;
/*
* Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.println(maxSpaces("     A nnn ny "));
    }

    public static int maxSpaces(String text) {
        int max = text.length();
        while(!text.contains(spaceString(max))) {
            max--;
        }

        return max;
    }

    //This method returns a string of length spaces
    private static String spaceString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}

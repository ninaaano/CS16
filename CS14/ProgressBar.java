package CS14;

public class ProgressBar {

    static void print(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 1; i <= count; i++) {
            stringBuilder.append("■");
        }
        for (int i = count + 1; i <= 100; i++) {
            stringBuilder.append(" ");
        }
        stringBuilder.append("] ")
                .append(count)
                .append("%")
                .append("\r");
        System.out.print(stringBuilder);
    }
}

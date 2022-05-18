import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String input = scanner.next();
        scanner.close();

        new SevenSegment(input, size);
    }
}

class SevenSegment {
    private String s;
    private int size;

    public SevenSegment(String s, int size) {
        this.s = s;
        this.size = size;
        print();
    }

    private String getPortraitSegment(int size, int type) {
        StringBuilder builder = new StringBuilder();
        
        if (type == 0)
            for (int i = 0; i < size + 2; i++)
                builder.append(" ");
        else {
            builder.append(' ');
            for (int i = 0; i < size; i++) 
                builder.append("-");
            builder.append(" ");
        }
        return builder.toString();
    }

    private String getLandscapeSegment(int size, int type) {
        StringBuilder builder = new StringBuilder();
        
        if (type == 0) {
            builder.append("|");
            for (int i = 0; i < size + 1; i++)
                builder.append(" ");
        } else if (type == 1) {
            for (int i = 0; i < size + 1; i++) 
                builder.append(" ");
            builder.append("|");
        } else {
            builder.append("|");
            for (int i = 0; i < size; i++)
                builder.append(" ");
            builder.append("|");
        }
        return builder.toString();
    }

    private void print() {
        StringBuilder[] output = new StringBuilder[2 * size + 3];

        for (int i = 0; i < output.length; i++) 
            output[i] = new StringBuilder();            

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            switch(currentChar) {
                case '0':
                    output[0].append(getPortraitSegment(size, 1));
                    output[size + 1].append(getPortraitSegment(size, 0));
                    output[2 * (size + 1)].append(getPortraitSegment(size, 1));
                    break;
                case '1':
                    output[0].append(getPortraitSegment(size, 0));
                    output[size + 1].append(getPortraitSegment(size, 0));
                    output[2 * (size + 1)].append(getPortraitSegment(size, 0));
                    break;
                case '4':
                    output[0].append(getPortraitSegment(size, 0));
                    output[size + 1].append(getPortraitSegment(size, 1));
                    output[2 * (size + 1)].append(getPortraitSegment(size, 0));
                    break;
                case '7':
                    output[0].append(getPortraitSegment(size, 1));
                    output[size + 1].append(getPortraitSegment(size, 0));
                    output[2 * (size + 1)].append(getPortraitSegment(size, 0));
                    break;
                default:
                    output[0].append(getPortraitSegment(size, 1));
                    output[size + 1].append(getPortraitSegment(size, 1));
                    output[2 * (size + 1)].append(getPortraitSegment(size, 1));
                    break;
            }

            switch(currentChar) {
                case '0':
                case '8':
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 2));
                        output[2 + size + j].append(getLandscapeSegment(size, 2));
                    }
                    break;
                case '1':
                case '3':
                case '7':
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 1));
                        output[2 + size + j].append(getLandscapeSegment(size, 1));
                    }
                    break;
                case '2':
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 1));
                        output[2 + size + j].append(getLandscapeSegment(size, 0));
                    }
                    break;
                case '4':
                case '9':
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 2));
                        output[2 + size + j].append(getLandscapeSegment(size, 1));
                    }
                    break;
                case '5':
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 0));
                        output[2 + size + j].append(getLandscapeSegment(size, 1));
                    }
                    break;
                default:
                    for (int j = 0; j < size; j++) {
                        output[1 + j].append(getLandscapeSegment(size, 0));
                        output[2 + size + j].append(getLandscapeSegment(size, 2));
                    }
                    break;
            }

            if (i < s.length() - 1) {
                for (int j = 0; j < output.length; j++) 
                    output[j].append(" ");
            }
        }
        
        for (int i = 0; i < output.length; i++) {
            if (i < output.length - 1)
                System.out.println(output[i].toString());
            else
                System.out.print(output[i].toString());
        }
    }
}

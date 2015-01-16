abstract class Reverse {
    public static final String INPUT = "Lorem ipsum dolor sit amet, "          +
        "consectetur adipiscing elit. Proin libero mi, euismod efficitur "     +
        "laoreet at, elementum et lectus. Curabitur finibus velit vel "        +
        "egestas vestibulum. Aliquam porta blandit ipsum, quis imperdiet "     +
        "purus ornare eget. Nullam in lectus nec massa finibus posuere. In "   +
        "molestie ut ipsum tempor interdum. Nulla accumsan risus ut diam "     +
        "ornare ultricies. Maecenas eu sollicitudin augue. Proin eu nulla "    +
        "lobortis, sodales dolor et, bibendum nisl. Integer vitae est ac "     +
        "purus condimentum mollis. Quisque bibendum nunc ac lorem ultricies, " +
        "et sagittis nunc fermentum. Nullam tincidunt egestas neque, ac "      +
        "luctus massa bibendum nec. Nunc tincidunt porta mattis. Fusce eget "  +
        "sem at lacus dapibus ullamcorper. Vestibulum maximus ligula at "      +
        "justo volutpat semper. Donec tincidunt quis arcu et interdum. "       +
        "Integer a mauris ut mi fringilla pharetra.";
    public abstract String reverse(String str);

    public static void main(String argv[]) {
        if (argv.length < 2) {
             System.err.println("Usage: java Reverse <times> <method:[1-3]>");
             System.exit(1);
        }
        int times  = Integer.parseInt(argv[0]);
        int type   = Integer.parseInt(argv[1]);
        String out = new String();

        Reverse rev = null;
        switch (type) {
            case 1: rev = new Reverse1(); break;
            case 2: rev = new Reverse2(); break;
            case 3: rev = new Reverse3(); break;
            default:
                System.err.println("No such method");
                System.exit(1);
        }

        long start = System.nanoTime();
        for (int i = 0; i < times; i++) {
            rev.reverse(INPUT);
        }
        System.out.println((System.nanoTime() - start) / 1e6);
    }
}

// Array manipulation
class Reverse1 extends Reverse {
    public String reverse(String str) {
        char[] in = str.toCharArray();
        int len = str.length();
        char[] out = new char[len];
        for (int i = 0; i < len; i++) {
            out[i] = in[len - i - 1];
        }
        return new String(out);
    }
}

// String concatenation
class Reverse2 extends Reverse {
    public String reverse(String str) {
        char[] in = str.toCharArray();
        String out = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            out += in[i];
        }
        return out;
    }
}

// Using the StringBuilder class
class Reverse3 extends Reverse {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

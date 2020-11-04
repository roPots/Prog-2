package helloworld;

public class Hello {
    public static void main(String[] args) {
        int times = Integer.parseInt(args[1]);
        for (int i=0;i<times;i++) System.out.println("Hello " + args[0] + "!");
    }
}


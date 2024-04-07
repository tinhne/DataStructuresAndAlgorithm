package MyStack;

public class BaseConversion {
    void BaseConversionRecursion(int value, int base) {
        if (value > 0) {
            int du = value % base;
            BaseConversionRecursion(value / base, base);
            if (du < 10)
                System.out.print(du);
            else
                System.out.printf("%c",du+ 55);
        }
    }
    void BaseConversionStack(int value, int base) {
        LinkedListBaseStack<Character> stack = new LinkedListBaseStack<>();
        int remainder;
        while (value > 0) {
            remainder = value % base;
            char digit = (char) (remainder < 10 ? remainder + '0' : remainder - 10 + 'A');
            stack.push(digit);
            value /= base;
        }
        String string = "";
        while (!stack.isEmpty()) {
            string += stack.pop();
        }
        System.out.println("\n" + string);
    }

    public static void main(String[] args) {
        System.out.println("Le Van trung Tinh");
        BaseConversion baseConversion = new BaseConversion();
        baseConversion.BaseConversionRecursion(3022, 7);
        baseConversion.BaseConversionStack(3022, 7);
    }
}

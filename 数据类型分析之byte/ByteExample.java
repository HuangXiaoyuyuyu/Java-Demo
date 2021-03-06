package org.hxy.springboot;

public class ByteExample {
    public static void main(String[] args) {
        /**
         *下面程序段 n1 输出为 127，
         * n2 编译报错不兼容的类型（从 int 转换到 byte 可能会有损失）。
         *
         * 因为这里的 10 和 117 属于字面量，经过 javac 编译优化后变成了 byte n = 127，
         * 而 n 的类型是 byte，编译后等号右侧的 127 默认类型是 int，所以会造成数据类型不匹配，
         * 而这时候 javac 会判断 127 是否位于 byte 类型的取值范围
         * （byte 是 1 个字节，也就是 8 位，去掉最高位为符号位，其他可取值为 -128～127）之内，
         * 若在范围之内则会将 127 的类型转换为 byte
         * （将 int 的 127 的第 32 位符号位记录在 byte 的第 8 位，然后截掉其他无用高位），否则报错。
         */

        /*byte n1 = 10 + 117;
        byte n2 = 10 + 118;
        System.out.println(n1);         //127
        System.out.println(n2);         //报错
        */


        /**
         *对于 n2 表达式来说，等号右边不是常量，所以编译时无法确定其值是否位于 bye 的取值范围，所以会直接报错，
         * 如果把 n1 前面加 final 则 n2 就能正确输出 127 了
         *
         *对于 n3 表达式来说，能成功编译类似 n4，而输出为 -128 是因为 int 类型的 128 转换为 byte 时，
         * 由于 byte 只有 8 位，所以 int 的 128（0000 0000 0000 0000 0000 0000 1000 0000）被截取低 8 位变为（1000 0000），
         * 而对于 8 位的 byte 来说最高位 1 表示这是负数，其他七位为 0 表示数值，而计算机中数据都是通过补码存储的，
         * 对于正数的表示就是二进制原码（因为正数的反码和补码都是原码），
         * 对于负数的表示用补码（负数的反码为符号位外其他位取反，负数的补码为原码符号位外其他位取反后最低位加一），
         * 所以对于 byte 来说 1000 0000（128）表示一个负数的补码，
         * 其原码为 1000 0000 减 1，即 0111 1111，然后取反，即 1000 0000，所以为 -128。
         *
         * 对于 n4 表达式来说由于明确指定了类型强转，所以明确说明了要自己知道有可能会有损失，所以就能成功输出，
         * 由于 10 + 117 刚好在 byte 范围之内，所以输出 127 没问题。
         */

        byte n3 = 10;
    //    byte n4 = n3 + 117;
    //    System.out.println(n4);   //类型不兼容 从int转换到byte可能会有损失

        byte n5 = (byte) 128;
        System.out.println(n5);     //-128

        byte n6 = (byte) (n3 + 117);
        System.out.println(n6);     //127

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2;

/**
 *
 * @author User
 */
public class AlGamal {

    public void function(int p, int gen, int CB,  int k,int m) {
        long r, e, dB, m1;
        long demo;
        dB = FastPowFunc(gen, CB, p);
        System.out.println("dB=" + dB);
        r = FastPowFunc(gen, k, p);
        System.out.println("r=" + r);
        demo = (long) (m * Math.pow(dB, k));
        e = FastPowFunc(demo, 1, p);
        System.out.println("e=" + e);
        if (m < p && m < (p - 1) && k <= (p - 2)) {
            demo = (long) (12 * Math.pow(17, (p - 1 - CB)));
            m1 = FastPowFunc(demo, 1, p);
            System.out.println("m1=" + m1 + " : m=" + m);
            if (m1 == m) {
                System.out.println("Ключи совпадают");
            } else {
                System.out.println("Ключи не совпадают");
            }
        } else {
            System.out.println("Ошибка ввода");
        }
    }
    static long FastPowFunc(long Number, long Pow, long Mod) {
        long Result = 1;
        long Bit = Number % Mod;

        while (Pow > 0) {
            if ((Pow & 1) == 1) {
                Result *= Bit;
                Result %= Mod;
            }
            Bit *= Bit;
            Bit %= Mod;
            Pow >>= 1;
        }
        if (Pow < 0) {
            //System.out.println("зашел");
            long i = 1;

            long mod = 0;
            // System.out.println("("+i+"*"+Mod+"+1)/"+Number);
            for (;;) {
                //  System.out.println("("+i+"*"+Mod+"+1)/"+Number);
                Result = (i * Mod + 1) / Number;
                mod = (i * Mod + 1) % Number;
                i++;
                if (mod == 0 & Result > 0) {
                    //  System.out.println("Ответ="+Result);
                    break;

                }
            }
            //  System.out.println("ответ "+n);
        }
        //   System.out.println(Result);
        return Result;
    }
}

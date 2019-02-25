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
public class RSA {
    
    
     public void function(int p, int q,int e,int m) {
         long n,c;
         int m1;
         n=p*q;
        functionAiler(n);
        long d;
         int i=1;
       for (;;)
       {
      
       d=(i*functionAiler(n)+1)/e;
       
       if ((i*functionAiler(n)+1)%e==0)
           break;
       i++;
       }
      System.out.println("d="+d);
       c=FastPowFunc(m,e,n);
         System.out.println("c="+c);
         m1=(int) FastPowFunc(c,d,n);
         System.out.println("m1="+m);
         if (m==m1)
             System.out.println("Ключи  совпадают");
         else 
             System.out.println("Ключи не совпадают");
        
     }
     long result = 0;

    long functionAiler(long number) {
result =number;
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                while (number % i == 0) {
                    number /= i;
                }
                result -= result / i;
            }
        }
        if (number > 1) {
            result -= result / number;
        }
      //  System.out.println(result);
        return result;
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

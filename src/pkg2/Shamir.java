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
public class Shamir {

    public void function(int p, int CA, int CB,int m) {
        int A, B, K1, K2;
int x1,x2,x3,x4;
        int dB, dA;
        dA = FastPowFunc(CA, -1, (p - 1));
        System.out.println("dA="+dA);
        dB = FastPowFunc(CB, -1, (p - 1));
        System.out.println("dB="+dB);
        FastPowFunc((CA*dA),1,(p-1));
//        /&& FastPowFunc((CA*dA),1,p)==1&&FastPowFunc((CB*dB),1,p)==1
        if (dA < p && dB < p ) {
            x1=FastPowFunc(10,CA,p);
            System.out.println("x1="+x1);
            x2=FastPowFunc(x1,CB,p);
            System.out.println("x2="+x2);
            x3=FastPowFunc(x2,dA,p);
            System.out.println("x3="+x3);
            x4=FastPowFunc(x3,dB,p);
            System.out.println("Ответ="+x4);
           
        } else {
            System.out.println("Ошибка ввода");
        }
    }

    static int FastPowFunc(int Number, int Pow, int Mod) {
        int Result = 1;
        int Bit = Number % Mod;

        while (Pow > 0) {
            if ((Pow & 1) == 1) {
                Result *= Bit;
                Result %= Mod;
            }
            Bit *= Bit;
            Bit %= Mod;
            Pow >>= 1;
        }
          if (Pow <0)
        {
            //System.out.println("зашел");
            int i=1;
       
            int mod=0;
           // System.out.println("("+i+"*"+Mod+"+1)/"+Number);
           for (;;)
            {
              //  System.out.println("("+i+"*"+Mod+"+1)/"+Number);
            Result=(i*Mod+1)/Number;
            mod=(i*Mod+1)%Number;
            i++;
          if (mod==0&Result>0)
          {
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

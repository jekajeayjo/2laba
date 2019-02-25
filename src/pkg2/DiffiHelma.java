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
public class DiffiHelma {

    public void function(int p, int gen, int a, int b) {
        int A, B, K1, K2;
        boolean prove = (FastPowFunc(gen, p - 1, p) == 1 && gen < (p - 1)) ? true : false;
        
        if (prove == false) {
            System.out.println("Ошибка ввода");

        } else {
            A = FastPowFunc(gen, a, p);
            System.out.println("Скрытый ключ А " + A);
            B = FastPowFunc(gen, b, p);
            System.out.println("Скрытый ключ B " + B);
            K1 = FastPowFunc(B, a, p);
            K2 = FastPowFunc(A, b, p);
            System.out.println("Ключи отправленые от А:" + K2 + ",Ключи отправленые от B:" + K1);
            String answer = (K1 == K2) ? "КЛЮЧИ СОВПАДАЮТ" : "КЛЮЧИ НЕ СОВПАДАЮТ";
            System.out.println(answer);
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
        // System.out.println(Result);
        return Result;
    }
}

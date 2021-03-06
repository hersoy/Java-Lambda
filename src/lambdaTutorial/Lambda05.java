package lambdaTutorial;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println("TASK 01 amele topla--> "+toplaAmele(10));
        System.out.println("   ***   ");
        System.out.println("TASK 01 cincik topla--> "+toplaCincix(9));
        System.out.println("   ***   ");

        System.out.println("TASK 02 -->"+toplaCift(10));
        System.out.println("   ***   ");

        System.out.println("TASK 03 -->"+toplaIlkXCift (10));   // 2+4+6+8....20
        System.out.println("   ***   ");

        System.out.println("TASK 04 -->"+toplaIlkXTek(10));     // 1+3+5+7....19
        System.out.println("   ***   ");

        System.out.println("TASK 05 -->");
        IkininIlkXKuvvetPrint(7);
        System.out.println("\n   ***   ");

        System.out.println("TASK 06 -->");
        isteneSayiIlkXKuvvetPrint(3, 4);
        System.out.println("  \n ***   ");
        isteneSayiIlkXKuvvetPrint(4, 3);
        System.out.println("  \n ***   ");

        System.out.println("TASK 07 -->"+istenenSayiFactorial(5));
        System.out.println("   ***   ");

        System.out.println("TASK 08 -->"+xKuvveti (3, 4));
        System.out.println("   ***   ");

    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.

    //Structured(AMELE) Programming
    public static int toplaAmele(int x){
        int toplam=0;
    for (int i = 1; i <=x ; i++) {
        toplam+=i;

    }
        return toplam;
}

    //Functional(cincix Programming

    public static int toplaCincix(int x){
        return IntStream.
                range(1,x+1).   // 1'den x'e kadar(x dahil) int degerler akisa alindi
                sum();          // akistaki int degerler toplandi

    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).//1 den x'e kadar(x dahil) int degerler ak??sa al??nd??
                        filter(Lambda01::ciftBul).//ak??sdaki ??ift int degerler filtrelendi
                        sum();//ak??sdaki int degerler topland??
    }

        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
        public static int toplaIlkXCift ( int x) {
            return IntStream.
                    iterate(2, t -> t + 2).//2 den sonsuza  kadar elemanlar?? 2 art??rarak ak??sa al??r -->2,4,6,8,10...
                            limit(x).//ak??sdaki ilk x int degeri ak??sa al??r
                            sum();//ak??sdaki int degerler topland??

            // iterate(seed, repeat action) --> seed'den ba??layarak repeat action'a g??re  sonsuza kadar elemanlar?? ak??sa koyar
        }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2).//1 den sonsuza  kadar elemanlar?? 2 art??rarak ak??sa al??r -->1,3,5,7,9...
                        limit(x).//ak??sdaki ilk x int degeri ak??sa al??r
                        sum();//ak??sdaki int degerler topland??
        //iterate(seed, repeat action) --> seed'den ba??layarak repeat action'a g??re  sonsuza kadar elemanlar?? ak??sa k??yar
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void IkininIlkXKuvvetPrint(int x) {
        IntStream.
                iterate(2, t -> t * 2).//2 den sonsuza  kadar elemanlar?? 2 ile carparak ak??sa al??r -->2,4,8,16,32...
                limit(x).//ak??sdaki ilk x int degeri ak??sa al??r
                forEach(Lambda01::yazdir);//ak??sdaki int degerler topland??

        //iterate(seed, repeat action) --> seed'den ba??layarak repeat action'a g??re  sonsuza kadar elemanlar?? ak??sa k??yar
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi create ediniz.
    public static void isteneSayiIlkXKuvvetPrint(int isteneSayi, int x) {
        IntStream.
                iterate(isteneSayi, t -> t * isteneSayi).//2 den sonsuza  kadar elemanlar?? 2 ile carparak ak??sa al??r -->2,4,8,16,32...
                limit(x).//ak??sdaki ilk x int degeri ak??sa al??r
                forEach(Lambda01::yazdir);//ak??sdaki int degerler topland??

    }
        //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
        public static int istenenSayiFactorial(int x){
        return IntStream.rangeClosed(1,x).
                // reduce(Math::multiplyExact).
                reduce(1,(t,u)->t*u);

        }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi create ediniz.
    public static int xKuvveti (int istenenSayi, int x) {
        return IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                        limit(x).reduce(0, (t, u) -> u);
    }
}

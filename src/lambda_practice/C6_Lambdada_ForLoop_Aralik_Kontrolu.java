package lambda_practice;

import java.util.stream.IntStream;

public class C6_Lambdada_ForLoop_Aralik_Kontrolu {

    public static void main(String[] args) {
        System.out.println("\n *** s-1 *** ");
        birDen30KadarSayilariYaz(30);
        System.out.println("\n *** s-2 *** ");
        birDen30DahilSayilariYaz(30);
        System.out.println("\n *** s-3 *** ");
        istenenIkiDgrArsSayTopla(1,5);
        System.out.println("\n *** s-4 *** ");
        otzIleKrkArsnSaylOrtBul(30,40);
        System.out.println("\n *** s-5 *** ");
        sekizeBolnKacSayiVar(325,468);
        System.out.println("\n *** s-6 *** ");
        sekizeBolnSayilar(325,468);
        System.out.println("\n *** s-7 *** ");
        sekizeBolnSayilarinToplami(325,468);
        System.out.println("\n *** s-8 *** ");
        besIleOnBesArsTekSyCarp(7,15);
        System.out.println("\n *** s-9 *** ");
        pozTekSayIlkOnElYazdir(10);
        System.out.println("\n *** s-10 *** ");
        yediKatTekOlnIlkOnTerm(21);
        System.out.println("\n *** s-11 *** ");
        yediKatIlk20TermTopla(21);
    }

    // S1:1 den 30 kadar olan sayilari (30 dahil degil) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //range(int startInclusive, int endExclusive)
        public static void birDen30KadarSayilariYaz(int sayi){
        IntStream.range(1,sayi).forEach(t-> System.out.print(t+" "));
        }

    //S2 1 den 30 kadar olan sayilari (30 dahil ) 1 2 3 .... seklinde siralayalim (for loopsuz)
    //rangeClosed(int startInclusive, int endInclusive)
    public static void birDen30DahilSayilariYaz(int sayi){
        IntStream.
                rangeClosed(1,sayi).
                forEach(t-> System.out.print(t+" "));
    }

    //S3 Istenen iki deger(dahil) arasindaki sayilari toplayalim
    public static void istenenIkiDgrArsSayTopla(int sayi1, int sayi2){
        System.out.println(IntStream.
                rangeClosed(sayi1, sayi2).
                sum());
    }

    //S4: 30 ile 40 arasindaki sayilarin (dahil) ortalamasini bulalim
    public static void otzIleKrkArsnSaylOrtBul(int sayi1, int sayi2){
        System.out.println(IntStream.
                rangeClosed(sayi1, sayi2).
                average());
    }

    //S5: 325 ile 468 arasinda 8 e bolunen kac sayi vardir?
    public static void sekizeBolnKacSayiVar(int sayi1, int sayi2){
        System.out.println(IntStream.
                range(sayi1, sayi2).
                filter(t -> t % 8 == 0).
                count());
    }

    //S6: 325 ile 468 arasinda 8 bolunen sayilari yazdiralim
    public static void sekizeBolnSayilar(int sayi1, int sayi2){
        IntStream.
                range(sayi1, sayi2).
                filter(t -> t % 8 == 0).forEach(t-> System.out.print(t+" "));
    }

    // S7:325 ile 468 arasinda 8 bolunen sayilarin toplamini bulalim
    public static void sekizeBolnSayilarinToplami(int sayi1, int sayi2) {
        System.out.println(IntStream.
                range(sayi1, sayi2).
                filter(t -> t % 8 == 0).sum());
    }

    // S8: 7 ile 15 arasindaki tek sayilarin carpimini bulalim
    public static void besIleOnBesArsTekSyCarp(int sayi1, int sayi2) {
        System.out.println(IntStream.
                range(sayi1, sayi2).
                filter(t -> t % 2 != 0).
                reduce(Math::multiplyExact));
    }
    //S9: pozitif tek sayilarin ilk 10 elemanini yazdiralim
    public static void pozTekSayIlkOnElYazdir(int sayi) {
    IntStream.
            iterate(1,t->t+2).
            limit(10).
            forEach(t-> System.out.print(t+" "));
    }
    //S10: 21 den baslayan 7 nin katlarinin tek olanlari ilk 10 terimini yaziralim
    public static void yediKatTekOlnIlkOnTerm(int sayi) {
        IntStream.
                iterate(21, t->t+7).
                filter(Methods::tekMi).
                limit(10).
                forEach(t-> System.out.print(t+" "));
    }

    //S11: 21 den baslayan 7 nin katlarinin ilk 20 terimini toplayalim
    public static void yediKatIlk20TermTopla(int sayi) {
        System.out.println(IntStream.
                iterate(21, t -> t + 7).
                limit(20).sum());

    }
}
//iterate bize sayilari istedigimiz sekilde yineletmeyi saglar yani buradaki ornekte 7ser7ser artmayi saglar
//iterate icin bir baslangic degeri girilmeli ve artisin nasil olacagi belirtilmeli nerede biteceginide
// limit() ile belilioruz
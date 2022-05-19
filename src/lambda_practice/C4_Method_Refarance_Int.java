package lambda_practice;

// lambda da method kullanimi :
//ilk olarak class adi yazilir
//sonra  :: noktalar konur
//son olarak method secilir
//String class i sayesinde length gibi touppercase gibi methodlari kullanabiliriz
//Math classi sayesinde de sum vb methodlar kullanabiliriz

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C4_Method_Refarance_Int {
    public static void main(String[] args) {
        List<Integer> intL= Arrays.asList(-2,-8,-5,0,2,5,6,7,15,6,8);

        System.out.println("\n *** s-1 *** ");
        tekSayYazdir(intL);
        System.out.println("\n *** s-2 *** ");
        tekSayCarpYazdir(intL);
        System.out.println("\n *** s-3 *** ");
        negSayKarTopYazdir(intL);
        System.out.println("\n *** s-4 *** ");
        pozSayKarMaxYazdir(intL);


    }
    // S1: tekleri aralarinda bir bosluk birakarak yazdiralim
    public static void tekSayYazdir(List<Integer> intL){
        intL.stream().filter(t -> t % 2 != 0).forEach(t-> System.out.print(t+" "));
    }

    // S2: ciftlerin carpimini bulalim
    public static void tekSayCarpYazdir(List<Integer> intL){
        intL.stream().filter(t -> t % 2 == 0).map(t->t*t).forEach(t-> System.out.print(t+" "));
    }

    // S3: negatiflerin kare toplamlarini  bulalim
    public static void negSayKarTopYazdir(List<Integer> intL) {
        System.out.println(intL.stream().filter(t -> t < 0).mapToInt(t -> t * t).sum());

    }
    // S4: poziflerin kuplerinden max yazdiralim
    public static void pozSayKarMaxYazdir(List<Integer> intL) {
        System.out.println(intL.stream().filter(t -> t > 0).mapToInt(t -> t * t*t).max());

    }


}

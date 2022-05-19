package lambdaTutorial;

import java.util.*;
import java.util.stream.Stream;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("kucleme", "adana", "trilece", "havucDilim", "buryan",
                "yaglama", "kokorec", "arabAsi", "guvec", "cacik", "waffle"));
        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        karateriTersSirala(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        crakterSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n   ***   ");
        xIleBitenElKontrol(menu);
        System.out.println("\n   ***   ");
        charSayisiBykElPrint(menu);
        System.out.println("\n   ***   ");
        sonHarfeGoreSiralaYazdir(menu);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfBykTekrrsz(List<String> menu) {
        menu.
        stream().
                // map(t->t.toUpperCase()).    // Lamb. Ex. elemanlar buyuk harfe cevrildi
                        map(String::toUpperCase).   // Meth. Ref. elemanlar buyuk harfe cevrildi
                sorted().       // dogal sira yapildi
                distinct().     // benzersiz, tekrarsiz hale getirdi
                forEach(t -> System.out.print(t + " "));

        // distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void karateriTersSirala(List<String> menu) {

        menu.
             stream().//akısa alındı
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi
    }

    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiBkSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));

    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    public static void sonHarfeGoreSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : listin elemanlarin karakterlerinin cift sayili karelerini hesaplayan,ve karelerini
    // tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void charKaresiCiftElSirala(List<String> menu) {
        menu.
                stream().
                map(t -> t.length() * t.length()).
                filter(Lambda01::ciftBul).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(t -> System.out.print(t + " "));
    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void crakterSayisi7denAzKontrol(List<String> menu) {
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanlari 7 ve daha az harften olusuyor");
        } else
            System.out.println("list elemanlari 7 harften buyuk");

        //cincix code
        System.out.println("cincix code");
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" :
                                                 "list elemanları 7 harften  buyuk");
    }
    // anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    // allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    // noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> menu) {
        System.out.println(menu.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yok" :
                "agam wenemen ne menem bi sey");
    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> menu) {
        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "x ile biten elman var" :
                                                 "x ile biten elman yok");
           }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiBykElPrint(List<String> menü) {
        Stream<String> sonIsim = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                //  findFirst();    //ilk eleman alındı
                        limit(3);   //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
    /*
    sonIsim.toArray()--> limit() meth return dan dolayı  stream type olan sonIsim toArray()
    method ile array type convert edildi
    */

        System.out.println(Arrays.toString(sonIsim.toArray()));//arraya cevrilen sonIsim stream print edildi

        // limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.
        // akıs cıktısını bir veriable assaign edilebilir

        Optional<String> enBykKrEl = menü.
                stream().
                sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()).
                findFirst();//ilk eleman alındı
    }

    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void sonHarfeGoreSiralaYazdir(List<String> menu) {
        menu.
                stream().   // akisa alindi
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).    // son harfe gore siralandi
                skip(1).    // ilk eleman atlandi
                forEach(t -> System.out.println(t + " ")); // yazdirildi

        // skip(1) => atlama demek. Akışın ilk n elemanını attıktan sonra bu akışın kalan elemanlarından
        // oluşan bir akış return eder.
        // Bu akış n'den daha az öğe içeriyorsa, boş bir akış döndürülür. Bu, durum bilgisi olan bir ara işlemdir.
        // skip(list.size()-1) => List'in uzunluğunun 1 eksiğini yazarsak son elemanı yazdırırız.

    }

}

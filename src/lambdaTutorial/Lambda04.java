package lambdaTutorial;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {

    /*
    TASK :
    fields --> Universite (String)
               bolum (String)
               ogrcSayisi (int)
               notOrt (int)
               olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
     */
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 119, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 123, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOtr74BykUnv(unv));
        System.out.println("2-*****");
        System.out.println(ogrSay110AzUnv(unv));
        System.out.println("3-*****");
        System.out.println(matematikVarMi(unv));
        System.out.println("4-*****");
        OgrenciSayGoreSirala(unv);
        System.out.println("\n5-*****");
        System.out.println(notOrtGoreSirala(unv));
        System.out.println("\n6-*****");
        ogrcSayEnAz2Univ(unv);
        System.out.println("\n7-*****");
        notOrt63DenBykOgrSayTop(unv);
        System.out.println("\n7-*****");
        System.out.println(notOrt63DenBykOgrSayTop1(unv));
        System.out.println("\n8-*****");
        ogrSay130DanBykUnvNtOrt(unv);
        System.out.println("\n9-*****");
        matBolumSay(unv);
        System.out.println("\n10-*****");
        System.out.println(ogrcSayisi571BykMaxNotort(unv));
        System.out.println("\n11-*****");
        ogrSay150DenAzUnvEnKcNtOrt(unv);
    }

    //task 01--> notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOtr74BykUnv(List<Universite>unv){

        return unv.
                stream().
                allMatch(t-> t.getNotOrt()>74);
    }

    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrSay110AzUnv(List<Universite>unv){

        return unv.
                stream().
                allMatch(t->t.getOgrSayisi()>110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.

    public static boolean matematikVarMi(List<Universite>unv){

        return unv.
                stream().
                anyMatch(t->t.getBolum().
                        equalsIgnoreCase("matematik"));
    }

    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static void OgrenciSayGoreSirala(List<Universite>unv){

       System.out.println(unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).
                        reversed()).
                collect(Collectors.toList()));

         // collect()->akısdaki elamanları istenen sarta gore toplar
        // Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }
    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    public static List<Universite> notOrtGoreSirala(List<Universite>unv){
       return unv.
                stream().
                sorted(Comparator.comparing(Universite::getNotOrt).reversed()).
                limit(3).collect(Collectors.toList());

    }

    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static void ogrcSayEnAz2Univ(List<Universite>unv){
        System.out.println(unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi)).
                limit(2).skip(1).collect(Collectors.toList()));

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static void notOrt63DenBykOgrSayTop(List<Universite>unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                map(t -> t.getOgrSayisi()).
                //reduce(Integer::sum));            // bu yontem toplar
                //reduce(Math::addExact));         // bu yontemle de da toplanir
                reduce(0,(t,u)-> t+u));     // bu yontemle de da toplanir
    }
    // 2.YOL...
    public static int notOrt63DenBykOgrSayTop1(List<Universite>unv) {
         return unv.
                stream().
                filter(t -> t.getNotOrt() > 63).
                mapToInt(t -> t.getOgrSayisi()).sum();

    // mapToInt() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki() degere göre Int data type update eder
    // mapToInt() --> bu method akısdaki elemanların data type'nı
    // parameterisindeki() degere göre Int data type update eder

    }

    //task 08--> Ogrenci sayisi 333'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.
    public static void ogrSay130DanBykUnvNtOrt(List<Universite>unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrSayisi() > 333).
                mapToDouble(Universite::getNotOrt).
                average());      // akistaki elemanlarin ortalamasi alindi

        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static void matBolumSay(List<Universite>unv){
        System.out.println(unv.
                stream().
                filter(t -> t.getBolum().
                        equalsIgnoreCase("matematik")).count());
    }

    //task 10-->Ogrenci sayilari 571'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrcSayisi571BykMaxNotort(List<Universite> unv) {
        return unv.
                stream().//akıs
                        filter(t->t.getOgrSayisi()>571).    // unv obj akısı fittrelendi
                        mapToInt(t->t.getNotOrt()).     // akısdaki unv obj notOrt akısı olarak update edildi
                        max();   //akısın en byk degerini return eder

    }

    //task 11-->Ogrenci sayilari 150'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static void ogrSay150DenAzUnvEnKcNtOrt(List<Universite>unv) {
        System.out.println(unv.
                stream().
                filter(t -> t.getOgrSayisi() < 150).    // unv obj akısı fittrelendi
                mapToInt(t -> t.getNotOrt()).       // akısdaki unv obj notOrt akısı olarak update edildi
                min());     // akisin en kucuk degerini alir

    }
}

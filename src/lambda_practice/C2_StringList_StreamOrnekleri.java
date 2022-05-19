package lambda_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class C2_StringList_StreamOrnekleri {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Java");
        list.add("ogrenmek");
        list.add("cok");
        list.add("eglenceliydi");
        list.add("lambda");
        list.add("gelince");
        list.add("Daha");
        list.add("da");
        list.add("Cok");
        list.add("Eglenceli");
        list.add("Oldu");

        System.out.println("\n *** S-1 ***");
        ilkHarfiDveyColan(list);
        System.out.println("\n *** S-2 ***");
        strinBasVeSonYildizEkleYazdir(list);
        System.out.println("\n *** S-3 ***");
        System.out.println(alfabetikOlarakSirala(list));
        System.out.println("\n *** S-4 ***");
        tumLleriSilYazdir(list);
        System.out.println("\n *** S-5 ***");
        System.out.println(eOlanlarinlistesi(list));
        System.out.println("\n *** S-6 ***");
        ilkHarfi3KreYaz(list);
        System.out.println("\n *** S-7 ***");
        ilkHarfiBykDiglKucukYaz(list);
        System.out.println("\n *** S-8 ***");
        System.out.println(uzunlugu4Ve6HrcLisyele(list));


    }
    // S1: ilk harfi d veya c olanlari listeleyelim
    public static void ilkHarfiDveyColan(List<String> list){
        System.out.println(list.
                stream().
                filter(t -> t.toLowerCase().startsWith("d") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList()));
    }

    //S2: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void strinBasVeSonYildizEkleYazdir(List<String> list){
    list.
            stream().
            map(t->"*"+t+"*").
            forEach(System.out::println);
    }

    //S3: alfabedik olarak siralayalim list olarak
    public static List<String> alfabetikOlarakSirala(List<String> list){
        return list.
                stream().
                map(String::toLowerCase).
                sorted().
                collect(Collectors.toList());
    }

    //S4: tum 'l' leri silelim yazdiralim
    public static void tumLleriSilYazdir(List<String> list){
        list.
                stream().
                map(t->t.replaceAll("l","")).
                forEach(t-> System.out.print(t+" "));
    }

    //S5 : icinde e olanlardan yeni bir list olusturunuz
    public static  List<String>  eOlanlarinlistesi( List<String> list){
        return list.
                stream().
                filter(t -> t.contains("e")).
                collect(Collectors.toList());
    }

    // S6 : ilk harfini 3 kere tekrar edip yazalim ornek jjjava gibi
    public static void ilkHarfi3KreYaz(List<String> list){
       list.
               stream().
               map(t -> t.substring(0, 1).toUpperCase() + t.substring(0, 1).toLowerCase() + t.toLowerCase()).
               forEach(t-> System.out.println(t));

    }

    // S7: tum elemanlarin ilk harfini buyuk digerlerini kucuk yaziniz
    public static void ilkHarfiBykDiglKucukYaz(List<String> list) {
        list.
               stream().
                map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
                forEach(t-> System.out.println(t));
    }

    // S8: uzunlugu 4 ve 6 olanlar haric bir liste olusturunuz
    public static List<String> uzunlugu4Ve6HrcLisyele(List<String> list){
        return list.
                stream().
                filter(t->t.length()!=4 && t.length()!=6).
                collect(Collectors.toList());

    }

}

package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        yazdir(5);
        System.out.println("\n *****");
        listiYazdir(list);
        System.out.println("\n *****");
        negatifSayiYazdir(list);
        System.out.println("\n *****");
        listElmKareYazdir(list);
        System.out.println("\n *****");
        listElmKareTekrsizYazdir(list);
        System.out.println("\n *****");
        listElmKcDenByYazdir(list);
        System.out.println("\n *****");
        listElmByDenKcYazdir(list);
        System.out.println("\n *****");
        listPozElKupBirlBas5OlanList(list);
        System.out.println("\n *****");
        listPozElKarBirlBas5OlmayList(list);
        System.out.println("\n *****");
        listElmToplami(list);
        System.out.println("\n *****");
        negatiKarelerdenList(list);
        System.out.println("\n *****");
        BesDenBykSayiVarMi(list);
        System.out.println("\n *****");
        System.out.println(BesDenBykSayiVarMi2(list));
        System.out.println("\n *****");
        tumElemSifirdanKckMu(list);
        System.out.println("\n *****");
        System.out.println(tumElemSifirdanKckMu2(list));
        System.out.println("\n *****");
        lis100eEsitElemYokMu(list);
        System.out.println("\n *****");
        System.out.println(lis100eEsitElemYokMu2(list));
        System.out.println("\n *****");
        lis0aEsitElemYokMu(list);
        System.out.println("\n *****");
        lisIlk5ElmTopla(list);
        System.out.println("\n *****");
        lisSon5ElmListele(list);


    }
    public static void yazdir(int sayi){
        System.out.print(sayi+" ");
    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz //
        public static void listiYazdir(List<Integer> list){
            list.
                    stream().
                    forEach(C1_IntList_StreamOrnekleri::yazdir);
        }

    //S2: sadece negatif olanlari yazdir
    public static void negatifSayiYazdir(List<Integer> list){
        list.
                stream().
                filter(t->t<0).
                forEach(C1_IntList_StreamOrnekleri::yazdir);

    }

    //S3: pozitif olanlardan yeni bir liste olustur
    public static void pozitifSayiList(List<Integer> list){
        System.out.println(list.
                stream().
                map(t -> t > 0).
                collect(Collectors.toList()));
    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static void listElmKareYazdir(List<Integer> list){
        list.
                stream().
                map(t->t*t).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static void listElmKareTekrsizYazdir(List<Integer> list){
        list.
                stream().
                map(t -> t*t).
                distinct().collect(Collectors.toList()).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S6: listin elemanlarini kucukten buyuge siralayalim
    public static void listElmKcDenByYazdir(List<Integer> list){
        list.
                stream().
                sorted().
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void listElmByDenKcYazdir(List<Integer> list) {
        list.
                stream().
                sorted(Comparator.reverseOrder()).
                forEach(C1_IntList_StreamOrnekleri::yazdir);
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static void listPozElKupBirlBas5OlanList(List<Integer> list){
        System.out.println(list.
                stream().
                filter(t -> t > 0).
                map(t -> (t * t * t)).
                filter(t -> t % 10 == 5).
                collect(Collectors.toList()));
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static void listPozElKarBirlBas5OlmayList(List<Integer> list){
        System.out.println(list.
                stream().
                filter(t -> t > 0).
                map(t -> t * t).
                filter(t -> t % 10 != 5).
                collect(Collectors.toList()));
    }

    // S10 :list elemanlarini toplamini bulalim
    public static void listElmToplami(List<Integer> list){
        System.out.println(list.
                stream().
                reduce(Integer::sum));
    }

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static void negatiKarelerdenList(List<Integer> list){
        System.out.println(list.
                stream().
                filter(t -> t < 0).
                peek(t -> System.out.println("negatifler : "+t)).
                map(t -> t * t).
                collect(Collectors.toList()));
    }

    // S12 : listeden 5 den buyuk  sayi var mi?
    public static void BesDenBykSayiVarMi(List<Integer> list) {
        System.out.println(list.
                stream().
                anyMatch(t -> t > 5) ? "Listede 5'den buyuk sayi var" : "Listede 5'den buyuk sayi yok");
    }
    // 2. YOL:
    public static boolean BesDenBykSayiVarMi2(List<Integer> list) {
        return  list.
                        stream().
                        anyMatch(t -> t > 5);

    }

                // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static void tumElemSifirdanKckMu(List<Integer> list) {
        System.out.println(list.
                stream().
                allMatch(t -> t < 0) ? "Listede tum elemanlar 0'dan kucuk" : "Listede tum elemanlar 0'dan kucuk degil");
    }
    // 2. YOL:
    public static boolean tumElemSifirdanKckMu2(List<Integer> list) {
        return list.
                stream().
                allMatch(t -> t < 0);
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static void lis100eEsitElemYokMu(List<Integer> list) {
        System.out.println(list.
                stream().
                allMatch(t -> t !=100) ? "Listenin 100'e esit elemani yok" : "Listenin 100'e esit elemani var");
    }
    // 2. YOL:
    public static boolean lis100eEsitElemYokMu2(List<Integer> list) {
         return list.
                        stream().
                        allMatch(t -> t !=100);
    }

                // S15: listenin sifira esit elemani yok mu?
    public static void lis0aEsitElemYokMu(List<Integer> list) {
        System.out.println(list.
                stream().
                allMatch(t -> t !=0) ? "Listenin 0'a esit elemani yok" : "Listenin 0'a esit elemani var");
    }

    // S16:  listenin ilk 5 elemanini topla?
    public static void lisIlk5ElmTopla(List<Integer> list) {
        System.out.println(list.
                stream().
                limit(5).
                reduce(Integer::sum));
    }

    //S17: listenin son bes elemanini listele
    public static void lisSon5ElmListele(List<Integer> list) {
        System.out.println(list.
                stream().
                skip(list.size() - 5).
                collect(Collectors.toList()));
    }


}
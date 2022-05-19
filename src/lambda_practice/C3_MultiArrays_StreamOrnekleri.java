package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        System.out.println("\n *** s-1 *** ");
        tumElemListYap(arr);
        System.out.println("\n *** s-2 *** ");
        eIleBasElmDoubleYazdir(arr);
        System.out.println("\n *** s-3 *** ");
        eIleBasElmListYazdir(arr);
        System.out.println("\n *** s-4 *** ");
        kIleBitenYildizEkle(arr);

    }
    // S1 : tum elemanlari list yapalim
    public static void tumElemListYap(String arr[][]){
        System.out.println(Arrays.
                stream(arr).
                flatMap(Arrays::stream).
                collect(Collectors.toList()));
    }

    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void eIleBasElmDoubleYazdir(String arr[][]){
        Arrays.
                stream(arr).
                flatMap(Arrays::stream).
                filter(t->t.startsWith("E")).
                forEach(t-> System.out.println(t+t));

    }

    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static void eIleBasElmListYazdir(String arr[][]){
        System.out.println(Arrays.
                stream(arr).
                flatMap(Arrays::stream).
                filter(t -> t.startsWith("E")).
                collect(Collectors.toList()));
    }
    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kIleBitenYildizEkle(String arr[][]){
        Arrays.
                stream(arr).
                flatMap(Arrays::stream).
                filter(t -> t.endsWith("k")).collect(Collectors.toList()).
                forEach(t-> System.out.println(t+"*"+" "));
    }


}

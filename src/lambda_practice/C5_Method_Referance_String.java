package lambda_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C5_Method_Referance_String {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Elma", "Muz", "Portakal", "Cilek", "Limon");

        System.out.println("\n *** s-1 *** ");
        tumHarfBykHrfYzdir(list);
        System.out.println("\n *** s-2 *** ");
        tumStrgUznGoreSirala(list);
        System.out.println("\n *** s-3 *** ");
        eIleBaslKelYazdir(list);

    }
    // S1: Tum harfleri buyuk harf ile aralarinda bosluk birakarak yazdiralim
    public static void tumHarfBykHrfYzdir(List<String> list) {
        list.stream().map(String::toUpperCase).forEach(t -> System.out.print(t + " "));
        System.out.println();
        System.out.println(list.
                stream().
                map(String::toUpperCase).
                map(t -> t.split("")).
                flatMap(Arrays::stream).
                collect(Collectors.toList()));
    }
    //S2: Stringleri uzunluklarina gore siralayip yaziniz
    public static void tumStrgUznGoreSirala(List<String> list) {
        list.
                stream().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }

    //S3: E ILE Baslayanlari yazdiralim
    public static void eIleBaslKelYazdir(List<String> list) {
        list.
                stream().
                filter(t -> t.startsWith("E")).
                forEach(t -> System.out.print(t + " "));
    }
}
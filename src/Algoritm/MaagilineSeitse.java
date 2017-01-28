package Algoritm;//package Algoritm;

/**
 * Created by aleksandra on 27/01/2017.
 *Antud on int[] massiiv. Korruta kõik seitsmed kahega ja leia arvude keskmine.
 */
public class MaagilineSeitse {

    public static void main(String[] args) {

        int[] naide = {7, 4, 324, 65, 4, 78, 7, 45, 4};
        int summa = 0;
        int keskmine;

        for (int i = 0; i < naide.length; i++) {
            if(naide[i]==7){summa+=(naide[i]*2);}
            else{summa+=naide[i];}
        }
        keskmine = summa/naide.length;
        System.out.println(keskmine);
    }

}

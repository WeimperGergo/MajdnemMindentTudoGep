// Folyamatban...

package modell;

import java.util.Random;
import java.util.Scanner;


public class MindentTudoGep {
    
    private int[] lottoSzamok;
    private String totoEredmeny;
    private String[] dalok;
    private Scanner sc = new Scanner(System.in);
    private Random rnd = new Random();
    
    
    public MindentTudoGep() {
        this(new String[0]);
    }
    
    public MindentTudoGep(String dal) {
        this(new String[] {dal});
    }
    
    public MindentTudoGep(String[] dalok) {
        this.lottoSzamok = new int[5];
        this.totoEredmeny = "";
        this.dallalFeltolt();
        if(!(dalok == null || dalok.length == 0 || dalok[0].isBlank())){
            dalokatFelvesz(dalok);
        }
    }
    
    private void generalLottoSzelveny(){
        int db = 0;
        while (db < 5) {            
            int rSzam = rnd.nextInt(1, 91);
            if(!benneVan(rSzam, db)) {
                    lottoSzamok[db] = rSzam;
                    db++;
            }
        }
               
        
    }
    
    private boolean benneVan(int rndSzam, int ind){
        int i = 0;
        while (i < ind && !(lottoSzamok[ind] == rndSzam)){            
            i++;
        }
        if(i == ind) return false;
        else return true;
    }
    
    public String generalTotoSzelveny(){
        String toto = "";
        for (int i = 0; i < 13; i++) {
            int szam = rnd.nextInt(1, 4);
            if (szam == 1) toto += "1 ";
            else if (szam == 2) toto += "2 ";
            else toto += "x ";
        }
        
        return toto;
    }

    public void setLottoSzamok(int[] lottoSzamok) {
        this.lottoSzamok = lottoSzamok;
    }

    public void setTotoEredmeny(String totoEredmeny) {
        this.totoEredmeny = totoEredmeny;
    }

    public void setDalok(String[] dalok) {
        this.dalok = dalok;
    }

    private void dalokatFelvesz(String[] dalok) {
        String[] ujDalok = new String[dalok.length + dalok.length];
        int i;
        for (i = 0; i < dalok.length; i++) {
            ujDalok[i] = this.dalok[i];
        }
        ujDalok[i] = this.dalok[i];
    }

    public void dalBeker(){
        String[] ujDalok = new String[dalok.length + 1];
        ujDalok[ujDalok.length-1] = sc.next();
        setDalok(ujDalok);
    }

    private void dallalFeltolt() {
        this.dalok = new String[3];
        dalok[0] = "This could be us";
        dalok[1] = "Breaksh!t";
        dalok[2] = "Planet sX";
    }
    
    public void ujraIndit(){
        this.generalLottoSzelveny();
        this.generalTotoSzelveny();
        this.dalokatFelvesz(dalok);
    }

    
//    private void generalDalok(){
//        String[] ujDalok = new String[dalok.length + this.dalok.length];
//        setDalok(ujDalok);
//    }
    
    public String kerDal(){
        return this.dalok[velSzam(0, this.dalok.length)];
    }
    
    public int velSzam(int a, int b){
        return rnd.nextInt(a, b);
    }
}

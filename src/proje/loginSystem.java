package proje;
import java.io.*;

public class loginSystem {//0:id 1:tc 2:isim 3:psw 4:mevki 5:kredi sayısı 6:hesap sayısı 7: kk sayısı
    public int id;
    public String tcno, psw, username, mevki;
    public String truePsw;
    public Boolean isCorrect, isRegistered, kayitDurumu;
    public loginSystem(String[] gelenUser, int mod) throws IOException{ //mod 0: giriş | 1: kayıt
        switch(mod) {
            case 0:
                tcno= gelenUser[0];
                psw= gelenUser[1];
                getUser(tcno);
                isCorrect=checkPsw(psw,truePsw);
                break;
            case 1:
                tcno= gelenUser[0];
                username= gelenUser[1];
                psw= gelenUser[2];
                mevki= gelenUser[3];
                getUser(tcno);
                if(!isRegistered){
                    kayıtOl(tcno,username,psw,mevki);
                }else{
                    kayitDurumu=false;
                }
                break;
        }
    }
    private void getUser(String tcno) throws IOException{
        String Line;
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        reader.readLine();
        isRegistered=false;
        while ((Line = reader.readLine()) != null) {
            String[] arrOfStr = Line.split("@", 8);
            if(arrOfStr[1].equals(tcno)){
                truePsw=arrOfStr[3];
                isRegistered=true;
                break;
            }else{
                isRegistered=false;
            }
        }
        reader.close();
    }
    private void kayıtOl(String gelentcno, String gelenusername, String gelenpsw, String gelenmevki) throws IOException{
        String Line, modifiedContent="";
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        Line = reader.readLine();
        id=Integer.parseInt(Line);
        modifiedContent+=String.valueOf(id+1)+ System.lineSeparator();
        while ((Line = reader.readLine()) != null) {
            modifiedContent+=Line+ System.lineSeparator();
        }
        reader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));  
        writer.write(modifiedContent);  //idnin değişmiş halini yazdırdık
        writer.close();
        
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("users.txt", true));  
        writer2.append(id+"@"+gelentcno+"@"+gelenusername+"@"+gelenpsw+"@"+gelenmevki+"@0@1@0"+"\n");
        writer2.close();
        BufferedWriter writer3 = new BufferedWriter(new FileWriter("hesaplar.txt", true));  
        writer3.append((1000000000+(int)(Math.random()* 1000000000))+"@"+id+"@0"+"\n");
        writer3.close();
        kayitDurumu=true;
    }
    private Boolean checkPsw(String gelenPsw, String truePsw){
        if(gelenPsw.equals(truePsw)){
            return true;
        }
        else{
            return false;
        }
    }
}

package proje;
import java.io.*;

public class userArayüz {//0:id 1:tc 2:isim 3:psw 4:mevki 5:kredi sayısı 6:hesap sayısı 7:kk sayısı
    public String[] userInfo;
    public userArayüz(String tcNo) throws IOException {
        getUserInfo(tcNo);
        arayüzOlustur(userInfo);
    }
    private void getUserInfo(String tc) throws IOException{
        String Line;
        BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
        reader.readLine();
        while ((Line = reader.readLine()) != null) {
            userInfo = Line.split("@", 8);
            if(userInfo[1].equals(tc)){break;}
        }
    }
    private void arayüzOlustur(String[] userArr) throws IOException{
        switch(userArr[4]) {
            case "Banka Müdürü":
                mudur userMudur=new mudur(userArr);
                userMudur.welcomePage();
                break;
            case "Banka Personeli":
                personel userPersonel=new personel(userArr);
                userPersonel.welcomePage();
                break;
            case "Müşteri":
                musteri userMusteri=new musteri(userArr);
                userMusteri.welcomePage();
                break;
        }

    }
}

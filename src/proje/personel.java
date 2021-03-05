package proje;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


class basvurular{
    public Color LIGHTGRAY= new Color(204,204,204);
    public static JPanel mainPanel= new JPanel();
    public static JPanel krediPanel= new JPanel();
    public static JPanel kkPanel= new JPanel();
    public static int kkBasvuruSayisi=0, krediBasvuruSayisi=0;
    
    public void setPage() throws IOException {
        //kredi kartı basvuru sayısını bulma
        String Line;
        BufferedReader reader = new BufferedReader(new FileReader("kkbasvurular.txt"));
        while ((Line = reader.readLine()) != null) {
            kkBasvuruSayisi++;
        }
        reader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader("kredibasvurular.txt"));
        while ((Line = reader2.readLine()) != null) {
            krediBasvuruSayisi++;
        }
        reader2.close();
        mainPanel.setBackground(LIGHTGRAY);
        mainPanel.setBounds(0, 100, 700, 400);
        mainPanel.setLayout(null);
        personel.personelPage.add(mainPanel);
        mainPanel.setVisible(false);
    }
}

class kredi extends basvurular implements ActionListener{
    JLabel krediTuru[] = new JLabel[0], krediLimit[] = new JLabel[0], 
           krediGelir[] = new JLabel[0], krediHesapID[] = new JLabel[0],
           krediMiktar[] = new JLabel[0], krediVade[] = new JLabel[0];
    JButton onayBtn[] = new JButton[0], redBtn[] = new JButton[0];//47298@2@İhtiyaç Kredisi@9000@3000@12
    public void krediYazdir(String[] gelenArr) throws IOException{ //2@İhtiyaç Kredisi@1000@1460@5@10000
        BufferedWriter writer = new BufferedWriter(new FileWriter("krediler.txt", true));
        writer.append((1000000000+(int)(Math.random()* 1000000000))+"@"+gelenArr[0]+"@"+gelenArr[1]+"@"+gelenArr[3]+"@"+Integer.valueOf(gelenArr[3])/Integer.valueOf(gelenArr[4])+"@"+gelenArr[4]+"\n");
        writer.close();
    }
    @Override
    public void setPage() throws IOException{
        krediPanel.setBackground(LIGHTGRAY);
        krediPanel.setBounds(0, 100, 700, 400);
        krediPanel.setLayout(null);
        krediPanel.setVisible(true);
        personel.personelPage.add(krediPanel);
        
        krediHesapID = new JLabel[krediBasvuruSayisi];
        krediTuru    = new JLabel[krediBasvuruSayisi];
        krediLimit   = new JLabel[krediBasvuruSayisi];
        krediMiktar  = new JLabel[krediBasvuruSayisi];
        krediVade    = new JLabel[krediBasvuruSayisi];
        krediGelir   = new JLabel[krediBasvuruSayisi];
        onayBtn   = new JButton[krediBasvuruSayisi];
        redBtn    = new JButton[krediBasvuruSayisi];
        
        int i=0;
        String Line, krediBasvurulariInfo[] = new String[4];
        BufferedReader reader2 = new BufferedReader(new FileReader("kredibasvurular.txt"));
        while ((Line = reader2.readLine()) != null) {//2@İhtiyaç Kredisi@1000@1460@5@10000
            krediBasvurulariInfo = Line.split("@", 6);
            krediHesapID[i]  = new JLabel(krediBasvurulariInfo[0]);
            krediTuru[i]     = new JLabel(krediBasvurulariInfo[1]);
            krediLimit[i]    = new JLabel(krediBasvurulariInfo[2]+" tl");
            krediMiktar[i]   = new JLabel(krediBasvurulariInfo[3]+" tl");
            krediVade[i]     = new JLabel(krediBasvurulariInfo[4]);
            krediGelir[i]    = new JLabel(krediBasvurulariInfo[5]+" tl");
            onayBtn[i]       = new JButton("Onay");
            redBtn[i]        = new JButton("Red");
            krediHesapID[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediTuru[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediLimit[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediMiktar[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediVade[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediGelir[i].setFont(new Font("Serif", Font.PLAIN, 12));
            krediPanel.add(krediHesapID[i]);
            krediPanel.add(krediTuru[i]);
            krediPanel.add(krediLimit[i]);
            krediPanel.add(krediMiktar[i]);
            krediPanel.add(krediVade[i]);
            krediPanel.add(krediGelir[i]);
            krediPanel.add(onayBtn[i]);
            krediPanel.add(redBtn[i]);
            krediHesapID[i].setBounds(40,((i+1)*30)+40,100,30);
            krediTuru[i].setBounds(100,((i+1)*30)+40,100,30);
            krediLimit[i].setBounds(220,((i+1)*30)+40,80,30);
            krediMiktar[i].setBounds(300,((i+1)*30)+40,80,30);
            krediVade[i].setBounds(390,((i+1)*30)+40,60,30);
            krediGelir[i].setBounds(450,((i+1)*30)+40,80,30);
            onayBtn[i].setBounds(520,((i+1)*30)+40,80,30);
            redBtn[i].setBounds(600,((i+1)*30)+40,80,30);
            onayBtn[i].addActionListener(this);
            redBtn[i].addActionListener(this);
            i++;
        }
        reader2.close();
        i=0;
        
        JLabel krediHesapID, krediTuruL, krediLimitL, krediGelirL, krediVadeL, krediMiktarL, onayL, redL;
        krediHesapID  = new JLabel("Hesap id");
        krediTuruL    = new JLabel("Kredi Türü");
        krediLimitL   = new JLabel("Kredi Miktari");
        krediMiktarL  = new JLabel("Kredi Faiz ile");
        krediVadeL    = new JLabel("Vade");
        krediGelirL   = new JLabel("Yıllık Gelir");
        onayL         = new JLabel("Onay");
        redL          = new JLabel("Red");
        JSeparator sep = new JSeparator();
        JSeparator sep2 = new JSeparator();
        krediPanel.add(krediHesapID);
        krediPanel.add(krediTuruL);
        krediPanel.add(krediLimitL);
        krediPanel.add(krediMiktarL);
        krediPanel.add(krediVadeL);
        krediPanel.add(krediGelirL);
        krediPanel.add(onayL);
        krediPanel.add(redL);
        krediPanel.add(sep);
        krediPanel.add(sep2);
        krediHesapID.setBounds(20,20,100,30);
        krediTuruL.setBounds(100,20,100,30);
        krediLimitL.setBounds(200,20,80,30);
        krediMiktarL.setBounds(290,20,80,30);
        krediVadeL.setBounds(380,20,40,30);
        krediGelirL.setBounds(445,20,80,30);
        onayL.setBounds(545,20,70,30);
        redL.setBounds(630,20,70,30);
        sep.setBounds(0,20,700,10);
        sep2.setBounds(0,50,700,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String gönderlicekArr[] = new String[4];
        for(int i=0; i<krediBasvuruSayisi; i++){
            if(e.getSource()==onayBtn[i]){
                BufferedReader reader=null;
                try {
                    int satirNo=0;
                    String Line, modifiedContent="";
                    reader = new BufferedReader(new FileReader("kredibasvurular.txt"));
                    while ((Line = reader.readLine()) != null) {
                        if(satirNo==i){
                            gönderlicekArr = Line.split("@", 6);
                        }
                        if(satirNo!=i){
                            modifiedContent+=Line+ System.lineSeparator();
                        }
                        satirNo++;
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("kredibasvurular.txt"));
                    writer.write(modifiedContent);
                    writer.close();
                    new fileProcedures("users.txt", gönderlicekArr[0], 8, 5, 1, 1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                        krediYazdir(gönderlicekArr);
                        krediPanel.setVisible(false);
                        krediPanel.removeAll();
                        setPage();
                        krediPanel.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            if(e.getSource()==redBtn[i]){
                BufferedReader reader=null;
                try {
                    int satirNo=0;
                    String Line, modifiedContent="";
                    reader = new BufferedReader(new FileReader("kredibasvurular.txt"));
                    while ((Line = reader.readLine()) != null) {
                        if(satirNo!=i){
                            modifiedContent+=Line+ System.lineSeparator();
                        }
                        satirNo++;
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("kredibasvurular.txt"));
                    writer.write(modifiedContent);  //idnin değişmiş halini yazdırdık
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                        krediPanel.setVisible(false);
                        krediPanel.removeAll();
                        setPage();
                        krediPanel.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
    }
}

class krediKarti extends basvurular implements ActionListener{
    JLabel kkTuru[] = new JLabel[0], kkLimit[] = new JLabel[0], 
           kkGelir[] = new JLabel[0], kkHesapID[] = new JLabel[0];
    JButton onayBtn[] = new JButton[0], redBtn[] = new JButton[0];
    public void kkYazdir(String[] gelenArr) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("kredikartlari.txt", true));
        writer.append((1000000000+(int)(Math.random()* 1000000000))+"@"+gelenArr[0]+"@"+gelenArr[2]+"@0@"+gelenArr[1]+"\n");
        writer.close();
    }
    @Override
    public void setPage() throws IOException{
        kkPanel.setBackground(LIGHTGRAY);
        kkPanel.setBounds(0, 100, 700, 400);
        kkPanel.setLayout(null);
        kkPanel.setVisible(false);
        personel.personelPage.add(kkPanel);
        
        kkTuru    = new JLabel[kkBasvuruSayisi];
        kkLimit   = new JLabel[kkBasvuruSayisi];
        kkGelir   = new JLabel[kkBasvuruSayisi];
        kkHesapID = new JLabel[kkBasvuruSayisi];
        onayBtn   = new JButton[kkBasvuruSayisi];
        redBtn    = new JButton[kkBasvuruSayisi];
        String kkBasvurulariInfo[] = new String[4];
        int i=0;
        String Line;
        BufferedReader reader2 = new BufferedReader(new FileReader("kkbasvurular.txt"));
        while ((Line = reader2.readLine()) != null) {
            kkBasvurulariInfo = Line.split("@", 4);
            kkHesapID[i]     = new JLabel(kkBasvurulariInfo[0]);
            kkTuru[i]        = new JLabel(kkBasvurulariInfo[1]);
            kkLimit[i]       = new JLabel(kkBasvurulariInfo[2]+" tl");
            kkGelir[i]       = new JLabel(kkBasvurulariInfo[3]+" tl");
            onayBtn[i]       = new JButton("Onay");
            redBtn[i]        = new JButton("Red");
            kkHesapID[i].setFont(new Font("Serif", Font.PLAIN, 12));
            kkTuru[i].setFont(new Font("Serif", Font.PLAIN, 12));
            kkLimit[i].setFont(new Font("Serif", Font.PLAIN, 12));
            kkGelir[i].setFont(new Font("Serif", Font.PLAIN, 12));
            kkPanel.add(kkHesapID[i]);
            kkPanel.add(kkTuru[i]);
            kkPanel.add(kkLimit[i]);
            kkPanel.add(kkGelir[i]);
            kkPanel.add(onayBtn[i]);
            kkPanel.add(redBtn[i]);
            kkHesapID[i].setBounds(40,((i+1)*30)+40,100,30);
            kkTuru[i].setBounds(100,((i+1)*30)+40,100,30);
            kkLimit[i].setBounds(220,((i+1)*30)+40,100,30);
            kkGelir[i].setBounds(320,((i+1)*30)+40,150,30);
            onayBtn[i].setBounds(400,((i+1)*30)+40,100,30);
            redBtn[i].setBounds(500,((i+1)*30)+40,100,30);
            onayBtn[i].addActionListener(this);
            redBtn[i].addActionListener(this);
            i++;
        }
        reader2.close();
        i=0;
        
        JLabel kkHesapIDL, kkTuruL, kkLimitL, kkGelirL, onayL, redL;
        kkHesapIDL = new JLabel("Hesap id");
        kkTuruL    = new JLabel("Kart Türü");
        kkLimitL   = new JLabel("İstenen Limit");
        kkGelirL   = new JLabel("Yıllık Gelir");
        onayL      = new JLabel("Onay");
        redL      = new JLabel("Red");
        JSeparator sep  = new JSeparator();
        JSeparator sep2 = new JSeparator();
        kkPanel.add(kkHesapIDL);
        kkPanel.add(kkTuruL);
        kkPanel.add(kkLimitL);
        kkPanel.add(kkGelirL);
        kkPanel.add(onayL);
        kkPanel.add(redL);
        kkPanel.add(sep);
        kkPanel.add(sep2);
        kkHesapIDL.setBounds(20,20,100,30);
        kkTuruL.setBounds(100,20,100,30);
        kkLimitL.setBounds(210,20,100,30);
        kkGelirL.setBounds(315,20,100,30);
        onayL.setBounds(435,20,100,30);
        redL.setBounds(540,20,100,30);
        sep.setBounds(0,20,700,10);
        sep2.setBounds(0,50,700,10);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String gönderlicekArr[] = new String[4];
        for(int i=0; i<kkBasvuruSayisi; i++){
            if(e.getSource()==onayBtn[i]){
                BufferedReader reader=null;
                try {
                    int satirNo=0;
                    String Line, modifiedContent="";
                    reader = new BufferedReader(new FileReader("kkbasvurular.txt"));
                    while ((Line = reader.readLine()) != null) {
                        if(satirNo==i){
                            gönderlicekArr = Line.split("@", 4);
                        }
                        if(satirNo!=i){
                            modifiedContent+=Line+ System.lineSeparator();
                        }
                        satirNo++;
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("kkbasvurular.txt"));
                    writer.write(modifiedContent);
                    writer.close();
                    new fileProcedures("users.txt", gönderlicekArr[0], 8, 7, 1, 1);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                        kkYazdir(gönderlicekArr);
                        kkPanel.setVisible(false);
                        kkPanel.removeAll();
                        setPage();//kkBasvurulariArr yi burda sıfırlanır
                        kkPanel.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            if(e.getSource()==redBtn[i]){
                BufferedReader reader=null;
                try {
                    int satirNo=0;
                    String Line, modifiedContent="";
                    reader = new BufferedReader(new FileReader("kkbasvurular.txt"));
                    while ((Line = reader.readLine()) != null) {
                        if(satirNo!=i){
                            modifiedContent+=Line+ System.lineSeparator();
                        }
                        satirNo++;
                    }
                    BufferedWriter writer = new BufferedWriter(new FileWriter("kkbasvurular.txt"));
                    writer.write(modifiedContent);  //idnin değişmiş halini yazdırdık
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        reader.close();
                        kkPanel.setVisible(false);
                        kkPanel.removeAll();
                        setPage();//kkBasvurulariArr yi burda sıfırlanır
                        kkPanel.setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(krediKarti.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
    }
}

public class personel{  
    public static JFrame personelPage = new JFrame("PERSONEL PANELİ");
    public JPanel menuPanel= new JPanel();
    public Color LIGHTGRAY= new Color(204,204,204);
    
    public String id;
    public personel(String[] userInfo){
        id=userInfo[0];
    }
    public void setPanel(basvurular a) throws IOException {
        a.setPage();
    }
    public class dinleyici implements ActionListener{
        @Override
  	public void actionPerformed(ActionEvent e){
            switch(((JButton) e.getSource()).getText()) {
                case "Kredi Başvuruları":
                    basvurular.kkPanel.setVisible(false);
                    basvurular.krediPanel.setVisible(true);
                    break;
                case "Kredi Kartı Başvuruları":
                    basvurular.kkPanel.setVisible(true);
                    basvurular.krediPanel.setVisible(false);
                    break;
            }
        }
    }
    public void welcomePage() throws IOException{
        personelPage.setSize(700 , 500);
        personelPage.getContentPane().setBackground(LIGHTGRAY);
        personelPage.setLayout(null);
        personelPage.setVisible(true);
        BufferedImage myPicture = ImageIO.read(new File("src/proje/staff.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        personelPage.add(picLabel);
        picLabel.setBounds(18,18,64,64);
        personelPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuPanel.setBackground(LIGHTGRAY);
        menuPanel.setBounds(100, 0, 600, 100);
        menuPanel.setLayout(null);
        personelPage.add(menuPanel);
        menuPanel.setVisible(true);
        
        JButton krediPageBtn = new JButton("Kredi Başvuruları");
        JButton kkPageBtn    = new JButton("Kredi Kartı Başvuruları");
        krediPageBtn.setBackground(Color.WHITE);
        kkPageBtn.setBackground(Color.WHITE);
        menuPanel.add(krediPageBtn);
        menuPanel.add(kkPageBtn);
        krediPageBtn.setBounds(80,20,180,50);
        kkPageBtn.setBounds(300,20,180,50);
        krediPageBtn.addActionListener(new dinleyici());
        kkPageBtn.addActionListener(new dinleyici());
        
        //overload
        basvurular x = new basvurular();
        kredi y = new kredi();
        krediKarti z = new krediKarti();
        setPanel(x);
        setPanel(y);
        setPanel(z);
    }
}

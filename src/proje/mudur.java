package proje;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class mudur {
    public static JFrame mudurPage = new JFrame("MÜDÜR PANELİ");
    public JTextField yeniSifreField;
    public JTextField yeniFaiz;
    public JPanel personelPanel = new JPanel();
    public JPanel krediPanel = new JPanel();
    public JComboBox personelBox;
    public JComboBox krediBox;
    public Color LIGHTGRAY= new Color(204,204,204);
    public String[] userBilgiler=new String[8];
    
    mudurIslem x = new mudurIslem();
    
    
    public mudur(String[] userInfo){
        for(int i=0; i<8;i++){
            userBilgiler[i]=userInfo[i];
        }
    }
    public void welcomePage() throws IOException{
        mudurPage.setSize(700 , 500);
        mudurPage.getContentPane().setBackground(LIGHTGRAY);
        mudurPage.setLayout(null);
        mudurPage.setVisible(true);
        BufferedImage myPicture = ImageIO.read(new File("src/proje/boss.png"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        mudurPage.add(picLabel);
        picLabel.setBounds(70,20,64,64);
        mudurPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton sifreDegisBtn = new JButton("Şifre Değişme");
        JButton personelBtn = new JButton("Personel Listesi");
        JButton krediBtn = new JButton("Kredi Çeşitleri");
        krediBtn.setBackground(Color.WHITE);
        personelBtn.setBackground(Color.WHITE);
        sifreDegisBtn.setBackground(Color.WHITE);
        mudurPage.add(personelBtn);
        mudurPage.add(sifreDegisBtn);
        mudurPage.add(krediBtn);
        sifreDegisBtn.setBounds(20,100,150,30);
        krediBtn.setBounds(450,20,200,30);
        personelBtn.setBounds(200,20,200,30);
        sifreDegisBtn.addActionListener(new mudur.dinleyici());
        personelBtn.addActionListener(new mudur.dinleyici());
        krediBtn.addActionListener(new mudur.dinleyici());
        
        x.setPersonelPanel();
        x.setKrediPanel();
    }
    
    interface mudurIO{
        public void setKrediPanel() throws IOException;
        public void setSifreDegis();
        public void sifreDegis();
        public void setPersonelPanel() throws IOException;
    }
    class mudurIslem implements mudurIO{
        public void oranDegis(String degisenKredi, String yeniDeger) throws IOException{
            new fileProcedures("kredicesitleri.txt", degisenKredi, yeniDeger, 4, 1);
            krediPanel.removeAll();
            setKrediPanel();
            krediPanel.setVisible(true);
        }
        public void personelKov(String isim) throws IOException{
            String modifiedContent="", Line="";
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            Line=reader.readLine();
            modifiedContent+=Line;
            while ((Line = reader.readLine()) != null) {
                String arr[] = Line.split("@", 8);
                if(!arr[2].equals(isim)){
                    modifiedContent+=Line + System.lineSeparator();
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt"));
            writer.write(modifiedContent);
            writer.close();
            personelPanel.removeAll();
            setPersonelPanel();
            personelPanel.setVisible(true);
        }
        @Override
        public void setSifreDegis(){
            JFrame a=new JFrame();
            a.setSize(300,200);
            a.setVisible(true);
            a.setLayout(null);
            a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            yeniSifreField   = new JTextField(30);
            JLabel sifreL    = new JLabel("Yeni Şifreniz", SwingConstants.CENTER);
            JButton sifreBtn = new JButton("Şifre Değiştir");
            sifreBtn.setBackground(Color.WHITE);
            a.add(sifreL);
            a.add(yeniSifreField);
            a.add(sifreBtn);
            sifreL.setBounds(0,10,300,30);
            yeniSifreField.setBounds(75,40,150,30);
            sifreBtn.setBounds(90,80,120,30);
            sifreBtn.addActionListener(new mudur.dinleyici());
        }
        @Override
        public void sifreDegis(){
            try {
                new fileProcedures("users.txt", userBilgiler[0], yeniSifreField.getText(), 8, 3);
            } catch (IOException ex) {
                Logger.getLogger(mudur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        public void setPersonelPanel() throws IOException{
            String personelIdArr[]=new String[5];
            personelPanel.setBackground(LIGHTGRAY);
            personelPanel.setBounds(200, 100, 500, 400);
            personelPanel.setLayout(null);
            personelPanel.setVisible(true);
            mudurPage.add(personelPanel);
            
            JLabel[] id = new JLabel[5], isim = new JLabel[5], pozisyon = new JLabel[5];
            
            String Line="";
            int i=0;
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            reader.readLine();
            while ((Line = reader.readLine()) != null) {
                String arr[] = Line.split("@", 8);
                if(arr[4].equals("Banka Personeli")){
                    personelIdArr[i]=arr[2];
                    id[i]=new JLabel(arr[0]);
                    isim[i]=new JLabel(arr[2]);
                    pozisyon[i]=new JLabel(arr[4]);
                    id[i].setFont(new Font("Serif", Font.PLAIN, 16));
                    isim[i].setFont(new Font("Serif", Font.PLAIN, 16));
                    pozisyon[i].setFont(new Font("Serif", Font.PLAIN, 16));
                    personelPanel.add(id[i]);
                    personelPanel.add(isim[i]);
                    personelPanel.add(pozisyon[i]);
                    id[i].setBounds(50,((i+1)*30)+40,100,30);
                    isim[i].setBounds(150,((i+1)*30)+40,100,30);
                    pozisyon[i].setBounds(280,((i+1)*30)+40,100,30);
                    i++;
                }
            }
            i=0;
            reader.close();
            
            JLabel kovL =new JLabel("İşten Çıkarma");
            JLabel idL =new JLabel("ID");
            JLabel isimL =new JLabel("İsim");
            JLabel pozisyonL =new JLabel("Pozisyon");
            JButton kovBtn = new JButton("İşten Çıkar");
            personelBox = new JComboBox(personelIdArr);
            idL.setFont(new Font("Serif", Font.BOLD, 16));
            isimL.setFont(new Font("Serif", Font.BOLD, 16));
            pozisyonL.setFont(new Font("Serif", Font.BOLD, 16));
            kovBtn.setBackground(Color.WHITE);
            personelPanel.add(idL);
            personelPanel.add(isimL);
            personelPanel.add(pozisyonL);
            personelPanel.add(kovBtn);
            personelPanel.add(kovL);
            personelPanel.add(personelBox);
            idL.setBounds(50,20,100,30);
            isimL.setBounds(150,20,100,30);
            pozisyonL.setBounds(280,20,100,30);
            kovL.setBounds(20,270,200,30);
            kovBtn.setBounds(200,300,200,30);
            personelBox.setBounds(50,300,80,30);
            kovBtn.addActionListener(new mudur.dinleyici());
        }
        @Override
        public void setKrediPanel() throws IOException{
            String krediArr[]=new String[3];
            krediPanel.setBackground(LIGHTGRAY);
            krediPanel.setBounds(200, 100, 500, 400);
            krediPanel.setLayout(null);
            krediPanel.setVisible(false);
            mudurPage.add(krediPanel);
            
            JLabel[] faiz = new JLabel[3], türü = new JLabel[3], vade = new JLabel[3], miktar = new JLabel[3];
            
            String Line="";
            int i=0;
            BufferedReader reader = new BufferedReader(new FileReader("kredicesitleri.txt"));
            while ((Line = reader.readLine()) != null) {
                String arr[] = Line.split("@", 4);
                krediArr[i]=arr[0];
                faiz[i]=new JLabel(arr[1]);
                türü[i]=new JLabel(arr[0]);
                vade[i]=new JLabel(arr[2]);
                miktar[i]=new JLabel(arr[3] + " tl");
                faiz[i].setFont(new Font("Serif", Font.PLAIN, 16));
                türü[i].setFont(new Font("Serif", Font.PLAIN, 16));
                vade[i].setFont(new Font("Serif", Font.PLAIN, 16));
                miktar[i].setFont(new Font("Serif", Font.PLAIN, 16));
                krediPanel.add(faiz[i]);
                krediPanel.add(türü[i]);
                krediPanel.add(vade[i]);
                krediPanel.add(miktar[i]);
                faiz[i].setBounds(20,((i+1)*30)+40,100,30);
                türü[i].setBounds(120,((i+1)*30)+40,100,30);
                vade[i].setBounds(250,((i+1)*30)+40,100,30);
                miktar[i].setBounds(320,((i+1)*30)+40,120,30);
                i++;
            }
            i=0;
            reader.close();
            
            JLabel faizL =new JLabel("Faiz Oranı");
            JLabel yenifaizL =new JLabel("Yeni Faiz Oranı");
            JLabel türüL =new JLabel("Kredi Türü");
            JLabel yenitürüL =new JLabel("Kredi Türü");
            JLabel vadeL =new JLabel("Vade Sayısı");
            JLabel miktarL =new JLabel("Miktar");
            krediBox = new JComboBox(krediArr);
            yeniFaiz = new JTextField(30);
            JButton orandegisBtn = new JButton("Oranı Değiştir");
            yenifaizL.setFont(new Font("Serif", Font.BOLD, 16));
            faizL.setFont(new Font("Serif", Font.BOLD, 16));
            yenitürüL.setFont(new Font("Serif", Font.BOLD, 16));
            türüL.setFont(new Font("Serif", Font.BOLD, 16));
            vadeL.setFont(new Font("Serif", Font.BOLD, 16));
            miktarL.setFont(new Font("Serif", Font.BOLD, 16));
            orandegisBtn.setBackground(Color.WHITE);
            krediPanel.add(faizL);
            krediPanel.add(yenifaizL);
            krediPanel.add(türüL);
            krediPanel.add(yenitürüL);
            krediPanel.add(vadeL);
            krediPanel.add(miktarL);
            krediPanel.add(orandegisBtn);
            krediPanel.add(krediBox);
            krediPanel.add(yeniFaiz);
            faizL.setBounds(0,20,100,30);
            türüL.setBounds(120,20,100,30);
            vadeL.setBounds(230,20,100,30);
            miktarL.setBounds(350,20,100,30);
            yenitürüL.setBounds(0,220,150,30);
            krediBox.setBounds(20,250,150,30);
            yenifaizL.setBounds(0,280,150,30);
            yeniFaiz.setBounds(20,310,150,30);
            orandegisBtn.setBounds(220,310,180,30);
            orandegisBtn.addActionListener(new mudur.dinleyici());
        }
    }
    public class dinleyici implements ActionListener{
        @Override
  	public void actionPerformed(ActionEvent e){
            switch(((JButton) e.getSource()).getText()) {
                case "Kredi Çeşitleri":
                    personelPanel.setVisible(false);
                    krediPanel.setVisible(true);
                    break;
                case "Personel Listesi":
                    krediPanel.setVisible(false);
                    personelPanel.setVisible(true);
                    break;
                case "İşten Çıkar":
                 {
                     try {
                         x.personelKov(personelBox.getSelectedItem().toString());
                     } catch (IOException ex) {
                         Logger.getLogger(mudur.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                    break;
                case "Oranı Değiştir":
                 {
                     try {
                         x.oranDegis(krediBox.getSelectedItem().toString(), yeniFaiz.getText());
                     } catch (IOException ex) {
                         Logger.getLogger(mudur.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                    break;

                case "Şifre Değişme":
                    x.setSifreDegis();
                    break;
                case "Şifre Değiştir":
                    x.sifreDegis();
                    break;
            }
            
        }
    }
}

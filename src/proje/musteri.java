package proje;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class musteri {//0:id 1:tc 2:isim 3:psw 4:mevki 5:kredi sayısı 6:hesap sayısı 7:kk sayısı
    public String[] userBilgiler=new String[8];
    public int hesapSayisi;
    public String[] hesapNoArr;
    
    
    //Başlangıç sayfası
    public JLabel menuL;
    public JFrame musteriPage = new JFrame();
    public JPanel welcomePanel= new JPanel();
    public JPanel menuPanel   = new JPanel();
    public JPanel ayirici     = new JPanel();
    public JTextField yeniSifreField;
    
    //kredi sayfaları
    public JPanel krediPanel         = new JPanel();
    public JPanel krediBorcPanel     = new JPanel();
    public JPanel krediBasvuruPanel  = new JPanel();
    public JTextField krediMiktar, krediMaas, krediVade;
    public JComboBox krediTurleriBox, odencekKredilerim, krediHesaplarımBox;
    
    //kredi kartı sayfaları
    public JPanel kkPanel         = new JPanel();
    public JPanel kkBorcPanel     = new JPanel();
    public JPanel kkBasvuruPanel  = new JPanel();
    public JTextField kkOdencekMiktar, kkLimit, kkMaas;
    public JComboBox kkTuruBox, kklarıBox, kkHesaplarımBox;
    
    //fatura sayfası
    public JPanel faturaPanel = new JPanel();
    public JTextField faturaNo, faturaMiktar;
    public JComboBox faturaHesaplarımBox;
    
    //bakiye sayfaları
    public JPanel bakiyePanel = new JPanel(); 
    public JPanel hesaplariGosterPanel = new JPanel(); 
    public JPanel bakiyeGonderPanel = new JPanel(); 
    public JTextField eklenecekMiktar, gönderilcekMiktar, gonderilcekHesapNo;
    public JComboBox hesaplarımBox1, hesaplarımBox2;
    
    public Color LIGHTGRAY= new Color(204,204,204);
    
    public musteri(String[] userInfo){
        for(int i=0; i<8;i++){
            userBilgiler[i]=userInfo[i];
        }
        hesapSayisi = Integer.parseInt(userBilgiler[6]);
        hesapNoArr = new String[hesapSayisi];
    }
    public void welcomePage() throws IOException{
        musteriPage  = new JFrame("MÜŞTERİ PANELİ");
        musteriPage.setSize(700 , 500);
        musteriPage.getContentPane().setBackground(LIGHTGRAY);
        musteriPage.setLayout(null);
        
        setMenuPanel();
        setWelcomePanel();
        
        setBakiyePanel();
        setHesaplariGosterPanel();
        setBakiyeGonderPanel();
        
        setKrediPanel();
        setKrediBasvuruPanel();
        setKrediBorcPanel();
        
        setKKPanel();
        setKKBorcPanel();
        setKKBasvuruPanel();
        
        setFaturaPanel();
        
        
        musteriPage.setVisible(true);
        musteriPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setMenuPanel(){
        JButton krediIslemleri, kkIslemleri, faturaOdeme, bakiyeIslemleri, sifreDegisBtn;
        menuPanel.setBackground(LIGHTGRAY);
        menuPanel.setBounds(0, 0, 170, 500);
        menuPanel.setLayout(null);
        musteriPage.add(menuPanel);
        ayirici.setBackground(Color.GRAY);
        ayirici.setBounds(170, 10, 3, 440);
        ayirici.setLayout(null);
        musteriPage.add(ayirici);
        
        menuL           = new JLabel("İşlemler Menü");
        krediIslemleri  = new JButton("Kredi İşlemleri");
        kkIslemleri     = new JButton("Kredi Kartı İşlemleri"); 
        faturaOdeme     = new JButton("Fatura Ödeme"); 
        bakiyeIslemleri = new JButton("Hesap İşlemleri");
        sifreDegisBtn   = new JButton("Şifre Değişme");
        krediIslemleri.setBackground(Color.WHITE);
        kkIslemleri.setBackground(Color.WHITE);
        faturaOdeme.setBackground(Color.WHITE);
        bakiyeIslemleri.setBackground(Color.WHITE);
        sifreDegisBtn.setBackground(Color.WHITE);
        menuL.setFont(new Font("Serif", Font.BOLD, 18));
        menuPanel.add(menuL);
        menuPanel.add(krediIslemleri);
        menuPanel.add(kkIslemleri);
        menuPanel.add(faturaOdeme);
        menuPanel.add(bakiyeIslemleri);
        menuPanel.add(sifreDegisBtn);
        menuL.setBounds(13,20,160,40);
        krediIslemleri.setBounds(5,80,160,40);
        kkIslemleri.setBounds(5,125,160,40);
        faturaOdeme.setBounds(5,170,160,40);
        bakiyeIslemleri.setBounds(5,215,160,40);
        sifreDegisBtn.setBounds(5,260,160,40);
        krediIslemleri.addActionListener(new dinleyici());
        kkIslemleri.addActionListener(new dinleyici());
        faturaOdeme.addActionListener(new dinleyici());
        bakiyeIslemleri.addActionListener(new dinleyici());
        sifreDegisBtn.addActionListener(new dinleyici());
    }
    public void setWelcomePanel(){
        welcomePanel.setBackground(LIGHTGRAY);
        welcomePanel.setBounds(180, 0, 420, 500);
        welcomePanel.setLayout(null);
        musteriPage.add(welcomePanel);
        
        JLabel welcomeL       = new JLabel("<html><p>Bankamıza Hoşgeldiniz. <br><br>  Yapmak istediğiniz işlemleri sol tarafta bulunan menüden kolayca yapabilirsiniz.</p></html>");
        JLabel krediWelcomeL  = new JLabel("<html><p>Bankamızın müşterilerimize sunduğu düşük faizli kredilerden yararlanmak istermiydiniz ? </p><br>"
                                        + "<p>Kredi çeşitleri ve faiz oranları Kredi Tablosunda bulunmaktadır.</p></html>");
        JButton  krediTablosuBtn       = new JButton("Kredi Tablosu");
        krediTablosuBtn.setBackground(Color.WHITE);
        welcomeL.setFont(new Font("Serif", Font.PLAIN, 18));
        krediWelcomeL.setFont(new Font("Serif", Font.PLAIN, 16));
        welcomePanel.add(welcomeL);  
        welcomePanel.add(krediWelcomeL);  
        welcomePanel.add(krediTablosuBtn);  
        welcomeL.setBounds(10,40,400,120);
        krediWelcomeL.setBounds(10,180,400,120);
        krediTablosuBtn.setBounds(10,310,160,40);
        krediTablosuBtn.addActionListener(new dinleyici());
    }
    public void setKrediPanel(){
        JLabel krediL;
        JButton krediTablosuBtn, krediBasvurBtn , krediBorcuBtn;
        krediPanel.setBackground(LIGHTGRAY);
        krediPanel.setBounds(180, 0, 500, 500);
        krediPanel.setLayout(null);
        musteriPage.add(krediPanel);
        krediPanel.setVisible(false);
        
        krediL          = new JLabel("Kredi İşlemleri");
        krediTablosuBtn = new JButton("Kredi Tablosu");
        krediBasvurBtn  = new JButton("Kredi Başvuru");
        krediBorcuBtn   = new JButton("Kredilerim");
        krediL.setFont(new Font("Serif", Font.BOLD, 18));
        krediTablosuBtn.setBackground(Color.WHITE);
        krediBasvurBtn.setBackground(Color.WHITE);
        krediBorcuBtn.setBackground(Color.WHITE);
        krediPanel.add(krediL);
        krediPanel.add(krediTablosuBtn);
        krediPanel.add(krediBasvurBtn);
        krediPanel.add(krediBorcuBtn); 
        krediL.setBounds(20,20,150,50);
        krediTablosuBtn.setBounds(30,80,120,30);
        krediBasvurBtn.setBounds(160,80,120,30);
        krediBorcuBtn.setBounds(290,80,120,30);
        krediTablosuBtn.addActionListener(new dinleyici());
        krediBasvurBtn.addActionListener(new dinleyici());
        krediBorcuBtn.addActionListener(new dinleyici());
    }
    public void showKrediTablosu() throws IOException{
        String krediTurleri[][] = new String[3][4];
        String tabloBasliklari[]= {"Kredi Türü","Yıllık Faiz Oranı","Vade","Limit"};
        String Line="";
        int i=0;
        BufferedReader reader = new BufferedReader(new FileReader("kredicesitleri.txt"));
        while ((Line = reader.readLine()) != null) {
            String arr[] = Line.split("@", 4);
            for(int a=0; a<4; a++){
                krediTurleri[i][a]=arr[a];
            }
            i++;
        }
        i=0;
        reader.close();
        JFrame f=new JFrame();
        JTable jt=new JTable(krediTurleri,tabloBasliklari);
        jt.setBounds(60,60,280,150);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(400,200);
        f.setVisible(true);
    }
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
        sifreBtn.addActionListener(new dinleyici());
    }
    public void setKrediBasvuruPanel(){
        String[] krediTurleriArr={"İhtiyaç Kredisi", "Konut Kredisi", "Taşıt Kredisi"};
        JLabel baslikL, krediTurleriL, krediMiktarL, krediVadeL, maasL;
        JButton krediBasvurBtn;
        krediBasvuruPanel.setBackground(LIGHTGRAY);
        krediBasvuruPanel.setBounds(0, 120, 500, 360);
        krediBasvuruPanel.setLayout(null);
        krediPanel.add(krediBasvuruPanel);
        krediBasvuruPanel.setVisible(true);
        
        baslikL          = new JLabel("Kredi Başvuru");
        krediTurleriL    = new JLabel("Kredi Türü");
        krediMiktarL     = new JLabel("Kredi Miktarı");
        krediVadeL       = new JLabel("Kredi Vade Sayısı");
        maasL            = new JLabel("Yıllık Gelir");
        krediBasvurBtn   = new JButton("Krediye Başvur");
        krediMiktar      = new JTextField(30);
        krediMaas        = new JTextField(30);
        krediVade        = new JTextField(30);
        krediTurleriBox  = new JComboBox(krediTurleriArr);
        baslikL.setFont(new Font("Serif", Font.BOLD, 16));
        krediTurleriL.setFont(new Font("Serif", Font.PLAIN, 16));
        krediMiktarL.setFont(new Font("Serif", Font.PLAIN, 16));
        krediVadeL.setFont(new Font("Serif", Font.PLAIN, 16));
        maasL.setFont(new Font("Serif", Font.PLAIN, 16));
        krediBasvurBtn.setBackground(Color.WHITE);
        krediBasvuruPanel.add(baslikL);
        krediBasvuruPanel.add(krediTurleriL);
        krediBasvuruPanel.add(krediMiktarL);
        krediBasvuruPanel.add(krediVadeL);
        krediBasvuruPanel.add(maasL);
        krediBasvuruPanel.add(krediBasvurBtn);
        krediBasvuruPanel.add(krediMiktar);
        krediBasvuruPanel.add(krediMaas);
        krediBasvuruPanel.add(krediTurleriBox);
        krediBasvuruPanel.add(krediVade);
        baslikL.setBounds(20,10,160,40);
        krediTurleriL.setBounds(50,50,160,30);
        krediTurleriBox.setBounds(50,90,160,30);
        krediVadeL.setBounds(50,130,160,30);
        krediVade.setBounds(50,170,160,30);
        krediMiktarL.setBounds(230,50,150,30);
        krediMiktar.setBounds(230,90,150,30);
        maasL.setBounds(230,130,150,30);
        krediMaas.setBounds(230,170,150,30);
        krediBasvurBtn.setBounds(230,240,150,30);
        krediBasvurBtn.addActionListener(new dinleyici());
    }
    public void setKrediBorcPanel() throws IOException{
        int krediSayisi=Integer.parseInt(userBilgiler[5]), i=0;
        System.out.print(krediSayisi+"\n");
        String[] odencekKredilerimArr = new String[krediSayisi];
        JButton krediOdemeBtn;
        JLabel baslik, baslik1, baslik2, baslik3, baslik4, baslik5, baslik6, krediOdemeL;
        JLabel krediTuru[] = new JLabel[krediSayisi], krediTutari[]= new JLabel[krediSayisi], 
               krediAylikMiktar[]= new JLabel[krediSayisi], krediTaksitSayisi[]= new JLabel[krediSayisi],
               krediID[]= new JLabel[krediSayisi];
        krediBorcPanel.setBackground(LIGHTGRAY);
        krediBorcPanel.setBounds(0, 120, 500, 360);
        krediBorcPanel.setLayout(null);
        krediPanel.add(krediBorcPanel);
        krediBorcPanel.setVisible(false);
        
        String Line, krediBilgileri[]= null;
        BufferedReader reader = new BufferedReader(new FileReader("krediler.txt"));//0:kullanıcıid 1:türü 2:toplamborç 3:aylıktutar 4:taksitsayisi 
        while ((Line = reader.readLine()) != null && i<=krediSayisi) {
            krediBilgileri = Line.split("@", 6);
            if(krediBilgileri[1].equals(userBilgiler[0])){
                odencekKredilerimArr[i]=krediBilgileri[0];
                krediID[i]           = new JLabel(krediBilgileri[0]);
                krediTuru[i]         = new JLabel(krediBilgileri[2]);
                krediTutari[i]       = new JLabel(krediBilgileri[3]+" tl");
                krediAylikMiktar[i]  = new JLabel(krediBilgileri[4]+" tl");
                krediTaksitSayisi[i] = new JLabel(krediBilgileri[5]);
                krediTuru[i].setFont(new Font("Serif", Font.PLAIN, 12));
                krediTutari[i].setFont(new Font("Serif", Font.PLAIN, 12));
                krediAylikMiktar[i].setFont(new Font("Serif", Font.PLAIN, 12));
                krediTaksitSayisi[i].setFont(new Font("Serif", Font.PLAIN, 12));
                krediID[i].setFont(new Font("Serif", Font.PLAIN, 12));
                krediBorcPanel.add(krediTuru[i]);
                krediBorcPanel.add(krediTutari[i]);
                krediBorcPanel.add(krediAylikMiktar[i]);
                krediBorcPanel.add(krediTaksitSayisi[i]);
                krediBorcPanel.add(krediID[i]);
                krediTuru[i].setBounds(20,((i+1)*30)+40,100,30);
                krediTutari[i].setBounds(120,((i+1)*30)+40,100,30);
                krediAylikMiktar[i].setBounds(240,((i+1)*30)+40,150,30);
                krediTaksitSayisi[i].setBounds(350,((i+1)*30)+40,100,30);
                krediID[i].setBounds(430,((i+1)*30)+40,100,30);
                i++;
            }
        }
        
        baslik      = new JLabel("Kredilerim");
        baslik1     = new JLabel("Kredi Türü");
        baslik2     = new JLabel("Kalan Borç"); 
        baslik3     = new JLabel("Aylık Taksit Tutarı");
        baslik4     = new JLabel("Kalan Taksit");
        baslik5     = new JLabel("Kredi No");
        baslik6     = new JLabel("Hesap No");
        krediOdemeL = new JLabel("Ödenecek Kredi No");
        baslik.setFont(new Font("Serif", Font.BOLD, 17));
        baslik1.setFont(new Font("Serif", Font.BOLD, 13));
        baslik2.setFont(new Font("Serif", Font.BOLD, 13));
        baslik3.setFont(new Font("Serif", Font.BOLD, 13));
        baslik4.setFont(new Font("Serif", Font.BOLD, 13));
        baslik5.setFont(new Font("Serif", Font.BOLD, 13));
        odencekKredilerim  = new JComboBox(odencekKredilerimArr);
        krediHesaplarımBox = new JComboBox(hesapNoArr);
        krediOdemeBtn      = new JButton("Taksidi Öde");
        krediOdemeBtn.setBackground(Color.WHITE);
        krediBorcPanel.add(baslik);
        krediBorcPanel.add(baslik1);
        krediBorcPanel.add(baslik2);
        krediBorcPanel.add(baslik3);
        krediBorcPanel.add(baslik4);
        krediBorcPanel.add(baslik5);
        krediBorcPanel.add(baslik6);
        krediBorcPanel.add(krediHesaplarımBox);
        krediBorcPanel.add(krediOdemeL);
        krediBorcPanel.add(odencekKredilerim);
        krediBorcPanel.add(krediOdemeBtn);
        baslik.setBounds(0,0,100,40);
        baslik1.setBounds(20,40,100,40);
        baslik2.setBounds(120,40,100,40);
        baslik3.setBounds(200,40,150,40);
        baslik4.setBounds(320,40,100,40);
        baslik5.setBounds(420,40,100,40);
        krediOdemeL.setBounds(50,210,140,30);
        baslik6.setBounds(200,210,140,30);
        odencekKredilerim.setBounds(50,250,120,30);
        krediHesaplarımBox.setBounds(200,250,120,30);
        krediOdemeBtn.setBounds(340,250,120,30);
        krediOdemeBtn.addActionListener(new dinleyici());
    }
    public void krediBorcOde(String krediNo, String hesapNo) throws IOException{
        String Line, ödencekMiktar = null;
        BufferedReader reader = new BufferedReader(new FileReader("krediler.txt"));
        while ((Line = reader.readLine()) != null) {
            String[] arrOfStr = Line.split("@", 6);
            if(arrOfStr[0].equals(krediNo)){
                ödencekMiktar=arrOfStr[4];
                break;
            }
        }
        reader.close();
        
        fileProcedures x=new fileProcedures("hesaplar.txt", hesapNo, 3, 2, Integer.valueOf(ödencekMiktar), 0);
        if(x.veriDegisti){
            new fileProcedures("krediler.txt", krediNo, 6, 3, Integer.valueOf(ödencekMiktar), 0);
            new fileProcedures("krediler.txt", krediNo, 6, 5, 1, 0);

            Line=""; 
            String modifiedContent="";
            BufferedReader reader2 = new BufferedReader(new FileReader("krediler.txt"));
            while ((Line = reader2.readLine()) != null) {
                String arr[] = Line.split("@", 6);
                if(Integer.valueOf(arr[5])<=0){
                    new fileProcedures("users.txt", userBilgiler[0], 8, 5, 1, 0);
                }else{
                    modifiedContent+=Line+ System.lineSeparator();
                }
            }
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("krediler.txt"));
            writer2.write(modifiedContent);
            writer2.close();

            krediBorcPanel.removeAll();
            setKrediBorcPanel();
            krediBorcPanel.setVisible(true);
            hesaplariGosterPanel.removeAll();
            setHesaplariGosterPanel();
            hesaplariGosterPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Bakiye Yetersiz!", "Başarısız İşlem", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    public void krediBasvuru(String miktar, String vade, String krediTuru, String gelir){
        switch(krediTuru){
            case "İhtiyaç Kredisi":
                ihtiyacKredisi x = new ihtiyacKredisi(userBilgiler[0], Integer.valueOf(miktar), Integer.valueOf(vade), Integer.valueOf(gelir));
                if(x.uygunluk()){
                    x.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz krediye başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Konut Kredisi":
                konutKredisi y = new konutKredisi(userBilgiler[0], Integer.valueOf(miktar), Integer.valueOf(vade), Integer.valueOf(gelir));
                if(y.uygunluk()){
                    y.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz krediye başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Taşıt Kredisi":
                tasitKredisi z = new tasitKredisi(userBilgiler[0], Integer.valueOf(miktar), Integer.valueOf(vade), Integer.valueOf(gelir));
                if(z.uygunluk()){
                    z.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz krediye başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
        }
    }
    
    //kredi karti bölümü
    public void setKKPanel(){
        JLabel kkL;
        JButton kkBasvurBtn , kkBorcuBtn;
        kkPanel.setBackground(LIGHTGRAY);
        kkPanel.setBounds(180, 0, 420, 500);
        kkPanel.setLayout(null);
        musteriPage.add(kkPanel);
        kkPanel.setVisible(false);
        
        kkL         = new JLabel("Kredi Kartı");
        kkBasvurBtn = new JButton("Kredi Kartı Başvuru");
        kkBorcuBtn  = new JButton("Kredi Kartı Borç Ödeme");
        kkL.setFont(new Font("Serif", Font.BOLD, 18));
        kkBasvurBtn.setBackground(Color.WHITE);
        kkBorcuBtn.setBackground(Color.WHITE);
        kkPanel.add(kkL);
        kkPanel.add(kkBasvurBtn);
        kkPanel.add(kkBorcuBtn);
        kkL.setBounds(20,20,90,50);
        kkBorcuBtn.setBounds(30,80,180,30);
        kkBasvurBtn.setBounds(220,80,180,30);
        kkBasvurBtn.addActionListener(new dinleyici());
        kkBorcuBtn.addActionListener(new dinleyici());
    }
    public void setKKBorcPanel() throws IOException{
        int kkSayisi=Integer.parseInt(userBilgiler[7]), i=0;
        String[] kkNoArr = new String[kkSayisi];
        JButton kkOdemeBtn;
        JLabel baslik, baslik1, baslik2, baslik3, baslik4, baslik5, kkOdemeL, kkBorcL, kkTuruL;
        JLabel kkNo[] = new JLabel[kkSayisi], kkLimitArr[]= new JLabel[kkSayisi], 
               kkBorc[]= new JLabel[kkSayisi], kkTuru[]= new JLabel[kkSayisi];
        kkBorcPanel.setBackground(LIGHTGRAY);
        kkBorcPanel.setBounds(0, 120, 420, 360);
        kkBorcPanel.setLayout(null);
        kkPanel.add(kkBorcPanel);
        kkBorcPanel.setVisible(true);
        
        String Line, kkBilgileri[]= null;
        BufferedReader reader = new BufferedReader(new FileReader("kredikartlari.txt"));//0:kullanıcıid 1:türü 2:toplamborç 3:aylıktutar 4:taksitsayisi 
        while ((Line = reader.readLine()) != null && i<=kkSayisi) {
            kkBilgileri = Line.split("@", 5);
            if(kkBilgileri[1].equals(userBilgiler[0])){
                kkNoArr[i]=kkBilgileri[0];
                kkNo[i]    = new JLabel(kkBilgileri[0]);
                kkLimitArr[i] = new JLabel(kkBilgileri[2]+" tl");
                kkBorc[i]  = new JLabel(kkBilgileri[3]+" tl");
                kkTuru[i]  = new JLabel(kkBilgileri[4]);
                kkNo[i].setFont(new Font("Serif", Font.PLAIN, 12));
                kkLimitArr[i].setFont(new Font("Serif", Font.PLAIN, 12));
                kkBorc[i].setFont(new Font("Serif", Font.PLAIN, 12));
                kkTuru[i].setFont(new Font("Serif", Font.PLAIN, 12));
                kkBorcPanel.add(kkNo[i]);
                kkBorcPanel.add(kkLimitArr[i]);
                kkBorcPanel.add(kkBorc[i]);
                kkBorcPanel.add(kkTuru[i]);
                kkNo[i].setBounds(20,((i+1)*30)+40,100,30);
                kkLimitArr[i].setBounds(150,((i+1)*30)+40,100,30);
                kkBorc[i].setBounds(240,((i+1)*30)+40,150,30);
                kkTuru[i].setBounds(360,((i+1)*30)+40,150,30);
                i++;
            }
        }
        i=0;
        baslik      = new JLabel("Kredi Kartlarım");
        baslik1     = new JLabel("Kredi Kartı No");
        baslik2     = new JLabel("Limit"); 
        baslik3     = new JLabel("Harcanan Tutar");
        baslik4     = new JLabel("Ödenecek Miktar");
        baslik5     = new JLabel("Çekilecek Hesap");
        kkOdemeL    = new JLabel("Kredi Kartı No");
        kkBorcL     = new JLabel("Borç Ödeme");
        kkTuruL     = new JLabel("Kart Türü");
        baslik.setFont(new Font("Serif", Font.BOLD, 17));
        baslik1.setFont(new Font("Serif", Font.BOLD, 13));
        baslik2.setFont(new Font("Serif", Font.BOLD, 13));
        baslik3.setFont(new Font("Serif", Font.BOLD, 13));
        kkTuruL.setFont(new Font("Serif", Font.BOLD, 13));
        kkOdemeL.setFont(new Font("Serif", Font.PLAIN, 13));
        baslik4.setFont(new Font("Serif", Font.PLAIN, 13));
        baslik5.setFont(new Font("Serif", Font.PLAIN, 13));
        kklarıBox         = new JComboBox(kkNoArr);
        kkOdencekMiktar   = new JTextField(30);
        kkOdemeBtn        = new JButton("Öde");
        kkHesaplarımBox   = new JComboBox(hesapNoArr);
        kkOdemeBtn.setBackground(Color.WHITE);
        kkBorcPanel.add(baslik);
        kkBorcPanel.add(baslik1);
        kkBorcPanel.add(baslik2);
        kkBorcPanel.add(baslik3);
        kkBorcPanel.add(baslik4);
        kkBorcPanel.add(baslik5);
        kkBorcPanel.add(kkTuruL);
        kkBorcPanel.add(kkBorcL);
        kkBorcPanel.add(kkOdemeL);
        kkBorcPanel.add(kkHesaplarımBox);
        kkBorcPanel.add(kkOdencekMiktar);
        kkBorcPanel.add(kklarıBox);
        kkBorcPanel.add(kkOdemeBtn);
        baslik.setBounds(0,0,150,40);
        baslik1.setBounds(20,40,100,40);
        baslik2.setBounds(150,40,100,40);
        baslik3.setBounds(240,40,150,40);
        kkTuruL.setBounds(360,40,150,40);
        baslik4.setBounds(210,220,150,30);
        kkBorcL.setBounds(30,180,140,30);
        kkOdemeL.setBounds(50,220,140,30);
        kklarıBox.setBounds(50,250,150,30);
        baslik5.setBounds(50,280,140,30);
        kkHesaplarımBox.setBounds(50,310,150,30);
        kkOdencekMiktar.setBounds(210,250,120,30);
        kkOdemeBtn.setBounds(360,250,60,30);
        kkOdemeBtn.addActionListener(new dinleyici());
    }
    public void setKKBasvuruPanel(){
        String[] kkturleriArr={"Classic Kart", "Business Kart", "Premium Kart" };
        JLabel baslik, kkLimitL, maasL, kkTuruL;
        JButton kkBasvurBtn;
        kkBasvuruPanel.setBackground(LIGHTGRAY);
        kkBasvuruPanel.setBounds(0, 100, 420, 400);
        kkBasvuruPanel.setLayout(null);
        kkPanel.add(kkBasvuruPanel);
        kkBasvuruPanel.setVisible(false);
        
        baslik       = new JLabel("Kredi Kartı Başvuru");
        kkTuruL      = new JLabel("Kredi Kartı Türü");
        kkLimitL     = new JLabel("Talep Ettiğiniz Limit");
        maasL        = new JLabel("Yıllık Gelir");
        kkBasvurBtn  = new JButton("Başvur");
        kkLimit      = new JTextField(30);
        kkMaas       = new JTextField(30);
        kkTuruBox       = new JComboBox(kkturleriArr);
        baslik.setFont(new Font("Serif", Font.BOLD, 18));
        kkTuruL.setFont(new Font("Serif", Font.PLAIN, 14));
        kkLimitL.setFont(new Font("Serif", Font.PLAIN, 14));
        maasL.setFont(new Font("Serif", Font.PLAIN, 14));
        kkBasvurBtn.setBackground(Color.WHITE);
        kkBasvuruPanel.add(baslik);
        kkBasvuruPanel.add(kkBasvurBtn);
        kkBasvuruPanel.add(kkLimit);
        kkBasvuruPanel.add(kkMaas);
        kkBasvuruPanel.add(maasL);
        kkBasvuruPanel.add(kkTuruL);
        kkBasvuruPanel.add(kkLimitL);
        kkBasvuruPanel.add(kkTuruBox);
        baslik.setBounds(20,20,200,50);
        kkTuruL.setBounds(50,80,200,30);
        kkTuruBox.setBounds(50,110,150,30);
        kkLimitL.setBounds(50,140,200,30);
        kkLimit.setBounds(50,170,130,30);
        maasL.setBounds(50,200,150,30);
        kkMaas.setBounds(50,230,120,30);
        kkBasvurBtn.setBounds(50,280,130,30);
        kkBasvurBtn.addActionListener(new dinleyici());
    }
    public void kkBorcOde(String kkNo, String miktar, String hesapNo) throws IOException{
        fileProcedures x=new fileProcedures("hesaplar.txt", hesapNo, 3, 2, Integer.valueOf(miktar), 0);
        if(x.veriDegisti){
            new fileProcedures("kredikartlari.txt", kkNo, 5, 3, Integer.valueOf(miktar), 0);
            kkBorcPanel.removeAll();
            setKKBorcPanel();
            kkBorcPanel.setVisible(true);
            hesaplariGosterPanel.removeAll();
            setHesaplariGosterPanel();
            hesaplariGosterPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Bakiye Yetersiz!", "Başarısız İşlem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void kkBasvuruYap(String limit, String gelir, String kkTuru){
        switch(kkTuru){
            case "Classic Kart":
                classicCard x = new classicCard(userBilgiler[0], Integer.valueOf(limit), Integer.valueOf(gelir));
                if(x.uygunluk()){
                    x.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz karta başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Business Kart":
                businessCard y = new businessCard(userBilgiler[0], Integer.valueOf(limit), Integer.valueOf(gelir));
                if(y.uygunluk()){
                    y.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz karta başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case "Premium Kart":
                premiumCard z = new premiumCard(userBilgiler[0], Integer.valueOf(limit), Integer.valueOf(gelir));
                if(z.uygunluk()){
                    z.basvuruYap();
                }else{
                    JOptionPane.showMessageDialog(null, "Maalesef belirttiğiniz karta başvurmak için gereken şartları sağlamıyorsunuz!", "Başarısız Başvuru", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
        }
    }
    
    //fatura bolümü
    public void setFaturaPanel(){
        JButton faturaOdeBtn;
        JLabel faturaL, faturaNoL, faturaMiktarL, hesaplarL;
        faturaPanel.setBackground(LIGHTGRAY);
        faturaPanel.setBounds(180, 0, 420, 500);
        faturaPanel.setLayout(null);
        musteriPage.add(faturaPanel);
        faturaPanel.setVisible(false);
        
        faturaL       = new JLabel("Fatura Ödeme");
        faturaNoL     = new JLabel("Fatura No");
        faturaMiktarL = new JLabel("Ödenecek Miktar");
        faturaHesaplarımBox = new JComboBox(hesapNoArr);
        hesaplarL     = new JLabel("Hesap No");
        faturaNo      = new JTextField(30);
        faturaMiktar  = new JTextField(30);
        faturaOdeBtn  = new JButton("Fatura Öde");
        faturaOdeBtn.setBackground(Color.WHITE);
        faturaL.setFont(new Font("Serif", Font.BOLD, 18));
        faturaPanel.add(faturaL);
        faturaPanel.add(faturaNoL);
        faturaPanel.add(faturaMiktarL);
        faturaPanel.add(faturaNo);
        faturaPanel.add(faturaMiktar);
        faturaPanel.add(faturaOdeBtn);
        faturaPanel.add(hesaplarL);
        faturaPanel.add(faturaHesaplarımBox);
        faturaL.setBounds(20,20,200,50);
        faturaNoL.setBounds(60,80,200,30);
        faturaNo.setBounds(60,110,200,30);
        hesaplarL.setBounds(60,140,200,30);
        faturaHesaplarımBox.setBounds(60,170,200,30);
        faturaMiktarL.setBounds(60,200,200,30);
        faturaMiktar.setBounds(60,230,200,30);
        faturaOdeBtn.setBounds(80,280,160,30);
        faturaOdeBtn.addActionListener(new dinleyici());
    }
    public void faturaOde(String miktar, String faturaNo, String hesapNo) throws IOException{
        fileProcedures x = new fileProcedures("hesaplar.txt", hesapNo, 3, 2, Integer.valueOf(miktar), 0);
        if(x.veriDegisti){
            hesaplariGosterPanel.removeAll();
            setHesaplariGosterPanel();
            hesaplariGosterPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Bakiye Yetersiz!", "Başarısız İşlem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //bakiye bölümü
    public void setBakiyePanel(){
        JLabel bakiyeL;
        JButton hesaplarımıGosterBtn, paraGonderBtn;
        bakiyePanel.setBackground(LIGHTGRAY);
        bakiyePanel.setBounds(180, 0, 460, 500);
        bakiyePanel.setLayout(null);
        musteriPage.add(bakiyePanel);
        bakiyePanel.setVisible(false);
        
        bakiyeL              = new JLabel("Hesap İşlemleri");
        hesaplarımıGosterBtn = new JButton("Hesapları Göster");
        paraGonderBtn        = new JButton("Para Transferi");
        bakiyeL.setFont(new Font("Serif", Font.BOLD, 18));
        hesaplarımıGosterBtn.setBackground(Color.WHITE);
        paraGonderBtn.setBackground(Color.WHITE);
        bakiyePanel.add(bakiyeL);
        bakiyePanel.add(hesaplarımıGosterBtn);
        bakiyePanel.add(paraGonderBtn);
        bakiyeL.setBounds(20,20,120,50);
        hesaplarımıGosterBtn.setBounds(20,80,150,30);
        paraGonderBtn.setBounds(180,80,150,30);
        hesaplarımıGosterBtn.addActionListener(new dinleyici());
        paraGonderBtn.addActionListener(new dinleyici());
    }
    public void setHesaplariGosterPanel() throws IOException{
        int i=0;
        JLabel baslik, baslik1, baslik2;
        JLabel hesapTutari[]= new JLabel[hesapSayisi], hesapID[]= new JLabel[hesapSayisi];
        hesaplariGosterPanel.setBackground(LIGHTGRAY);
        hesaplariGosterPanel.setBounds(0, 100, 450, 400);
        hesaplariGosterPanel.setLayout(null);
        bakiyePanel.add(hesaplariGosterPanel);
        hesaplariGosterPanel.setVisible(true);
        
        String Line, hesapBilgileri[]= null;
        BufferedReader reader = new BufferedReader(new FileReader("hesaplar.txt"));//0:kullanıcıid 1:türü 2:toplamborç 3:aylıktutar 4:taksitsayisi 
        while ((Line = reader.readLine()) != null && i<=hesapSayisi) {
            hesapBilgileri = Line.split("@", 3);
            if(hesapBilgileri[1].equals(userBilgiler[0])){
                hesapNoArr[i]=String.valueOf(hesapBilgileri[0]);
                hesapTutari[i]       = new JLabel(hesapBilgileri[2]+" tl");
                hesapID[i]           = new JLabel(hesapBilgileri[0]);
                hesapTutari[i].setFont(new Font("Serif", Font.PLAIN, 16));
                hesapID[i].setFont(new Font("Serif", Font.PLAIN, 16));
                hesaplariGosterPanel.add(hesapTutari[i]);
                hesaplariGosterPanel.add(hesapID[i]);
                hesapID[i].setBounds(50,((i+1)*30)+80,200,30);
                hesapTutari[i].setBounds(220,((i+1)*30)+80,150,30);
                i++;
            }
        }
        i=0;
        
        baslik     = new JLabel("Hesaplarım");
        baslik1    = new JLabel("Hesap No");
        baslik2     = new JLabel("Bakiye");
        baslik.setFont(new Font("Serif", Font.BOLD, 18));
        baslik1.setFont(new Font("Serif", Font.BOLD, 15));
        baslik2.setFont(new Font("Serif", Font.BOLD, 15));
        hesaplariGosterPanel.add(baslik);
        hesaplariGosterPanel.add(baslik1);
        hesaplariGosterPanel.add(baslik2);
        baslik.setBounds(20,20,100,50);
        baslik1.setBounds(50,80,200,30);
        baslik2.setBounds(220,80,150,30);
        
        //bakiye ekleme bölümü
        JButton paraEkleBtn;
        JLabel hesapSecL, miktarL;
        hesapSecL = new JLabel("Hesap Numarası");
        miktarL   = new JLabel("Eklenecek Miktar");
        eklenecekMiktar    = new JTextField(30);
        paraEkleBtn    = new JButton("Para Ekle");
        hesaplarımBox1 = new JComboBox(hesapNoArr);
        hesapSecL.setFont(new Font("Serif", Font.BOLD, 14));
        miktarL.setFont(new Font("Serif", Font.BOLD, 14));
        paraEkleBtn.setBackground(Color.WHITE);
        hesaplariGosterPanel.add(hesapSecL);
        hesaplariGosterPanel.add(miktarL);
        hesaplariGosterPanel.add(paraEkleBtn);
        hesaplariGosterPanel.add(eklenecekMiktar);
        hesaplariGosterPanel.add(hesaplarımBox1);
        hesapSecL.setBounds(30,200,250,30);
        hesaplarımBox1.setBounds(30,230,160,30);
        miktarL.setBounds(30,270,200,30);
        eklenecekMiktar.setBounds(30,300,160,30);
        paraEkleBtn.setBounds(230,300,120,30);
        paraEkleBtn.addActionListener(new dinleyici());
    }
    public void setBakiyeGonderPanel(){
        bakiyeGonderPanel.setBackground(LIGHTGRAY);
        bakiyeGonderPanel.setBounds(0, 100, 450, 400);
        bakiyeGonderPanel.setLayout(null);
        bakiyePanel.add(bakiyeGonderPanel);
        bakiyeGonderPanel.setVisible(false);
        
        JButton paraEkleBtn;
        JLabel baslik, hesapSecL,gonderilcekHesapNoL, miktarL;
        baslik    = new JLabel("Para Transfer İşlemleri");
        hesapSecL = new JLabel("Hesap Numaranız");
        miktarL   = new JLabel("Gönderilecek Miktar");
        gonderilcekHesapNoL = new JLabel("Gönderilecek Hesap Numarası");
        gönderilcekMiktar   = new JTextField(30);
        gonderilcekHesapNo  = new JTextField(30);
        paraEkleBtn         = new JButton("Para Gönder");
        hesaplarımBox2      = new JComboBox(hesapNoArr);
        baslik.setFont(new Font("Serif", Font.BOLD, 18));
        hesapSecL.setFont(new Font("Serif", Font.PLAIN, 14));
        gonderilcekHesapNoL.setFont(new Font("Serif", Font.PLAIN, 14));
        miktarL.setFont(new Font("Serif", Font.PLAIN, 14));
        paraEkleBtn.setBackground(Color.WHITE);
        bakiyeGonderPanel.add(baslik);
        bakiyeGonderPanel.add(hesapSecL);
        bakiyeGonderPanel.add(miktarL);
        bakiyeGonderPanel.add(paraEkleBtn);
        bakiyeGonderPanel.add(gönderilcekMiktar);
        bakiyeGonderPanel.add(gonderilcekHesapNoL);
        bakiyeGonderPanel.add(gonderilcekHesapNo);
        bakiyeGonderPanel.add(hesaplarımBox2);
        baslik.setBounds(20,20,250,50);
        hesapSecL.setBounds(50,80,250,30);
        hesaplarımBox2.setBounds(50,110,160,30);
        gonderilcekHesapNoL.setBounds(50,140,200,30);
        gonderilcekHesapNo.setBounds(50,170,200,30);
        miktarL.setBounds(50,200,160,30);
        gönderilcekMiktar.setBounds(50,230,160,30);
        paraEkleBtn.setBounds(50,280,120,30);
        paraEkleBtn.addActionListener(new dinleyici());
    }
    public void paraEkle(String hesapNo, String miktar) throws IOException{
        new fileProcedures("hesaplar.txt", hesapNo, 3, 2, Integer.valueOf(miktar), 1);
        hesaplariGosterPanel.removeAll();
        setHesaplariGosterPanel();
        hesaplariGosterPanel.setVisible(true);
    }
    public void bakiyeTransfer(String gidenHesapNo, String gidecekHesapNo, String miktar) throws IOException{
        fileProcedures x=new fileProcedures("hesaplar.txt", gidenHesapNo, 3, 2, Integer.valueOf(miktar), 0);
        if(x.veriDegisti){
            new fileProcedures("hesaplar.txt", gidecekHesapNo, 3, 2, Integer.valueOf(miktar), 1);
            hesaplariGosterPanel.removeAll();
            setHesaplariGosterPanel();
            hesaplariGosterPanel.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Bakiye Yetersiz!", "Başarısız İşlem", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public class dinleyici implements ActionListener{
        @Override
  	public void actionPerformed(ActionEvent e){
            switch(((JButton) e.getSource()).getText()) {
                case "Kredi İşlemleri":
                    welcomePanel.setVisible(false);
                    kkPanel.setVisible(false);
                    faturaPanel.setVisible(false);
                    bakiyePanel.setVisible(false);
                    krediPanel.setVisible(true);
                    break;
                case "Kredi Kartı İşlemleri":
                    welcomePanel.setVisible(false);
                    faturaPanel.setVisible(false);
                    krediPanel.setVisible(false);
                    bakiyePanel.setVisible(false);
                    kkPanel.setVisible(true);
                    break;
                case "Fatura Ödeme":
                    welcomePanel.setVisible(false);
                    krediPanel.setVisible(false);
                    kkPanel.setVisible(false);
                    bakiyePanel.setVisible(false);
                    faturaPanel.setVisible(true);
                    break;
                case "Hesap İşlemleri":
                    welcomePanel.setVisible(false);
                    krediPanel.setVisible(false);
                    kkPanel.setVisible(false);
                    faturaPanel.setVisible(false);
                    bakiyePanel.setVisible(true);
                    break;
                case "Şifre Değişme":
                    setSifreDegis();
                    break;
                case "Şifre Değiştir":
                    try {
                        new fileProcedures("users.txt", userBilgiler[0], yeniSifreField.getText(), 8, 3);
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                //KREDİ İŞLEMLERİ-----------------------------------------
                
                
                //kredi işlemleri panelleri
                case "Kredi Başvuru":
                    krediBorcPanel.setVisible(false);
                    krediBasvuruPanel.setVisible(true);
                    break;
                case "Kredilerim":
                    krediBasvuruPanel.setVisible(false);
                    krediBorcPanel.setVisible(true);
                    break;
                //kredi işlemleri fonksiyonları
                case "Kredi Tablosu":
                {
                    try {
                        showKrediTablosu();
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "Krediye Başvur":
                    krediBasvuru(krediMiktar.getText(), krediVade.getText(), krediTurleriBox.getSelectedItem().toString(), krediMaas.getText());
                    break;
                case "Taksidi Öde":
                {
                    try {
                        krediBorcOde(odencekKredilerim.getSelectedItem().toString(), krediHesaplarımBox.getSelectedItem().toString());
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }

                //HESAP İŞLEMLERİ-----------------------------------------
                //hesap işlemleri panelleri
                case "Hesapları Göster":
                    bakiyeGonderPanel.setVisible(false);
                    hesaplariGosterPanel.setVisible(true);
                    break;
                case "Para Transferi":
                    hesaplariGosterPanel.setVisible(false);
                    bakiyeGonderPanel.setVisible(true);
                    break;
                //hesap işlemleri fonksiyonları
                case "Para Ekle":
                {
                    try {
                        paraEkle(hesaplarımBox1.getSelectedItem().toString(), eklenecekMiktar.getText());// hesapNo miktar
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }

                case "Para Gönder":
                {
                    try {
                        bakiyeTransfer(hesaplarımBox2.getSelectedItem().toString(), gonderilcekHesapNo.getText(), gönderilcekMiktar.getText());// gidenHesapNo gidecekHesapNo miktar
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }

                //FATURA İŞLEMLERİ-----------------------------------------
                case "Fatura Öde":
                {
                    try {
                        faturaOde(faturaMiktar.getText(), faturaNo.getText(), faturaHesaplarımBox.getSelectedItem().toString());// faturaNo miktar
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }

                //KREDİ KARTI İŞLEMLERİ-----------------------------------------
                //kredi kartı panelleri
                case "Kredi Kartı Başvuru":
                    kkBorcPanel.setVisible(false);
                    kkBasvuruPanel.setVisible(true);
                    break;
                case "Kredi Kartı Borç Ödeme":
                    kkBasvuruPanel.setVisible(false);
                    kkBorcPanel.setVisible(true);
                    break;
                //kredi kartı fonksiyonları
                case "Başvur":
                    kkBasvuruYap(kkLimit.getText(), kkMaas.getText(), kkTuruBox.getSelectedItem().toString());// limit maaş karttürü
                    break;
                case "Öde":
                {
                    try {
                        kkBorcOde(kklarıBox.getSelectedItem().toString(), kkOdencekMiktar.getText(), kkHesaplarımBox.getSelectedItem().toString());// kkno miktar hesapNo
                    } catch (IOException ex) {
                        Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        }
    }
    
    interface islemler{
        public boolean uygunluk();
        public void basvuruYap();
    }
    abstract class krediBasvur implements islemler{
        String id; 
        public int miktar, vade, gelir;
        public krediBasvur(String id, int miktar, int vade, int gelir){
            this.id=id;
            this.miktar=miktar;
            this.vade=vade;
            this.gelir=gelir;
        }
        public void krediBasvurusu(String turu, int krediMiktari) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter("kredibasvurular.txt", true));  
            writer.append(id+"@"+turu+"@"+miktar+"@"+krediMiktari+"@"+vade+"@"+gelir+"\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Başvurunuz Alınmıştır.", "Başarılı Başvuru", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    class ihtiyacKredisi extends krediBasvur{
        double faiz=1.18;
        int krediMiktari;
        public ihtiyacKredisi(String id, int miktar,int vade, int gelir){
            super(id, miktar, vade, gelir);
            krediMiktari=(int)(miktar*faiz);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(vade<=12 && miktar <=10000){
                uygun = krediMiktari <= (gelir/12)*vade;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                krediBasvurusu("İhtiyaç Kredisi", krediMiktari);
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class konutKredisi extends krediBasvur{
        double faiz=1.09;
        int krediMiktari;
        public konutKredisi(String id, int miktar,int vade, int gelir){
            super(id, miktar, vade, gelir);
            krediMiktari=(int)(miktar*faiz);
            System.out.print(krediMiktari);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(vade<=120 && miktar <=200000){
                uygun = krediMiktari <= (gelir/12)*vade;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                krediBasvurusu("Konut Kredisi", krediMiktari);
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class tasitKredisi extends krediBasvur{
        double faiz=1.27;
        int krediMiktari;
        public tasitKredisi(String id, int miktar,int vade, int gelir){
            super(id, miktar, vade, gelir);
            krediMiktari=(int)(miktar*faiz);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(vade<=48 && miktar <=80000){
                uygun = krediMiktari <= (gelir/12)*vade;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                krediBasvurusu("Taşıt Kredisi", krediMiktari);
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    abstract class kkBasvur implements islemler{
        String id; 
        public int limit, gelir;
        public kkBasvur(String id, int limit, int gelir){
            this.id=id;
            this.limit=limit;
            this.gelir=gelir;
        }
        public void kkBasvurusu(String turu) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter("kkbasvurular.txt", true));  
            writer.append(id+"@"+turu+"@"+limit+"@"+gelir+"\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Başvurunuz Alınmıştır.", "Başarılı Başvuru", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    class classicCard extends kkBasvur{
        public classicCard(String id, int limit, int gelir){
            super(id, limit, gelir);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(limit<=3000&&limit>=500){
                uygun = 24000 <= gelir;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                kkBasvurusu("Classic Kart");
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class businessCard extends kkBasvur{
        public businessCard(String id, int limit, int gelir){
            super(id, limit, gelir);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(limit>=3000&&limit<=80000){
                uygun = 100000 <= gelir;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                kkBasvurusu("Business Kart");
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class premiumCard extends kkBasvur{
        public premiumCard(String id, int limit, int gelir){
            super(id, limit, gelir);
        }
        @Override
        public boolean uygunluk(){
            boolean uygun;
            if(limit>=3000&&limit<=200000){
                uygun = 500000 <= gelir;
            }else{
                uygun = false;
            }
            return uygun;
        }
        @Override
        public void basvuruYap(){
            try {
                kkBasvurusu("Premium Kart");
            } catch (IOException ex) {
                Logger.getLogger(musteri.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

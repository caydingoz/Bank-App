package proje;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Proje extends JFrame{
    public static JFrame mainPage;
    public static JComboBox mevki;
    public static JButton loginPageBtn, signUpPageBtn, loginBtn, signUpBtn;
    public static JTextField tcnoLogin, tcno, username;
    public static JPasswordField passwordLogin, password, password2;
    public static JLabel header, tanim, tanim2, tcnoL, passwordL, passwordL2, usernameL, mevkiL;
    public static JPanel loginPanel = new JPanel();
    public static JPanel signUpPanel = new JPanel();
    public static JPanel tanimPanel = new JPanel();
    public static Color LIGHTGRAY= new Color(204,204,204);
    
    public Proje(){
        mainPage  = new JFrame("BANKA OTOMASYONU");
        mainPage.setSize(400 , 500);
        mainPage.getContentPane().setBackground(LIGHTGRAY);
        mainPage.setLayout(null);
        
        setWelcomePage();
        setLoginPage();
        setSignUpPage();
        
        mainPage.setVisible(true);
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void setWelcomePage(){
        tanimPanel.setBackground(LIGHTGRAY);
        tanimPanel.setBounds(0, 0, 400, 400);
        tanimPanel.setLayout(null);
        mainPage.add(tanimPanel);
        
        header       = new JLabel("Bankamıza Hoşgeldiniz", SwingConstants.CENTER);
        tanim        = new JLabel("Yapmak istediğiniz işlem için lütfen giriş yapınız. ", SwingConstants.CENTER);
        tanim2       = new JLabel("Eğer üye değilseniz burdan üye olabilirsiniz. ", SwingConstants.CENTER);
        loginPageBtn = new JButton("Giriş Yap");
        signUpPageBtn= new JButton("Kayıt Ol");
        header.setFont(new Font("Serif", Font.BOLD, 24));
        tanim.setFont(new Font("Serif", Font.PLAIN, 16));
        tanim2.setFont(new Font("Serif", Font.PLAIN, 16));
        loginPageBtn.setBackground(Color.WHITE);
        signUpPageBtn.setBackground(Color.WHITE);
        tanimPanel.add(header);
        tanimPanel.add(tanim);
        tanimPanel.add(tanim2);
        tanimPanel.add(loginPageBtn);
        tanimPanel.add(signUpPageBtn);
        header.setBounds(0,0,400,80);
        tanim.setBounds(0,100,400,40);
        loginPageBtn.setBounds(140,150,100,40);
        tanim2.setBounds(0,190,400,40);
        signUpPageBtn.setBounds(140,240,100,40);
        loginPageBtn.addActionListener(new dinleyici());
        signUpPageBtn.addActionListener(new dinleyici());
    }
    public static void setLoginPage(){
        loginPanel.setBackground(LIGHTGRAY);
        loginPanel.setBounds(0, 50, 400, 300);
        loginPanel.setLayout(null);
        mainPage.add(loginPanel);
        
        header    = new JLabel("Giriş Yap");
        tcnoL = new JLabel("Tc No :");
        passwordL = new JLabel("Password  :");
        tanim2 = new JLabel("Üye değilseniz", SwingConstants.CENTER);
        loginBtn  = new JButton("Giriş");
        signUpPageBtn  = new JButton("Kayıt Ol");
        signUpPageBtn.setBackground(Color.WHITE);
        loginBtn.setBackground(Color.WHITE);
        tcnoLogin  = new JTextField(30);
        passwordLogin  = new JPasswordField(30);
        header.setFont(new Font("Serif", Font.BOLD, 18));
        tanim2.setFont(new Font("Serif", Font.PLAIN, 16));
        tcnoL.setFont(new Font("Serif", Font.BOLD, 14));
        passwordL.setFont(new Font("Serif", Font.BOLD, 14));
        loginPanel.add(header);
        loginPanel.add(tcnoL);
        loginPanel.add(tcnoLogin);
        loginPanel.add(passwordL);
        loginPanel.add(passwordLogin);
        loginPanel.add(loginBtn);
        loginPanel.add(signUpPageBtn);
        loginPanel.add(tanim2);
        header.setBounds(20,0,80,40);
        tcnoL.setBounds(90,40,80,40);
        tcnoLogin.setBounds(140,45,120,30);
        passwordL.setBounds(65,80,80,40);
        passwordLogin.setBounds(140,85,120,30);
        loginBtn.setBounds(140,130,120,30);
        tanim2.setBounds(0,165,400,30);
        signUpPageBtn.setBounds(140,205,120,30);
        loginBtn.addActionListener(new dinleyici());
        signUpPageBtn.addActionListener(new dinleyici());
        loginPanel.setVisible(false);
    }
    public static void setSignUpPage(){
        String[] mevkiArr={"Banka Yöneticisi", "Banka Personeli", "Müşteri"};
        signUpPanel.setBackground(LIGHTGRAY);
        signUpPanel.setBounds(0, 50, 400, 400);
        signUpPanel.setLayout(null);
        mainPage.add(signUpPanel);
        
        header     = new JLabel("Kayıt Ol");
        tcnoL      = new JLabel("Tc No :");
        usernameL  = new JLabel("İsim Soyisim :");
        passwordL  = new JLabel("Password  :");
        passwordL2 = new JLabel("Password Again  :");
        mevkiL = new JLabel("Kullanıcı Türü  :");
        mevki      = new JComboBox(mevkiArr);
        signUpBtn  = new JButton("Kayıt");
        loginPageBtn  = new JButton("Giriş Yap");
        tanim2 = new JLabel("Üye iseniz", SwingConstants.CENTER);
        loginPageBtn.setBackground(Color.WHITE);
        signUpBtn.setBackground(Color.WHITE);
        tcno       = new JTextField(30);
        username   = new JTextField(30);
        password   = new JPasswordField(30);
        password2  = new JPasswordField(30);
        header.setFont(new Font("Serif", Font.BOLD, 18));
        tanim2.setFont(new Font("Serif", Font.PLAIN, 16));
        tcnoL.setFont(new Font("Serif", Font.BOLD, 14));
        usernameL.setFont(new Font("Serif", Font.BOLD, 14));
        passwordL.setFont(new Font("Serif", Font.BOLD, 14));
        passwordL2.setFont(new Font("Serif", Font.BOLD, 14));
        mevkiL.setFont(new Font("Serif", Font.BOLD, 14));
        signUpPanel.add(header);
        signUpPanel.add(tcnoL);
        signUpPanel.add(usernameL);
        signUpPanel.add(passwordL);
        signUpPanel.add(passwordL2);
        signUpPanel.add(tcno);
        signUpPanel.add(username);
        signUpPanel.add(password);
        signUpPanel.add(password2);
        signUpPanel.add(mevkiL);
        signUpPanel.add(mevki);
        signUpPanel.add(signUpBtn);
        signUpPanel.add(loginPageBtn);
        signUpPanel.add(tanim2);
        header.setBounds(20,0,80,40);
        tcnoL.setBounds(90,40,80,40);
        tcno.setBounds(140,45,120,30);
        usernameL.setBounds(45,80,180,40);
        username.setBounds(140,85,120,30);
        passwordL.setBounds(65,120,120,40);
        password.setBounds(140,125,120,30);
        passwordL2.setBounds(25,160,160,40);
        password2.setBounds(140,165,120,30);
        mevkiL.setBounds(30,200,120,40);
        mevki.setBounds(140,205,120,30);
        signUpBtn.setBounds(140,245,120,30);
        tanim2.setBounds(0,285,400,30);
        loginPageBtn.setBounds(140,325,120,30);
        signUpBtn.addActionListener(new dinleyici());
        loginPageBtn.addActionListener(new dinleyici());
        signUpPanel.setVisible(false);
    }
    public static class dinleyici implements ActionListener{
        @Override
  	public void actionPerformed(ActionEvent e){
            switch(((JButton) e.getSource()).getText()) {
                case "Giriş Yap":
                    openLoginPage();
                    break;
                case "Kayıt Ol":
                    openSignUpPage();
                    break;
                case "Giriş":
                {
                    try {
                        login();
                    } catch (IOException ex) {
                        Logger.getLogger(Proje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "Kayıt":
                {
                    try {
                        signUp();
                    } catch (IOException ex) {
                        Logger.getLogger(Proje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

            }
  	}
        public void openLoginPage(){
            tanimPanel.setVisible(false);
            signUpPanel.setVisible(false);
            loginPanel.setVisible(true);
        }
        public void openSignUpPage(){
            tanimPanel.setVisible(false);
            loginPanel.setVisible(false);
            signUpPanel.setVisible(true);
        }
        public void login() throws IOException{
            String[] userInfo = new String[2];
            userInfo[0]=tcnoLogin.getText();
            userInfo[1]=String.valueOf(passwordLogin.getPassword());
            try {
                loginSystem loginObj=new loginSystem(userInfo, 0);
                if(loginObj.isCorrect){
                    mainPage.dispose();
                    new userArayüz(userInfo[0]);
                    JOptionPane.showMessageDialog(null, "Başarıyla Giriş Yaptınız !", "Başarılı Giriş", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Şifreniz Yanlış !", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(Proje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public void signUp() throws IOException{
            if(String.valueOf(password.getPassword()).equals(String.valueOf(password2.getPassword()))){
                String[] registerInfo = new String[4];
                registerInfo[0]=tcno.getText();
                registerInfo[1]=username.getText();
                registerInfo[2]=String.valueOf(password.getPassword());
                registerInfo[3]=mevki.getSelectedItem().toString();
                try {
                    loginSystem loginObj=new loginSystem(registerInfo, 1);
                    if(loginObj.kayitDurumu){
                        mainPage.dispose();
                        new userArayüz(registerInfo[0]);
                        JOptionPane.showMessageDialog(null, "Başarıyla Kayıt Oldunuz ! Sisteme Hoşgeldiniz "
                                +username.getText(), "Başarılı Giriş", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Tc No Kayıtlı !", "Hatalı Kayıt", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Proje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Şifreler Eşleşmiyor !", "Hatalı Giriş", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public static void main(String[] args){
        new Proje();
        //JOptionPane.showMessageDialog(null, "Hatalı giriş !", "Hatalı giriş", JOptionPane.ERROR_MESSAGE);
    }
 
}

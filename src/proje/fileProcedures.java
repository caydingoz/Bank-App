package proje;
import java.io.*;
import javax.swing.JOptionPane;
//Overload
//1 : text dosyasında veriyi tamamen değiştirmek için
//2 : text dosyasında sayısal veriyi artırıp azaltmak için
public class fileProcedures { 
    public Boolean veriDegisti=false;
    public fileProcedures(String fileName, String id, String yeniVeri, int veriSayisi, int veriYeri) throws IOException{
        String Line, modifiedContent="", newLine="";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if(fileName.equals("users.txt")){ //ilk baştaki id verisini atlamak için
            Line = reader.readLine();
            modifiedContent+=Line+ System.lineSeparator();
         }
         while ((Line = reader.readLine()) != null) {
             String[] arrOfStr = Line.split("@", veriSayisi);
             if(arrOfStr[0].equals(id)){
                 newLine+=arrOfStr[0];
                 for(int a=1;a<veriSayisi;a++){
                     if(a==veriYeri){
                         arrOfStr[a]=yeniVeri;
                     }
                     newLine+="@"+arrOfStr[a];
                 }
                 modifiedContent+=newLine+ System.lineSeparator();
                 veriDegisti=true;
             }else{
                 modifiedContent+=Line+ System.lineSeparator();
             }
         }
         reader.close();
         BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));  
         writer.write(modifiedContent);  //idnin değişmiş halini yazdırdık
         writer.close();
        
    }
    public fileProcedures(String fileName, String id, int veriSayisi, int veriYeri, int miktar ,int mode) throws IOException{
        //mode 1: ekleme   0: çıkarma
        String Line, modifiedContent="", newLine="";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if(fileName.equals("users.txt")){ //ilk baştaki id verisini atlamak için
            Line = reader.readLine();
            modifiedContent+=Line+ System.lineSeparator();
         }
         while ((Line = reader.readLine()) != null) {
             String[] arrOfStr = Line.split("@", veriSayisi);
             if(arrOfStr[0].equals(id)){
                 newLine+=arrOfStr[0];
                 for(int a=1;a<veriSayisi;a++){
                     if(a==veriYeri){
                         if(mode==0){
                             if(Integer.valueOf(arrOfStr[a])<miktar){
                                 veriDegisti=false;
                             }else{
                                arrOfStr[a]=String.valueOf(Integer.valueOf(arrOfStr[a])- miktar);
                                 veriDegisti=true;
                             }
                         }else{
                            arrOfStr[a]=String.valueOf(Integer.valueOf(arrOfStr[a])+ miktar);
                         }
                     }
                     newLine+="@"+arrOfStr[a];
                 }
                 modifiedContent+=newLine+ System.lineSeparator();
             }else{
                 modifiedContent+=Line+ System.lineSeparator();
             }
         }
         reader.close();
         BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));  
         writer.write(modifiedContent);  //idnin değişmiş halini yazdırdık
         writer.close();
         
    }
}

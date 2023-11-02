package AOK;
//Andika Saktidana Hernadi - 235150207111029   
//Referensi : https://www.javatpoint.com 
//dibantu dengan chatGpt untuk proses perhitungan pengubahan bilangan
import java.util.Scanner;
public class tugas_aok {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int jawaban = 0;
        do{
            System.out.printf("""
                          ingin menghitung apa?
                          1. desimal ke biner
                          2. biner ke desimal
                          3. biner ke heksadesimal
                          4. heksadesimal ke biner
                          5. desimal ke hexadesimal
                          6. hexadesimal ke desimal
                          0. selesai
                          Masukkan angka sesuai keinginan anda: 
                          """);
            jawaban = in.nextInt();
            if(jawaban == 1){
                System.out.print("Masukkan bilangan desimal : ");
                in = new Scanner(System.in);
                int bilangan_desimal = in.nextInt();
                String biner = " ";
        
                while(bilangan_desimal>0){
                int sisa = bilangan_desimal%2;
                bilangan_desimal=bilangan_desimal/2;
                String stringsisa = Integer.toString(sisa);
                biner = stringsisa + biner;
            
            }System.out.printf("""
                            bilangan biner            = %s
                            """,biner);
            
            }else if(jawaban == 2){
                System.out.print("Masukkan bilangan biner : ");
                in = new Scanner(System.in);
                String biner = in.nextLine();//harus dalam bentuk String agar dapat diambil perdigit
                int bilangan_desimal = 0;
                int basis = 1;// 2 pangkat 0 adalah 1
                int panjang_biner = biner.length();
        
                for(int i = panjang_biner - 1; i>=0;i--){
                char digit = biner.charAt(i);
                if(digit=='1'){
                    bilangan_desimal=bilangan_desimal+basis;
                }
                basis=basis*2; //seiring berjalannya program basis akan dikali 2 sehingga sama saja dipangkatkan 2
                }System.out.printf("""
                           bilangan desimal = %d
                           """,bilangan_desimal);
                
            }else if(jawaban == 3){
                System.out.print("Masukkan bilangan biner : ");
                in = new Scanner(System.in);
                String biner = in.nextLine();
                int panjang_biner = biner.length();
                int sisa = panjang_biner%4;
        
                if (sisa !=0){ //menentukan apakah panjang biner habis dibagi 4
                sisa = 4-sisa;
                for(int i = 0; i<sisa;i++){//menambah bilangan 0 di depan angka biner sebanyak sisa agar bisa habis dibagi 4
                    biner = "0"+biner; 
                }
                }
                String hexa = " ";//menampung nilai hexa
                for (int i = 0; i < biner.length(); i += 4) { //Setiap iterasi loop, kita akan mengambil 4 bit dari string biner.
                String nibble = biner.substring(i, i + 4);  //mengambil 4  biner dari string biner
                int desimal = 0;// untuk menyimpan nilai desimal dimulai dari 0
        
                for (int j = 0; j < nibble.length(); j++) {
                    desimal = desimal * 2 + (nibble.charAt(j) - '0');// desimal akan menghasilkan angka int 1 sampai 15
                }
                char hexDigit = ' ';
                if (desimal >= 0 && desimal <= 9) {// menampilkan nilai hexa yang berupa angka
                    hexDigit = (char) ('0' + desimal);
                } else if (desimal >= 10 && desimal <= 15) {// menampilkan nilai hexa yang berupa huruf
                    hexDigit = (char) ('A' + (desimal - 10));
                }        
                hexa = hexa + hexDigit; //hexa akan menampung hasil dari if else
                }System.out.println("Heksadesimal: " + hexa);
                
            }else if(jawaban == 4){
                System.out.print("Masukkan bilangan heksadesimal : ");
                in = new Scanner(System.in);
                String heksa = in.nextLine().toUpperCase(); // Mengambil input heksadesimal dan mengubahnya menjadi huruf besar

                String biner = ""; // String untuk menyimpan hasil konversi biner

                // Membuat peta untuk mengonversi heksadesimal ke biner
                String[] heksa_ke_biner = {//nilai heksadesimal dari 0 hingga F.
                    "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"
                };

                for (int i = 0; i < heksa.length(); i++) {
                    char heksaDigit = heksa.charAt(i);

                    if (heksaDigit >= '0' && heksaDigit <= '9') {
                        int index = heksaDigit - '0'; // Mengambil indeks dari karakter heksadesimal
                        biner += heksa_ke_biner[index];
                    }else if (heksaDigit >= 'A' && heksaDigit <= 'F') {
                        int index = heksaDigit - 'A' + 10; // Mengambil indeks dari karakter heksadesimal
                        biner += heksa_ke_biner[index];
                    }else{
                    System.out.println("Input heksadesimal tidak valid.");
                    }
                }System.out.println("bilangan biner: " + biner);
                
            }else if(jawaban == 5){
                System.out.print("Masukkan bilangan desimal: ");
                in = new Scanner(System.in);
                int desimal = in.nextInt();

                if (desimal < 0) {
                    System.out.println("Bilangan desimal harus non-negatif.");
                }else if(desimal == 0) {
                    System.out.println("Heksadesimal: 0");
                }else{
                    String heksa = "";
                    while (desimal > 0) { //desimal akan dibagi terus sampai mencapai 0
                    int sisa = desimal % 16;
                    char heksaDigit;
                    if (sisa < 10) {
                        heksaDigit = (char) (sisa + '0');
                    }else{
                        heksaDigit = (char) (sisa - 10 + 'A');
                    }
                    heksa = heksaDigit + heksa;
                    desimal /= 16;
                    }System.out.println("bilangan heksadesimal: " + heksa);
                }
                
            }else if(jawaban == 6){
                System.out.print("Masukkan bilangan heksadesimal: ");
                in = new Scanner(System.in);
                String heksa = in.nextLine().toUpperCase();

                long desimal = 0;
                int pangkat = 0;

                for (int i = heksa.length() - 1; i >= 0; i--) {
                    char digit = heksa.charAt(i);//dari paling kanan
                    int nilaiDigit;

                if (digit >= '0' && digit <= '9') {
                    nilaiDigit = digit - '0';
                }else if(digit >= 'A' && digit <= 'F') {
                    nilaiDigit = digit - 'A' + 10;
                }else{
                    System.out.println("Input heksadesimal tidak valid.");
                    return;
                }
                desimal += nilaiDigit * Math.pow(16, pangkat);
                pangkat++;
                }System.out.println("bilangan desimal: " + desimal);
            }else if(jawaban == 0){
                System.out.println("terima kasih sudah memakai layanan kami");
                break;
            }else{
                System.out.println("maaf kami hanya melayani perhitungan itu saja");
            }
        }while(jawaban != 0);
        
    }
}

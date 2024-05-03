import java.util.Scanner;

import javax.print.attribute.standard.PageRanges;

import java.util.*;
abstract class Musik{
    private String judul;
    private String genre;
    private String artist;
    private String pencipta;
    private int tahun;

    protected Musik(String judul, String genre, String artist, String pencipta, int tahun){
        this.judul = judul;
        this.genre = genre;
        this.artist = artist;
        this.pencipta = pencipta;
        this.tahun = tahun;
    }
    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPencipta() {
        return this.pencipta;
    }

    public void setPencipta(String pencipta) {
        this.pencipta = pencipta;
    }

    public int getTahun() {
        return this.tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    abstract String getKategori();

}
class MusikOldschool extends Musik {
    protected MusikOldschool(String judul, String genre, String artist, String pencipta, int tahun){
        super(judul, genre, artist, pencipta, tahun);
    }
    @Override
    public String getKategori(){
        return "Oldschool";
    }
    
}
class MusikNew extends Musik{
    protected MusikNew(String judul, String genre, String artist, String pencipta, int tahun){
        super(judul, genre, artist, pencipta, tahun);
    }
    @Override
    public String getKategori(){
        return "New";
    }
}
class Playlist{
    private List<Musik> musik = new ArrayList<Musik>();

    public void tambahMusik(Musik m){
        this.musik.add(m);
    }
    public void hapusMusik(int index){
        try{
       this.musik.remove(index);
         }
       catch(Exception e){
           System.out.println("Musik tidak ditemukan");
       }
        }
    
    public void tampilPlaylist(){
    System.out.println("Playlist:");
    int i = 0;
    while (i < musik.size()) {
        Musik m = musik.get(i);
        if(m.getKategori().equalsIgnoreCase("New")){
            continue;
        }
        System.out.println((i+1) + ". Judul: " + m.getJudul());
        System.out.println("   Genre: " + m.getGenre());
        System.out.println("   Artist: " + m.getArtist());
        System.out.println("   Pencipta: " + m.getPencipta());
        System.out.println("   Tahun: " + m.getTahun());
        System.out.println("   Kategori: " + m.getKategori());
        i++;
    }
    System.out.println("Total lagu kamu: " + musik.size());
        
    }

}
abstract class Pelanggan implements Mendengarkan{
    private String kodePelanggan;
    private String nama;
    private String statusKeanggotaan;
    private Playlist playlist;
    protected Pelanggan(String kodePelanggan, String nama, String statusKeanggotaan){
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.statusKeanggotaan = statusKeanggotaan;
    }
    public String getKodePelanggan() {
        return this.kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatusKeanggotaan() {
        return this.statusKeanggotaan;
    }

    public void setStatusKeanggotaan(String statusKeanggotaan) {
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
    public void Lihat(int index){
        //implementasi

    
    }
    abstract void Mendengarkan();

}
class PelangganFree extends Pelanggan {
    // pelanggan free itu cuma bisa liat dan mendengarkan musik oldschool
    protected PelangganFree(String kodePelanggan, String nama, String statusKeanggotaan) {
        super(kodePelanggan, nama, statusKeanggotaan);
    }
    
    public void Mendengarkan(){
        //implementasi

    }
    
    public void ambilListLagu(){
        //implementsi

    }

}
class PelangganPremium extends Pelanggan{
    //pelanggan premium bisa liat dan mendengarkan musik oldschool dan new
    protected PelangganPremium(String kodePelanggan, String nama, String statusKeanggotaan) {
        super(kodePelanggan, nama, statusKeanggotaan);
    }

    public void Mendengarkan(){

    }

    public void ambilListLagu(){ 
        // implementasi

    }
}

interface Mendengarkan{
    public void ambilListLagu();
}
public class Main{
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pelanggan p = new PelangganFree("0000001", "Sandhika", "Free");
        Playlist playlist = new Playlist();
        
        while(true){
            System.out.println("Selamat datang " + p.getNama() + " di Spookyfy.");
            System.out.println("1. Tambah Musik");
            System.out.println("2. Hapus musik");
            System.out.println("3. Lihat playlist");
            if(p.getStatusKeanggotaan().equals("Free")){
                System.out.println("4. Upgrade ke premium");
            }
            else{
                System.out.println("4. Downgrade ke free");
            }
            System.out.println("5. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = sc.nextInt();

            if(pilihan == 1){
                System.out.println("Playlist " + p.getNama());
                System.out.print("Judul : ");
                String judul = sc.next();
                System.out.println();
                System.out.print("Genre : ");
                String genre = sc.next();
                System.out.println();
                System.out.print("Artist : ");
                String artist = sc.next();
                System.out.println();
                System.out.print("Pencipta : ");
                String pencipta = sc.next();
                System.out.println();
                System.out.print("Tahun : ");
                int tahun = sc.nextInt();
                System.out.println();
                if(2024 - tahun > 3){
                    Musik m = new MusikOldschool(judul, genre, artist, pencipta, tahun);
                    p.getPlaylist().tambahMusik(m);
                }
                else{
                    Musik m = new MusikNew(judul, genre, artist, pencipta, tahun);
                    p.getPlaylist().tambahMusik(m);
                }
            }
            if(pilihan == 2){
                playlist.tampilPlaylist();
                System.out.println("Hapus musik ke: ");
                int index = sc.nextInt();
                playlist.hapusMusik(index - 1);

            }
            if(pilihan == 3){
                playlist.tampilPlaylist();
                System.out.println("Lihat info musik ke- ");
                int index = sc.nextInt();
                p.Lihat(index - 1);
            }
            if(pilihan == 4){
                if(p.getStatusKeanggotaan().equals("Free")){
                    p = new PelangganPremium(p.getKodePelanggan(), p.getNama(), "Premium");
                    p.ambilListLagu();
                }
                else{
                    p = new PelangganFree(p.getKodePelanggan(), p.getNama(), "Free");
                    p.ambilListLagu();
                }
            }
            if(pilihan == 5){
                break;
            }
        }
        
    }

}   
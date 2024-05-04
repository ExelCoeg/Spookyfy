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
class DaftarOldschool{
    public List<Musik> oldschool = new ArrayList<Musik>();
    public void tambahOldschool(Musik m){
        this.oldschool.add(m);
    }
    public void hapusOldschool(int index){
        try{
            this.oldschool.remove(index);
        }
        catch(Exception e){
            System.out.println("Musik tidak ditemukan\n");
        }
    }
   public void tampilList(){
       System.out.println("Daftar Lagu Oldschool");
       for(int i = 0; i < this.oldschool.size(); i++){
           Musik m = this.oldschool.get(i);
           System.out.println((i+1) + ". " + m.getJudul());
       }
       
   }
}
class DaftarNew{
    public List<Musik> newmusik = new ArrayList<Musik>();
    public void tambahNew(Musik m){
        this.newmusik.add(m);
    }
    public void hapusNew(int index){
        try{
            this.newmusik.remove(index);
        }
        catch(Exception e){
            System.out.println("Musik tidak ditemukan\n");
        }
    }
    public void tampilList(){
        System.out.println("Daftar Lagu New: ");
        for(int i = 0; i < this.newmusik.size(); i++){
            Musik m = this.newmusik.get(i);
            System.out.println((i+1) + ". " + m.getJudul());
        }
    }
}
class Playlist{
    public List<Musik> musik = new ArrayList<Musik>();

    public void tambahMusik(Musik m){
        this.musik.add(m);
    }
    public void hapusMusik(int index){
        try{
       this.musik.remove(index);
         }
       catch(Exception e){
           System.out.println("Musik tidak ditemukan\n");
       }
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
        if(index >= 0 && index < this.playlist.musik.size()){
            Musik m = this.playlist.musik.get(index);
            System.out.println("Judul: " + m.getJudul());
            System.out.println("Genre: " + m.getGenre());
            System.out.println("Artist: " + m.getArtist());
            System.out.println("Pencipta: " + m.getPencipta());
            System.out.println("Tahun: " + m.getTahun());
            System.out.println("Kategori: " + m.getKategori());
        } else {
            System.out.println("Index tidak valid.");
        }
    }
    public void tampilPlaylist(){
        System.out.println("Playlist:");
        int i = 0;
        if(getPlaylist().musik.size() == 0){
            System.out.println("Playlist kosong.");
        }
        else{
            while (i < getPlaylist().musik.size()) {
                Musik m = getPlaylist().musik.get(i);
                System.out.println((i+1) + ". Judul: " + m.getJudul());
                System.out.println("   Genre: " + m.getGenre());
                System.out.println("   Artist: " + m.getArtist());
                System.out.println("   Pencipta: " + m.getPencipta());
                System.out.println("   Tahun: " + m.getTahun());
                System.out.println("   Kategori: " + m.getKategori());
                i++;
            }
            System.out.println("Total lagu kamu: " + getPlaylist().musik.size());
            System.out.println();
        }
    }
    abstract void Mendengarkan();
}
class PelangganFree extends Pelanggan {
    // pelanggan free itu cuma bisa liat dan mendengarkan musik oldschool
    protected PelangganFree(String kodePelanggan, String nama, String statusKeanggotaan) {
        super(kodePelanggan, nama, statusKeanggotaan);
    }
    
    public void Mendengarkan(){
        for(Musik m : this.getPlaylist().musik){
            if(m.getKategori().equals("Oldschool")){
                System.out.println("Mendengarkan " + m.getJudul());
            } else if(m.getKategori().equals("New")){
                System.out.println("Maaf, sebagai pelanggan free, Anda tidak dapat mendengarkan musik " + m.getJudul());
            }
        }
    }
    
    public void ambilListLagu(){
        System.out.println("List Lagu yang dapat didengar: ");
        for(Musik m : this.getPlaylist().musik){
            if(m.getKategori().equals("Oldschool")){
                System.out.println(m.getJudul());
            }
        }
    }
   
}
class PelangganPremium extends Pelanggan{
    //pelanggan premium bisa liat dan mendengarkan musik oldschool dan new
    protected PelangganPremium(String kodePelanggan, String nama, String statusKeanggotaan) {
        super(kodePelanggan, nama, statusKeanggotaan);
    }

    public void Mendengarkan(){
        for(Musik m : this.getPlaylist().musik){
            System.out.println("Mendengarkan " + m.getJudul());
        }
    }

    public void ambilListLagu(){ 
        System.out.println("List Lagu yang dapat didengar: ");
        for(Musik m : this.getPlaylist().musik){
            System.out.println(m.getJudul());
        }
    }
}

interface Mendengarkan{
    public void ambilListLagu();
}
public class Main{
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pelanggan p = new PelangganFree("0000001", "Sandhika", "Free");
        DaftarOldschool d = new DaftarOldschool();
        DaftarNew d2 = new DaftarNew();
       // Menambahkan 5 lagu New secara manual
        d2.tambahNew(new MusikNew("Shape of You", "Pop", "Ed Sheeran", "Ed Sheeran, Steve Mac, Johnny McDaid", 2017));
        d2.tambahNew(new MusikNew("Uptown Funk", "Funk", "Mark Ronson ft. Bruno Mars", "Mark Ronson, Jeff Bhasker, Bruno Mars", 2014));
        d2.tambahNew(new MusikNew("Blinding Lights", "Pop", "The Weeknd", "The Weeknd, Max Martin, Oscar Holter", 2019));
        d2.tambahNew(new MusikNew("Thinking Out Loud", "Pop", "Ed Sheeran", "Ed Sheeran, Amy Wadge", 2014));
        d2.tambahNew(new MusikNew("Despacito", "Reggaeton", "Luis Fonsi ft. Daddy Yankee", "Luis Fonsi, Daddy Yankee, Erika Ender", 2017));

        // Menambahkan 5 lagu Oldschool secara manual
        d.tambahOldschool(new MusikOldschool("Bohemian Rhapsody", "Rock", "Queen", "Freddie Mercury", 1975));
        d.tambahOldschool(new MusikOldschool("Hotel California", "Rock", "Eagles", "Don Felder, Glenn Frey, Don Henley", 1976));
        d.tambahOldschool(new MusikOldschool("Stairway to Heaven", "Rock", "Led Zeppelin", "Jimmy Page, Robert Plant", 1971));
        d.tambahOldschool(new MusikOldschool("Sweet Child o' Mine", "Rock", "Guns N' Roses", "Axl Rose, Slash", 1987));
        d.tambahOldschool(new MusikOldschool("Smells Like Teen Spirit", "Grunge", "Nirvana", "Kurt Cobain", 1991));

        p.setPlaylist(new Playlist());
        while(true){
            System.out.println("Selamat datang " + p.getNama() + " di Spookyfy.");
            System.out.println("1. Tambah Musik");
            System.out.println("2. Hapus musik");
            System.out.println("3. Lihat Playlist");
            if(p.getStatusKeanggotaan().equals("Free")){
                System.out.println("4. Upgrade ke premium");
            }
            else{
                System.out.println("4. Downgrade ke free");
            }
            System.out.println("5. Mendengarkan Musik");
            System.out.println("6. List Lagu yang dapat didengar");
            System.out.println("7. Keluar");
            System.out.print("Pilihan : ");
            int pilihan = sc.nextInt();

            if(pilihan == 1){
                System.out.println("1. Musik Oldschool");
                System.out.println("2. Musik New");
                System.out.print("Pilihan : ");
                int pilihan2 = sc.nextInt();
                if(pilihan2 == 1){
                    d.tampilList();
                    System.out.print("Pilih musik: ");
                    int index = sc.nextInt();
                    Musik m = d.oldschool.get(index-1);
                    p.getPlaylist().tambahMusik(m);
                }
                if(pilihan2 == 2){
                    d2.tampilList();
                    System.out.print("Pilih musik: ");
                    int index = sc.nextInt();
                    Musik m = d2.newmusik.get(index-1);
                    p.getPlaylist().tambahMusik(m);
                }
                System.out.println("Musik berhasil ditambahkan ke playlist.\n");
            }
            if(pilihan == 2){
                p.tampilPlaylist();
                System.out.print("Pilih musik: ");
                int index = sc.nextInt();
                p.getPlaylist().hapusMusik(index);
                System.out.println();
            }
            if(pilihan == 3){
                p.tampilPlaylist();
            }
            if(pilihan == 4){
                if(p.getStatusKeanggotaan().equals("Free")){
                    Playlist temp = p.getPlaylist();
                    p = new PelangganPremium(p.getKodePelanggan(), p.getNama(), "Premium");
                    p.setPlaylist(temp);
                }
                else{
                    Playlist temp = p.getPlaylist();
                    p = new PelangganFree(p.getKodePelanggan(), p.getNama(), "Free");
                    p.setPlaylist(temp);
                }
            }
            if(pilihan==5){
                p.Mendengarkan();
            }
            if(pilihan == 6){
                p.ambilListLagu();
            }
            if(pilihan == 7){
                break;
            }
        }
    }
}   
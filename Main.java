class Bank {
    
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    protected int hitungBiayaTransfer(String bankTujuan) {
        return 6500; 
    }

    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " berhasil diproses.");
        System.out.println("Biaya Transfer: Rp0 (Sesama Bank)");
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " berhasil diproses.");
        System.out.println("Biaya Transfer: Rp" + biaya + " (Antar Bank)");
        System.out.println("Total yang dipotong: Rp" + (jumlah + biaya));
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " berhasil diproses.");
        System.out.println("Berita: " + berita);
        System.out.println("Biaya Transfer: Rp" + biaya + " (Antar Bank)");
        System.out.println("Total yang dipotong: Rp" + (jumlah + biaya));
    }
}

class BankBNI extends Bank {
    
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI"; 
        int biaya = 0; 
        
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " berhasil diproses.");
        System.out.println("Biaya Transfer: Rp" + biaya + " (Bebas Biaya Sesama BNI)");
    }
}

class BankBCA extends Bank {
    
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA"; 
        int biaya = 0; 
        
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di Bank " + bankTujuan + " berhasil diproses.");
        System.out.println("Biaya Transfer: Rp" + biaya + " (Bebas Biaya Sesama BCA)");
    }
}

class Main {
    public static void main(String[] args) {
        Bank bankUmum = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("==== UJI KELAS BANK UMUM ====");
        bankUmum.sukuBunga();
        bankUmum.transferUang(50000, "11112222");
        bankUmum.transferUang(100000, "33334444", "Mandiri");
        bankUmum.transferUang(150000, "55556666", "BRI", "Pembayaran Buku Kuliah");

        System.out.println("\n==== UJI KELAS BANK BNI ====");
        bni.sukuBunga();
        bni.transferUang(200000, "77778888", "Mandiri"); 

        System.out.println("\n==== UJI KELAS BANK BCA ====");
        bca.sukuBunga();
        bca.transferUang(300000, "99990000", "BRI");
    }
}
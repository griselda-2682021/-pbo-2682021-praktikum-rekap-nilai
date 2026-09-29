import java.util.Scanner;

public class RekapNilai {
    // Pembacaan nilai memakai do-while dengan sentinel -1
    // Dipilih karena nilai pertama wajib diminta dulu sebelum diperiksa oleh kondisi perulangan.
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pencacahNilai = 1;
        int nilai;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.\n");

        do {
            System.out.print("Nilai ke-" + pencacahNilai + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            // Sementara cetak ulang nilai yang dimasukkan
            System.out.println("Nilai diterima: " + nilai);
            pencacahNilai++;

        } while (true);

        input.close();
    }
}
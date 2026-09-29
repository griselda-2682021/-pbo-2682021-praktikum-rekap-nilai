import java.util.Scanner;

public class RekapNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double total = 0;
        int jumlahSah = 0;
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

            // Nilai di luar 0-100 ditolak dengan continue, pencacah tidak ikut naik
            if (nilai < 0 || nilai > 100) {
                System.out.println("ditolak - nilai harus 0..100");
                continue;
            }

            // Akumulator total dengan augmented assignment
            total += nilai;
            jumlahSah++;

            pencacahNilai++;

        } while (true);

        System.out.println("\nNilai sah : " + jumlahSah);
        if (jumlahSah > 0) {
            System.out.println("Rata-rata : " + (total / jumlahSah));
        }

        input.close();
    }
}
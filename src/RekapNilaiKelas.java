import java.util.Scanner;

public class RekapNilai {
    // Pembacaan nilai memakai do-while dengan sentinel -1
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

            if (input.hasNextInt()) {
                nilai = input.nextInt();

                if (nilai == SELESAI) {
                    break;
                }

                // Nilai di luar 0-100 ditolak dengan continue
                if (nilai < 0 || nilai > 100) {
                    System.out.println("ditolak - nilai harus 0..100");
                    continue;
                }

                // Akumulator total memakai augmented assignment
                total += nilai;
                jumlahSah++;

                // Grade ditentukan dengan ladder if / else
                char grade;
                if (nilai >= 90) {
                    grade = 'A';
                } else if (nilai >= 80) {
                    grade = 'B';
                } else if (nilai >= 70) {
                    grade = 'C';
                } else if (nilai >= 60) {
                    grade = 'D';
                } else {
                    grade = 'E';
                }

                // Keterangan grade memakai switch lambda (Java 14+)
                String keterangan = switch (grade) {
                    'A' -> "Sangat Baik";
                    'B' -> "Baik";
                    'C' -> "Cukup";
                    'D' -> "Kurang";
                    default -> "Tidak Lulus";
                };

                System.out.println("Grade " + grade + " - " + keterangan);
                pencacahNilai++;

            } else {
                input.next();
            }

        } while (true);

        System.out.println("\n------------------------------");
        System.out.println("Nilai sah      : " + jumlahSah);

        // Jaga kasus tidak ada nilai sah sama sekali supaya tidak terjadi pembagian dengan nol
        if (jumlahSah > 0) {
            double rata = total / jumlahSah;
            // Status kelas ditentukan dengan ternary
            String status = (rata >= 60) ? "LULUS" : "TIDAK LULUS";

            System.out.println("Rata-rata      : " + String.format("%.2f", rata));
            System.out.println("Status         : " + status);
        } else {
            System.out.println("Rata-rata      : 0,00");
            System.out.println("Status         : TIDAK LULUS");
        }

        input.close();
    }
}
package Array;

import java.util.ArrayList;

public class TimSoNguyenTo {
    public void sieveOfEratosthenes(int n) {
        ArrayList<Boolean> isPrimes = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            isPrimes.add(true);
        }

        // Thuật toán sàng lọc để đánh dấu các số không phải là số nguyên tố
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrimes.get(i)) {
                // Nếu i là số nguyên tố, đánh dấu tất cả bội số của i là không phải số nguyên tố
                for (int j = i * i; j <= n; j += i) {
                    isPrimes.set(j, false);
                }
            }
        }

        // In ra các số nguyên tố từ 2 đến n
        System.out.println("Các số nguyên tố từ 2 đến " + n + " là:");
        for (int i = 2; i <= n; i++) {
            if (isPrimes.get(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        TimSoNguyenTo a = new TimSoNguyenTo();
        a.sieveOfEratosthenes(10000);
    }
}

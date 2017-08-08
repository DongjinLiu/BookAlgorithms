import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double staMean;
    private final double staStddev;
    private final int t;

    public PercolationStats(int n, int trivals) {
        if (n <= 0)
            throw new IllegalArgumentException();
        if (trivals <= 0)
            throw new IllegalArgumentException();
        double[] sta = new double[trivals];
        this.t = trivals;
        int x, y;
        int count;
        for (int i = 0; i < trivals; i++) {
            Percolation p = new Percolation(n);
            count = 0;
            while (true) {
                if (n > 1) {
                    x = StdRandom.uniform(n) + 1;
                    y = StdRandom.uniform(n) + 1;
                } else {
                    x = 1;
                    y = 1;
                }
                if (p.isOpen(x, y)) {
                    continue;
                } else {
                    p.open(x, y);
                    count++;
                }
                if (p.percolates()) {
                    sta[i] = (double) count / (n * n);
                    break;
                }
            }
        }
        this.staMean = StdStats.mean(sta);
        this.staStddev = StdStats.stddev(sta);
    }

    public double mean() {
        return this.staMean;
    }

    public double stddev() {
        return this.staStddev;
    }

    public double confidenceLo() {
        return this.staMean - 1.96 * this.staStddev / Math.sqrt(this.t);
    }

    public double confidenceHi() {
        return this.staMean + 1.96 * this.staStddev / Math.sqrt(this.t);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PercolationStats p = new PercolationStats(64, 150);
        System.out.println("mean=" + p.mean());
        System.out.println("stddev=" + p.stddev());
        System.out.println("[" + p.confidenceLo() + "," + p.confidenceHi() + "]");
    }

}

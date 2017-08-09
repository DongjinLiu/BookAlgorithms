import edu.princeton.cs.algs4.WeightedQuickUnionUF;
/**
 * Homework week1
 * @author jin
 * Date 2017/8/8
 * Grade 81/100
 */
public class Percolation {

    private final int n;
    private final WeightedQuickUnionUF uf;
    private boolean[] open;
    private int numberOfOpenSites;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        numberOfOpenSites = 0;
        uf = new WeightedQuickUnionUF(n * n + 2);
        open = new boolean[n * n + 2];
        for (int i = 0; i < n * n + 2; i++) {
            open[i] = false;
        }
    }

    public void open(int row, int col) {
        if (n == 1 && row == 1 && col == 1) {
            uf.union(0, 1);
            open[1] = true;
            numberOfOpenSites++;
            return;
        }
        check(row, col);
        if (isOpen(row, col)) {
            return;
        }
        open[(row - 1) * n + col] = true;
        numberOfOpenSites++;
        if (col > 1 && col < n && row == 1) {

            uf.union(0, (row - 1) * n + col);

            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        } else if (col > 1 && col < n && row == n) {
            if (isOpen(row, col - 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col - 1));
            }
            if (isOpen(row, col + 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col + 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
        } else if (row > 1 && row < n && col == 1) {
            if (isOpen(row, col + 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col + 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        } else if (row > 1 && row < n && col == n) {
            if (isOpen(row, col - 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col - 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        } else if (row == 1 && col == 1) {
            uf.union(0, (row - 1) * n + col);
            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        } else if (row == 1 && col == n) {
            uf.union(0, (row - 1) * n + col);
            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        } else if (row == n && col == 1) {
            if (isOpen(row, col + 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col + 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
        } else if (row == n && col == n) {
            if (isOpen(row, col - 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col - 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
        } else {
            if (isOpen(row, col + 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col + 1));
            }
            if (isOpen(row, col - 1)) {
                uf.union((row - 1) * n + col, (row - 1) * n + (col - 1));
            }
            if (isOpen(row - 1, col)) {
                uf.union((row - 1) * n + col, (row - 2) * n + col);
            }
            if (isOpen(row + 1, col)) {
                uf.union((row - 1) * n + col, row * n + col);
            }
        }

    }

    public boolean isOpen(int row, int col) {
        check(row, col);
        return open[(row - 1) * n + col];
    }

    public boolean isFull(int row, int col) {
        check(row, col);
        return uf.connected(0, (row - 1) * n + col);
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        for (int i = 0; i < n; i++) {
            if (isFull(n, i + 1)) {
                uf.union((n - 1) * n + i + 1, n * n + 1);
            }
        }

        return uf.connected(0, n * n + 1) || (n == 1 && this.open[1]);
    }

    private void check(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Percolation p = new Percolation(1);
        p.open(1, 1);
        System.out.println(p.isOpen(1, 1));
        System.out.println(p.percolates());
    }
}
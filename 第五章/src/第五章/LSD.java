package 第五章;

/**
 * 低位优先的字符串排序，基于键索引计数法，适用于长度相同的字符串排序
 * 
 * @author jin
 *
 */
public class LSD {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;// 字符表中的数量
        String[] aux = new String[N];// 辅助数组

        // 根据第d个字符用键索引计数法
        for (int d = W - 1; d >= 0; d--) {

            // 计算出键的频率
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // 将频率转为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // 将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // 回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

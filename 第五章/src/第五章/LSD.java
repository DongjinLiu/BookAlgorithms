package ������;

/**
 * ��λ���ȵ��ַ������򣬻��ڼ������������������ڳ�����ͬ���ַ�������
 * 
 * @author jin
 *
 */
public class LSD {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;// �ַ����е�����
        String[] aux = new String[N];// ��������

        // ���ݵ�d���ַ��ü�����������
        for (int d = W - 1; d >= 0; d--) {

            // ���������Ƶ��
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // ��Ƶ��תΪ����
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // ��Ԫ�ط���
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // ��д
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

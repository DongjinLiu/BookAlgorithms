package µÚÒ»ÕÂÊ¾Àı;

public class QuickUnionUF {

	public int[] id;
	public int count;
	public QuickUnionUF(int n) {
		count=n;
		id=new int[n];
		for(int i=0;i<n;i++) {
			id[i]=i;
		}
	}
	public int count() {
		return count;
	}
	public int find(int p) {
		while(p!=id[p]) {
			p=id[p];
		}
		return p;
	}
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	public void union(int p,int q) {
		if(connected(p,q)) {
			return ;
		}else {
			id[find(q)]=find(p);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickUnionUF uf=new QuickUnionUF(10);
		uf.union(6, 5);
		uf.union(4, 3);
		uf.union(9, 4);
		uf.union(9, 2);
		System.out.println(uf.connected(5,9));
		uf.union(5, 3);
		System.out.println(uf.connected(5,9));
	}

}

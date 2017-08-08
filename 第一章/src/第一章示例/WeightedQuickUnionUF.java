package 第一章示例;

public class WeightedQuickUnionUF {

	private int[] id;
	private int count;
	private int[] size;
	
	public WeightedQuickUnionUF(int n) {
		id=new int[n];
		count=n;
		size=new int[n];
		for(int i=0;i<n;i++) {
			id[i]=i;
			size[i]=1;
		}
	}
	
	public int root(int p) {
		while(p!=id[p]) {
			id[p]=id[id[p]];//压缩树的深度
			p=id[p];
		}
		return p;
	}
	
	public void union(int p,int q) {
		int proot=root(p);
		int qroot=root(q);
		if(proot==qroot) {
			return;
		}else {
			//将小树添加到大树上
			if(size[proot]>size[qroot]) {
				id[qroot]=proot;
				size[proot]+=size[qroot];
			}else {
				id[proot]=qroot;
				size[qroot]+=size[proot];
			}
			count--;
		}
	}
	
	public boolean connected(int p,int q) {
		return root(p)==root(q);
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeightedQuickUnionUF uf=new WeightedQuickUnionUF(10);
		uf.union(6, 5);
		uf.union(4, 3);
		uf.union(9, 4);
		uf.union(9, 2);
		System.out.println(uf.connected(3, 9));
	}

}

package µÚÒ»ÕÂÊ¾Àı;

public class QuickFindUF {

	int[] id;
	int count;
	
	public QuickFindUF(int n) {
		count=n;
		id=new int[n];
		for(int i=0;i<n;i++) {
			id[i]=i;
		}
	}
	
	public int find(int p) {
		return id[p];
	}
	
	public boolean connected(int p,int q) {
		return find(p)==find(q);
	}
	
	public int count() {
		return count;
	}
	
	public void union(int p,int q) {
		if(connected(p,q)) {
			return;
		}else {
			int pid=id[p];
			int qid=id[q];
			for(int i=0;i<count;i++) {
				if(id[i]==pid) {
					id[i]=qid;
				}
			}
			count--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickFindUF uf=new QuickFindUF(7);
		uf.union(3, 5);
		System.out.println(uf.connected(3,5));
	}

}

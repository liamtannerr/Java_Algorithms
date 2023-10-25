// number operations to convert str1 to str2
// First need to compile it in terminal: 
		//javac EditDist.java
// In order to run it in terminal: 
		//java EditDist str1 str2
class EditDist {
	
	static int min(int x, int y, int z) {
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	static int editDistDP(String str1, String str2, int m, int n){
		// Create a table to store results of subproblems
		//System.out.println(str1.length());
		//System.out.println(str2.length());
		if( str1.equals(str2) || (m == 0 && n == 0)){
			return 0;
		}
		if(m == 0){
			return n;
		}
		if(n == 0){
			return m;
		}
		if((n == 1) && (m == 1)){
			return 1;
		} 

		int D[][] = new int[m + 1][n + 1];
		int char_dif;
		//TODO fill matrix D 
			//1. Find the base subproblems: D[i][0] and D[0][j]
			D[0][0] = 0;
				for(int i = 0; i < m; i++){
						D[i + 1][0] = D[i][0]+1;	
				}
				for(int j = 0; j < n; j++){
						D[0][j + 1] = D[0][j] + 1;	
				}
				
			//2. Update matrix D for bigger subproblems.
				//2.1 If their last characters are the same.
				//2.2 If their last characters are different
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(str1.charAt(i-1) != str2.charAt(j-1)){
					char_dif = 1;
				} else {
					char_dif = 0;
				}
				D[i][j] = min(D[i][j-1] + 1, D[i-1][j] + 1, D[i-1][j-1] + char_dif);
				//System.out.println(D[i][j]);
			}
		}

		return D[m][n];
	}

	

	public static void main(String args[]){

		String str1 = args[0];
		String str2 = args[1];
		System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));
	}
} 


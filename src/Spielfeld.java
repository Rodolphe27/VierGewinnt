
public class Spielfeld {
	
	private int z;
	private int s;
	private int[] line;
	private int[][] feld;
	
	
	Spielfeld(int z,int s){
		feld = new int[z][s];
		this.s=s;
		this.z=z;
		
		line= new int[s];
		for(int i=0; i<s; i++){
			line[i]=z;
		}
	}
	
	
    public void output() {
    	for(int i=0;i<z;i++) {
    		System.out.print(i+1+"|");
    		for(int j=0;j<s;j++) {
    			if(feld[i][j]==1) {
    			System.out.print("\u001B[32m"+feld[i][j]+"\u001B[0m"+"|");
    		}
    			else if(feld[i][j]==2) {
        			System.out.print("\u001B[31m"+feld[i][j]+"\u001B[0m"+"|");

    			}else {
    			System.out.print(feld[i][j]+"|");
    			}
    		}
    		System.out.println();
   }
    	System.out.println("  -------------");
    	System.out.print("  ");

    	for(int i=1;i<=s;i++) {
    		System.out.print(i+" ");
    	}
    	System.out.println(); 	
    }
    
    public boolean setzeStein(int num, int c) {
     if(c <=feld[0].length && c>0) {
    	if(line[c-1]>0 && line[c-1]<=feld.length) {
    		if(feld[line[c-1]-1][c-1]==0) {
    			feld[--line[c-1]][c-1]=num;
    			return true;
    			
    			}
    		}
       }
    	return false;
    	
    }
   
    
   /* public boolean setzeStein(int num,int c) {
    	if(copieZiele>0) {
    		if(feld[copieZiele-1][c-1]==0) {
    			feld[--copieZiele][c-1]=num;
    			return true;
    		}
    	}return false;
    }*/
  public boolean testeSieg(int num) {
            for (int i = 0; i < z; i++) {
                for (int j = 0; j < s; j++) {
                    if (checkConsecutive(num, i, j)) {
                        return true;
                    }
                }
            }

            return false;
        }

   private boolean checkConsecutive(int num, int row, int col) {
	   if( horizontal(num, row, col) || vertical( num, row,col)||
					   diagonal ( num, row, col))
	   {
		   return true;
		   }
	    return false;
   }
        	    
   private boolean vertical(int num,int row,int col) {
	   if(row+3<z) {
			if((feld[row][col]==num && feld[row+1][col]==num )&& 
   				(feld[row+2][col]==num && feld[row+3][col]==num)){
   					return true;
   		   }
	   }
			return false;
			
      }
   private boolean horizontal(int num,int row,int col) {
	   if (col+3<s) {
   		if((feld[row][col]==num && feld[row][col+1]==num) && 
   				(feld[row][col+2]==num && feld[row][col+3]==num)){
   						return true;
   		          }

   	}
			return false;
			
  }

   private boolean diagonal(int num,int row,int col) {
	   if(col+3<s && row+3<z) {
			if((feld[row][col]==num && feld[row+1][col+1]==num )&& 
				(feld[row+2][col+2]==num && feld[row+3][col+3]==num)){
						return true;
		           }
			}      
      return false;
      }
   

	   
   
        
    

   

}

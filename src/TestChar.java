import java.util.ArrayList;
import java.util.Scanner;


public class TestChar {
/*	public static final int NUM = 50;
	int[] array = new int[NUM];*/
	public static void main(String[] args) {
/*		char ch = 'A';
		for(int i=0; i<4; i++) {
			System.out.println((char)(ch + i));
		}*/
		Grouping(getNum());
		
	}
	
	   public static int getNum(){  
	        Scanner s=new Scanner(System.in);  
	        System.out.print("请输入一个偶数:");  
	        int n=Integer.parseInt(s.nextLine());  
	        return n;  
	    }
	   
	      
	    public static void Grouping(int n){  
	        int num=n;  
	        ArrayList<Integer> glist=new ArrayList<Integer>();  
	        for(int i=0;i<num;i++){  
	            glist.add(i+1);  
	        }
	        
	        System.out.println(glist.toString());
	        for(int i=0;i<num/8;i++){  
	            for(int j=0;j<8;j++){  
	                int r=(int)(Math.random()*glist.size());  
	                System.out.print(glist.get(r)+"   ");  
	                glist.remove(r);  
	            }  
	        System.out.println();  
	        }  
	    }
	
/*	
	 * 
	 
	public static void grouping(int teamsNum, int groups ) {
		for(int i = 0 ; ; i++){ 
		    // 只生成10个随机数 
		    if(array.length<teamsNum){ 
		          generateRandom(teamsNum); 
		    }else{ 
		      break; 
		   } 
		}
	}
	
	public void generateRandom(int count) {
		int rand = (int)Math.random() * count;
		for(int i=0; i < count; i++) {
			if(array[i] == rand) {
				// return false
			}
			array[i] = rand;
		}
	}*/
}



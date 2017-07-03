
public class Decription {

	  static String decrypt(String word) {
		    
		    if(word==null || word.length()==0)
		      return null;
		      
		     String re="";
		     re=decryptionHelper( word.charAt(0),1 )+re;
		    
		    for(int i=1;i< word.length(); i++){
		      
		      re = re+decryptionHelper (word.charAt(i), (int) word.charAt(i-1)) ;
		    }
		   
		    return re;
		  }
		  
		  static char decryptionHelper( char c, int prevous )
		  {
		    int i=c;//step 3 reverse
		    i-=prevous; //step 1 reverse
		    while(! (i<='z' && i>= 'a'))
		    {
		      i+=26;//step 2  reverse
		    }
		    return (char) i;
		  }

		  public static void main(String[] args) {
		    System.out.println(decrypt("dnotq")); // crime
		  }

}

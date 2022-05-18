import java.util.StringTokenizer;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int a,b;
        while(true) {
        	String s=br.readLine();
        	StringTokenizer st=new StringTokenizer(s);
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	String result=String.valueOf(a+b);
        	if(a==0 && b==0) break;
        	bw.write(result+"\n");
        }
        bw.flush();
        bw.close();
    }
}
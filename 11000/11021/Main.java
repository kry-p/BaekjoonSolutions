import java.util.StringTokenizer;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cycle,a,b;
        String str=br.readLine();
        cycle=Integer.parseInt(str);
        for(int i=0;i<cycle;i++) {
        	String s=br.readLine();
        	StringTokenizer st=new StringTokenizer(s);
        	a=Integer.parseInt(st.nextToken());
        	b=Integer.parseInt(st.nextToken());
        	String result=String.valueOf(a+b);
        	if(i==cycle-1) {
        		bw.write("Case #"+(i+1)+": "+result);
        	}else {
        		bw.write("Case #"+(i+1)+": "+result+"\n");
        	}
        }
        bw.flush();
        bw.close();
    }
}
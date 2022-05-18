import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cycle;
        String str=br.readLine();
        cycle=Integer.parseInt(str);
        for(int i=1;i<=cycle;i++) {
        	for(int j=1;j<=i;j++) {
        		if(j==i) bw.write("*\n");
        		else bw.write("*");
        	}
        }
        bw.flush();
        bw.close();
    }
}
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cycle;
        String str=br.readLine();
        cycle=Integer.parseInt(str);
        for(int i=0;i<cycle;i++) {
        	int r=i+1;
        	bw.write(r+"\n");
        }
        bw.flush();
        bw.close();
    }
}
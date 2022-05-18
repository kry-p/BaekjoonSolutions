import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) throws IOException{
    	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int cycle=Integer.parseInt(br.readLine());
        for(int i=cycle;i>0;i--) {
        	int r=i;
        	bw.write(r+"\n");
        }
        bw.flush();
        bw.close();
    }
}
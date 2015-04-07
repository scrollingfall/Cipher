import java.io.*;
import java.util.*;

public class Encoder {
	
	public File file;
	
	public static final String key="TheQuickBrownFoxJumpsOverTheLazyDog";
	
	public Encoder(String f){
		file=new File(f);
	}
	public void write(String in){
		try {
			PrintWriter o=new PrintWriter(new FileWriter(file,true));
			o.println(encode(in));
			o.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Null char is x00 and newLine is x0A, so it should be ok since I'm adding.
	//Else, I can create a special case somehow...
	public String encode(String in){
		char[] key2=key.toCharArray();
		char[] ca=in.toCharArray();
		for(int i=0;i<ca.length;i++){
			//ca[i]+=key2[i%key.length()];
			ca[i]+=5;
			ca[i]%=128;
		}
		String out="";
		for(int i=0;i<ca.length;i++){
			out+=ca[i];
		}
		return out;
		//return in;
	}
	
	public ArrayList<String> read(){
		try {
			Scanner scan=new Scanner(file);
			ArrayList<String> l=new ArrayList<String>();
			while(scan.hasNextLine()){
			l.add(decode(scan.nextLine()));
			}
			return l;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}
	
	public String decode(String in){
		char[] key2=key.toCharArray();
		char[] ca=in.toCharArray();
		for(int i=0;i<ca.length;i++){
			//ca[i]-=key2[i%key.length()];
			ca[i]-=5;
			ca[i]+=128;
			ca[i]%=128;
		}
		String out="";
		for(int i=0;i<ca.length;i++){
			out+=ca[i];
		}
		return out;
		//return in;
	}
	
	public static void main(String[] args) {
		Encoder e=new Encoder("");
		String in="My name is bob! HI Bob";
		String out=(e.encode(in));
		System.out.println(out);
		
		String test="HI Man";
		String out2=(e.encode(test));
		System.out.println(e.decode(out2));
		
	}
}

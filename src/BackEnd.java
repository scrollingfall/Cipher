import java.util.*;
import java.io.*;
import java.nio.file.Files;
public class BackEnd {
	private ArrayList<String>usernames=new ArrayList<String>();
	private ArrayList<Encoder>encoders=new ArrayList<Encoder>();
	private Map<String, Integer>filenamerepeats=new HashMap<String,Integer>();
	public BackEnd()
	{
		try{
			Scanner scan=new Scanner(new File("Usernames.txt"));	
			while(scan.hasNextLine())
			{
				String s=scan.nextLine();
				if(!usernames.contains(s))
				{
					usernames.add(s);
					String two=new String(s.toCharArray());
					two.replaceAll("[\\/:\\*?\"<>|]","");
					if(filenamerepeats.containsKey(two))
					{
						filenamerepeats.put(two,filenamerepeats.get(two)+1);
					}
					else
					{
						filenamerepeats.put(two, 0);
					}
					encoders.add(new Encoder(two+"("+filenamerepeats.get(two)+").txt"));
				}
			}
			scan.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}



	}
	public ArrayList<String> getMessages(String user){
		if(usernames.contains(user))
			return encoders.get(usernames.indexOf(user)).read();
		else
			return null;
	}
	public void addMessage(String name, String message)throws Exception{
		if(usernames.contains(name))
		{
			encoders.get(usernames.indexOf(name)).write(message);
		}
		else
		{
			usernames.add(name);
			String two=new String(name.toCharArray());
			two.replaceAll("[\\/:\\*?\"<>|]","");
			if(filenamerepeats.containsKey(two))
			{
				filenamerepeats.put(two,filenamerepeats.get(two)+1);
			}
			else
			{
				filenamerepeats.put(two, 0);
			}
			encoders.add(new Encoder(two+"("+filenamerepeats.get(two)+").txt"));
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Usernames.txt", true)));
			out.println(name);
			out.close();
		}
	}
	public ArrayList<String> getUsers(){
		ArrayList<String>newlist=new ArrayList<String>(usernames);
		Collections.sort(newlist);
		return newlist;
	}
	public static void main(String[]args)
	{
		new BackEnd();
	}
}

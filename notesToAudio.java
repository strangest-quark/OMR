package audio;
import java.io.*;
import java.util.*;
import sun.audio.*;

/* ***************************************
 * PROGRAM TO PLAY THE GIVEN MUSICAL NOTES
 * ***************************************
 * Input       : note<space>note<space>...
 * Note Format : note(subscript)+count
 * Note not.   : # notation
 * Example     : C1 D1 E1 F1 G# A1 B1 C2
 * Output      : audio
 * Author      : Sowmiya Nagarajan
 */

public class Audio1
{
	
	public static void main(String[] args) throws Exception
    {
		
		String str;
		int i=0;
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		//Tempo
		int tempo=140;
		
		//List to store names of necessary files
		ArrayList<String> arr=new ArrayList<String>();
		//List to store note lengths
		ArrayList<Double> arr1=new ArrayList<Double>();
		
		//Input String
		str=sc.readLine();
		
		arr.add("S");
		arr1.add(3.0);
	
		while(i<str.length())
		{
			String temp="";
			String temp1="";
			double b=0;
			
			//Adding filenames to list
			if(str.charAt(i+2)!='#')
			{
				temp+=str.charAt(i);
				temp+=str.charAt(i+1);
				int t=i+2;
				while(t<str.length() && str.charAt(t)!=' ')
					temp1+=str.charAt(t++);
				b=Double.parseDouble(temp1);
				i=t+1;
			}
			else
			{
				temp+=str.charAt(i);
				temp+=str.charAt(i+1);
				temp+=str.charAt(i+2);
				int t=i+3;
				while(t<str.length() && str.charAt(t)!=' ')
					temp1+=str.charAt(t++);
				b=Double.parseDouble(temp1);
				i=t+1;
			
			}
			arr.add(temp);
			arr1.add(b);
		}
	
		//Source folder containing notes
		String f="G:/music/";
		i=0;
		
		while(i<arr.size())
		{
			//Creating file name for playing
			String gongFile = f;
			gongFile+=arr.get(i);
			gongFile+=".wav";
    
			//Open the sound file as a Java input stream
			InputStream in = new FileInputStream(gongFile);

			//Create an Audio stream from the Input stream
			AudioStream audioStream = new AudioStream(in);

			//Play the audio clip with the Audio player class
			AudioPlayer.player.start(audioStream);
			Double d=arr1.get(i)*(200000/(tempo*4));
			AudioPlayer.player.join(d.intValue());
		
			//System.out.println(AudioPlayer.currentThread().isAlive());
			i++;
		}
    }
}

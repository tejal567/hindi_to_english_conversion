import java.io.*;
import java.net.*;
public class Trans {
	public static void main(String[]args)throws Exception{
		String str="",stro="";
		String d;
		//Find location of current working directory
		URL location = Trans.class.getProtectionDomain().getCodeSource().getLocation();
        String loc=location.getFile();
		FileWriter fw=new FileWriter(loc+"output.txt",true);
		PrintWriter p=new PrintWriter(fw);
		FileReader fr1=new FileReader(loc+"input.txt");
		BufferedReader br1=new BufferedReader(fr1);
		boolean bool=true;
		while((d=br1.readLine())!=null){
			str=d;
			String a;
			char b,c;
			for(int i=0;i<str.length();i++){
				FileReader fr=new FileReader(loc+"table.txt");
				BufferedReader br=new BufferedReader(fr);
				if(str.charAt(i)=='अ')
					stro=stro+'a';
				if(str.charAt(i)==' ')
					stro=stro+' ';
				while((a=br.readLine())!=null){
					if(str.charAt(i)==a.charAt(0)){
						for(int k=1;k<a.length();k++)
							stro=stro+a.charAt(k);
						c=str.charAt(i);
						if(i!=str.length()-1){
							b=str.charAt(i+1);
							if(b!='ा'&&b!='ि'&&b!='ी'&&b!='े'&&b!='ै'&&b!='ो'&&b!='ौ'&&b!='ु'&&b!='ू'&&b!='ं'&&b!='अ'&&b!='आ'&&b!='इ'&&b!='ई'&&b!='उ'&&b!='ऊ'&&b!='ए'&&b!='ऐ'&&b!='ओ'&&b!='औ'){
								if(c!='ा'&&c!='ि'&&c!='ी'&&c!='े'&&c!='ै'&&c!='ो'&&c!='ौ'&&c!='ु'&&c!='ू'&&c!=' '){
									if(b!='्')
										stro=stro+'a';
								}
							}
						}
					
					}
				}
			}
			while(bool){
				stro=stro.substring(2);
				bool=false;
			}
			p.println(stro);	
			stro="";
			p.flush();
		}
		p.close();
		fw.close();
	}
}

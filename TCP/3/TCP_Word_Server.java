import java.io.*;
import java.net.*;
import java.util.Arrays;
class TCP_Word_Server{
    public static void main(String args[])
        throws Exception
        {
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();
            System.out.println("Connection Established");
            PrintStream ps = new PrintStream(s.getOutputStream());
            BufferedReader br =  new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader kb =  new BufferedReader(new InputStreamReader(System.in));  
            while(true){
                String str1,str2;
                while((str1=br.readLine())!=null){
                    str2=br.readLine();
                    if(str1=="exit"){
                        System.exit(1);
                    }
                    System.out.println("Word1 : "+str1);
                    System.out.println("Word2 : "+str2);
                    int f=0;
                    char sa1[] = new char[100];
                    char sa2[] = new char[100];
                    if(str1.length()==str2.length()){
                        for(int i=0;i<str1.length();i++){
                            sa1[i]=str1.charAt(i);
                            sa2[i]=str2.charAt(i);
                        }
                        Arrays.sort(sa1);
                        Arrays.sort(sa2);
                        if(Arrays.equals(sa1, sa2)){
                            ps.println("Check Conditon Satisfied ! ");   
                        }
                        else{
                            ps.println("Check Conditon NOT Satisfied ! ");
                                
                        }   
                    }     
                }
                ps.close();
                br.close();
                kb.close();
                ss.close();
                s.close();
                System.exit(0);
            }
        }
}

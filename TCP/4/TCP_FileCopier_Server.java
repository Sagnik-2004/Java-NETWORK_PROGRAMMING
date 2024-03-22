import java.io.*;
import java.net.*;
public class TCP_FileCopier_Server{
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(22222);
        Socket s = ss.accept();
        System.out.println("Connection Established !");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintStream ps = new PrintStream(s.getOutputStream());
        while(true){
            String str,str1,str2;
            while((str1=br.readLine())!=null){
                str2=br.readLine();
                if(str1=="exit"){
                    System.exit(-1);
                }
                System.out.println("Source : "+str1);
                System.out.println("Destination : "+str2);
                File inFile = new File(str1);
                File outFile = new File(str2);
                FileReader ins=null;
                FileWriter outs=null;
                try{
                    ins=new FileReader(inFile);
                    outs=new FileWriter(outFile);
                    int ch;
                    while((ch=ins.read())!=-1){
                        outs.write(ch);
                    }
                    ps.println("Successfully Copied from : "+str1+" to "+str2);
                }
                catch(IOException e){
                    ps.println(e);
                    System.exit(-1);
                }
                finally{
                    try{
                        ins.close();
                        outs.close();
                    }
                    catch (IOException e) {
                        System.out.println(e);
                        System.exit(-1);
                    }
                }
                
            }
            ps.close();
            br.close();
            ss.close();
            s.close();
  
            // terminate application
            System.exit(0);
        }
    }
}
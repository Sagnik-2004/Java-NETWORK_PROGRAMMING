import java.io.*;
import java.net.*;
class TCP_Block_Server{
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(55555);
        Socket s = ss.accept();
        System.out.println("Connection  Established !");
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while(true){
            String str1,str2,st="";
            while((str1=br.readLine())!=null){
                str2=br.readLine();
                if(str1=="exit"){
                    System.exit(1);
                }
                long n=Long.parseLong(str2);
                File inFile = new File(str1);
                FileReader ins = null;
                long len = inFile.length();
                long x;
                if(len%n==0){
                    x=len/n;
                }
                else{
                    x=(len/n)+1;
                }
                try{
                    ins = new FileReader(inFile);
                    dos.writeBytes(String.valueOf(x)+"\n");
                    long bk=0;    
                    System.out.println(len);
                    System.out.println(x);
                    while (true) {
                        for(long j=bk;j<bk+n;j++){
                            if(j<=len-1){
                                st=st+String.valueOf((char)ins.read());
                            }
                            else{
                                break;
                            }    
                        }
                        bk=bk+n;
                        dos.writeBytes(st+"\n") ;
                        st="";
                        if(bk>=len){
                            break;
                        }
                    }  
                }
                catch(IOException e){
                    System.out.println(e);
                    System.exit(-1);
                }
                finally{
                    try{
                        ins.close();
                    }
                    catch (IOException e) {
                        System.out.println(e);
                        System.exit(-1);
                    }
                }
            }
            dos.close();
            br.close();
            ss.close();
            s.close();
            System.exit(0);
        }
    }
}
import java.io.*;
import java.net.*;
class TCP_Block_Client{
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",55555);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        String str1=" ",st;
        while(!str1.equals("exit")){
            long sz=0;
            String str2,sv;
            System.out.println("Enter File Name : ");
            str1=kb.readLine();
            if(str1.equals("exit")){
                break;
            }
            System.out.println("Enter Block size : ");
            str2=kb.readLine();
            dos.writeBytes(str1 + "\n");
            dos.writeBytes(str2 + "\n");
            sv=br.readLine();
            sz=Long.parseLong(sv); 
            int m=1;
            for(long bk=0;bk<sz;bk++){
                System.out.println("block : "+m); 
                st=br.readLine();
                System.out.println(st);
                m=m+1;
            }
            System.out.println();
        }
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}
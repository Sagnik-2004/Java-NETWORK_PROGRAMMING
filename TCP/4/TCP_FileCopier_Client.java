import java.io.*;
import java.net.*;
public class TCP_FileCopier_Client{
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",22222);
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in)); 
        String str,str1="   ";
        while(!str1.equals("exit")){
            String str2;
            System.out.println("Enter Source file name : ");
            str1=kb.readLine();
            if(str1.equals("exit")){
                break;
            }
            System.out.println("Enter Destination file name : ");
            str2=kb.readLine();
            dos.writeBytes(str1+"\n");
            dos.writeBytes(str2+"\n");
            str=br.readLine();
            System.out.println(str);
        }
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}
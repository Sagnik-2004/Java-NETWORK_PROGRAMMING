import java.io.*;
import java.net.*;
class TCP_Word_Client{
    public static void main(String args[])
        throws Exception
        {
            Socket s= new Socket("localhost",9999);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
            String str1=" ",str2,str;
            while(!(str1.equals("exit"))){
                System.out.println("Enter 1st word : ");
                str1=kb.readLine();
                if(str1.equals("exit")){
                    break;
                }
                System.out.println("Enter 2nd word : ");
                str2=kb.readLine();
                dos.writeBytes(str1 + "\n");
                dos.writeBytes(str2 + "\n");
                str=br.readLine();
                System.out.println(str);
            }
            dos.close();
            br.close();
            kb.close();
            s.close();
        }
}

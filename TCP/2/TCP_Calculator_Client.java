//Java program to illustrate Client side duplex implementation using TCP
import java.io.*;
import java.net.*;
  
class TCP_Calculator_Client {
  
    public static void main(String args[])
        throws Exception
    {
  
        // Create client socket
        Socket s = new Socket("localhost", 9999);
  
        // to send data to the server
        DataOutputStream dos= new DataOutputStream(s.getOutputStream());
  
        // to read data coming from the server
        BufferedReader br
            = new BufferedReader(new InputStreamReader(s.getInputStream()));
  
        // to read data from the keyboard
        BufferedReader kb= new BufferedReader(new InputStreamReader(System.in));
        String str,str1="    ";
  
        // repeat as long as exit
        // is not typed at client
        while (!str1.equals("exit")) {
  
            // send to the server
            String str2,str3;
            System.out.println("Enter Operand1 : ");
            str1 = kb.readLine();
            if (str1.equals("exit")) {
                break;  // exit the loop if the user inputs "exit"
            }
            System.out.println("Enter Operator : ");
            str2 = kb.readLine();
            System.out.println("Enter Operand3 : ");
            str3 = kb.readLine();
            dos.writeBytes(str1 + "\n");
            dos.writeBytes(str2 + "\n");
            dos.writeBytes(str3 + "\n");
            // receive from the server
            str = br.readLine();
  
            System.out.println("Answer is : "+str);
        }
  
        // close connection.
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}
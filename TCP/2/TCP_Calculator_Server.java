//Java program to illustrate Client side duplex implementation using TCP
import java.io.*;
import java.net.*;
  
class TCP_Calculator_Server {
  
    public static void main(String args[])
        throws Exception
    {
  
        // Create server Socket
        ServerSocket ss = new ServerSocket(9999);
  
        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");
  
        // to send data to the client
        PrintStream ps
            = new PrintStream(s.getOutputStream());
  
        // to read data coming from the client
        BufferedReader br
            = new BufferedReader(
                new InputStreamReader(
                    s.getInputStream()));
  
        // to read data from the keyboard
        BufferedReader kb
            = new BufferedReader(
                new InputStreamReader(System.in));
                int i=0;
        // server executes continuously
        while (true) {
  
            String str1;//str2,str3;
            double str=0;
            String str2,str3;
            // repeat as long as the client
            // does not send a null string
  
            // read from client
            while ((str1 = br.readLine()) != null) {
                str2 = br.readLine();
                str3 = br.readLine();
                if(str1=="exit"){
                    System.exit(1);
                }
                System.out.println("case : "+(i+1));
                System.out.println("Operand1 : "+str1);
                System.out.println("Operand2 : "+str2);
                System.out.println("Operand3 : "+str3);
                int x=Integer.parseInt(str1);
                int y=Integer.parseInt(str3);
                char z = str2.charAt(0);
                if(z=='+'){
                    str=x+y;
                }
                else if(z=='-'){
                    str=x-y;
                }
                else if(z=='%'){
                    str=x%y;
                }
                else if(z=='/'){
                    str=x/y;
                }
                else if(z=='*'){
                    str=x*y;
                }
                else{
                    ps.println("Wrong Input");
                }
                // send to client
                ps.println(str);
            }
  
            // close connection
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();
  
            // terminate application
            System.exit(0);
  
        } // end of while
    }
}
package code.Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Work00 {
    public static void main(String [] args){

        try {
            Work00.login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void login() throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src\\TestFile\\File06"));

        char c[] =new char[100];
        String login = new String(c,0,bufferedReader1.read(c));

        String line = "";


        while((line = bufferedReader.readLine()) != null){
            if(line.equals(login)){
                System.out.println("登陆成功");
                break;
            }else{
                System.out.println("用户名密码错误！");
                break;
            }
        }
        bufferedReader.close();
        bufferedReader.close();
    }
}

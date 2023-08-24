package ServiceB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

@RestController
@RequestMapping("/b")
public class ServiceBController {

    @GetMapping
    public String serviceB() {
        Scanner sc= new Scanner(System.in);
        System.out.print("insert from ");
        String from = sc.nextLine();
        System.out.print("insert to ");
        String to = sc.nextLine();
        System.out.print("insert amount ");
        double amount = sc.nextDouble();
        return getUrlContents("https://v6.exchangerate-api.com/v6/ecf10bab01b34bf0de9636e1/pair/" + from + "/" + to +
                "/" +
                amount);
    }

    public String getUrlContents(String url) {
        StringBuilder content = new StringBuilder();
        // Use try and catch to avoid the exceptions
        try
        {
            URL u = new URL(url); // creating a url object
            URLConnection urlConnection = u.openConnection(); // creating a urlconnection object

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }

}

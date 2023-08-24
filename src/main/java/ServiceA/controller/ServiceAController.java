package ServiceA.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL
            = "http://localhost:8081/";

    private static final String SERVICE_A = "serviceA";

    int count=1;

    @GetMapping
    @CircuitBreaker(name = SERVICE_A, fallbackMethod = "serviceAFallback")
    //@Retry(name = SERVICE_A)
    //@RateLimiter(name = SERVICE_A)
    public String serviceA() {

        String url = BASE_URL + "b";
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        return restTemplate.getForObject(
                url,
                String.class
        );
    }

    public String serviceAFallback(Exception e) {
        Scanner sc= new Scanner(System.in);
        System.out.print("insert from ");
        String from = sc.nextLine();
        System.out.print("insert to ");
        String to = sc.nextLine();
        System.out.print("insert amount ");
        double amount = sc.nextDouble();
        return getUrlContents("https://v6.exchangerate-api.com/v6/ecf10bab01b34bf0de9636e1/pair/" + from + "/" +
                to +
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

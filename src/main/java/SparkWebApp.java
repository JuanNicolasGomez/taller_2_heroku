

import org.apache.log4j.BasicConfigurator;

import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        port(getPort());
        get("/hello", (req, res) -> "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h1>TALLER 2</h1>\n" +
                "<p>web application to calculate the mean and standard deviation of a set of n\n" +
                "real numbers.</p>\n" +
                "\n" +
                "<form action=\"/hello2\">\n" +
                "  Enter the numbers separated by commas:<br>\n" +
                "\n" +
                "  <input type=\"text\" name=\"numbers\" value=\"213,234,34,21,5546,657\"><br>\n" +
                "\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

        get("/hello2", (req, res) -> {
            return req.params();

        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}

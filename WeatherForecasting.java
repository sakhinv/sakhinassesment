import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherForecasting {

    private static final String API_KEY = "b6907d289e10d714a6e88b30761fae22";
    private static final String BASE_URL = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=" + API_KEY;

    public static void main(String[] args) {
        System.out.println("Welcome to the Weather Forecast Program!");

        try {
            String jsonData = getWeatherData();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\nOptions:");
                System.out.println("1. Get weather");
                System.out.println("2. Get Wind Speed");
                System.out.println("3. Get Pressure");
                System.out.println("0. Exit");

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter the date (YYYY-MM-DD): ");
                        String date = sc.next();
                        double temperature = getWeatherByDate(jsonData, date);
                        if (temperature != Double.MIN_VALUE) {
                            System.out.printf("The temperature on %s is %.2f °K%n", date, temperature);
                        } else {
                            System.out.println("No data available for the given date.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter the date (YYYY-MM-DD): ");
                        date = sc.next();
                        double windSpeed = getWindSpeedByDate(jsonData, date);
                        if (windSpeed != Double.MIN_VALUE) {
                            System.out.printf("The wind speed on %s is %.2f m/s%n", date, windSpeed);
                        } else {
                            System.out.println("No data available for the given date.");
                        }
                        break;
                    case 3:
                        System.out.print("Enter the date (YYYY-MM-DD): ");
                        date = sc.next();
                        double pressure = getPressureByDate(jsonData, date);
                        if (pressure != Double.MIN_VALUE) {
                            System.out.printf("The pressure on %s is %.2f hPa%n", date, pressure);
                        } else {
                            System.out.println("Data not available");
                        }
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error fetching data.");
        }
    }

    private static String getWeatherData() throws IOException {
        URL apiUrl = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    private static double getWeatherByDate(String jsonData, String date) {
     
        return 290.12;
    }

    private static double getWindSpeedByDate(String jsonData, String date) {

        return 6.2;
    }

    private static double getPressureByDate(String jsonData, String date) {
       
        return 1012.3;
    }
}

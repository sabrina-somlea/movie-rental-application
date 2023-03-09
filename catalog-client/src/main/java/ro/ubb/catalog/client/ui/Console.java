package ro.ubb.catalog.client.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.ubb.catalog.web.dto.*;


import java.util.Scanner;
@Component
public class Console {

    @Autowired
    RestTemplate restTemplate;

    Scanner scanner = new Scanner(System.in);

    public void runConsole() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            printMenu();
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    addMovie();
                    break;
                case "2":
                    showAllMovies();
                    break;
                case "3":
                    updateMovie();
                    break;
                case "4":
                    deleteMovie();
                    break;
//                case "5":
//                    sortMovies();
//                    break;
//                case "6":
//                    filerMovies();
//                    break;
                case "7":
                    addCustomer();
                    break;
                case "8":
                    showAllCustomers();
                    break;
                case "9":
                    updateCustomer();
                    break;
                case "10":
                    deleteCustomer();
                    break;
//                case "11":
//                    sortCustomers();
//                    break;
//                case "12":
//                    filterCustomers();
//                    break;
                case "13":
                    addStaff();
                    break;
                case "14":
                    showAllStaff();
                    break;
                case "15":
                    updateStaff();
                    break;
                case "16":
                    deleteStaff();
                    break;
//                case "17":
//                    sortStaff();
//                    break;
//                case "18":
//                    filterStaff();
//                    break;
                case "19":
                    addStore();
                    break;
                case "20":
                    showAllStores();
                    break;
                case "21":
                    updateStore();
                    break;
                case "22":
                    deleteStore();
                    break;
//                case "23":
//                    sortStores();
//                    break;
//                case "24":
//                    filterStores();
//                    break;
                case "25":
                    addMovieDate();
                    break;
                case "26":
                    showAllMovieDates();
                    break;
                case "27":
                    updateMovieDate();
                    break;
                case "28":
                    deleteMovieDate();
                    break;
//                case "29":
//                    sortMovieDates();
//                    break;
//                case "30":
//                    filterMovieDates();
//                    break;
                case "x":
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    private void printMenu() {
        String[] menu = {"Choose your option: ",
                " 1. MOVIE create",
                " 2. MOVIE read",
                " 3. MOVIE update",
                " 4. MOVIE delete",
                " 5. MOVIE sort",
                " 6. MOVIE filter",
                " 7. CUSTOMER create",
                " 8. CUSTOMER read",
                " 9. CUSTOMER update",
                "10. CUSTOMER delete",
                "11. CUSTOMER sort",
                "12. CUSTOMER filter",
                "13. STAFF create",
                "14. STAFF read",
                "15. STAFF update",
                "16. STAFF delete",
                "17. STAFF sort",
                "18. STAFF filter",
                "19. STORE create",
                "20. STORE read",
                "21. STORE update",
                "22. STORE delete",
                "23. STORE sort",
                "24. STORE filter",
                "25. DATE create",
                "26. DATE read",
                "27. DATE update",
                "28. DATE delete",
                "29. DATE sort",
                "30. DATE filter",
                "x - exit"};

        for (String item : menu) {
            System.out.println(item);
        }
    }

//    ---------------
//         MOVIE
//    ---------------

    private void addMovie() {
        System.out.println("Movie: title, releaseYear, language, rating, rentalPrice");
        String movieInfo = scanner.nextLine();

        String[] movieInfo2 = movieInfo.split(",");
        String title = movieInfo2[0];
        int releaseYear = Integer.parseInt(movieInfo2[1]);
        String language = movieInfo2[2];
        float rating = Float.parseFloat(movieInfo2[3]);
        float rentalPrice = Float.parseFloat(movieInfo2[4]);

        restTemplate.postForObject("http://localhost:8080/api/movies",
                new MovieDto(title, releaseYear, language, rating, rentalPrice), MovieDtos.class);

        System.out.println("Movie added successfully");
    }

    private void showAllMovies() {
        MovieDtos movies = restTemplate.getForObject("http://localhost:8080/api/movies", MovieDtos.class);
        for (MovieDto movie : movies.getMovieDtos()) {
            System.out.println(movie);
        }
    }

    private void updateMovie() {
        System.out.println("Movie: id, title, releaseYear, language, rating, rentalPrice");
        String movieInfo = scanner.nextLine();

        String[] movieInfo2 = movieInfo.split(",");
        Long id = Long.valueOf(movieInfo2[0]);
        String title = movieInfo2[1];
        int releaseYear = Integer.parseInt(movieInfo2[2]);
        String language = movieInfo2[3];
        float rating = Float.parseFloat(movieInfo2[4]);
        float rentalPrice = Float.parseFloat(movieInfo2[5]);

        MovieDto updatedMovie = new MovieDto(title, releaseYear, language, rating, rentalPrice);
        restTemplate.put("http://localhost:8080/api/movies/{:id}",
                updatedMovie, id);

        System.out.println("Movie updated successfully");

    }

    private void deleteMovie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Movie id = ?");

        Long id = Long.valueOf(scanner.nextLine());

        restTemplate.delete("http://localhost:8080/api/movies/{:id}", id);

        System.out.println("Movie deleted successfully");
    }

//    ---------------
//         CUSTOMER
//    ---------------

    private void addCustomer() {
        System.out.println("Customer: name, email, yearOfBirth, gender");
        String customerInfo = scanner.nextLine();

        String[] customerInfo2 = customerInfo.split(",");
        String name = customerInfo2[0];
        String email = customerInfo2[1];
        int yearOfBirth = Integer.parseInt(customerInfo2[2]);
        String gender = customerInfo2[3];

        CustomerDto savedCustomer = restTemplate.postForObject("http://localhost:8080/api/customers",
                new CustomerDto(name, email, yearOfBirth, gender),
                CustomerDto.class);

        System.out.println(savedCustomer);

    }

    private void showAllCustomers() {
        CustomerDtos customers = restTemplate.getForObject("http://localhost:8080/api/customers", CustomerDtos.class);
        System.out.println(customers);
    }

    private void updateCustomer() {
        System.out.println("Customer: id, name, email, year of birth, gender");
        String customerData = scanner.nextLine();
        String[] customerArray = customerData.split(",");
        Long id = Long.valueOf(customerArray[0]);
        String name = customerArray[1];
        String email = customerArray[2];
        int yearOfBirth = Integer.parseInt(customerArray[3]);
        String gender = customerArray[4];

        restTemplate.put("http://localhost:8080/api/customers/{:id}",
                new CustomerDto(name, email, yearOfBirth, gender),
                id);
    }

    private void deleteCustomer() {
        System.out.println("Customer id = ?");
        Long customerId = Long.valueOf(scanner.nextLine());

        restTemplate.delete("http://localhost:8080/api/customers/{:id}", customerId);
    }

//    ---------------
//         STAFF
//    ---------------

    private void addStaff() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Staff: name, yearOfBirth, email, phoneNumber");
        String staffDescription = scanner.nextLine();
        String[] staffDescription2 = staffDescription.split(",");
        String name = staffDescription2[0];
        int yearOfBirth = Integer.parseInt(staffDescription2[1]);
        String email = staffDescription2[2];
        String phoneNumber = staffDescription2[3];
        restTemplate.postForObject("http://localhost:8080/api/staff",
                new StaffDto(name, yearOfBirth, email, phoneNumber),
                StaffDtos.class);

        System.out.println("Staff saved");
    }

    private void showAllStaff() {
        StaffDtos staff = restTemplate.getForObject("http://localhost:8080/api/staff", StaffDtos.class);
        System.out.println(staff);

    }

    private void updateStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Staff: id, name, yearOfBirth, email, phoneNumber");
        String staffDescription = scanner.nextLine();
        String[] staffDescription2 = staffDescription.split(",");
        long id = Long.parseLong(staffDescription2[0]);
        String name = staffDescription2[1];
        int yearOfBirth = Integer.parseInt(staffDescription2[2]);
        String email = staffDescription2[3];
        String phoneNumber = staffDescription2[4];
        restTemplate.put("http://localhost:8080/api/staff/{:id}", new StaffDto(name, yearOfBirth, email, phoneNumber), id);


    }

    private void deleteStaff() {
        System.out.println("Staff id: ");
        Long staffId = Long.valueOf(scanner.nextLine());

        restTemplate.delete("http://localhost:8080/api/staff/{:id}", staffId);
    }

//    ---------------
//         DATE
//    ---------------
    private void addMovieDate() {
        System.out.println("Movie Date: quarter, year, month, day");
        String movieDateInfo = scanner.nextLine();

        String[] movieDateInfo2 = movieDateInfo.split(",");
        int quarter = Integer.parseInt(movieDateInfo2[0]);
        int year = Integer.parseInt(movieDateInfo2[1]);
        String month = movieDateInfo2[2];
        int day = Integer.parseInt(movieDateInfo2[3]);

        restTemplate.postForObject("http://localhost:8080/api/moviedate",
                new MovieDateDto(quarter, year, month, day), MovieDateDtos.class);

        System.out.println("Movie Date added successfully");
    }

    private void showAllMovieDates() {
        MovieDateDtos movieDates = restTemplate.getForObject("http://localhost:8080/api/moviedate", MovieDateDtos.class);
        for (MovieDateDto movieDate : movieDates.getMovieDateDtos()) {
            System.out.println(movieDate);
        }
    }

    private void updateMovieDate() {
        System.out.println("Movie Date: id, quarter, year, month, day");
        String movieDateInfo = scanner.nextLine();

        String[] movieDateInfo2 = movieDateInfo.split(",");
        Long id = Long.valueOf(movieDateInfo2[0]);
        int quarter = Integer.parseInt(movieDateInfo2[1]);
        int year = Integer.parseInt(movieDateInfo2[2]);
        String month = movieDateInfo2[3];
        int day = Integer.parseInt(movieDateInfo2[4]);

        MovieDateDto updatedMovieDate = new MovieDateDto(quarter, year, month, day);
        restTemplate.put("http://localhost:8080/api/moviedate/{:id}",
                updatedMovieDate, id);

        System.out.println("Movie Date updated successfully");

    }

    private void deleteMovieDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Movie Date id = ?");

        Long id = Long.valueOf(scanner.nextLine());

        restTemplate.delete("http://localhost:8080/api/moviedate/{:id}", id);

        System.out.println("Movie Date deleted successfully");
    }


//    ---------------
//         STORE
//    ---------------

    private void addStore() {
        System.out.println("Store: name, address, city, county, postalCode");
        String movieInfo = scanner.nextLine();

        String storeInfo = scanner.nextLine();
        String[] storeInfo2 = storeInfo.split(",");
        String name = storeInfo2[0];
        String address = storeInfo2[1];
        String city = storeInfo2[2];
        String county = storeInfo2[3];
        int postalCode = Integer.parseInt(storeInfo2[4]);

        restTemplate.postForObject("http://localhost:8080/api/stores",
                new StoreDto(name, address, city, county, postalCode), StoreDtos.class);

        System.out.println("Store added successfully");
    }

    private void showAllStores() {
        StoreDtos stores = restTemplate.getForObject("http://localhost:8080/api/stores", StoreDtos.class);
        for (StoreDto store : stores.getStoreDtos()) {
            System.out.println(store);
        }
    }

    private void updateStore() {
        System.out.println("Store: id, name, address, city, county, postalCode");
        String storeDateInfo = scanner.nextLine();
        String[] storeDateInfo2 = storeDateInfo.split(",");

        Long id = Long.valueOf(storeDateInfo2[0]);
        String name = storeDateInfo2[1];
        String address = storeDateInfo2[2];
        String city = storeDateInfo2[3];
        String county = storeDateInfo2[4];
        int postalCode = Integer.parseInt(storeDateInfo2[5]);

        StoreDto updatedStore = new StoreDto(name, address, city, county, postalCode);
        restTemplate.put("http://localhost:8080/api/stores/{:id}",
                updatedStore, id);

        System.out.println("Store updated successfully");

    }

    private void deleteStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Store id = ?");

        Long id = Long.valueOf(scanner.nextLine());

        restTemplate.delete("http://localhost:8080/api/stores/{:id}", id);

        System.out.println("Store deleted successfully");
    }

}




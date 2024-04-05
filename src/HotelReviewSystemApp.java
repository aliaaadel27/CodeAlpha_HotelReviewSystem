import java.util.Scanner;
import java.util.List;


public class HotelReviewSystemApp {
    private static Hotel createHotel(Scanner scanner) {
        System.out.print("Enter hotel name: ");
        String name = scanner.nextLine();
        System.out.print("Enter hotel location: ");
        String location = scanner.nextLine();
        return new Hotel(name, location);
    }

    private static void addReview(Scanner scanner, HotelReviewSystem reviewSystem) {
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();
        System.out.print("Enter review text: ");
        String reviewText = scanner.nextLine();
        System.out.print("Enter rating (1-5): ");
        int rating = scanner.nextInt();
        scanner.nextLine();
        reviewSystem.addReview(hotelName, reviewText, rating);
    }

    private static void printReviews(List<Review> reviews) {
        for (Review review : reviews) {
            System.out.println(review.getHotel().getName() + " (" + review.getHotel().getLocation() + "): " +
                    review.getReviewText() + " (Rating: " + review.getRating() + ")");
        }
    }
    private static void printHotelsList(List<Hotel> hotels) {
        for (Hotel hotel : hotels) {
            System.out.println(hotel.getName() + " (" + hotel.getLocation() + ") ");
        }
    }
    public static void main(String[] args) {
        HotelReviewSystem reviewSystem = new HotelReviewSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("_________(Hotel Review System)_________");
            System.out.println("Choose an option:");
            System.out.println("1. Add Hotel");
            System.out.println("2. Add Review");
            System.out.println("3. View ALl hotels");
            System.out.println("4. View All Reviews");
            System.out.println("5. View Reviews for a Hotel");
            System.out.println("6. Sort Reviews by Rating");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter details for the hotel:");
                    Hotel hotel = createHotel(scanner);
                    reviewSystem.addHotel(hotel);
                    System.out.println("Hotel added successfully.");
                    break;

                case 2:
                    if (reviewSystem.getAllHotels().isEmpty()) {
                        System.out.println("No hotels available. Please add a hotel first.");
                        break;
                    }
                    System.out.println("Enter review details:");
                    addReview(scanner, reviewSystem);
                    System.out.println("Review added successfully.");
                    break;

                case 3:
                    System.out.println("All Hotels:");
                    printHotelsList(reviewSystem.getAllHotels());
                    break;

                case 4:
                    System.out.println("All Reviews:");
                    printReviews(reviewSystem.getAllReviews());
                    break;
                case 5:
                    if (reviewSystem.getAllReviews().isEmpty()) {
                        System.out.println("No hotels available. Please add a hotel first.");
                        break;
                    }
                    System.out.print("Enter hotel name: ");
                    String hotelName = scanner.nextLine();
                    printReviews(reviewSystem.getReviewsForHotel(hotelName));
                    break;
                case 6:
                    System.out.println("Sorted Reviews by Rating:");
                    printReviews(reviewSystem.sortReviewsByRating());
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }

        scanner.close();
    }
}

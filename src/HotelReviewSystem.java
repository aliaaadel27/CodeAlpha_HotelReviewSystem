import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class HotelReviewSystem implements ReviewService {
    private final List<Review> reviews;
    private final List<Hotel> hotels;

    public HotelReviewSystem() {
        reviews = new ArrayList<>();
        hotels = new ArrayList<>();
    }

    @Override
    public void addReview(String hotelName, String reviewText, int rating) {
        Hotel hotel = getHotelByName(hotelName);
        if (hotel == null) {
            throw new IllegalArgumentException("Hotel does not exist. Please add the hotel first.");
        }
        reviews.add(new Review(hotel, reviewText, rating));
    }

    @Override
    public List<Review> getAllReviews() {
        return new ArrayList<>(reviews);
    }

    @Override
    public List<Review> getReviewsForHotel(String hotelName) {
        Hotel hotel = getHotelByName(hotelName);
        List<Review> hotelReviews = new ArrayList<>();
        for (Review review : reviews) {
            if (review.getHotel().equals(hotel)) {
                hotelReviews.add(review);
            }
        }
        return hotelReviews;
    }

    @Override
    public List<Review> sortReviewsByRating() {
        List<Review> sortedReviews = new ArrayList<>(reviews);
        sortedReviews.sort(Comparator.comparingInt(Review::getRating).reversed());
        return sortedReviews;
    }

    @Override
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return new ArrayList<>(hotels);
    }

    private Hotel getHotelByName(String hotelName) {
        for (Hotel hotel : hotels) {
            if (hotel.getName().equals(hotelName)) {
                return hotel;
            }
        }
        return null;
    }
}

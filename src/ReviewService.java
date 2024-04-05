import java.util.List;

interface ReviewService {
    void addReview(String hotelName, String reviewText, int rating);
    List<Review> getAllReviews();
    List<Review> getReviewsForHotel(String hotelName);
    List<Review> sortReviewsByRating();
    void addHotel(Hotel hotel);
    List<Hotel> getAllHotels();
}
